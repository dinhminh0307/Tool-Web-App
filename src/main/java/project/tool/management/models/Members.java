package project.tool.management.models;

public class Members extends Developers {
    // Default Constructor
    public Members() {
        super(); // Calls the default constructor of Developers
    }

    // Parameterized Constructor
    public Members(String _id, String _accountID) {
        super(_id, _accountID); // Calls the parameterized constructor of Developers
    }
}
