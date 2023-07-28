package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {
	
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Student student1=new Student("keerthana","aravapalli","keerthi@gmail.com");
//		studentRepository.save(student1);
//		
//
//		Student student2=new Student("yamini","aravapalli","yamini@gmail.com");
//		studentRepository.save(student2);
		
	}

}
