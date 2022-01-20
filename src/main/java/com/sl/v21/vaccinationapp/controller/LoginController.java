package com.sl.v21.vaccinationapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
    public String login(HttpServletRequest request,Model model, String error, String logout) {
        if (error != null) {
        	HttpSession session = request.getSession(false);
            String errorMessage = null;
            if (session != null) {
                AuthenticationException ex = (AuthenticationException) session
                        .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
                if (ex != null) {                	
                	if(ex instanceof UsernameNotFoundException) {
                		UsernameNotFoundException unfEx= (UsernameNotFoundException) ex;
                		errorMessage = unfEx.getMessage();
                	}else {                    	
                        errorMessage = ex.getMessage();
                	}
                }
            }
        	
            model.addAttribute("error", errorMessage);
        }
        if (logout != null)
            model.addAttribute("message", "logged out successfully.");

        return "login";
    }
	
}
