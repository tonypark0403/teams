package com.tony.teams.services;

import com.tony.teams.domain.Project;
import com.tony.teams.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        //Logic for update...
        return projectRepository.save(project);
    }
}
