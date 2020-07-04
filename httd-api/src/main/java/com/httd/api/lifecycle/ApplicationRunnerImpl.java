package com.httd.api.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("项目启动后首次执行");
	}
}