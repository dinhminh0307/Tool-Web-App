package project.tool.management.models;

public class Task {
    private String _taskId;
    private String _taskName;
    private String _status;
    private String _assignedTo;
    private String _startDate;
    private String _dueDate;

    // Default Constructor
    public Task() {
    }

    // Parameterized Constructor
    public Task(String _taskId, String _taskName, String _status, String _assignedTo, String _startDate, String _dueDate) {
        this._taskId = _taskId;
        this._taskName = _taskName;
        this._status = _status;
        this._assignedTo = _assignedTo;
        this._startDate = _startDate;
        this._dueDate = _dueDate;
    }

    // Getters and Setters
    public String getTaskId() {
        return _taskId;
    }

    public void setTaskId(String _taskId) {
        this._taskId = _taskId;
    }

    public String getTaskName() {
        return _taskName;
    }

    public void setTaskName(String _taskName) {
        this._taskName = _taskName;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String _status) {
        this._status = _status;
    }

    public String getAssignedTo() {
        return _assignedTo;
    }

    public void setAssignedTo(String _assignedTo) {
        this._assignedTo = _assignedTo;
    }

    public String getStartDate() {
        return _startDate;
    }

    public void setStartDate(String _startDate) {
        this._startDate = _startDate;
    }

    public String getDueDate() {
        return _dueDate;
    }

    public void setDueDate(String _dueDate) {
        this._dueDate = _dueDate;
    }
}
