package io.agileintelligence.ppmtools.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtools.domain.Project;
import io.agileintelligence.ppmtools.repositories.ProjectRepository;

@Service
public class ProjectService 
{
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdate(Project project)
	{
		//logic
		return projectRepository.save(project);
	}

}
