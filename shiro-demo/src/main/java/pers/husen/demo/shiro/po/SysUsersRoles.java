package pers.husen.demo.shiro.po;

public class SysUsersRoles {
    private Long userId;

    private Long roleId;

    public SysUsersRoles(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public SysUsersRoles() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}