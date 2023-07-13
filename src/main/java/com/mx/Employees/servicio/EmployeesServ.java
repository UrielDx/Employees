package com.mx.Employees.servicio;

import java.util.List;

import com.mx.Employees.Model.Employees;

public interface EmployeesServ {
	
	public void guardar(Employees employee);

	public void editar(Employees employee);

	public void eliminar(Employees employee);

	public Employees buscar(Employees employee);
	
	public List<Employees> mostrar();

}
