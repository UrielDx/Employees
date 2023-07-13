package com.mx.Employees.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.Employees.Model.Genders;

public interface GendersDao extends CrudRepository<Genders, Integer>{

}
