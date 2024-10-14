package project.tool.management.utils;

import org.springframework.stereotype.Service;
import project.tool.management.models.Accounts;
import project.tool.management.models.Projects;

import java.util.Comparator;
import java.util.List;

@Service
public class GenerateID {

    public String generateAccountID(List<Accounts> _accounts) {
        String lastId = _accounts.stream()
                .map(Accounts::getId)
                .filter(id -> id.startsWith("A"))
                .max(Comparator.comparing(id -> Integer.parseInt(id.substring(2))))
                .orElse("A000");

        // Extract the numeric part of the ID and increment it
        int numericPart = Integer.parseInt(lastId.substring(2)) + 1;

        // Return the new ID formatted with a prefix "FA" and a three-digit number
        return String.format("A%03d", numericPart);
    }

    public String generateProjectID(List<Projects> projects) {
        String lastId = projects.stream()
                .map(Projects::getId)
                .filter(id -> id.startsWith("P"))
                .max(Comparator.comparing(id -> Integer.parseInt(id.substring(2))))
                .orElse("P000");

        // Extract the numeric part of the ID and increment it
        int numericPart = Integer.parseInt(lastId.substring(2)) + 1;

        // Return the new ID formatted with a prefix "FA" and a three-digit number
        return String.format("P03d", numericPart);
    }
}
