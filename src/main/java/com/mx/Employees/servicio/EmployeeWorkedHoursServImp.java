package com.mx.Employees.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Employees.Model.EmployeeWorkedHours;
import com.mx.Employees.Model.Employees;
import com.mx.Employees.dao.EmployeeWorkedHoursDao;
import com.mx.Employees.dao.EmployeesDao;

@Service
public class EmployeeWorkedHoursServImp implements EmployeeWorkedHoursServ{
	
	@Autowired
	EmployeeWorkedHoursDao ewhd;
	@Autowired
	EmployeesDao ed;

	@Override
	public void guardar(EmployeeWorkedHours ewh) {
		ewhd.save(ewh);
	}

	@Override
	public void editar(EmployeeWorkedHours ewh) {
		ewhd.save(ewh);
	}

	@Override
	public void eliminar(EmployeeWorkedHours ewh) {
		ewhd.delete(ewh);
	}

	@Override
	public EmployeeWorkedHours buscar(EmployeeWorkedHours ewh) {
		return ewhd.findById(ewh.getId()).orElse(null);
	}

	@Override
	public List<EmployeeWorkedHours> mostrar() {
		return (List<EmployeeWorkedHours>) ewhd.findAll();
	}
	
	public List<Integer> obtieneIDs(){
		List<Employees> listaEmpleados = (List<Employees>) ed.findAll();
		List<Integer> idsEmpleados = new ArrayList<Integer>();
		
		// Obtiene ids de empleados
		for (Employees e : listaEmpleados) {
			int id = e.getId();
			idsEmpleados.add(id);
		}
		
		return idsEmpleados;
	}
}
