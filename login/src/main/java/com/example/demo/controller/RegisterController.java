package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Register;
import com.example.demo.service.IRegisterService;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	IRegisterService registerServ;
	
	private static Logger logger = LogManager.getLogger();
	@PostMapping("/add")
    ResponseEntity<Register> addUser(@RequestBody Register register){
        logger.info("Sending request to add new user");
        Register newUser = registerServ.adduser(register);
        logger.info("Added new user");
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
	
	  @GetMapping("/get/{rId}")
	    ResponseEntity<Register> getById(@PathVariable int rId){
	        logger.info("Request user rId");
	        Register register = registerServ.getById(rId);
	        logger.info("Successfully viewed a user by rId");
	        return new ResponseEntity<>(register,HttpStatus.OK);
	    }
	
	   @DeleteMapping("/delete/{rId}")
	    ResponseEntity<Register> deleteUser(@PathVariable int rId) {
	        logger.info("Request to delete a user");
	        Register deletedUser = registerServ.deleteuser(rId);
	        logger.info("Successfully deleted a user");
	        return new ResponseEntity<>(deletedUser,HttpStatus.OK);
	    }
	

}
