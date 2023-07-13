package com.mx.Employees.servicio;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.Employees.Model.Employees;
import com.mx.Employees.Model.Genders;
import com.mx.Employees.Model.Jobs;
import com.mx.Employees.dao.EmployeesDao;
import com.mx.Employees.dao.GendersDao;
import com.mx.Employees.dao.JobsDao;

@Service
public class EmployeesServImp implements EmployeesServ {

	@Autowired
	EmployeesDao ed;
	@Autowired
	GendersDao gd;
	@Autowired
	JobsDao jd;


	@Transactional
	@Override
	public void guardar(Employees employee) {
		ed.save(employee);
	}

	@Transactional
	@Override
	public void editar(Employees employee) {
		ed.save(employee);
	}

	@Transactional
	@Override
	public void eliminar(Employees employee) {
		ed.delete(employee);
	}

	@Transactional(readOnly = true)
	@Override
	public Employees buscar(Employees employee) {
		return ed.findById(employee.getId()).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Employees> mostrar() {
		return (List<Employees>) ed.findAll();
	}

	@Transactional(readOnly = true)
	public Employees searchByName(String nombre) {
		Employees emp = new Employees();
		for (Employees e : ed.findAll()) {
			if (e.getName().equals(nombre)) {
				emp = e;
			}
		}
		return emp;
	}
	
	public List<Integer> idsGeneros(){
		List<Genders> generos = (List<Genders>) gd.findAll();
		List<Integer> idsGeneros = new ArrayList<Integer>();
		
		for (Genders g : generos) {
			int idGenero = g.getId();
			idsGeneros.add(idGenero);
		}
		
		return idsGeneros; 
	}
	
	public List<Integer> idsJobs(){
		List<Jobs> jobs = (List<Jobs>) jd.findAll();
		List<Integer> idsJobs = new ArrayList<Integer>();
		
		for (Jobs j : jobs) {
			int idJob = j.getId();
			idsJobs.add(idJob);
		}
		
		return idsJobs; 
	}
	
	public List<String> nombreCompletos(){
		List<Employees> listaEmpleados = (List<Employees>) ed.findAll();
		List<String> nombreCompletos = new ArrayList<String>();
		
		for (Employees e : listaEmpleados) {
			String nombreCompleto = e.getName() + " " + e.getLast_name();
			nombreCompletos.add(nombreCompleto);
		}
		
		return nombreCompletos; 
	}
	
	public int obtieneEdad(Employees employee) {
		LocalDate currentDate = LocalDate.now();
		LocalDate birthdate = employee.getBirthdate();
		int age = Period.between(birthdate, currentDate).getYears();
		
		return age;
	
	}

}
