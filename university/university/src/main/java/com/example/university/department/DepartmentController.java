package com.example.university.department;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/api/v1/department")
public class DepartmentController {
	
	final private DepartmentService departmentService;

	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	@GetMapping (params ="id")
	public Department getDepartment(@RequestParam(name ="id") String DepartemntID)
	{
		return departmentService.getDepartment(DepartemntID);
	}
	@GetMapping
	public List<Department> getDepartments()
	{
		return departmentService.getDepartments();
	}
	@PostMapping
	public String CreateDepartment(@RequestBody Department department)
	{
		return departmentService.createDepartment(department);
	}
	@PatchMapping
	public String updateDepartment(@RequestBody Department department)
	{
		return departmentService.updateDepartment(department);
	}
}
