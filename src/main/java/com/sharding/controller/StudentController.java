package com.sharding.controller;

import com.sharding.pojo.GetStudentListDto;
import com.sharding.pojo.Student;
import com.sharding.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //新增学生
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student) {
        Student result = studentService.addStudent(student);
        return result;
    }

    //批量新增学生
    @RequestMapping(value = "/addStudentBatch", method = RequestMethod.POST)
    public Student addStudentBatch(@RequestBody Student student) {
        String name = student.getName();
        for (int i = 1; i < 10001; i++) {
            student.setName(name + i);
            studentService.addStudent(student);
        }
        return null;
    }

    //修改学生
    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public Student updateStudent(@RequestBody Student student) {
        Student result = studentService.updateStudent(student);
        return result;
    }

    //删除学生
    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
    public Student deleteStudent(@RequestBody Student student) {
        Student result = studentService.deleteStudent(student);
        return result;
    }

    //查询学生列表
    @RequestMapping(value = "/getStudentList", method = RequestMethod.POST)
    public List<Student> getStudentList(@RequestBody GetStudentListDto dto) {
        List<Student> list = studentService.getStudentList(dto);
        return list;
    }
}
