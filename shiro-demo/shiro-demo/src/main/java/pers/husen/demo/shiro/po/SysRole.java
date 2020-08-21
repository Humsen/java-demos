package pers.husen.demo.shiro.po;

public class SysRole {
    private Long id;

    private String role;

    private String description;

    private String resourceIds;

    private Boolean available;

    public SysRole(Long id, String role, String description, String resourceIds, Boolean available) {
        this.id = id;
        this.role = role;
        this.description = description;
        this.resourceIds = resourceIds;
        this.available = available;
    }

    public SysRole() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds == null ? null : resourceIds.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}