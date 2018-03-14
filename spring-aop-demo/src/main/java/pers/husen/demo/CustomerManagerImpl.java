package pers.husen.demo;

/**
 * @Desc 测试接口实现
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月2日 上午11:44:31
 * 
 * @Version 1.0.0
 */
public class CustomerManagerImpl implements CustomerManager {
	public void addCustomer(String name, String password) {
		System.out.print("加入了客户： " + name + "密码是： " + password);

	}

	public void deleteCustomer(String name) {

		System.out.println("删除了客户： " + name);
	}

	public String getCustomerById(int id) {
		System.out.println("找到了用户");
		return "dfy";
	}

	public void updateCustomer(int id, String name, String password) {

		System.out.println("更改了用户基本信息");
	}

}
