package com.entity;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Ticket")
public class TicketRedis implements Serializable {
        private Long id;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }
}
