package com.exl.employeesearch.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exl.employeesearch.exception.RecordNotFoundException;
import com.exl.employeesearch.model.EmployeeEntity;
import com.exl.employeesearch.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeSearchController {

	@Autowired
	EmployeeService service;

	@RequestMapping
	public String getAllEmployees(Model model) 
	{
		model.addAttribute("employee", new EmployeeEntity());
		return "searchEmployee";
	}

	@RequestMapping(path = { "/backToSearch"})
	public String backToSearch(Model model) 
							throws RecordNotFoundException {
			model.addAttribute("employee", new EmployeeEntity());
		return "searchEmployee";
	}
	
	@RequestMapping(path = "/searchEmployee", method = RequestMethod.POST)
	public String searchEmployee(EmployeeEntity employee, Model model) throws RecordNotFoundException 
	{
		List<EmployeeEntity> searchResult=	service.searchEmployee(employee);
		model.addAttribute("employees", searchResult);
		return "searchResult";
	}
	

}
