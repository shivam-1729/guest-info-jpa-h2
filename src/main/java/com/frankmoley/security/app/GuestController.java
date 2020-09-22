package com.frankmoley.security.app;

import com.frankmoley.security.app.domain.Guest;
import com.frankmoley.security.app.domain.MyUserDetails;
import com.frankmoley.security.app.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
//import com.frankmoley.security.app.domain.MyUserDetailsService ;
/**
 * @author Frank P. Moley III.
 */
@Controller
@RequestMapping("/")
public class GuestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value={"/", "/index"})
    public String getHomePage(Model model){

        return "index";
    }

    @GetMapping(value="/login")
    public String getLoginPage(Model model){
        return "login";
    }

    @GetMapping(value="/logout-success")
    public String getLogoutPage(Model model){
        return "logout";
    }

    @GetMapping(value="/user/{id}")
    @PreAuthorize("authentication.principal.getId()==#id || hasRole('ROLE_ADMIN')")
    //@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String getUserPage(@PathVariable("id") int id, Model model){
        //System.out.println("shivam") ;
        //System.out.println(user.getId());
        Optional<Guest> u=userRepository.findById(id) ;
        u.orElseThrow(() -> new UsernameNotFoundException("Not found: " + String.valueOf(id)));

        MyUserDetails user= u.map(MyUserDetails::new).get() ;
        model.addAttribute("firstname", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        model.addAttribute("email", user.getEmailAddress());
        model.addAttribute("address", user.getAddress());
        model.addAttribute("phone", user.getPhoneNumber());
        model.addAttribute("country", user.getCountry());
        return "user";
//        if(user != null) {
//            model.addAttribute("firstname", user.getFirstName());
//            model.addAttribute("lastname", user.getLastName());
//            model.addAttribute("email", user.getEmailAddress());
//            model.addAttribute("address", user.getAddress());
//            model.addAttribute("phone", user.getPhoneNumber());
//            model.addAttribute("country", user.getCountry());
//            return "user";
//        }
//        else
//        {   Authentication loggeduser= SecurityContextHolder.getContext().getAuthentication() ;
//            MyUserDetails usr= (MyUserDetails) loggeduser.getPrincipal();
//            return ("redirect:/user/"+usr.getId());
//        }
    }

//    @GetMapping(value="/user/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
//
//    public String getUserPage(Model model){
//        Authentication loggeduser= SecurityContextHolder.getContext().getAuthentication() ;
//        MyUserDetails user= (MyUserDetails) loggeduser.getPrincipal();
//        model.addAttribute("firstname", user.getFirstName());
//        model.addAttribute("lastname", user.getLastName());
//        model.addAttribute("email", user.getEmailAddress());
//        model.addAttribute("address", user.getAddress());
//        model.addAttribute("phone", user.getPhoneNumber());
//        model.addAttribute("country", user.getCountry());
//        return "user";
//    }

    @GetMapping(value="/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAdminPage(Model model){
        //System.out.println("shivam");
        Authentication loggeduser= SecurityContextHolder.getContext().getAuthentication() ;
        MyUserDetails user= (MyUserDetails)loggeduser.getPrincipal();
        //model.addAttribute("usercount",user.getUsercount());
        return "admin";
    }

    @GetMapping(value="/user/{id}/setcountry/{value}")
    @PreAuthorize("authentication.principal.getId()==#id || hasRole('ROLE_ADMIN')")
    //@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String updatecountry(@PathVariable("id") int id,@PathVariable("value") String country){
        //System.out.println("shivam") ;
        //System.out.println(user.getId());
        Optional<Guest> u=userRepository.findById(id) ;
        u.orElseThrow(() -> new UsernameNotFoundException("Not found: " + String.valueOf(id)));
        MyUserDetails user= u.map(MyUserDetails::new).get() ;

        userRepository.setCountry(country,id) ;

        return ("redirect:/user/"+String.valueOf(user.getId()));
//
        }

    @GetMapping(value="/user/{id}/setid/{value}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    //@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String updateid(@PathVariable("id") int id,@PathVariable("value") int value){
        //System.out.println("shivam") ;
        //System.out.println(user.getId());
        Optional<Guest> u=userRepository.findById(id) ;
        u.orElseThrow(() -> new UsernameNotFoundException("Not found: " + String.valueOf(id)));
        MyUserDetails user= u.map(MyUserDetails::new).get() ;

        userRepository.setId(value,id) ;

        return ("redirect:/user/"+String.valueOf(user.getId()));
//
    }



}
