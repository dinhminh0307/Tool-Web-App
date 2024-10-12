package project.tool.management.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;

/**
 * To match the JSON properties exactly as they are sent, you can use
 * the @JsonProperty annotation from the com.fasterxml.jackson.annotation package. This will tell Jackson explicitly
 * how to map each JSON property to the corresponding field in your model class.*/

@Entity(name = "accounts")
@Table(schema = "project_tool")
public class Accounts {
    @Id
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("_email")
    private String _email;

    @JsonProperty("_fullName")
    private String _fullName;

    @JsonProperty("_lastName")
    private String _lastName;

    @JsonProperty("_firstName")
    private String _firstName;

    @JsonProperty("_dob")
    private String _dob;

    @JsonProperty("_phoneNumber")
    private String _phoneNumber;

    @JsonProperty("_companies")
    private String _companies;

    @JsonProperty("_password")
    private String _password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "projects",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Projects> _projects;

    // Default Constructor
    public Accounts() {
    }

    // Parameterized Constructor
    public Accounts(String _id, String _email, String _fullName, String _lastName, String _firstName,
                    String _dob, String _phoneNumber, String _companies, List<Projects> _projects, String _password) {
        this._id = _id;
        this._email = _email;
        this._fullName = _fullName;
        this._lastName = _lastName;
        this._firstName = _firstName;
        this._dob = _dob;
        this._phoneNumber = _phoneNumber;
        this._companies = _companies;
        this._projects = _projects;
        this._password = _password;
    }

    // Getters and Setters
    // Getter and Setter for _id
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return this._email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getPassword() {
        return this._password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public String getFullName() {
        return _fullName;
    }

    public void setFullName(String _fullName) {
        this._fullName = _fullName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String _lastName) {
        this._lastName = _lastName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String getDob() {
        return _dob;
    }

    public void setDob(String _dob) {
        this._dob = _dob;
    }

    public String getPhoneNumber() {
        return _phoneNumber;
    }

    public void setPhoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

    public String getCompanies() {
        return _companies;
    }

    public void setCompanies(String _companies) {
        this._companies = _companies;
    }

    public List<Projects> getProjects() {
        return _projects;
    }

    public void setProjects(List<Projects> _projects) {
        this._projects = _projects;
    }
}
