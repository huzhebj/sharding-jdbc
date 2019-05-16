package com.sharding.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by huzhe on 2019-05-16.
 */
@Configuration
@MapperScan(basePackages = {"com.sharding.mapper.teacher"}, sqlSessionFactoryRef = "teacherSqlSessionFactory")
public class MybatisDbTeacherConfig {

  @Autowired
  @Qualifier("teacherDataSource")
  private DataSource teacherDataSource;

  @Bean
  public SqlSessionFactory teacherSqlSessionFactory() throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(teacherDataSource);
    return factoryBean.getObject();

  }
}
