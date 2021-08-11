package com.exl.employeesearch.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.exl.employeesearch.exception.RecordNotFoundException;
import com.exl.employeesearch.model.EmployeeEntity;

public class EmployeeRepositoryImpl  {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<EmployeeEntity> getEmployee(EmployeeEntity employee) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		boolean isWhereAdded = false;
		DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sql = new StringBuilder("select * from Exl_EMPLOYEES ");
		if (employee == null) {
			throw new RecordNotFoundException("Please Fill any value");
		}

		if (employee.getFirstName() != null && !employee.getFirstName().isEmpty()) {
			sql.append(" where first_name= '" + employee.getFirstName() + "'");
			sql.append(" OR last_name= '" + employee.getLastName() + "'");
			isWhereAdded = true;
		}
		if (employee.getStartDate() != null) {

			String startDate = outputFormatter.format(employee.getStartDate());
			if (isWhereAdded) {
				sql.append("And start_Date >='" + startDate + "'");
			} else {
				sql.append(" where start_Date >='" + startDate + "'");
				isWhereAdded = true;
			}
		}
		if (employee.getEndDate() != null) {
			String endDate = outputFormatter.format(employee.getEndDate());
			if (isWhereAdded) {
				sql.append(" And end_Date <='" + endDate + "'");

			} else {
				sql.append(" where end_Date <='" + endDate + "'");
			}
		}
		List<EmployeeEntity> list = jdbcTemplate.query(sql.toString(),
				(rs, rowNum) -> new EmployeeEntity(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("job_title"), rs.getInt("age"), rs.getDate("start_date"), rs.getDate("end_date")));

		return list;
	}


}
