package com.mx.Employees.servicio;

import java.util.List;

import com.mx.Employees.Model.Genders;

public interface GendersServ {

	public void guardar(Genders gender);

	public void editar(Genders gender);

	public void eliminar(Genders gender);

	public Genders buscar(Genders gender);

	public List<Genders> mostrar();

}
