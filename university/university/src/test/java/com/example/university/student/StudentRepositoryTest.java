package com.example.university.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	void canFindByCodiceFiscale()
	{
		//given
		String codiceFiscale="YBSGRL97C19Z306I";
		//when
		Student student= studentRepository.findStudentByCodiceFiscale(codiceFiscale).get();
		//then
		assertInstanceOf(Student.class, student);
		assertEquals("S000002", student.getStudentID());
	}
}
