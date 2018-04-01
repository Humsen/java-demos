package pers.husen.demo.shiro.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import pers.husen.demo.shiro.po.SysUsers;

/**
 * @Desc 密码助手
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月27日 下午2:24:56
 * 
 * @Version 1.0.0
 */
public class PasswordHelper0 {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private String algorithmName = "md5";
	private final int hashIterations = 2;

	public void encryptPassword(SysUsers user) {

		user.setSalt(randomNumberGenerator.nextBytes().toHex());

		String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();

		user.setPassword(newPassword);
	}
}