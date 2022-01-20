package com.sl.v21.vaccinationapp.repsitory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sl.v21.vaccinationapp.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>{

	@Query("SELECT ua FROM UserAccount ua WHERE ua.userName LIKE %:userName%")
	UserAccount findByUsername(@Param("userName") String userName);
	
}
