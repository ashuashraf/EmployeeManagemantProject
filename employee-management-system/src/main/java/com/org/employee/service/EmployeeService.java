package com.org.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.org.employee.model.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeService.
 */
public interface EmployeeService {
	
	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	List<Employee> getAllEmployees();
	
	/**
	 * Save employee.
	 *
	 * @param employee the employee
	 */
	void saveEmployee(Employee employee);
	
	/**
	 * Gets the employee by id.
	 *
	 * @param id the id
	 * @return the employee by id
	 */
	Employee getEmployeeById(int id);
	
	/**
	 * Delete employee by id.
	 *
	 * @param id the id
	 */
	void deleteEmployeeById(int id);
	
	/**
	 * Find paginated.
	 *
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @param sortField the sort field
	 * @param sortDirection the sort direction
	 * @return the page
	 */
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}