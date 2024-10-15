package project.tool.management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.tool.management.models.Projects;
import project.tool.management.services.ProjectService;

@RestController
@RequestMapping("/")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @MutationMapping
    public Projects createProject(
            @Argument String name,
            @Argument String description
    ) {
        Projects projects = new Projects();
        projects.setName(name);
        projects.setDescription(description);

        return projectService.create(projects);
    }
}
