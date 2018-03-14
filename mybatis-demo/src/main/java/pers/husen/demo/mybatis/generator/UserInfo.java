package pers.husen.demo.mybatis.generator;

import java.util.Date;

public class UserInfo {
	private Integer userId;

	private String userName;

	private String userPassword;

	private Date userCreateDate;

	public UserInfo(Integer userId, String userName, String userPassword, Date userCreateDate) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userCreateDate = userCreateDate;
	}

	public UserInfo() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword == null ? null : userPassword.trim();
	}

	public Date getUserCreateDate() {
		return userCreateDate;
	}

	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}
}