package com.kapasiya.SFasionHub.serviceimpl;

import com.kapasiya.SFasionHub.datatransferobject.UserRegisteredDTO;
import com.kapasiya.SFasionHub.entity.Role;
import com.kapasiya.SFasionHub.entity.User;
import com.kapasiya.SFasionHub.repository.RoleRepository;
import com.kapasiya.SFasionHub.repository.UserRepository;
import com.kapasiya.SFasionHub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println("Email: "+email);
        User user = userRepository.findByEmail(email);
        System.out.println(user);

        if(user == null)
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles)
    {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }


    @Override
    public User save(UserRegisteredDTO userRegisteredDTO)
    {
        Role role = new Role();

        if(userRegisteredDTO.getRole().equals("USER"))
            role = roleRepo.findByRole("USER");

        else if(userRegisteredDTO.getRole().equals("ADMIN"))
            role = roleRepo.findByRole("ADMIN");

        User user = new User();
        user.setEmail(userRegisteredDTO.getEmail());
        user.setFname(userRegisteredDTO.getFname());
        user.setLname(userRegisteredDTO.getLname());
        user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));
        user.setRole(role);

        return userRepository.save(user);
    }
}
