package com.example.university.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/api/v1/course")
public class CourseController {

	final private CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@GetMapping
	public List<Course> getCourses()
	{
		return courseService.getCourses();
	}
	@GetMapping (params ="id")
	public Course getCourse(@RequestParam(name ="id") String courseID)
	{
		return courseService.getCourse(courseID);
	}
	@PostMapping
	public String createCourse(@RequestBody Course course)
	{
		return courseService.createCourse(course);
	}
	@PatchMapping
	public String updateStartTimeOrEndTime(Course course)
	{
		return courseService.updateCourseStartTimeOrEndTime(course);
	}
	
}
