package project.tool.management.models;

public class Owners extends Developers {
    // Default Constructor
    public Owners() {
        super(); // Calls the default constructor of Developers
    }

    // Parameterized Constructor
    public Owners(String _id, String _accountID) {
        super(_id, _accountID); // Calls the parameterized constructor of Developers
    }
}
