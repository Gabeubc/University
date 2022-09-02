package com.example.university.teacher;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String>{
	
	Optional<Teacher> findTeacherByCodiceFiscale(String codiceFiscale);

}
