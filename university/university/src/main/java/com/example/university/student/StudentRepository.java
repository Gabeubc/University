package com.example.university.student;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{
	
	Optional<Student> findTeacherByCodiceFiscale(String codiceFiscale);

}
