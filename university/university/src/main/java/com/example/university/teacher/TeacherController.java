package com.example.university.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="api/v1/teacher")
public class TeacherController {

	final private TeacherService teacherService;

	@Autowired
	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}
	@GetMapping (params ="id")
	public Teacher getTeacher(@RequestParam(name ="id", required =false) String teacherID)
	{
		return teacherService.getTeacher(teacherID);
	}
	@GetMapping
	public List<Teacher> getTeachers()
	{
		return teacherService.getTeachers();
	}
	@PostMapping
	public String createTeacher(@RequestBody Teacher teacher)
	{
		return teacherService.createTeacher(teacher);
	}
	@PatchMapping
	public String updateTeacher(@RequestBody Teacher teacher)
	{
		return teacherService.updateTeacherDepartment(teacher);
	}
	
}

