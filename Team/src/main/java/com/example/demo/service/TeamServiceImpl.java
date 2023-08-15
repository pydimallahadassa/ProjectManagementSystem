package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Project;
import com.example.demo.entity.Team;
import com.example.demo.repository.ITeamRepository;

@Service
public class TeamServiceImpl implements ITeamService{
	
	@Autowired
	ITeamRepository teamRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TeamServiceImpl(ITeamRepository teamRepo) {
		this.teamRepo = teamRepo;
	}
	
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

	@Override
	public Team getByProjectId(int projectId) {
		Team t1 = teamRepo.findByProjectId(projectId);
		Project project = restTemplate.getForObject("http://localhost:8082/project/get"+t1.getProjectId(), Project.class);
		t1.setProject(project);
		return t1;
	}
	
}