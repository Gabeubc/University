package com.example.university.teacher;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherService {

	static private Integer countID=0;
	final private TeacherRepository teacherRepository;



	@Autowired
	public TeacherService(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}
	
	public Teacher getTeacher(String teacherID)
	{
		return teacherRepository.findById(teacherID).get();
	}
	public List<Teacher> getTeachers()
	{
		return teacherRepository.findAll();
	}
	@Transactional
	public String createTeacher(Teacher teacher)
	{
		String teacherID="T";
		if(!teacherRepository.findTeacherByCodiceFiscale(teacher.getCodiceFiscale()).isPresent())
		{
			countID++;
			int countIDLength= countID.toString().length();
			for(int i=0; i< 6 - countIDLength; i++)
				teacherID+=0;
			teacherID+=countID;
			String email= teacherID+"@teacher.it";
			teacher.setTeacherID(teacherID);
			teacher.setTeacherID(teacherID);
			teacher.setUniversityEmail(email);
			teacherRepository.save(teacher);
		}
		return teacherID;	
	}
	public String updateTeacherDepartment(Teacher teacher)
	{
		String done="";
		if(!teacher.getDepartment().equals(teacherRepository.findTeacherByCodiceFiscale(teacher.getCodiceFiscale()).get().getDepartment()))
		{
			teacherRepository.findTeacherByCodiceFiscale(teacher.getCodiceFiscale()).get().setDepartment(teacher.getDepartment());
			done="done";
		}
		return done;
	}
}
