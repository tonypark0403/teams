package com.tony.teams.web;

import com.tony.teams.domain.Project;
import com.tony.teams.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<String> getProjects() {
        return new ResponseEntity<>("Good", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> createNewProject(Project project){
        System.out.println(project);
        project = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
}
