package com.example.demo.service;



import com.example.demo.entity.Register;

public interface IRegisterService {
	Register getById(int rId);
	Register adduser(Register register);
	Register deleteuser(int rId);
	
	
}