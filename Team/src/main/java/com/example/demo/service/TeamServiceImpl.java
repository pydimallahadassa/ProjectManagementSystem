package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Team;
import com.example.demo.repository.ITeamRepository;

@Service
public class TeamServiceImpl implements ITeamService{
	
	@Autowired
	ITeamRepository teamRepo;
	
	
	
	@Override
	public Team addTeam(Team t) {
			return teamRepo.save(t);
		
		
	}

	@Override
	public String deleteTeamById(int tId) {
		Optional<Team> teamOpt = teamRepo.findById(tId);
		
			Team deletedTeam = teamOpt.get();
			teamRepo.deleteById(tId);
			return 	"Deleted sucessfuly";

		
		
	}

	@Override
	public Team getTeamById(int tId)  {
		Optional<Team> teamOpt = teamRepo.findById(tId);
		
		Team team = teamOpt.get();
		return team;
		
		
}
	
	
	@Override
	public List<Team> getAllTeams() {
		List<Team> getallteams = teamRepo.findAll();
		return getallteams;
	}
	
}