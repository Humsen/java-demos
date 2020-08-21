package cn.humsen.shiro.encode;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hemingsheng@bxin.cn
 * @since 2020-08-21 21:40
 */
public class DigestsUtil {
    public static final String SHA1 = "SHA-1";

    public static final Integer ITERATIONS = 512;

    public static String sha1(String input, String salt) {
        return new SimpleHash(SHA1, input, salt, ITERATIONS).toString();
    }

    /**
     * 随机获得salt字符串
     */
    public static String generateSalt() {
        SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        return randomNumberGenerator.nextBytes().toHex();
    }

    /**
     * 生成密码字符密文和salt密文
     */
    public static Map<String, String> entryptPassword(String passwordPlain) {
        Map<String, String> map = new HashMap<>();
        String salt = generateSalt();
        String password = sha1(passwordPlain, salt);
        map.put("salt", salt);
        map.put("password", password);

        return map;
    }
}
