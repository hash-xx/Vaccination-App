package com.sl.v21.vaccinationapp.controller;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class DashboardController {
	
	@RequestMapping("")
	public String index(Model model) {
		return "dashboard";
	}
}
