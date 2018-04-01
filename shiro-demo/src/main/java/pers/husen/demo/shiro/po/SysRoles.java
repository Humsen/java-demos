package pers.husen.demo.shiro.po;

public class SysRoles {
	private Long id;

	private String role;

	private String description;

	private Boolean available;

	public SysRoles(Long id, String role, String description, Boolean available) {
		this.id = id;
		this.role = role;
		this.description = description;
		this.available = available;
	}

	public SysRoles(String role, String description, Boolean available) {
		this.role = role;
		this.description = description;
		this.available = available;
	}

	public SysRoles() {
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

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}