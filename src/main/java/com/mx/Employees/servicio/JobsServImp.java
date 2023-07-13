package com.mx.Employees.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Employees.Model.Jobs;
import com.mx.Employees.dao.JobsDao;

@Service
public class JobsServImp implements JobsServ{
	
	@Autowired
	JobsDao jd;

	@Override
	public void guardar(Jobs job) {
		jd.save(job);
	}

	@Override
	public void editar(Jobs job) {
		jd.save(job);
	}

	@Override
	public void eliminar(Jobs job) {
		jd.delete(job);
	}

	@Override
	public Jobs buscar(Jobs job) {
		return jd.findById(job.getId()).orElse(null);
	}

	@Override
	public List<Jobs> mostrar() {
		return (List<Jobs>) jd.findAll();
	}

}
