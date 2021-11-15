package com.capgemini.ebugtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.capgemini.ebugtracker")
//@ComponentScans(value = { @ComponentScan("com.capgemini.Ebugtracker.Admin.AdminServiceImpl"),
//		@ComponentScan("com.capgemini.Ebugtracker.Admin.AdminService"),		
//		@ComponentScan("com.capgemini.Ebugtracker.BugServices"),
//		@ComponentScan("com.capgemini.Ebugtracker.Bugs"),		
//		@ComponentScan("com.capgemini.Ebugtracker.Bugs.Bugs"),
//	@ComponentScan("com.capgemini.Ebugtracker.mailsender"),
////		@ComponentScan("com.capgemini.Ebugtracker.Staff.Staff"),
////		
//		@ComponentScan("com.capgemini.Ebugtracker.Staff.StaffService"),
//		@ComponentScan("com.capgemini.Ebugtracker.user.Customer")
//	})
////
//@EnableJpaRepositories("com.capgemini.Ebugtracker.Staff.StaffDao")
public class EbugtrackerCasestudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbugtrackerCasestudyApplication.class, args);
	}

}
