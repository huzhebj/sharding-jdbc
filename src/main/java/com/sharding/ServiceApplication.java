package com.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sharding.mapper")
public class ServiceApplication {
	private static Logger logger = LoggerFactory.getLogger(ServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
		logger.info("service start success .....");
	}
}
