package project.tool.management.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import project.tool.management.models.Projects;

import java.util.List;

public class AccountResponse {
    private String _id;
    private String _fullName;
    private String _lastName;
    private String _firstName;
    private String _dob;
    private String _phoneNumber;
    private String _companies;

    private List<Projects> _projects;

    // Default Constructor
    public AccountResponse() {
    }

    // Parameterized Constructor
    public AccountResponse(String _id, String _fullName, String _lastName, String _firstName,
                    String _dob, String _phoneNumber, String _companies, List<Projects> _projects) {
        this._id = _id;
        this._fullName = _fullName;
        this._lastName = _lastName;
        this._firstName = _firstName;
        this._dob = _dob;
        this._phoneNumber = _phoneNumber;
        this._companies = _companies;
        this._projects = _projects;
    }

    // Getters and Setters
    // Getter and Setter for _id
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    // Getter and Setter for _fullName
    public String getFullName() {
        return _fullName;
    }

    public void setFullName(String _fullName) {
        this._fullName = _fullName;
    }

    // Getter and Setter for _lastName
    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String _lastName) {
        this._lastName = _lastName;
    }

    // Getter and Setter for _firstName
    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    // Getter and Setter for _dob
    public String getDob() {
        return _dob;
    }

    public void setDob(String _dob) {
        this._dob = _dob;
    }

    // Getter and Setter for _phoneNumber
    public String getPhoneNumber() {
        return _phoneNumber;
    }

    public void setPhoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

    // Getter and Setter for _companies
    public String getCompanies() {
        return _companies;
    }

    public void setCompanies(String _companies) {
        this._companies = _companies;
    }

    // Getter and Setter for _projects
    public List<Projects> getProjects() {
        return _projects;
    }

    public void setProjects(List<Projects> _projects) {
        this._projects = _projects;
    }
}
