package com.sharding.mapper;

import com.sharding.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {
    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);

    List<Student> getStudentList(Student student);
}
