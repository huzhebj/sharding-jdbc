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
 * Created by huzhe on 2019-05-13.
 */
@Configuration
@MapperScan(basePackages = {"com.sharding.mapper.student"}, sqlSessionFactoryRef = "studentSqlSessionFactory")
public class MybatisDbStudentConfig {

  @Autowired
  @Qualifier("studentDataSource")
  private DataSource studentDataSource;

  @Bean
  @Primary
  public SqlSessionFactory studentSqlSessionFactory() throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(studentDataSource);
    return factoryBean.getObject();

  }
}
