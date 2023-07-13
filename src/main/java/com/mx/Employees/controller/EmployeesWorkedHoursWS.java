package com.mx.Employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Employees.Model.EmployeeWorkedHours;
import com.mx.Employees.servicio.EmployeeWorkedHoursServImp;

@RestController
@RequestMapping("EmployeesWorkedHoursWS")
@CrossOrigin
public class EmployeesWorkedHoursWS {

	@Autowired
	EmployeeWorkedHoursServImp esi;

	// http://localhost:9000/EmployeesWorkedHoursWS/mostrar
	@GetMapping("mostrar")
	public List<EmployeeWorkedHours> listar() {
		return esi.mostrar();
	}

	// http://localhost:9000/EmployeesWorkedHoursWS/guardar
	@PostMapping("guardar")
	public ResponseEntity<String> guardar(@RequestBody EmployeeWorkedHours emp) {

		List<Integer> idsEmpleados = esi.obtieneIDs();

		// Compara si el id indicado se encuentra dentro de la bd
		if (idsEmpleados.contains(emp.getEmployee().getId())) {
			esi.guardar(emp);
			return ResponseEntity.ok().body("Registro de empleado exitoso");
		} else {
			return ResponseEntity.badRequest().body("El ID de empleado indicado no existe");
		}

	}

	// http://localhost:9000/EmployeesWorkedHoursWS/buscar
	@PostMapping("buscar")
	public EmployeeWorkedHours buscar(@RequestBody EmployeeWorkedHours emp) {
		return esi.buscar(emp);
	}

	// http://localhost:9000/EmployeesWorkedHoursWS/editar
	@PostMapping("editar")
	public ResponseEntity<String> editar(@RequestBody EmployeeWorkedHours emp) {
		
		List<Integer> idsEmpleados = esi.obtieneIDs();

		// Compara si el id indicado se encuentra dentro de la bd
		if (idsEmpleados.contains(emp.getEmployee().getId())) {
			esi.editar(emp);
			return ResponseEntity.ok().body("Actualizacion de empleado exitoso");
		} else {
			return ResponseEntity.badRequest().body("El ID de empleado indicado no existe");
		}
	}

	// http://localhost:9000/EmployeesWorkedHoursWS/eliminar
	@PostMapping("eliminar")
	public void eliminar(@RequestBody EmployeeWorkedHours emp) {
		esi.eliminar(emp);
	}

}
