package com.mx.Employees.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.Employees.Model.Jobs;

public interface JobsDao extends CrudRepository<Jobs, Integer>{

}
