package com.kapasiya.SFasionHub.service;

import com.kapasiya.SFasionHub.datatransferobject.UserRegisteredDTO;
import com.kapasiya.SFasionHub.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService
{
    User save(UserRegisteredDTO userRegisteredDTO);

}
