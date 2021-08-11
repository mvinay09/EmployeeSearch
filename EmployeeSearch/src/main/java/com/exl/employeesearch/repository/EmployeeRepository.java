
package com.exl.employeesearch.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.exl.employeesearch.exception.RecordNotFoundException;
import com.exl.employeesearch.model.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
  
	List<EmployeeEntity> getEmployee(EmployeeEntity employee) throws   RecordNotFoundException;
  
  }
