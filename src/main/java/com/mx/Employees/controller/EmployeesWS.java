package com.mx.Employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Employees.Model.Employees;
import com.mx.Employees.servicio.EmployeesServImp;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("EmployeesWS")
@CrossOrigin
public class EmployeesWS {

	@Autowired
	EmployeesServImp esi;

	// http://localhost:9000/EmployeesWS/mostrar
	@GetMapping("mostrar")
	public List<Employees> mostrar() {
		return esi.mostrar();
	}

	// http://localhost:9000/EmployeesWS/guardar
	@PostMapping("guardar")
	public ResponseEntity<String> guardar(@RequestBody Employees employee, Model model) {

		// Verifica que el objeto genders exista
		List<Integer> idsGenders = esi.idsGeneros();
		if (idsGenders.contains(employee.getGenders().getId())) {
			// Varifica que el objeto jobs exista
			List<Integer> idsJobs = esi.idsJobs();
			if (idsJobs.contains(employee.getJobs().getId())) {
				// Obtiene nombres y apellidos de la bd
				List<String> nombresCompletos = esi.nombreCompletos();
				// Obtiene el nombre ingresado
				String nombreCompleto2 = employee.getName() + " " + employee.getLast_name();
				// Verifica que el nombre ingresado no exista
				if (!nombresCompletos.contains(nombreCompleto2)) {
					// Verifica que el empleado sea mayor de edad
					int edad = esi.obtieneEdad(employee);
					if (edad >= 18) {
						esi.guardar(employee);
						// return "redirect:mostrarEmpleados";
						return ResponseEntity.ok().body("Empleado registrado exitosamente");
					} else {
						return ResponseEntity.badRequest().body("El empleado debe ser mayor de edad");
					}
				} else {
					// Boolean alertaNombre = true;
					// model.addAttribute("mostrarAlert", alertaNombre);
					// return "altaEmpleado";
					return ResponseEntity.badRequest().body("El nombre indicado ya existe");
				}
			} else {
				// Boolean alertaJob = true;
				// model.addAttribute("mostrarAlert", alertaJob);
				// return "altaEmpleado";
				return ResponseEntity.badRequest().body("El ID trabajo no existe");
			}
		} else {
			//Boolean alertaGenero = true;
			//model.addAttribute("mostrarAlert", alertaGenero);
			// return "altaEmpleado";
			return ResponseEntity.badRequest().body("El ID de genero no existe");
		}
	}

	// http://localhost:9000/EmployeesWS/buscar
	@PostMapping("buscar")
	public Employees buscar(@RequestBody Employees employee) {
		return esi.buscar(employee);
	}

	// http://localhost:9000/EmployeesWS/editar
	@PostMapping("editar")
	public ResponseEntity<String> editar(@RequestBody Employees employee, Model model) {
		// Verifica que el objeto genders exista
		List<Integer> idsGenders = esi.idsGeneros();
		if (idsGenders.contains(employee.getGenders().getId())) {
			// Varifica que el objeto jobs exista
			List<Integer> idsJobs = esi.idsJobs();
			if (idsJobs.contains(employee.getJobs().getId())) {
				// Obtiene nombres y apellidos de la bd
				List<String> nombresCompletos = esi.nombreCompletos();
				// Obtiene el nombre ingresado
				String nombreCompleto2 = employee.getName() + " " + employee.getLast_name();
				// Verifica que el nombre ingresado no exista
				if (!nombresCompletos.contains(nombreCompleto2) || nombreCompleto2.equals(nombreCompleto2)) {
					// Verifica que el empleado sea mayor de edad
					int edad = esi.obtieneEdad(employee);
					if (edad >= 18) {
						esi.editar(employee);
						// return "redirect:mostrarEmpleados";
						return ResponseEntity.ok().body("Empleado actualizado exitosamente");
					} else {
						return ResponseEntity.badRequest().body("El empleado debe ser mayor de edad");
					}
				} else {
					// Boolean alertaNombre = true;
					// model.addAttribute("mostrarAlert", alertaNombre);
					// return "altaEmpleado";
					return ResponseEntity.badRequest().body("El nombre indicado ya existe");
				}
			} else {
				// Boolean alertaJob = true;
				// model.addAttribute("mostrarAlert", alertaJob);
				// return "altaEmpleado";
				return ResponseEntity.badRequest().body("El ID trabajo no existe");
			}
		} else {
			// Boolean alertaGenero = true;
			// model.addAttribute("mostrarAlert", alertaGenero);
			// return "altaEmpleado";
			return ResponseEntity.badRequest().body("El ID de genero no existe");
		}
	}

	@Transactional
	// http://localhost:9000/EmployeesWS/eliminar
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Employees employee) {
		esi.eliminar(employee);
	}

}
