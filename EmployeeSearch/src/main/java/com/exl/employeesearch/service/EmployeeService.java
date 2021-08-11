package com.exl.employeesearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exl.employeesearch.exception.RecordNotFoundException;
import com.exl.employeesearch.model.EmployeeEntity;
import com.exl.employeesearch.repository.EmployeeRepository;


@Service
public class EmployeeService {

		@Autowired
		EmployeeRepository employeeRepository;
		
		public List<EmployeeEntity> searchEmployee(EmployeeEntity employee) throws RecordNotFoundException {
			employee.setLastName(employee.getFirstName());
			List<EmployeeEntity> list = employeeRepository.getEmployee(employee);
			return list;

		}
}
