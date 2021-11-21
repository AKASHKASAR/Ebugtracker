package com.capgemini.ebugtracker.bugs.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ebugtracker.bugs.entity.Bugs;
import com.capgemini.ebugtracker.bugs.repositery.BugDao;

@Service
public class TicketService {
	@Autowired
    private BugDao ticketRepository;

//    @Autowired
//    public TicketService(final TicketRepository ticketRepository) {
//        this.ticketRepository = ticketRepository;
//    }

    public List<com.capgemini.ebugtracker.bugs.entity.Bugs> getAllTickets(){
        return ticketRepository.findAll();
    }

    public Bugs saveTicket(final Bugs ticketDetails){
        return ticketRepository.save(ticketDetails);
    }

    public com.capgemini.ebugtracker.bugs.entity.Bugs getTicket(final Long tiketId){
        try {
            return ticketRepository.findById(tiketId).get();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Bugs getBugForUser(final Long staffid){
        return ticketRepository.getById(staffid);
    }
}
