package com.example.demo.service;

import com.example.demo.model.Airplane;
import com.example.demo.model.Ticket;
import com.example.demo.repository.AirplaneRepository;
import com.example.demo.repository.TicketRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    public List<Ticket> list() {
        return ticketRepository.findAll();
    }

    public void update(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public Ticket read(Integer id) {
        return ticketRepository.findById(id).get();
    }

    public void delete(Integer id) {
        ticketRepository.deleteById(id);
    }

    public boolean useTicket(Integer id){
        Ticket ticket;
        try {
            ticket = ticketRepository.findById(id).get();
        }
        catch(NoSuchElementException e){
            return false;
        }
        ticket.setHasBeenUsed(true);
        ticketRepository.save(ticket);
        return true;
    }

    public List<Ticket> listNonUsedTickets() {
        List <Ticket> tickets = ticketRepository.findAll();
        List <Ticket> nonUsedTickets = tickets.stream().filter(ticket -> !ticket.isHasBeenUsed()).collect(Collectors.toList());
        return nonUsedTickets;
    }
}
