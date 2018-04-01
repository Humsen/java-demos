package pers.husen.demo.shiro.po;

public class SysPermissions {
    private Long id;

    private String permission;

    private String description;

    private Boolean available;

    public SysPermissions(Long id, String permission, String description, Boolean available) {
        this.id = id;
        this.permission = permission;
        this.description = description;
        this.available = available;
    }
    
    public SysPermissions(String permission, String description, Boolean available) {
        this.permission = permission;
        this.description = description;
        this.available = available;
    }

    public SysPermissions() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}