package com.leader.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.leader.main.entity.TeamLeader;
import com.leader.main.exception.InvalidCredentialsException;
import com.leader.main.exception.InvalidUserId;

import com.leader.main.repository.TeamLeaderRepository;
import com.leader.main.service.TeamLeaderService;
import com.leader.model.RequiredResponse;
import com.leader.model.TeamMember;

@RestController
@RequestMapping("/TeamLeader")
@CrossOrigin("http://localhost:4200/")
public class TeamLeaderController {

	@Autowired
	private TeamLeaderRepository leaderRepo;
	@Autowired
	TeamLeaderService teamLeaderService;

	@Autowired
	private RestTemplate restTemplate;
	

	// localhost:7001/TeamMember/addTeamMember
	@PostMapping("/add")
	public TeamLeader addTeamLeader(@RequestBody TeamLeader teamLeader) {

			return teamLeaderService.addTeamLeader(teamLeader);
		
	}
	
	// localhost:7001/TeamLeader/allTeamLeader
	@GetMapping("/allTeamLeader") 
	public List<TeamLeader> getAllTeamLeader() {

		return teamLeaderService.getAllTeamLeader();
	}

	// localhost:7001/TeamLeader/updateTeamLeader
	@PutMapping("/updateTeamLeader") 
	public TeamLeader updateTeamLeader(@RequestBody TeamLeader teamLeader) throws InvalidUserId {


		return teamLeaderService.updateTeamLeader(teamLeader);
	}
	
	// localhost:7001/TeamLeader/delete/2
	@DeleteMapping("/delete/{teamLeadId}") 
	public String deleteTeamLeaderById(@PathVariable int teamLeadId) throws InvalidUserId {

		try {
			teamLeaderService.delete(teamLeadId);

		} catch (Exception e) {


			e.printStackTrace();
			return "Id not found";
		}
		return "Deleted Id = " + teamLeadId + " Data";
	}
	
	// localhost:7001/TeamLeader/loginTeamLeader/anu@gmail.com/vijju
	@GetMapping("/loginTeamLeader/{email}/{password}") 
	public TeamLeader loginTeamLeader(@PathVariable String email, @PathVariable String password)
			throws InvalidCredentialsException {

		return teamLeaderService.loginTeamLeader(email, password);
	}

	@GetMapping("/getById/{teamLeadId}") // localhost:7001/TeamLeader/tId/4
	public TeamLeader getTeamleaderId(@PathVariable int teamLeadId) throws InvalidUserId {

		return teamLeaderService.getTeamLeaderById(teamLeadId);

	}
	
	
	
	
	
//	@GetMapping("/mId/{mId}")// localhost:7001/TeamLeader/id/2
//	public  ResponseEntity<RequiredResponse> getAllDataBasedOnTeamMemberId(@PathVariable int mId){
//		
//		RequiredResponse requiredResponse = new RequiredResponse();
//		
//		TeamLeader leader = leaderRepo.findById(mId).get();
//		
//		requiredResponse.setLeader(leader);
//		
//		List<TeamMember> listOfMembers =  restTemplate.getForObject("http://TEAMMEMBER/TeamMember/mId/"+mId, List.class);
//		
//		requiredResponse.setMember(listOfMembers);
//		return new ResponseEntity<>(requiredResponse, HttpStatus.OK);
//		
//	}
	
}
