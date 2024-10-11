package project.tool.management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class Developers {
    private String _id;
    private String _accountID;

    // Default Constructor
    public Developers() {
    }

    // Parameterized Constructor
    public Developers(String _id, String _accountID) {
        this._id = _id;
        this._accountID = _accountID;
    }

    // Getters and Setters
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getAccountID() {
        return _accountID;
    }

    public void setAccountID(String _accountID) {
        this._accountID = _accountID;
    }
}
