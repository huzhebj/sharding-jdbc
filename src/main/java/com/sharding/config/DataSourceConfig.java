package com.sharding.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huzhe on 2019-05-13.
 */
@Configuration
public class DataSourceConfig {

    /**
     * 以下内容是student的分库分表配置
     * ********************************************student的分库分表配置start********************************************
     */
    @Value("${spring.db_student.url}")
    private String studentUrl;

    @Value("${spring.db_student.username}")
    private String studentUsername;

    @Value("${spring.db_student.password}")
    private String studentPassword;

    @Value("${spring.db_student.initial-size}")
    private int studentInitialSize;

    @Value("${spring.db_student.max-active}")
    private int studentMaxActive;

    @Value("${spring.db_student.min-idle}")
    private int studentMinIdle;

    @Value("${spring.db_student.validation-query}")
    private String studentValidationQuery;

    @Value("${spring.db_student.test-on-borrow}")
    private boolean studentTestOnBorrow;

    @Value("${spring.db_student.test-while-idle}")
    private boolean studentTestWhileIdle;

    @Primary
    @Bean("studentDataSource")
    @ConfigurationProperties(prefix = "spring.db_student")
    public DataSource studentDataSource() {
        return buildStudentDataSource();
    }

    @Bean
    public DataSourceTransactionManager studentTransactitonManager(@Qualifier("studentDataSource") DataSource studentDataSource){
        return new DataSourceTransactionManager(studentDataSource);
    }

    private DataSource buildStudentDataSource() {
        //1.设置分库映射
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("db_student_0", createStudentDataSource("db_student_0"));
        dataSourceMap.put("db_student_1", createStudentDataSource("db_student_1"));
        dataSourceMap.put("db_student_2", createStudentDataSource("db_student_2"));
        dataSourceMap.put("db_student_3", createStudentDataSource("db_student_3"));
        dataSourceMap.put("db_student_4", createStudentDataSource("db_student_4"));
        //设置默认库，两个库以上时必须设置默认库。默认库的数据源名称必须是dataSourceMap的key之一
        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap, "db_student_0");

        //2.设置分表映射
        //tbl_student_*表
        TableRule studentTableRule = TableRule.builder("tbl_student")
                .dataSourceRule(dataSourceRule)
                .databaseShardingStrategy(new DatabaseShardingStrategy("cityId",new StudentDbShardingAlgorithm()))
                .actualTables(Arrays.asList("tbl_student_0", "tbl_student_1", "tbl_student_2", "tbl_student_3", "tbl_student_4", "tbl_student_5", "tbl_student_6", "tbl_student_7", "tbl_student_8", "tbl_student_9"))
                .tableShardingStrategy(new TableShardingStrategy("studentId", new StudentTableShardingAlgorithm()))
                .build();

        //3.具体的分库分表策略
        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .tableRules(Arrays.asList(studentTableRule))
                .build();
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
        return dataSource;
    }

    private DataSource createStudentDataSource(String dataSourceName) {
        //使用druid连接数据库
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl(String.format(studentUrl, dataSourceName));
        druidDataSource.setUsername(studentUsername);
        druidDataSource.setPassword(studentPassword);
        druidDataSource.setInitialSize(studentInitialSize);
        druidDataSource.setMaxActive(studentMaxActive);
        druidDataSource.setMinIdle(studentMinIdle);
        druidDataSource.setValidationQuery(studentValidationQuery);
        druidDataSource.setTestOnBorrow(studentTestOnBorrow);
        druidDataSource.setTestWhileIdle(studentTestWhileIdle);

        return druidDataSource;
    }
    /**
     * 以上内容是student的分库分表配置
     * ********************************************student的分库分表配置end********************************************
     */

    /**
     * 以下内容是teacher的分库分表配置
     * ********************************************teacher的分库分表配置start********************************************
     */
    @Value("${spring.db_teacher.url}")
    private String teacherUrl;

    @Value("${spring.db_teacher.username}")
    private String teacherUsername;

    @Value("${spring.db_teacher.password}")
    private String teacherPassword;

    @Value("${spring.db_teacher.initial-size}")
    private int teacherInitialSize;

    @Value("${spring.db_teacher.max-active}")
    private int teacherMaxActive;

    @Value("${spring.db_teacher.min-idle}")
    private int teacherMinIdle;

    @Value("${spring.db_teacher.validation-query}")
    private String teacherValidationQuery;

    @Value("${spring.db_teacher.test-on-borrow}")
    private boolean teacherTestOnBorrow;

    @Value("${spring.db_teacher.test-while-idle}")
    private boolean teacherTestWhileIdle;

    @Bean("teacherDataSource")
    @ConfigurationProperties(prefix = "spring.db_teacher")
    public DataSource teacherDataSource() {
        return buildTeacherDataSource();
    }

    @Bean
    public DataSourceTransactionManager teacherTransactitonManager(@Qualifier("teacherDataSource") DataSource teacherDataSource){
        return new DataSourceTransactionManager(teacherDataSource);
    }

    private DataSource buildTeacherDataSource() {
        //1.设置分库映射
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("db_teacher_0", createTeacherDataSource("db_teacher_0"));
        dataSourceMap.put("db_teacher_1", createTeacherDataSource("db_teacher_1"));
        dataSourceMap.put("db_teacher_2", createTeacherDataSource("db_teacher_2"));
        //设置默认库，两个库以上时必须设置默认库。默认库的数据源名称必须是dataSourceMap的key之一
        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap, "db_teacher_0");

        //2.设置分表映射
        //tbl_teacher_*表
        TableRule teacherTableRule = TableRule.builder("tbl_teacher")
                .dataSourceRule(dataSourceRule)
                .databaseShardingStrategy(new DatabaseShardingStrategy("cityId",new TeacherDbShardingAlgorithm()))
                .actualTables(Arrays.asList("tbl_teacher_0", "tbl_teacher_1", "tbl_teacher_2", "tbl_teacher_3", "tbl_teacher_4"))
                .tableShardingStrategy(new TableShardingStrategy("teacherId", new TeacherTableShardingAlgorithm()))
                .build();

        //3.具体的分库分表策略
        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .tableRules(Arrays.asList(teacherTableRule))
                .build();
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
        return dataSource;
    }

    private DataSource createTeacherDataSource(String dataSourceName) {
        //使用druid连接数据库
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl(String.format(teacherUrl, dataSourceName));
        druidDataSource.setUsername(teacherUsername);
        druidDataSource.setPassword(teacherPassword);
        druidDataSource.setInitialSize(teacherInitialSize);
        druidDataSource.setMaxActive(teacherMaxActive);
        druidDataSource.setMinIdle(teacherMinIdle);
        druidDataSource.setValidationQuery(teacherValidationQuery);
        druidDataSource.setTestOnBorrow(teacherTestOnBorrow);
        druidDataSource.setTestWhileIdle(teacherTestWhileIdle);

        return druidDataSource;
    }
    /**
     * 以上内容是teacher的分库分表配置
     * ********************************************teacher的分库分表配置end********************************************
     */

}
