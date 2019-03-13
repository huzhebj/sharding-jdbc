package com.sharding.service.impl;

import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import com.sharding.mapper.StudentMapper;
import com.sharding.pojo.Student;
import com.sharding.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student addStudent(Student student) {
        CommonSelfIdGenerator commonSelfIdGenerator = new CommonSelfIdGenerator();
        commonSelfIdGenerator.generateId();
        student.setId(new CommonSelfIdGenerator().generateId().longValue());
        studentMapper.addStudent(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        studentMapper.updateStudent(student);
        return student;
    }

    @Override
    public Student deleteStudent(Student student) {
        studentMapper.deleteStudent(student);
        return student;
    }

    @Override
    public List<Student> getStudentList(Student student) {
        return studentMapper.getStudentList(student);
    }
}
