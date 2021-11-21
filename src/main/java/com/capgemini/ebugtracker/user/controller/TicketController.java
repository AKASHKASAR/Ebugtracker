package com.capgemini.ebugtracker.user.controller;

import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.servies.TicketService;
import com.capgemini.ebugtracker.exception.BugNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public Bugs getTicket(@PathVariable("ticketId") String ticketId){
        Bugs bugs = ticketService.getTicket(Long.parseLong(ticketId));
        if(Objects.isNull(bugs)){
            throw new BugNotFoundException();
        }
    	return bugs;
    }

    @GetMapping("/getTicketForStaff/{userId}")
    public Bugs getTicketsForStaff(@PathVariable String userId){
        return ticketService.getBugForUser(Long.parseLong(userId));
    }

    @PostMapping("/saveTicket")
    public Bugs saveTicket(@RequestBody Bugs bugs){
        return ticketService.saveTicket(bugs);
    }

    /*@PostMapping ("/uploadImage")
    public String uploadImage(RequestParam("imagefile")multipartfile imagefile){
        String returnvalue = "start";
TicketService.saveImage(imagefile);
        return returnvalue;
    }*/
}
