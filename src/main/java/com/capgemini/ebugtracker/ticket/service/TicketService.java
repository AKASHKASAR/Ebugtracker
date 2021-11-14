package com.capgemini.ebugtracker.ticket.service;

import com.capgemini.ebugtracker.ticket.entity.Ticket;
import com.capgemini.ebugtracker.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(final TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public Ticket saveTicket(final Ticket ticketDetails){
        return ticketRepository.save(ticketDetails);
    }

    public Ticket getTicket(final Long tiketId){
        return ticketRepository.findById(tiketId).get();
    }
}
