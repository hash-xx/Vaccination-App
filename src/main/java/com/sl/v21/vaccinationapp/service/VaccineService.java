package com.sl.v21.vaccinationapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.v21.vaccinationapp.model.Vaccine;
import com.sl.v21.vaccinationapp.model.Search;
import com.sl.v21.vaccinationapp.repsitory.VaccineRepository;

@Service
@Transactional
public class VaccineService {
	
	@Autowired
	private VaccineRepository repo;
	
	public List<Vaccine> listAll() {
        return repo.findAll();
    }
     
    public void save(Vaccine vaccine) {
        repo.save(vaccine);
    }
     
    public Vaccine get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }

	public List<Vaccine> listSearched(Search search) {
		return repo.listSearched(search.getName());
	}
	

}
