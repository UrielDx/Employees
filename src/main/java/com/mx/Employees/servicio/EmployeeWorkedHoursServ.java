package com.mx.Employees.servicio;

import java.util.List;

import com.mx.Employees.Model.EmployeeWorkedHours;

public interface EmployeeWorkedHoursServ {
	
	public void guardar(EmployeeWorkedHours ewh);

	public void editar(EmployeeWorkedHours ewh);

	public void eliminar(EmployeeWorkedHours ewh);

	public EmployeeWorkedHours buscar(EmployeeWorkedHours ewh);

	public List<EmployeeWorkedHours> mostrar();

}
