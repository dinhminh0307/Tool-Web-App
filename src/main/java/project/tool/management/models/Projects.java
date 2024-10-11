package project.tool.management.models;

import jakarta.persistence.*;

import com.fasterxml.jackson.core.type.TypeReference;
import project.tool.management.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "projects")
@Table(schema = "project_tool")
public class Projects {
    @Id
    private String _id;
    private String _name;
    private String _description;

    @ManyToMany(mappedBy = "_projects")
    private List<Accounts> _account;

    @Column(columnDefinition = "jsonb")
    private String _owner; // JSON column to store owner details

    @Column(columnDefinition = "jsonb")
    private String _member; // JSON column to store members details

    @Column(columnDefinition = "jsonb")
    private String _tasks; // JSON column to store project tasks

    @Column(columnDefinition = "jsonb")
    private String _blueprints; // JSON column to store blueprints

    // Default Constructor
    public Projects() {
    }

    // Parameterized Constructor
    public Projects(String _id, String _name, String _description, String _owner,
                    String _member, String _tasks, String _blueprints, List<Accounts> _account) {
        this._id = _id;
        this._name = _name;
        this._description = _description;
        this._owner = _owner;
        this._member = _member;
        this._tasks = _tasks;
        this._blueprints = _blueprints;
        this._account = _account;
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

    public List<Accounts> getAccounts() {
        return  this._account;
    }

    public void setAccounts(List<Accounts> _account) {
        this._account = _account;
    }

    // Methods for tasks
    public List<Task> getTasks() {
        return JsonUtil.jsonToList(_tasks, new TypeReference<List<Task>>() {});
    }

    public void setTasks(List<Task> tasks) {
        this._tasks = JsonUtil.listToJson(tasks);
    }

    // Methods for blueprints
    public List<Blueprint> getBlueprints() {
        return JsonUtil.jsonToList(_blueprints, new TypeReference<List<Blueprint>>() {});
    }

    public void setBlueprints(List<Blueprint> blueprints) {
        this._blueprints = JsonUtil.listToJson(blueprints);
    }
}
