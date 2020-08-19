package com.frankmoley.security.app;

import com.frankmoley.security.app.domain.Guest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import com.frankmoley.security.app.domain.MyUserDetailsService ;
/**
 * @author Frank P. Moley III.
 */
@Controller
@RequestMapping("/")
public class GuestController {

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
    //@PreAuthorize("authentication.principal.getId()==#id || hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String getUserPage(@PathVariable("id") String id, Model model){
        Guest user= MyUserDetailsService.loadUserById(id);
        //System.out.println("shivam") ;
        //System.out.println(user.getId());
        if(user != null) {
            model.addAttribute("firstname", user.getFirstName());
            model.addAttribute("lastname", user.getLastName());
            model.addAttribute("email", user.getEmailAddress());
            model.addAttribute("address", user.getAddress());
            model.addAttribute("phone", user.getPhoneNumber());
            model.addAttribute("country", user.getCountry());
            return "user";
        }
        else
        {   Authentication loggeduser= SecurityContextHolder.getContext().getAuthentication() ;
            Guest usr= (Guest)loggeduser.getPrincipal();
            return ("redirect:/user/"+usr.getId());
        }
    }

    @GetMapping(value="/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAdminPage(Model model){
        //System.out.println("shivam");
        Authentication loggeduser= SecurityContextHolder.getContext().getAuthentication() ;
        Guest user= (Guest)loggeduser.getPrincipal();
        model.addAttribute("usercount",user.getUsercount());
        return "admin";
    }

}
