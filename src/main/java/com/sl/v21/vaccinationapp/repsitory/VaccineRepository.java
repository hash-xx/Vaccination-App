package com.sl.v21.vaccinationapp.repsitory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sl.v21.vaccinationapp.model.Vaccine;
import com.sl.v21.vaccinationapp.model.Search;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer>{

	@Query("SELECT e FROM Vaccine e WHERE e.name LIKE %:name% order by e.id desc")
	List<Vaccine> listSearched(@Param("name") String name);

}
