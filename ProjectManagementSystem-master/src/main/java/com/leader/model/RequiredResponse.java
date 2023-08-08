package com.leader.model;

import java.util.List;

import com.leader.main.entity.TeamLeader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequiredResponse {

	private TeamLeader leader;
	private List<TeamMember> member;
	
}
