package com.holautism.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
@Controller
public class AppController {
 
    @Autowired
    private UserRepository userRepo;
     
    @GetMapping("/home")
    public String viewHomePage() {
        return "index";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "signup_form";
    }
    
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         
        userRepo.save(user);
         
        return "register_success";
    }
    
    @GetMapping("/users")
    	public String showUsers() {
            return "users";
    }
    
    @GetMapping("/account")
    public String viewDetails(@AuthenticationPrincipal CustomUserDetails loggedUser, Model model) {
    	String email = loggedUser.getUsername();
    	User user = userRepo.getByEmail(email);
    	model.addAttribute("user", user);
    	
    	return "account_form";
    } 
    
    @GetMapping("/services")
    public String showServices() {
        return "services";
    }
    
    @GetMapping("/pro_profiles")
    public String showProProfiles() {
        return "pro_profiles";
    }
    
    @GetMapping("/update_user")
    public String viewUpdateForm(@AuthenticationPrincipal CustomUserDetails loggedUser, Model model) {
    	String email = loggedUser.getUsername();
    	User user = userRepo.getByEmail(email);
    	model.addAttribute("user", user);
    	
    	return "update_user";
    } 

}