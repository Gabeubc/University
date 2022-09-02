package com.example.university;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.university.department.*;
import com.example.university.student.*;

@SpringBootTest
class UniversityApplicationTests {

	@Autowired
	StudentService studentServiceUnderTest;
	@Autowired
	StudentRepository studentRepositoryUnderTest;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Test
	void itShouldBeStudent() {
		
		Student studentFromRepository = studentRepositoryUnderTest.findStudentByCodiceFiscale("YBSGRL97C19Z306I").get();
		Student studentFromService = studentServiceUnderTest.getStudent("S000003");
		Department departmentFromRepository = departmentRepository.findDepartmentByName("Computer Engineering").get();
		Department departmentFromService = departmentService.getDepartment("D000001");
		assertInstanceOf(Student.class, studentFromRepository);
		assertInstanceOf(Student.class, studentFromService);
		assertInstanceOf(Department.class, departmentFromRepository);
		assertInstanceOf(Department.class, departmentFromService);
	}
	@Test
	void itShouldByString()
	{
	}

}
