package project.tool.management.models;

public class Blueprint {
    private String _blueprintId;
    private String _description;
    private String _createdBy;
    private String _createdDate;

    // Default Constructor
    public Blueprint() {
    }

    // Parameterized Constructor
    public Blueprint(String _blueprintId, String _description, String _createdBy, String _createdDate) {
        this._blueprintId = _blueprintId;
        this._description = _description;
        this._createdBy = _createdBy;
        this._createdDate = _createdDate;
    }

    // Getters and Setters
    public String getBlueprintId() {
        return _blueprintId;
    }

    public void setBlueprintId(String _blueprintId) {
        this._blueprintId = _blueprintId;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public String getCreatedBy() {
        return _createdBy;
    }

    public void setCreatedBy(String _createdBy) {
        this._createdBy = _createdBy;
    }

    public String getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(String _createdDate) {
        this._createdDate = _createdDate;
    }
}
