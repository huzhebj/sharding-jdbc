package com.sharding.service;

import com.sharding.pojo.GetStudentListDto;
import com.sharding.pojo.Student;

import java.util.List;

public interface StudentService {
    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public Student deleteStudent(Student student);

    public List<Student> getStudentList(GetStudentListDto dto);
}
