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


import com.sl.v21.vaccinationapp.model.Patient;
import com.sl.v21.vaccinationapp.model.Search;

import com.sl.v21.vaccinationapp.service.PatientService;
import com.sl.v21.vaccinationapp.util.PaginatorHelper;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	

	@RequestMapping(value= "", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@ModelAttribute(value = "search") Search search,Model model, 
			@PageableDefault(value = PaginatorHelper.DEFAULT_PAGINATION_SIZE, page = 0) Pageable pageable) {
		List<Patient> patients = service.listSearched(search);
		Page<Patient> page=PaginatorHelper.pagiableList(patients, pageable);
		model.addAttribute("patients", patients);
		model.addAttribute("page", page);
		return "patient/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		Patient patient = new Patient();
		
		
	    model.addAttribute("patient", patient);
	   
		return "patient/add";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("patient") Patient patient) {
	    service.save(patient);
	     
	    return "redirect:/patient";
	}
	
	@RequestMapping("/edit/{id}")
	public String showEditProductPage(Model model,@PathVariable(name = "id") int id) {
	    Patient patient = service.get(id);
	   
	    
	    model.addAttribute("patient", patient);
	   
	    
	    return "patient/add";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String delete(Model model,@PathVariable(name = "id") int id) {
	    service.delete(id);
	    
	    return "redirect:/patient";
	}
}
