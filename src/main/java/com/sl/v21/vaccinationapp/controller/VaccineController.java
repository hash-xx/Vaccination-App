package com.sl.v21.vaccinationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.sl.v21.vaccinationapp.model.Vaccine;
import com.sl.v21.vaccinationapp.model.Search;

import com.sl.v21.vaccinationapp.service.VaccineService;
import com.sl.v21.vaccinationapp.util.PaginatorHelper;

@Controller
@RequestMapping("/vaccine")
public class VaccineController {
	
	@Autowired
	private VaccineService service;
	
	

	@RequestMapping(value= "", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@ModelAttribute(value = "search") Search search,Model model, 
			@PageableDefault(value = PaginatorHelper.DEFAULT_PAGINATION_SIZE, page = 0) Pageable pageable) {
		List<Vaccine> vaccines = service.listSearched(search);
		Page<Vaccine> page=PaginatorHelper.pagiableList(vaccines, pageable);
		model.addAttribute("vaccines", vaccines);
		model.addAttribute("page", page);
		return "vaccine/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		Vaccine vaccine = new Vaccine();
		
		
	    model.addAttribute("vaccine", vaccine);
	   
		return "vaccine/add";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("vaccine") Vaccine vaccine) {
	    service.save(vaccine);
	     
	    return "redirect:/vaccine";
	}
	
	@RequestMapping("/edit/{id}")
	public String showEditProductPage(Model model,@PathVariable(name = "id") int id) {
	    Vaccine vaccine = service.get(id);
	   
	    
	    model.addAttribute("vaccine", vaccine);
	   
	    
	    return "vaccine/add";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String delete(Model model,@PathVariable(name = "id") int id) {
	    service.delete(id);
	    
	    return "redirect:/vaccine";
	}
}
