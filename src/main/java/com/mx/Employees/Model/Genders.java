package com.mx.Employees.Model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Genders")
public class Genders {
	//Mapeo
	@Id
	int id;
	String name;
	
	// Cardinalidad
	@OneToMany(mappedBy = "genders", cascade = CascadeType.ALL)
	List<Employees> employee = new ArrayList<Employees>();

	public Genders() {
	}

	public Genders(int id) {
		this.id = id;
	}

	public Genders(int id, String name, List<Employees> employee) {
		this.id = id;
		this.name = name;
		this.employee = employee;
	}

	// A partir de aqui se quita
	
	@Override
	public String toString() {
		return "Genders [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
