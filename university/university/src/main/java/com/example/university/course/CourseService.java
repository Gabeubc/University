package com.example.university.course;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.example.university.department.DepartmentRepository;

@Service
public class CourseService {
	
	static private Integer countID=0;
	final private CourseRepository courseRepository;
	final private DepartmentRepository departmentRepository;

	@Autowired
	public CourseService(CourseRepository courseRepository, DepartmentRepository departmentRepository) {
		super();
		this.courseRepository = courseRepository;
		this.departmentRepository = departmentRepository;
	}
	public Course getCourse(String courseID)
	{
		return courseRepository.findById(courseID).get();
	}
	public List<Course> getCourses()
	{
		return courseRepository.findAll();
	}
	public String createCourse(Course course)
	{
		String courseID="C";
		if(departmentRepository.findDepartmentByName(course.getDepartment()).isPresent())
		{
			List<Course> listOfCourse = courseRepository.findAllCourseByName(course.getName()).get();
			for(Course c: listOfCourse)
			{
				if(c.getDepartment().equals(course.getDepartment()) && c.getEndTime().equals(course.getEndTime()) && c.getStartTime().equals(course.getStartTime()) && c.getStudentGroup().equals(course.getStudentGroup()))
					return courseID;
			}
			listOfCourse = courseRepository.findAll();
			for(Course c: listOfCourse)
			{
				if(c.getDepartment().equals(course.getDepartment()) && c.getEndTime().equals(course.getEndTime()) && c.getStartTime().equals(course.getStartTime()) && c.getStudentGroup().equals(course.getStudentGroup()))
					return courseID;
			}
			countID++;
			int countIDLenght = countID.toString().length();
			for(int i=0 ; i< 6 - countIDLenght ; i++)
				courseID+=0;
			courseID+=countID;
			course.setCourseID(courseID);
			courseRepository.save(course);
		}
		return courseID;
	}
	@Transactional
	public String updateCourseStartTimeOrEndTime(Course course)
	{
		String done="";
		if(courseRepository.findById(course.getCourseID()).isPresent())
		{
			if(!courseRepository.findById(course.getCourseID()).get().getStartTime().equals(course.getStartTime()))
			{
				courseRepository.findById(course.getCourseID()).get().setStartTime(course.getStartTime());
				done="done";
			}
			if(!courseRepository.findById(course.getCourseID()).get().getStartTime().equals(course.getEndTime()))
			{
				courseRepository.findById(course.getCourseID()).get().setStartTime(course.getEndTime());
				done="done";
			}
		}
		return done;
	}
}
