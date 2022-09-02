package com.example.university.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentService {

	static private Integer countID=0;
	final private DepartmentRepository departmentRepository;

	@Autowired
	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}
	public Department getDepartment(String departmentID)
	{
		return departmentRepository.findById(departmentID).get();
	}
	public List<Department> getDepartments()
	{
		return departmentRepository.findAll();
	}
	public String createDepartment(Department department)
	{
		String departmentID="D";
		if(!departmentRepository.findDepartmentByName(department.getName()).isPresent())
		{
			countID++;
			int countIdLength= countID.toString().length();
			for (int i=0; i< 6 - countIdLength; i++)
				departmentID+=0;
			departmentID+=countID;
			department.setDepartmentID(departmentID);
			departmentRepository.save(department);
		}
		
		return departmentID;
	}
	public String updateDepartment(Department department)
	{
		String done="";
		if(!departmentRepository.findById(department.getDepartmentID()).isPresent())
		{
			departmentRepository.findById(department.getDepartmentID()).get().setName(department.getName());
		    done="done";
		}
		return done;
	}
	
}
