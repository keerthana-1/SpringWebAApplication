package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
	  model.addAttribute("students",studentService.getAllStudents());
	  return "students";
	}
	
	@GetMapping("/students/new")
	public String addStudent(Model model) {
	  
	  Student student=new Student();
	  model.addAttribute("students",student);
	  return "create_student";
	}
	
	@PostMapping("/students")
	public String addStudent(@ModelAttribute("students") Student student) {
		  
		 studentService.saveStudent(student);
		  return "redirect:/students";
		}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id,Model model) {
	  
	  model.addAttribute("students",studentService.findStudentById(id));
	  return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("students") Student student,Model model) {
	  
	  Student existingstudent=studentService.findStudentById(id);
	  
	  existingstudent.setFirstName(student.getFirstName());
	  existingstudent.setLastName(student.getLastName());
	  existingstudent.setEmail(student.getEmail());
	  
	  studentService.updateStudent(existingstudent);
	  return "redirect:/students";
	}
	

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id,Model model) {
	  
		studentService.deleteStudent(id);
	  return "redirect:/students";
	}
	

}
