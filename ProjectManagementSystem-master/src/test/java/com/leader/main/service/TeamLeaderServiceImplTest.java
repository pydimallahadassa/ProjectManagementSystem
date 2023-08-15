package com.leader.main.service;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.leader.main.entity.TeamLeader;
import com.leader.main.exception.InvalidCredentialsException;
import com.leader.main.exception.InvalidUserId;
import com.leader.main.exception.NullEmailFoundException;
import com.leader.main.exception.NullUserFound;
import com.leader.main.exception.UserControllerAdvice;
import com.leader.main.repository.TeamLeaderRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeamLeaderServiceImplTest { 

    @Mock
    private TeamLeaderRepository teamLeaderRepository;

    @InjectMocks
    private TeamLeaderServiceImpl teamLeaderService;
    
    private UserControllerAdvice userControllerAdvice;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private static final Logger logger = LoggerFactory.getLogger(TeamLeaderServiceImplTest.class);

    @Test
     void testInsertTeamLeader() throws NullUserFound, NullEmailFoundException {
        logger.info("Running testInsertTeamLeader");

    	TeamLeader teamLeader = new TeamLeader();
		teamLeader.setFirstName("Jane Smith");
		teamLeader.setLastName("Smith");
		teamLeader.setEmail("jane@example.com");
		teamLeader.setPassword("js123");
        when(teamLeaderRepository.save(teamLeader)).thenReturn(teamLeader);

        TeamLeader result = teamLeaderService.addTeamLeader(teamLeader);

        assertNotNull(result);
        assertEquals(teamLeader, result);

        verify(teamLeaderRepository, times(1)).save(teamLeader);
    }

    @Test
     void testGetAllTeamLeader() throws Exception {
        logger.info("Running testGetAllTeamLeader");

        List<TeamLeader> paymentList = new ArrayList<>();
        paymentList.add(new TeamLeader(002, "Anu", "Ravi", "anu@gmail.com", "A@843",1));
        paymentList.add(new TeamLeader(003, "San", "Jai", "san@gmail.com", "S#234",2));

        when(teamLeaderRepository.findAll()).thenReturn(paymentList);

        List<TeamLeader> result = teamLeaderService.getAllTeamLeader();

        assertNotNull(result);
        assertEquals(paymentList, result);

        verify(teamLeaderRepository, times(1)).findAll();
    }
   

    @Test
     void testUpdateTeamLeader() throws Exception {
        logger.info("Running testUpdateTeamLeader");

    	TeamLeader teamLeader = new TeamLeader();
		teamLeader.setFirstName("Jane Smith");
		teamLeader.setLastName("Smith");
		teamLeader.setEmail("jane@example.com");
		teamLeader.setPassword("js123");

        when(teamLeaderRepository.existsById(teamLeader.getTeamLeadId())).thenReturn(true);
        when(teamLeaderRepository.save(teamLeader)).thenReturn(teamLeader);

        TeamLeader result = teamLeaderService.updateTeamLeader(teamLeader);

        assertNotNull(result);
        assertEquals(teamLeader, result);
    }

    @Test
     void testDelete() throws InvalidUserId {
        logger.info("Running testDelete");

        int teamLeadId = 1;

        when(teamLeaderRepository.existsById(teamLeadId)).thenReturn(true);

        assertDoesNotThrow(() -> teamLeaderService.delete(teamLeadId)); 

    }


//    @Test
//     void testGetTeamLeaderById() throws InvalidUserId {
//        logger.info("Running testGetTeamLeaderById");
//
//        int teamLeadId = 1; 
//        
//        TeamLeader teamLeader = new TeamLeader();
//        teamLeader.setTeamLeadId(teamLeadId);
//        teamLeader.setFirstName("John");
//        teamLeader.setLastName("Doe");
//       
//
//
//        when(teamLeaderRepository.findByTeamLeadId(teamLeadId)).thenReturn(teamLeader);
//
//        
//            TeamLeader tl = teamLeaderService.getTeamLeaderById(teamLeadId);
//
//            assertNotNull(teamLeadId);
//            assertEquals(teamLeadId, tl.getTeamLeadId());
//            assertEquals("John", tl.getFirstName());
//            assertEquals("Doe", tl.getLastName());
//            
//       
//    }

    @Test
     void testLoginTeamLeader_ValidCredentials() throws InvalidCredentialsException{
        logger.info("Running testLoginTeamLeader_ValidCredentials");

        when(teamLeaderRepository.findTeamLeaderByEmailPassword("jane@example.com", "js123"))
                .thenReturn(new TeamLeader());

        
            TeamLeader result = teamLeaderService.loginTeamLeader("jane@example.com", "js123");

            assertNotNull(result);
        
        
    }
    
    
  
    @Test
     void testInvalidUserId1() {
        String message = "Invalid user ID";
        InvalidUserId exception = new InvalidUserId(message);
        Assertions.assertEquals(message, exception.getMessage());
    }
    @Test
     void testInvalidCredentialsException() {
        String message = "Invalid Credentials";
        InvalidCredentialsException exception = new InvalidCredentialsException(message);
        Assertions.assertEquals(message, exception.getMessage());
    }

    @Test
     void testNullEmailFoundException1() {
        String message = "Null email found";
        NullEmailFoundException exception = new NullEmailFoundException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
     void testNullUserFound() {
        String message = "Null user found";
        NullUserFound exception = new NullUserFound(message);
        Assertions.assertEquals(message, exception.getMessage());
    }


    @Test
    void testNullUserFoundException() {
        NullUserFound exception = new NullUserFound("User not found");
        UserControllerAdvice controllerAdvice = new UserControllerAdvice();
        ResponseEntity<String> responseEntity = controllerAdvice.nullUserFoundException(exception);
        assertEquals(HttpStatus.BAD_GATEWAY, responseEntity.getStatusCode());
        assertEquals("User not found", responseEntity.getBody());
    }

    @Test
    void testNullEmailFoundException() {
        NullEmailFoundException exception = new NullEmailFoundException("Email not found");
        UserControllerAdvice controllerAdvice = new UserControllerAdvice();
        ResponseEntity<String> responseEntity = controllerAdvice.nullEmailFoundException(exception);
        assertEquals(HttpStatus.BAD_GATEWAY, responseEntity.getStatusCode());
        assertEquals("Email not found", responseEntity.getBody());
    }

    @Test
    void testInvalidUserId() {
        InvalidUserId exception = new InvalidUserId("Invalid user ID");
        UserControllerAdvice controllerAdvice = new UserControllerAdvice();
        ResponseEntity<String> responseEntity = controllerAdvice.invalidUserId(exception);
        assertEquals(HttpStatus.BAD_GATEWAY, responseEntity.getStatusCode());
        assertEquals("Invalid user ID", responseEntity.getBody());
    }

    @Test
    void testCantLoginUser() {
        InvalidCredentialsException exception = new InvalidCredentialsException("Invalid credentials");
        UserControllerAdvice controllerAdvice = new UserControllerAdvice();
        ResponseEntity<String> responseEntity = controllerAdvice.cantLoginUser(exception);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Invalid credentials", responseEntity.getBody());
    }

}