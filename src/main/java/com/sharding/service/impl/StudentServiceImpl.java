package com.sharding.service.impl;

import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import com.sharding.mapper.student.StudentMapper;
import com.sharding.pojo.GetStudentListDto;
import com.sharding.pojo.Student;
import com.sharding.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student addStudent(Student student) {
        CommonSelfIdGenerator commonSelfIdGenerator = new CommonSelfIdGenerator();
        long studentId = commonSelfIdGenerator.generateId().longValue();//此种方式生成的id大多为偶数
        student.setStudentId(studentId);
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
    public List<Student> getStudentList(GetStudentListDto dto) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", dto.getId());
        map.put("name", dto.getName());
        String ids = dto.getIds();
        if (StringUtils.isNotBlank(ids)) {
            map.put("idList", Arrays.asList(ids.split(",")));
        }
        List<Student> list = studentMapper.getStudentList(map);
        return list;
    }
}
