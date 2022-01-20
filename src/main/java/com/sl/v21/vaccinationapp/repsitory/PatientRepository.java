package com.sl.v21.vaccinationapp.repsitory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sl.v21.vaccinationapp.model.Patient;
import com.sl.v21.vaccinationapp.model.Search;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

	@Query("SELECT e FROM Patient e WHERE e.name LIKE %:name% order by e.id desc")
	List<Patient> listSearched(@Param("name") String name);

}
