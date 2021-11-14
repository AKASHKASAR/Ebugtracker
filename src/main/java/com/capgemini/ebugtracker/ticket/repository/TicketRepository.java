package com.capgemini.ebugtracker.ticket.repository;

import com.capgemini.ebugtracker.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAll();
    Ticket save(Ticket ticket);
    Optional<Ticket> findById(Long tiketId);
}
