package com.leader.main.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leader.main.exception.InvalidCredentialsException;
import com.leader.main.exception.InvalidUserId;
import com.leader.main.entity.TeamLeader;
import com.leader.main.repository.TeamLeaderRepository;

@Service
public class TeamLeaderServiceImpl implements TeamLeaderService {

	@Autowired
	TeamLeaderRepository teamLeaderRepository;

   

    @Override
	public TeamLeader addTeamLeader(TeamLeader teamLeader) {
		return teamLeaderRepository.save(teamLeader);
	}
    @Override
    public List<TeamLeader> getAllTeamLeader() {
        return teamLeaderRepository.findAll();
    }

    @Override
    public TeamLeader getTeamLeaderById(int teamLeadId) throws InvalidUserId {
        Optional<TeamLeader> t1=teamLeaderRepository.findByTeamLeadId(teamLeadId);
		if(t1.isPresent()) {
			TeamLeader teamLead=t1.get();
			return teamLead;
		}else {
			throw new InvalidUserId("Task not found with id: "+ teamLeadId);
		}
    }

    public TeamLeader updateTeamLeader(TeamLeader teamLeader) throws InvalidUserId {

    	return teamLeaderRepository.save(teamLeader);
        
    }

    @Override
    public void delete(int teamLeadId) throws InvalidUserId {
    	teamLeaderRepository.deleteById(teamLeadId);
    }

    @Override
    public TeamLeader loginTeamLeader(String email, String password) throws InvalidCredentialsException {

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidCredentialsException("Email or Password cannot be empty");
        }

        TeamLeader teamLeader = teamLeaderRepository.findTeamLeaderByEmailPassword(email, password);

        if (teamLeader == null) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        return teamLeader;
    }
	
}





