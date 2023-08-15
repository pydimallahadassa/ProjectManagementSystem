package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Register;

@Repository
public interface IRegisterRepository extends JpaRepository<Register, Integer>{
	
	Optional<Register> findByUserName(String userName);

}
