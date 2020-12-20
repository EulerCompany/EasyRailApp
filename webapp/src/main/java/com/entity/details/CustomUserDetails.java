package com.entity.details;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetails extends UserDetails {
   public String getFirstname();
   public String getLastname();
}
