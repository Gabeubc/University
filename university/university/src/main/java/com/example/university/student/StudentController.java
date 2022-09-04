package com.example.university.student;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path ="/api/v1/student")
public class StudentController {

	final private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@GetMapping(params ="id")
	public Optional<Student> getStudent(@RequestParam(name ="id") String studentID)
	{
		return studentService.getStudent(studentID);
	}
	@GetMapping
	public List<Student> getStudents()
	{
		return studentService.getStudents();
	}
	@PostMapping
	public String createStudent(@RequestBody Student student)
	{
		return studentService.createStudent(student);
	}
	@PatchMapping
	public String updateStudent(@RequestBody Student student)
	{
		return studentService.updateStudentDepartment(student);
	}
	
	
}
