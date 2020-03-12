package com.tony.teams.web;

import com.tony.teams.domain.Project;
import com.tony.teams.services.MapValidationErrorService;
import com.tony.teams.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @GetMapping
    public ResponseEntity<String> getProjects() {
        return new ResponseEntity<>("Good", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        System.out.println(project);

        return mapValidationErrorService.mapValidationService(result)
                .orElse(new ResponseEntity<>(projectService.saveOrUpdateProject(project), HttpStatus.CREATED));
    }
}
