package com.controller;

import com.entity.City;
import com.entity.Station;
import com.entity.TicketRedis;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TicketBookingController {


    @RequestMapping(value = "/admin/redis", method = RequestMethod.GET)
    @ResponseBody
    public String addStation(@RequestParam String cityName,
                             @RequestParam String stationName) {


        TicketRedis ticketRedis = new TicketRedis();
        ticketRedis.setId(100L);

        return "";
    }
}

