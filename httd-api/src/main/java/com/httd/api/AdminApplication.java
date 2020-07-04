package com.httd.api;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@EnableAsync
@SpringBootApplication
@EnableWebMvc
@EnableScheduling // 开启定时任务
@ServletComponentScan // 注解注册Servlet
@MapperScan("com.httd.api.mapper")
@EnableTransactionManagement // 支持事务管理
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
		log.info("项目启动成功");
	}

}
