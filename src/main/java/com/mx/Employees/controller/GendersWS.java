package com.mx.Employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Employees.Model.Genders;
import com.mx.Employees.servicio.GendersServImp;

@RestController
@RequestMapping("GendersWS")
@CrossOrigin
public class GendersWS {
	
	@Autowired
	GendersServImp gsi;

	// http://localhost:9000/GendersWS/mostrar
	@GetMapping("mostrar")
	public List<Genders> listar() {
		return gsi.mostrar();
	}

	// http://localhost:9000/GendersWS/guardar
	@PostMapping("guardar")
	public void guardar(@RequestBody Genders gender) {
		gsi.guardar(gender);
	}

	// http://localhost:9000/GendersWS/buscar
	@PostMapping("buscar")
	public Genders buscar(@RequestBody Genders gender) {
		return gsi.buscar(gender);
	}

	// http://localhost:9000/GendersWS/editar
	@PostMapping("editar")
	public void editar(@RequestBody Genders gender) {
		gsi.editar(gender);
	}

	// http://localhost:9000/GendersWS/eliminar
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Genders gender) {
		gsi.eliminar(gender);
	}

}
