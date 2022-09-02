package com.example.university.student;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

	private Integer countID=0;
	final private StudentRepository studentRepository;



	@Autowired
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	public Student getStudent(String studentID)
	{
		return studentRepository.findById(studentID).get();
	}
	public List<Student> getStudents()
	{
		return studentRepository.findAll();
	}
	@Transactional
	public String createStudent(Student student)
	{
		String studentID="S";
		if(!studentRepository.findTeacherByCodiceFiscale(student.getCodiceFiscale()).isPresent())
		{
			countID++;
			int countIDLength= countID.toString().length();
			for(int i=0; i< 6 - countIDLength; i++)
				studentID+=0;
			studentID+=countID;
			String email= studentID+"@student.it";
			student.setStudentID(studentID);
			student.setUniversityEmail(email);
			studentRepository.save(student);
		}
		return studentID;	
	}
	public String updateStudentDepartment(Student student)
	{
		String done="";
		if(!student.getDepartment().equals(studentRepository.findTeacherByCodiceFiscale(student.getCodiceFiscale()).get().getDepartment()))
		{
			studentRepository.findTeacherByCodiceFiscale(student.getCodiceFiscale()).get().setDepartment(student.getDepartment());
			done="done";
		}
		return done;
	}
}
