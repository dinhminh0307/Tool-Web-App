package project.tool.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.tool.management.models.Accounts;
import project.tool.management.models.Projects;
import project.tool.management.repo.DBProjectRepo;
import project.tool.management.utils.GenerateID;

@Service
public class ProjectService {

    @Autowired
    DBProjectRepo projectRepo;

    @Autowired
    GenerateID generateID;

    public Projects create(Projects projects) {
        String id = generateID.generateProjectID(projectRepo.findAll());

        projects.setId(id);

        Projects savedProject = projectRepo.save(projects);

        return savedProject;
    }
}
