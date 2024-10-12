package project.tool.management.exceptions;

public class DuplicateEmailHandler extends RuntimeException{
    public DuplicateEmailHandler(String message) {
        super(message);
    }
}
