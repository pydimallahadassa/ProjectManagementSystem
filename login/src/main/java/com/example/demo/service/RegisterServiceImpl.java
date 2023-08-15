package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Register;
import com.example.demo.repository.IRegisterRepository;

@Service
public class RegisterServiceImpl implements IRegisterService {
	
	@Autowired
	IRegisterRepository regRepo;
	
	@Override
	
	public Register getById(int rId) {
		// TODO Auto-generated method stub
		Optional<Register> register=regRepo.findById(rId);
		return register.get();
	}
	
	public Register adduser(Register register) {
		Register newRegister = regRepo.save(register);

		return newRegister;
}
	public Register deleteuser(int rId) {
		Optional<Register> registerOpt = regRepo.findById(rId);
		Register r1 = registerOpt.get();
		regRepo.deleteById(rId);
		return r1;
	}
}
