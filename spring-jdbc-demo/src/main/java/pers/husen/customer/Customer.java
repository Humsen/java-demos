package pers.husen.customer;


/**
 * @author 何明胜
 *
 * 2017年9月19日
 */
public class Customer {
	private Long custId;
	private String name;
	private Long age;
	/**
	 * @param long1
	 * @param string
	 * @param long2
	 */
	public Customer(Long long1, String string, Long long2) {
		setCustId(long1);
		setName(string);
		setAge(long2);
	}
	/**
	 * 
	 */
	public Customer() {
	}
	/**
	 * @return the custId
	 */
	public Long getCustId() {
		return custId;
	}
	/**
	 * @param long1 the custId to set
	 */
	public void setCustId(Long long1) {
		this.custId = long1;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public Long getAge() {
		return age;
	}
	/**
	 * @param long2 the age to set
	 */
	public void setAge(Long long2) {
		this.age = long2;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
