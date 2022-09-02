package com.example.university.department;

import java.util.Objects;

import javax.persistence.*;

@Entity(name ="Department")
public class Department {

	@Column(name ="Id",
			nullable =false,
			updatable =false)
	@Id
	private String departmentID;
	@Column(name ="name",
			nullable =false)
	private String name;
	public Department() {}
	public Department(String departmentID, String name) {
		super();
		this.departmentID = departmentID;
		this.name = name;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(departmentID, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(departmentID, other.departmentID) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", name=" + name + "]";
	}
	
}
