package com.mx.Employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Employees.Model.Jobs;
import com.mx.Employees.servicio.JobsServImp;

@RestController
@RequestMapping("JobsWS")
@CrossOrigin
public class JobsWS {

	@Autowired
	JobsServImp jsi;

	// http://localhost:9000/JobsWS/mostrar
	@GetMapping("mostrar")
	public List<Jobs> listar() {
		return jsi.mostrar();
	}

	// http://localhost:9000/JobsWS/guardar
	@PostMapping("guardar")
	public void guardar(@RequestBody Jobs job) {
		jsi.guardar(job);
	}

	// http://localhost:9000/JobsWS/buscar
	@PostMapping("buscar")
	public Jobs buscar(@RequestBody Jobs job) {
		return jsi.buscar(job);
	}

	// http://localhost:9000/JobsWS/editar
	@PostMapping("editar")
	public void editar(@RequestBody Jobs job) {
		jsi.editar(job);
	}

	// http://localhost:9000/JobsWS/eliminar
	@PostMapping("eliminar")
	public void eliminar(@RequestBody Jobs job) {
		jsi.eliminar(job);
	}

}
