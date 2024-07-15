package com.kapasiya.SFasionHub.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user_data")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fname;

    private String lname;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "cust_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") )
    Set<Role> roles = new HashSet<Role>();

    public Set<Role> getRole() {
        return roles;
    }

    public void setRole(Role role) {
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
