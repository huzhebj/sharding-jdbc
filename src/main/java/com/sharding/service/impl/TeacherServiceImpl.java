package com.sharding.service.impl;

import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import com.sharding.mapper.teacher.TeacherMapper;
import com.sharding.pojo.Teacher;
import com.sharding.service.TeacherService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private static  final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    private static final String TEACHERID_INCREMENT = "TEACHERID_INCREMENT";

    @Autowired
    @Qualifier("commonRedisTemplate")
    private RedisTemplate<String, String> commonRedisTemplate;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher addTeacher(Teacher teacher) {
        teacher.setTeacherId(getTeacherId2());
        logger.info("add teacher-->" + teacher);
        teacherMapper.addTeacher(teacher);
        return teacher;
    }

    //使用sharding-jdbc自带的id生成器生成，此种生成方式的弊端是生成的id大多为偶数
    public long getTeacherId1(){
        CommonSelfIdGenerator commonSelfIdGenerator = new CommonSelfIdGenerator();
        return commonSelfIdGenerator.generateId().longValue();
    }

    //Redis生成ID
    public long getTeacherId2(){
        String teacherId = commonRedisTemplate.opsForValue().get(TEACHERID_INCREMENT);
        if(StringUtils.isBlank(teacherId)){
            teacherId = "1";
            commonRedisTemplate.opsForValue().set(TEACHERID_INCREMENT,"1");
        }else{
            commonRedisTemplate.opsForValue().increment(TEACHERID_INCREMENT,1);
            teacherId = commonRedisTemplate.opsForValue().get(TEACHERID_INCREMENT);
        }
        return Long.parseLong(teacherId);
    }
}
