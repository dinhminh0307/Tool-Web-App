package project.tool.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.tool.management.models.Accounts;

import java.util.Optional;

@Repository
public interface DBAccountRepo extends JpaRepository<Accounts, String> {
    Optional<Accounts> findBy_email(String _email);  // Adjust to match the exact field name
}
