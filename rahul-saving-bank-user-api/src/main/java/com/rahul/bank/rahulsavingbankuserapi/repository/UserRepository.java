package com.rahul.bank.rahulsavingbankuserapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rahul.bank.rahulsavingbankuserapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "from User where email=:#{#user.email} AND password=:#{#user.password}")
	User isValid(@Param("user") User user);

}
