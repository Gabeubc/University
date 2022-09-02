package com.example.university.teacher;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name ="Teacher")
@Table
public class Teacher {

	@Column(name ="teacherId",
			nullable= false,
			updatable= false)
	@Id
	private String teacherID;
	@Column(name ="firstName",
			nullable= false)
	private String firstName;
	@Column(name ="lastName",
			nullable= false)
	private String lastName;
	@Column(name ="dob",
			nullable= false)
	private LocalDate dob;
	@Column(name ="pob",
			nullable= false)
	private String pob;
	@Column(name ="department",
			nullable= false)
	private String department;
	@Column(name ="email",
			nullable= false)
	private String email;
	@Column(name ="universityEmail",
			nullable= false)
	private String universityEmail;	
	@Column(name ="codiceFiscale",
			nullable= false)
	private String codiceFiscale;
	
	public Teacher() {}

	public Teacher(String teacherID, String firstName, String lastName, LocalDate dob, String pob, String department,
			String email, String codiceFiscale, String universityEmail) {
		super();
		this.teacherID = teacherID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.pob = pob;
		this.department = department;
		this.email = email;
		this.universityEmail=universityEmail;
		this.codiceFiscale = codiceFiscale;
	}

	public String getUniversityEmail() {
		return universityEmail;
	}

	public void setUniversityEmail(String universityEmail) {
		this.universityEmail = universityEmail;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPob() {
		return pob;
	}

	public void setPob(String pob) {
		this.pob = pob;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiceFiscale, department, dob, email, firstName, lastName, pob, teacherID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return Objects.equals(codiceFiscale, other.codiceFiscale) && Objects.equals(department, other.department)
				&& Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(pob, other.pob) && Objects.equals(teacherID, other.teacherID);
	}

	@Override
	public String toString() {
		return "Teacher [teacherID=" + teacherID + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", pob=" + pob + ", department=" + department + ", email=" + email + ", CodiceFiscale="
				+ codiceFiscale + "]";
	}
	
}
