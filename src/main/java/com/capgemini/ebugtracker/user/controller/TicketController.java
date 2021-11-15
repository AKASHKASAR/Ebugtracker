package com.capgemini.ebugtracker.user.controller;

import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.servies.TicketService;

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
    public List<Bugs> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/getTicket/{ticketId}")
    public Bugs getTicket(@RequestParam String ticketId){
        return ticketService.getTicket(Long.parseLong(ticketId));
    }

    @PostMapping("/saveTicket")
    public Bugs saveTicket(@RequestBody Bugs bugs){
        return ticketService.saveTicket(bugs);
    }
}
