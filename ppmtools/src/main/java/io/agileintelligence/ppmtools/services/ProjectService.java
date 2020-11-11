package io.agileintelligence.ppmtools.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtools.domain.Project;
import io.agileintelligence.ppmtools.exceptions.ProjectIdException;
import io.agileintelligence.ppmtools.repositories.ProjectRepository;

@Service
public class ProjectService 
{
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdate(Project project)
	{
		project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
		try {
		return projectRepository.save(project);
		}
		catch(Exception e)
		{
			throw new ProjectIdException("Project id - "+project.getProjectIdentifier().toUpperCase()+" already exists");
		}
	}
	
	public Project findProjectByIdentifier(String projectid)
	{
		Project project=projectRepository.findByProjectIdentifier(projectid);
		if(project==null)
		{
			throw new ProjectIdException("ProjectId - "+projectid.toUpperCase()+" does not exist");
		}
		return project;
	}

	public Iterable<Project> findAllProject()
	{
		return projectRepository.findAll();
	}
}
