package com.kapasiya.SFasionHub.controller;


import com.kapasiya.SFasionHub.datatransferobject.UserLoginDTO;
import com.kapasiya.SFasionHub.datatransferobject.UserRegisteredDTO;
import com.kapasiya.SFasionHub.global.GlobalData;
import com.kapasiya.SFasionHub.repository.RoleRepository;
import com.kapasiya.SFasionHub.repository.UserRepository;
import com.kapasiya.SFasionHub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController
{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/login")
    public String login()
    {
        GlobalData.cart.clear();
        return "login";
    }

    @ModelAttribute("userLogin")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }


    @Autowired
    UserService userService;

    @PostMapping("/login")
    public void loginUser(@ModelAttribute("userLogin") UserLoginDTO userLoginDTO)
    {
        System.out.println(userLoginDTO.getEmail());
        System.out.println(userLoginDTO.getPassword());

        userService.loadUserByUsername(userLoginDTO.getEmail());
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("userRegister") UserRegisteredDTO userRegisteredDTO)
    {
        userRegisteredDTO.setRole("USER");
        System.out.println(userRegisteredDTO);
        userService.save(userRegisteredDTO);

        return"redirect:/login";
    }

    @GetMapping("/register")
    public String registerGet()
    {
        return "register";
    }
}
