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
    public Bugs getTicket(@PathVariable String ticketId){
        return ticketService.getTicket(Long.parseLong(ticketId));
    }

    @GetMapping("/getTicketForStaff/{userId}")
    public Bugs getTicketsForStaff(@PathVariable String userId){
        return ticketService.getBugForUser(Long.parseLong(userId));
    }

    @PostMapping("/saveTicket")
    public Bugs saveTicket(@RequestBody Bugs bugs){
        return ticketService.saveTicket(bugs);
    }
}
