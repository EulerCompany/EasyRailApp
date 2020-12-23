package com.service;

import com.entity.Ticket;
import com.entity.Train;
import com.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public boolean saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        return true;
    }

}
