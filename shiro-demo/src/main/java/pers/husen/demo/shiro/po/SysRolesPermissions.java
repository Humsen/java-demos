package pers.husen.demo.shiro.po;

public class SysRolesPermissions {
    private Long roleId;

    private Long permissionId;

    public SysRolesPermissions(Long roleId, Long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public SysRolesPermissions() {
        super();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}