package com.julius.wisdom_teaching;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WisdomTeachingApplicationTests {

    @Test
    public void contextLoads() {
        String password="luolala";
        Md5Hash md5Hash=new Md5Hash(password,password,3);
        System.out.println("md5Hash = " + md5Hash);

    }
}
