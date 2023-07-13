package com.mx.Employees.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Employees.Model.Genders;
import com.mx.Employees.dao.GendersDao;

@Service
public class GendersServImp implements GendersServ{
	
	@Autowired
	GendersDao gd;

	@Override
	public void guardar(Genders gender) {
		gd.save(gender);
	}

	@Override
	public void editar(Genders gender) {
		gd.save(gender);
	}

	@Override
	public void eliminar(Genders gender) {
		gd.delete(gender);
	}

	@Override
	public Genders buscar(Genders gender) {
		return gd.findById(gender.getId()).orElse(null);
	}

	@Override
	public List<Genders> mostrar() {
		return (List<Genders>) gd.findAll();
	}

}
