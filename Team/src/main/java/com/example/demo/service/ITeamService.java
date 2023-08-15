package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Team;

public interface ITeamService {
	Team addTeam(Team t);
	String deleteTeamById(int tId);
	Team getTeamById(int tId);
	List<Team> getAllTeams();
	Team getByProjectId(int projectId);

}
