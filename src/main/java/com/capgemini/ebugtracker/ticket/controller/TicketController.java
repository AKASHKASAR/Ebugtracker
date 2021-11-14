package com.capgemini.ebugtracker.ticket.controller;

import com.capgemini.ebugtracker.ticket.entity.Ticket;
import com.capgemini.ebugtracker.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(final TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/getAllTickets")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/getTicket/{ticketId}")
    public Ticket getTicket(@RequestParam int ticketId){
        return ticketService.getTicket((long) ticketId);
    }

    @PostMapping("/saveTicket")
    public Ticket saveTicket(@RequestBody Ticket ticket){
        return ticketService.saveTicket(ticket);
    }
}
