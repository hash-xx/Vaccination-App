package com.sl.v21.vaccinationapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.v21.vaccinationapp.model.Patient;
import com.sl.v21.vaccinationapp.model.Search;
import com.sl.v21.vaccinationapp.repsitory.PatientRepository;

@Service
@Transactional
public class PatientService {
	
	@Autowired
	private PatientRepository repo;
	
	public List<Patient> listAll() {
        return repo.findAll();
    }
     
    public void save(Patient patient) {
        repo.save(patient);
    }
     
    public Patient get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }

	public List<Patient> listSearched(Search search) {
		return repo.listSearched(search.getName());
	}
	

}
