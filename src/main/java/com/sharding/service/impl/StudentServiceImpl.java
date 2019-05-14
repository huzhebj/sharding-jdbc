package com.sharding.service.impl;

import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import com.sharding.mapper.student.StudentMapper;
import com.sharding.pojo.GetStudentListDto;
import com.sharding.pojo.Student;
import com.sharding.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private static  final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private static final String STUDENTID_INCREMENT = "STUDENTID_INCREMENT";

    @Autowired
    @Qualifier("commonRedisTemplate")
    private RedisTemplate<String, String> commonRedisTemplate;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student addStudent(Student student) {
        student.setStudentId(getStudentId2());
        logger.info("add student-->" + student);
        studentMapper.addStudent(student);
        return student;
    }

    //使用sharding-jdbc自带的id生成器生成，此种生成方式的弊端是生成的id大多为偶数
    public long getStudentId1(){
        CommonSelfIdGenerator commonSelfIdGenerator = new CommonSelfIdGenerator();
        return commonSelfIdGenerator.generateId().longValue();
    }

    //Redis生成ID
    public long getStudentId2(){
        String studentId = commonRedisTemplate.opsForValue().get(STUDENTID_INCREMENT);
        if(StringUtils.isBlank(studentId)){
            studentId = "1";
            commonRedisTemplate.opsForValue().set(STUDENTID_INCREMENT,"1");
        }else{
            commonRedisTemplate.opsForValue().increment(STUDENTID_INCREMENT,1);
            studentId = commonRedisTemplate.opsForValue().get(STUDENTID_INCREMENT);
        }
        return Long.parseLong(studentId);
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
