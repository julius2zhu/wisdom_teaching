package com.julius.wisdom_teaching;

import com.julius.wisdom_teaching.domain.entity.ExaminationRecord;
import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.domain.entity.User;
import com.julius.wisdom_teaching.repository.ExaminationManageMapper;
import com.julius.wisdom_teaching.repository.StudentManageMapper;
import com.julius.wisdom_teaching.repository.UserMapper;
import com.julius.wisdom_teaching.util.EncryptUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WisdomTeachingApplicationTests {
    @Autowired
    ExaminationManageMapper examinationManageMapper;

//    @Test
//    public void contextLoads() throws IOException {
//        File file = new File("F:/填空题.txt");
//        final List<ExaminationRecord> records = new ArrayList<>();
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//        String line;
//        int index = 1;
//        ExaminationRecord record;
//        while ((line = bufferedReader.readLine()) != null) {
//            record = new ExaminationRecord();
//            record.setQuestion(line.trim());
//            records.add(record);
//            index = index % 5;
//            switch (index) {
//                case 1:
//                    record.setQuestion(line);
//                    break;
//                case 2:
//                    line = line.substring(1);
//                    record.setSelectA(line);
//                    break;
//                case 3:
//                    line = line.substring(1);
//                    record.setSelectB(line);
//                    break;
//                case 4:
//                    line = line.substring(1);
//                    record.setSelectC(line);
//                    break;
//                case 0:
//                    line = line.substring(1);
//                    record.setSelectD(line);
//                    records.add(record);
//                    record = new ExaminationRecord();
//                    break;
//            }
//            index++;
//        }
//        System.out.println(records.size());
//        System.out.println(records.get(0));
//        System.out.println(records.get(records.size() - 1));
//        examinationManageMapper.addRecordTest(records);
//    }

    @Autowired
    UserMapper userMapper;
    @Autowired
    StudentManageMapper studentManageMapper;

    @Test
    public void test() {
//        String username = "maliao";
//        System.out.println(EncryptUtil.encrypt(username, username, 3));
        //创建多个学生对象添加到数据库中
//        for (int i = 500; i < 1000; i++) {
//            User user = new User();
//            user.setName("大开发" + i);
//            user.setUsername("dakaifa" + i);
//            user.setPassword("dakaifa" + i);
//            user.setRole("0");
//            userMapper.addOne(user);
//            StudentInfo studentInfo = new StudentInfo();
//            studentInfo.setName("测试人员" + i);
//            studentInfo.setUserId(11);
//            if (i % 2 == 0) {
//                studentInfo.setSex("0");
//            } else {
//                studentInfo.setSex("1");
//            }
//            studentInfo.setGrade("350166");
//            studentInfo.setNumber(350166 + i);
//            studentInfo.setDepartment("计算机与通信工程学院");
//            studentInfo.setMajor("软件技术");
//            studentInfo.setClassTeacher("马丽丽");
//            studentManageMapper.addTest(studentInfo);
//        }
    }

}
