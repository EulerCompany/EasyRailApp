package com.entity;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Ticket")
public class TicketRedis implements Serializable {
        private Long ticketId;
        private Long userdId;
}
