package project.tool.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.tool.management.models.Accounts;
import project.tool.management.models.Projects;
import project.tool.management.repo.DBProjectRepo;
import project.tool.management.utils.GenerateID;
import project.tool.management.utils.JsonUtil;

@Service
public class ProjectService {

    @Autowired
    DBProjectRepo projectRepo;

    @Autowired
    GenerateID generateID;

    @Autowired
    AuthenticateService authenticateService;

    @Autowired
    JsonUtil jsonUtil;

    public Projects create(Projects projects) {
        String id = generateID.generateProjectID(projectRepo.findAll());

        // set owner
        Accounts onwer = authenticateService.getAccountByToken();

        projects.setOwner(JsonUtil.objectToJson(onwer));

        projects.setId(id);

        Projects savedProject = projectRepo.save(projects);

        return savedProject;
    }
}
