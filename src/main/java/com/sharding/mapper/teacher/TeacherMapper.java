package com.sharding.mapper.teacher;

import com.sharding.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TeacherMapper {
    void addTeacher(Teacher teacher);
}
