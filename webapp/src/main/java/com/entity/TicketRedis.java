package com.entity;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Ticket")
public class TicketRedis implements Serializable {


        private String id;
        private String name;
        private int grade;
}
