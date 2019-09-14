package com.julius.wisdom_teaching.util;

import com.julius.wisdom_teaching.domain.entity.User;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * author julius.zhu
 * date   2019/9/14
 * time   14:43
 * describe:
 * 负责处理密码加密的工具类
 */
public class EncryptUtil {
    /**
     * 根据密码进行加密,默认加盐使用用户名进行加盐
     * 散列次数默认为3为了和验证时候一致
     *
     * @param user 用户信息对象
     * @return 加密后的密码
     */
    public static String encrypt(User user) {
        return new Md5Hash(user.getNewPassWord(), user.getUsername(), 3).toString();
    }

    /**
     * 根据密码进行加密
     *
     * @param password 密码
     * @param salt     盐
     * @param count    散列次数
     * @return 加密后的密码
     */
    public static String encrypt(String password, String salt, int count) {
        return new Md5Hash(password, salt, count).toString();
    }
}
