package com.kapasiya.SFasionHub.repository;

import com.kapasiya.SFasionHub.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>
{
    Role findByRole(String name);
}
