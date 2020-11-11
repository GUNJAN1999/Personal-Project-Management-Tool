package io.agileintelligence.ppmtools.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.agileintelligence.ppmtools.domain.Project;
import io.agileintelligence.ppmtools.services.MapValidationErrorService;
import io.agileintelligence.ppmtools.services.ProjectService;


@RestController
@RequestMapping("/api/project")
public class ProjectController 
{
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createnewProject(@Valid @RequestBody Project project,BindingResult result)
	{
		ResponseEntity<?> errormap=mapValidationErrorService.MapValidationService(result);	
		if(errormap !=null)
		{
			return errormap;
		}
		Project project1=projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(project,HttpStatus.CREATED);
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId)
	{
		Project project=projectService.findProjectByIdentifier(projectId.toUpperCase());
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}

}






















