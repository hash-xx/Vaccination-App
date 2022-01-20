package com.sl.v21.vaccinationapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Patient {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date vaccination_date;

	private String national_id;
	
	private String sex;
	
	private String age;
	
	private String name_vaccine;
	
	private String vaccine_dose;
	
	private String place_vaccine;

	

	
	private String batch_number;
	
	
	private String district;

	
	@ManyToOne

		
    public Integer getId() {
        return id;
    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}






	public void setId(Integer id) {
		this.id = id;
	}




	public String getNational_id() {
		return national_id;
	}

	public void setNational_id(String national_id) {
		this.national_id = national_id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName_vaccine() {
		return name_vaccine;
	}

	public void setName_vaccine(String name_vaccine) {
		this.name_vaccine = name_vaccine;
	}

	public String getVaccine_dose() {
		return vaccine_dose;
	}

	public void setVaccine_dose(String vaccine_dose) {
		this.vaccine_dose = vaccine_dose;
	}

	public String getPlace_vaccine() {
		return place_vaccine;
	}

	public void setPlace_vaccine(String place_vaccine) {
		this.place_vaccine = place_vaccine;
	}

	public String getBatch_number() {
		return batch_number;
	}

	public void setBatch_number(String batch_number) {
		this.batch_number = batch_number;
	}

	public Date getVaccination_date() {
		return vaccination_date;
	}

	public void setVaccination_date(Date vaccination_date) {
		this.vaccination_date = vaccination_date;
	}




	
}
