package com.mx.Employees.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employees {
	// Mapeo
	@Id
	int id;
	// Cardinalidad
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GENDER_ID")
	Genders genders;
	// Cardinalidad
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "JOB_ID")
	Jobs jobs;
	String name;
	String last_name;
	LocalDate birthdate;

	public Employees() {
	}

	public Employees(int id) {
		this.id = id;
	}

	public Employees(int id, Genders genders, Jobs jobs, String name, String last_name, LocalDate birthdate) {
		this.id = id;
		this.genders = genders;
		this.jobs = jobs;
		this.name = name;
		this.last_name = last_name;
		this.birthdate = birthdate;
	}

	// Los objetos van en todo lo que sigue 
	
	@Override
	public String toString() {
		return "Employees [id=" + id + ", genders=" + genders + ", jobs=" + jobs + ", name=" + name + ", last_name="
				+ last_name + ", birthdate=" + birthdate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Genders getGenders() {
		return genders;
	}

	public void setGenders(Genders genders) {
		this.genders = genders;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
}