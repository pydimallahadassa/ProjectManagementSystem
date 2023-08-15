package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Team;
import com.example.demo.repository.ITeamRepository;
import com.example.demo.service.ITeamService;

@RestController
@RequestMapping("/team")
@CrossOrigin("http://localhost:4200/")
public class TeamController {
	
	@Autowired
	 ITeamRepository teamRepo;
	@Autowired
	ITeamService teamService;


	@PostMapping("/add")// localhost:8761/TeamMember/addTeamMember
	ResponseEntity<Team> addTeam(@RequestBody Team team){
		Team newTeam = teamService.addTeam(team);
		return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
	}

	@GetMapping("/allTeam") // localhost:8761/Team/allTeammembers
	public List<Team> getAllTeam() {
		return teamService.getAllTeams();
	}
	
	@GetMapping("/getByProjectId/{projectId}")
	ResponseEntity<Team> getByProjectId(@PathVariable int projectId){
		Team team = teamService.getByProjectId(projectId);
		return new ResponseEntity<>(team,HttpStatus.OK);
	}
}
