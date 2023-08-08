package com.leader.main.service;


import java.util.List;



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
    public TeamLeader getTeamLeaderById(Integer id) throws InvalidUserId {

        if (id == null || id == 0) {
            throw new InvalidUserId("Invalid user id");
        }

        TeamLeader teamLeader = teamLeaderRepository.getTeamLeaderbytId(id);

        if (teamLeader == null) {
            throw new InvalidUserId("No Team Leader exists with the provided id: " + id);
        }

        return teamLeader;
    }

    public TeamLeader updateTeamLeader(TeamLeader teamLeader) throws InvalidUserId {

    	return teamLeaderRepository.save(teamLeader);
        
    }

    @Override
    public void delete(int tId) throws InvalidUserId {
    	teamLeaderRepository.deleteById(tId);
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





