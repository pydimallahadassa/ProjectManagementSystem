package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Project;

@Repository
public interface IProjectRepository extends JpaRepository<Project,Integer> {
	Optional<Project> findByProjectName(String Project);

	Project findByTeamLeadId(int teamLeadId);
}
	 


