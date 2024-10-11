package project.tool.management.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "projects")
@Table(schema = "project_tool")
public class Projects {
    @Id
    private String _id;
    private String _name;
    private String _description;

    @Column(columnDefinition = "jsonb")
    private String _owner; // JSON column to store developer list

    @Column(columnDefinition = "jsonb")
    private String _member; // JSON column to store developer list

    @Column(columnDefinition = "jsonb")
    private String _tasks; // JSON column to store project tasks

    @Column(columnDefinition = "jsonb")
    private String _blueprints; // JSON column to store blueprints

    // Default Constructor
    public Projects() {
    }

    // Parameterized Constructor
    public Projects(String _id, String _name, String _description, String _owner,String _member, String _tasks, String _blueprints) {
        this._id = _id;
        this._name = _name;
        this._description = _description;
        this._owner = _owner;
        this._member = _member;
        this._tasks = _tasks;
        this._blueprints = _blueprints;
    }

    // Getters and Setters
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public String getOwner() {
        return _owner;
    }

    public void setOwner(String _owner) {
        this._owner = _owner;
    }

    public String getMember() {
        return _member;
    }

    public void setMember(String _member) {
        this._member = _member;
    }

    public String getTasks() {
        return _tasks;
    }

    public void setTasks(String _tasks) {
        this._tasks = _tasks;
    }

    public String getBlueprints() {
        return _blueprints;
    }

    public void setBlueprints(String _blueprints) {
        this._blueprints = _blueprints;
    }
}
