package com.example.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import javax.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @GetMapping("list")
    public ResponseEntity<List<Ticket>> List()
    {
        return ResponseEntity.ok(ticketService.list());
    }

    @GetMapping("{id}")
    public ResponseEntity<Ticket>  Get(@Valid @PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(ticketService.read(id));
    }

    @PostMapping("")
    public void Post(@RequestBody Ticket ticket){
        ticketService.update(ticket);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> Put(@Valid @RequestBody Ticket ticket, @PathVariable Integer id) {
        try {
            Ticket existingTicket = ticketService.read(id);
            ticket.setId(id);
            ticketService.update(ticket);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        ticketService.delete(id);
    }

    @GetMapping("list-not-used")
    public ResponseEntity<List<Ticket>> ListNonUsedTickets()
    {
        return ResponseEntity.ok(ticketService.listNonUsedTickets());
    }

    @PutMapping("use")
    public ResponseEntity<?> Use(@RequestBody Ticket ticket)
    {
        boolean success = ticketService.useTicket(ticket.getId());
        if (success){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}