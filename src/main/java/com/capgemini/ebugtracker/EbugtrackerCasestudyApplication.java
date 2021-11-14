package com.capgemini.ebugtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.capgemini.ebugtracker.admin.service.AdminServices")
@EnableJpaRepositories("com.capgemini.ebugtracker.staff.repositery.StaffDao")
public class EbugtrackerCasestudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbugtrackerCasestudyApplication.class, args);
	}

}
