package com.leader.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leader.main.entity.TeamLeader;


public interface TeamLeaderRepository extends JpaRepository<TeamLeader, Integer> {


	@Query("from TeamLeader tl where tl.email=:email and tl.password=:password")
	public TeamLeader findTeamLeaderByEmailPassword(@Param(value="email") String email, @Param(value="password")String password);

	public TeamLeader save(TeamLeader teamLeader);

	public Optional<TeamLeader> findByTeamLeadId(Integer teamLeadId);


}
