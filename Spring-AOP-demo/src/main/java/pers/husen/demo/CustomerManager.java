package pers.husen.demo;

/**
 * @Desc 测试接口
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月2日 上午11:44:38
 * 
 * @Version 1.0.0
 */
public interface CustomerManager {
	public void addCustomer(String name, String password);

	public void deleteCustomer(String name);

	public String getCustomerById(int id);

	public void updateCustomer(int id, String name, String password);
}
