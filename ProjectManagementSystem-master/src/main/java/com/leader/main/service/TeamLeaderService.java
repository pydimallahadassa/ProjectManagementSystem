package com.leader.main.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.leader.main.entity.TeamLeader;
import com.leader.main.exception.InvalidCredentialsException;
import com.leader.main.exception.InvalidUserId;

@Service
public interface TeamLeaderService {

	public TeamLeader addTeamLeader(TeamLeader teamLeader) ;


	public List<TeamLeader> getAllTeamLeader();

	public TeamLeader getTeamLeaderById(int teamLeadId) throws InvalidUserId;

	public TeamLeader updateTeamLeader(TeamLeader teamLeader) throws InvalidUserId;

	public void delete(int tId) throws InvalidUserId;

	public TeamLeader loginTeamLeader(String email, String password) throws InvalidCredentialsException;
}
