package com.julius.wisdom_teaching.web.studentimport;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.service.StudentInfoCheckService;
import com.julius.wisdom_teaching.service.TeacherStudentManageService;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.ExcelUtil;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * author julius.zhu
 * date   2019/6/7
 * time   12:22
 * describe:
 * 处理学生信息导入和导出controller
 */
@RestController
@CrossOrigin(origins = "*")
public class StudentInfoImport {
    private final TeacherStudentManageService teacherStudentManageService;
    private final StudentInfoCheckService studentInfoCheckService;

    @Autowired
    public StudentInfoImport(TeacherStudentManageService teacherStudentManageService,
                             StudentInfoCheckService studentInfoCheckService) {
        this.teacherStudentManageService = teacherStudentManageService;
        this.studentInfoCheckService = studentInfoCheckService;
    }

    /**
     * 导入学生数据
     *
     * @param file    文件对象
     * @param request 请求对象
     * @throws IOException
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @PostMapping(GlobalUrlMapping.student_upload_template)
    public void importStudentInfo(MultipartFile file, HttpServletRequest request) throws IOException {
        //读取excel中数据
        List<StudentInfo> studentInfos = ExcelUtil.readExcel(file.getInputStream(),
                Integer.valueOf(request.getParameter("userId")));
        //导入学生数据
        teacherStudentManageService.importStudentInfo(studentInfos);
    }

    /**
     * 导出数据为excel
     *
     * @param ids      多个id的数组
     * @param response 相应对象
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @GetMapping(value = GlobalUrlMapping.student_export)
    public void exportExcelData(Integer[] ids, HttpServletResponse response) throws IOException {
        OutputStream outputStream = response.getOutputStream();
        //写出数据
        //处理乱码问题
        String fileName = URLEncoder.encode("学生信息导出", "utf-8");
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        studentInfoCheckService.selectStudentById(ids, outputStream);
    }
}
