package pers.husen.demo.redis;

import redis.clients.jedis.Jedis;

/**
 * @Desc redis测试
 *
 * @Author 何明胜
 *
 * @Created at 2018年2月27日 下午10:53:30
 * 
 * @Version 1.0.0
 */
public class ReidsJava {
	/**
	 * 测试javadoc
	 * 
	 * @param df
	 * @return 值
	 */
	public String test(String df) {
		String sf = "sf";

		return sf;
	}

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost", 6379);
		System.out.println("Connection to server sucessfully");
		// 查看服务是否运行
		jedis.set("husen", "hemingsheng");
		System.out.println(jedis.get("husen"));
		System.out.println("Server is running: " + jedis.ping());
		jedis.close();
	}
}