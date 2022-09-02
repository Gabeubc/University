package com.example.university.course;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{

	Optional<Course> findCourseByDepartment(String department);
	Optional<List<Course>> findAllCourseByName(String name);

}
