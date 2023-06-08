package com.example.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.model.Ticket;
import com.example.demo.model.Ticket;
import com.example.demo.model.dto.TicketDto;
import com.example.demo.service.TicketService;
import com.example.demo.service.TicketService;
import javax.validation.Valid;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@Validated
public class TicketController {
    TicketService ticketService;
    private ModelMapper modelMapper;

    public TicketController(TicketService ticketService, ModelMapper modelMapper) {
        this.ticketService = ticketService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")
    public ResponseEntity<List<TicketDto>> List()
    {
        List<Ticket> tickets = ticketService.list();
        List<TicketDto> ticketDtos = modelMapper.map(tickets, new TypeToken<List<TicketDto>>() {}.getType());
        return ResponseEntity.ok(ticketDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  Get(@PathVariable("id") Integer id)
    {
        try {
            Ticket ticket = ticketService.read(id);
            TicketDto ticketDto = modelMapper.map(ticket, TicketDto.class);
            return ResponseEntity.ok(ticketDto);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("")
    public ResponseEntity<?>  Post(@Valid @RequestBody Ticket ticket){
        ticketService.update(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
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