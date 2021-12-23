package com.hris.absen;

import com.hris.absen.entity.User;
//import com.hris.absen.utils.AuditorAwarelmpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
//@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AbsenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbsenApplication.class, args);
	}

	public static User getCurrentUser(){
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal != null && principal.getClass().equals(User.class)){
				return (User) principal;
			}
		}catch (Exception ignore){

		}

		return null;
	}

//	public AuditorAware<String> auditorAware(){
//		return new AuditorAwarelmpl();
//	}

}
