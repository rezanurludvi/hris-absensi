package com.hris.absen;

import com.hris.absen.entity.Employee;
import com.hris.absen.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
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

    public static Employee getCurrentEmployee() {
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal != null && principal.getClass().equals(Employee.class)){
				return (Employee) principal;
			}
		}catch (Exception ignore){

		}

		return null;
    }
}
