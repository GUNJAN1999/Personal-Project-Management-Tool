package io.agileintelligence.ppmtools.repositories;

import org.springframework.data.repository.CrudRepository;

import io.agileintelligence.ppmtools.domain.Project;

public interface ProjectRepository extends CrudRepository<Project,Long> 
{
	public Project findByProjectIdentifier(String projectId);		

}
