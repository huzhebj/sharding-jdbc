package com.sharding.mapper.student;

import com.sharding.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface StudentMapper {
    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);

    List<Student> getStudentList(Map<String,Object> map);
}
