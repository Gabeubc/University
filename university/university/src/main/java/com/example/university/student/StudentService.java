package com.example.university.student;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.university.department.DepartmentRepository;

@Service
public class StudentService {

	private Integer countID=0;
	final private StudentRepository studentRepository;
	final private DepartmentRepository departmentRepository;


	@Autowired
	public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
		super();
		this.studentRepository = studentRepository;
		this.departmentRepository = departmentRepository;
	}
	public Optional<Student> getStudent(String studentID)
	{
		return studentRepository.findById(studentID);
	}
	public List<Student> getStudents()
	{
		return studentRepository.findAll();
	}
	public String createStudent(Student student)
	{
		String studentID="S";
		if(!studentRepository.findStudentByCodiceFiscale(student.getCodiceFiscale()).isPresent())
		{
			if(departmentRepository.findDepartmentByName(student.getDepartment()).isPresent())
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
			
		}
		return studentID;	
	}
	@Transactional
	public String updateStudentDepartment(Student student)
	{
		String done="";
		if(!student.getDepartment().equals(studentRepository.findStudentByCodiceFiscale(student.getCodiceFiscale()).get().getDepartment()))
		{
			studentRepository.findStudentByCodiceFiscale(student.getCodiceFiscale()).get().setDepartment(student.getDepartment());
			done="done";
		}
		return done;
	}
}
