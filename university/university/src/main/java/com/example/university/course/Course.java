package com.example.university.course;

import java.sql.*;
import java.util.Objects;

import javax.persistence.*;

@Entity(name ="course")
public class Course {
	
	@Column(name ="courseID",
			nullable= false,
			updatable= false)
	@Id
	private String courseID;
	@Column(name ="name",
			nullable= false)
	private String name;
	@Column(name ="department",
			nullable =false)
	private String department;
	@Column(name= "teacherID",
			nullable= false)
	private String teacherID;
	@Column(name ="studentGroup",
			nullable =false)
	private String studentGroup;
	@Column(name ="startTime",
			nullable =false)
	private Time startTime;
	@Column(name ="endsTime",
			nullable =false)	
	private Time endTime;
	public Course() {}
	public Course(String courseID, String name, String department, String teacherID, String studentGroup, Time startTime, Time endTime) {
		super();
		this.courseID = courseID;
		this.name = name;
		this.department = department;
		this.teacherID = teacherID;
		this.studentGroup = studentGroup;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStudentGroup() {
		return studentGroup;
	}
	public void setStudentGroup(String studentGroup) {
		this.studentGroup = studentGroup;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	@Override
	public int hashCode() {
		return Objects.hash(courseID, department, endTime, name, startTime, studentGroup, teacherID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseID, other.courseID) && Objects.equals(department, other.department)
				&& Objects.equals(endTime, other.endTime) && Objects.equals(name, other.name)
				&& Objects.equals(startTime, other.startTime) && Objects.equals(studentGroup, other.studentGroup)
				&& Objects.equals(teacherID, other.teacherID);
	}
	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", name=" + name + ", department=" + department + ", teacherID="
				+ teacherID + ", studentGroup=" + studentGroup + ", startTime=" + startTime + ", endTime=" + endTime
				+ "]";
	}
	
}
