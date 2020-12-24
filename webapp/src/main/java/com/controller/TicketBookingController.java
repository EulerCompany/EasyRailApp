package com.controller;

import com.entity.*;
import com.repository.UserRepository;
import com.service.TicketService;
import com.service.UserService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.plaf.PanelUI;
import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class TicketBookingController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/book", method = RequestMethod.GET)
    public @ResponseBody Ticket book(@RequestParam String userId,
                                    @RequestParam String ticketId) {

        Optional<Ticket> ticket = ticketService.findTicketById(Long.parseLong(ticketId));

        if(ticket.isPresent()) {
            Optional<User> user = userService.findUserById(Long.parseLong(userId));
            if(user.isPresent()) {
                Ticket ticket1 = ticket.get();
                ticket1.setUser(user.get());
                ticket1.setBooked(true);
                ticketService.saveTicket(ticket1);

                ticket1.setTrain(null);
                return ticket1;
            }
        }
        return null;
    }
}

