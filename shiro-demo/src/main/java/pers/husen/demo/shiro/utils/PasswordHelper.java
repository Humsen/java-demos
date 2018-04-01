package pers.husen.demo.shiro.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import pers.husen.demo.shiro.po.SysUsers;

/**
 * @Desc 带set函数
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月28日 上午11:49:47
 * 
 * @Version 1.0.0
 */
public class PasswordHelper {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;

	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

	public void encryptPassword(SysUsers user) {

		user.setSalt(randomNumberGenerator.nextBytes().toHex());

		String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();

		user.setPassword(newPassword);
	}
}