package com.mx.Employees.servicio;

import java.util.List;

import com.mx.Employees.Model.Jobs;

public interface JobsServ {

	public void guardar(Jobs job);

	public void editar(Jobs job);

	public void eliminar(Jobs job);

	public Jobs buscar(Jobs job);

	public List<Jobs> mostrar();

}
