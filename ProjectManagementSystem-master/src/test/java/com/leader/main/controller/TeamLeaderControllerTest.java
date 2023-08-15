package com.leader.main.controller;

import com.google.common.base.Optional;

import com.leader.main.entity.TeamLeader;
import com.leader.main.exception.InvalidCredentialsException;
import com.leader.main.exception.InvalidUserId;
import com.leader.main.exception.NullEmailFoundException;
import com.leader.main.exception.NullUserFound;
import com.leader.main.repository.TeamLeaderRepository;
import com.leader.main.service.TeamLeaderService;
import com.leader.model.RequiredResponse;
import com.leader.model.TeamMember;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TeamLeaderControllerTest {

	 @Mock
	    private RestTemplate restTemplate;

	 @Mock
	    private TeamLeaderRepository leaderRepo;

    @Mock
    private TeamLeaderService teamLeaderService;

    @Mock
    private Logger logger;

    @InjectMocks
    private TeamLeaderController teamLeaderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testRegisterTeamLeader() throws NullUserFound, NullEmailFoundException {
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setFirstName("John");
        teamLeader.setLastName("Doe");
        teamLeader.setEmail("john@example.com");
        teamLeader.setPassword("password");

        when(teamLeaderService.addTeamLeader(teamLeader)).thenReturn(teamLeader);

        TeamLeader result = teamLeaderController.addTeamLeader(teamLeader);

        assertEquals(teamLeader, result);
        verify(teamLeaderService, times(1)).addTeamLeader(teamLeader);
    }

    @Test
     void testGetAllTeamLeader() {
        List<TeamLeader> teamLeaderList = new ArrayList<>();
        teamLeaderList.add(new TeamLeader());
        teamLeaderList.add(new TeamLeader());

        when(teamLeaderService.getAllTeamLeader()).thenReturn(teamLeaderList);

        List<TeamLeader> result = teamLeaderController.getAllTeamLeader();

        assertEquals(teamLeaderList, result);
        verify(teamLeaderService, times(1)).getAllTeamLeader();
    }

    @Test
     void testUpdateTeamLeader() throws InvalidUserId {
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setTeamLeadId(1);
        teamLeader.setFirstName("John");
        teamLeader.setLastName("Doe");
        teamLeader.setEmail("john@example.com");
        teamLeader.setPassword("password");

        when(teamLeaderService.updateTeamLeader(teamLeader)).thenReturn(teamLeader);

        TeamLeader result = teamLeaderController.updateTeamLeader(teamLeader);

        assertEquals(teamLeader, result);
        verify(teamLeaderService, times(1)).updateTeamLeader(teamLeader);
    }

    @Test
     void testDeleteTeamLeaderById() throws InvalidUserId {
        int teamLeadId = 1;

        String expectedResult = "Deleted Id = " + teamLeadId + " Data";
        doNothing().when(teamLeaderService).delete(teamLeadId);

        String result = teamLeaderController.deleteTeamLeaderById(teamLeadId);

        assertEquals(expectedResult, result);
        verify(teamLeaderService, times(1)).delete(teamLeadId);
    }

    @Test
     void testLoginTeamLeader() throws InvalidCredentialsException {
        String email = "john@example.com";
        String password = "password";
        TeamLeader teamLeader = new TeamLeader();

        when(teamLeaderService.loginTeamLeader(email, password)).thenReturn(teamLeader);

        TeamLeader result = teamLeaderController.loginTeamLeader(email, password);

        assertEquals(teamLeader, result);
        verify(teamLeaderService, times(1)).loginTeamLeader(email, password);
    }

    @Test
     void testGetTeamleaderId() throws Exception {
        int tId = 1;
        TeamLeader teamLeader = new TeamLeader();

        when(teamLeaderService.getTeamLeaderById(tId)).thenReturn(teamLeader);

        TeamLeader result = teamLeaderController.getTeamleaderId(tId);

        assertEquals(teamLeader, result);
        verify(teamLeaderService, times(1)).getTeamLeaderById(tId);
    }


    @Test
    void testGetAllDataBasedOnTeamMemberId() throws NullUserFound, NullEmailFoundException, InvalidUserId {
        int mId = 2;

        // Mock the response from the team leader service
        TeamLeader leader = new TeamLeader();
        leader.setMId(mId);
        when(teamLeaderService.getTeamLeaderById(mId)).thenReturn(leader);

        // Mock the response from the team member API using RestTemplate
        List<TeamMember> members = new ArrayList<>();
        members.add(new TeamMember());
        members.add(new TeamMember());
        when(restTemplate.getForObject("http://TEAMMEMBER/TeamMember/mId/" + mId, List.class))
                .thenReturn(members);

        // Invoke the method under test
//        ResponseEntity<RequiredResponse> response = teamLeaderController.getAllDataBasedOnTeamMemberId(mId);
//
//        // Verify the response
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        RequiredResponse requiredResponse = response.getBody();
//        assertEquals(leader, requiredResponse.getLeader());
//        assertEquals(members, requiredResponse.getMember());
//
//        // Verify the interactions with the mock objects
//        verify(teamLeaderService, times(1)).getTeamLeaderById(mId);
//        verify(restTemplate, times(1)).getForObject("http://TEAMMEMBER/TeamMember/mId/" + mId, List.class);
    }
}