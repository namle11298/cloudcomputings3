package com.cc.three;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AssignmentThreeApp {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentThreeApp.class, args);
	}

}
