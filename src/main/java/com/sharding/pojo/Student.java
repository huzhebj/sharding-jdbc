package com.sharding.pojo;

import lombok.Data;

@Data
public class Student {
    //学生id
    private long id;
    //学生年龄
    private long age;
    //学生姓名
    private String name;
    //城市id
    private String cityID;
    //城市名称
    private String cityName;
}
