package pers.husen.demo.mybatis.po;

import java.util.Date;


/**
 * @Desc bean
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月7日 上午10:31:19
 * 
 * @Version 1.0.0
 */
public class UserInfo {
	private String className;
	private int userId;
	private String userName;
	private String userPassword;
	private Date createDate;

	public UserInfo() {
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * @param userId
	 * @param userName
	 * @param userPassword
	 * @param createDate
	 */
	public UserInfo(int userId, String userName, String userPassword, Date createDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.createDate = createDate;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword
	 *            the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "UserInfo [className=" + className + ", userId=" + userId + ", userName=" + userName + ", userPassword="
				+ userPassword + ", createDate=" + createDate + "]";
	}
}