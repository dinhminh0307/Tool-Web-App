package project.tool.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.tool.management.models.Accounts;

@Repository
public interface DBAccountRepo extends JpaRepository<Accounts, String> {
}
