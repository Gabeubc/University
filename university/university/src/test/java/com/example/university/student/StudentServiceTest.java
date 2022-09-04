package com.example.university.student;

import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.university.department.DepartmentRepository;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
	
	@Mock
	private StudentRepository studentRepository;
	@Mock
	private DepartmentRepository departmentRepository;
	private StudentService studentServiceUnderTest;
	

	@BeforeEach
	void setUp() throws Exception {
		studentServiceUnderTest = new StudentService(studentRepository, departmentRepository);
	}

	@Test
	void canGetAllTest() {
		//when
		studentServiceUnderTest.getStudents();
		//then}
		verify(studentRepository).findAll();
	
	}
	
	@Test
	void canGetById()
	{
		//when
		studentServiceUnderTest.getStudent("S000001");
		//then
		verify(studentRepository).findById("S000001");
	}

}
