package com.kapasiya.SFasionHub.repository;

import com.kapasiya.SFasionHub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{
    User findByEmail(String email);
}
