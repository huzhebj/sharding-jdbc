package com.sharding.controller;

import com.sharding.pojo.Teacher;
import com.sharding.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //新增教师
    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        Teacher result = teacherService.addTeacher(teacher);
        return result;
    }

    //批量新增教师
    @RequestMapping(value = "/addTeacherBatch", method = RequestMethod.POST)
    public Teacher addTeacherBatch(@RequestBody Teacher teacher) {
        String name = teacher.getName();
        for (int i = 1; i < 10001; i++) {
            teacher.setName(name + i);
            teacherService.addTeacher(teacher);
        }
        return null;
    }

}
