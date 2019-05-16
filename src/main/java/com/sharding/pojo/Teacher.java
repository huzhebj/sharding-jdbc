package com.sharding.pojo;

import lombok.Data;

@Data
public class Teacher {
    //记录id
    private long id;
    //学生id
    private long teacherId;
    //城市id
    private int cityId;
    //学生姓名
    private String name;
    //学生年龄
    private int age;
    //城市名称
    private String cityName;
}
