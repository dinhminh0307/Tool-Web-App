package project.tool.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.tool.management.models.Accounts;
import project.tool.management.models.Projects;

public interface DBProjectRepo extends JpaRepository<Projects, String> {
}
