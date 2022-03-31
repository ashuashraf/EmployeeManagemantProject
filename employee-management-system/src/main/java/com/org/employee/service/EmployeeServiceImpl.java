package com.org.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.org.employee.model.Employee;
import com.org.employee.repository.EmployeeRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeServiceImpl.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	/** The employee repository. */
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	/**
	 * Save employee.
	 *
	 * @param employee the employee
	 */
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	/**
	 * Gets the employee by id.
	 *
	 * @param id the id
	 * @return the employee by id
	 */
	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	/**
	 * Delete employee by id.
	 *
	 * @param id the id
	 */
	@Override
	public void deleteEmployeeById(int id) {
		this.employeeRepository.deleteById(id);
	}

	/**
	 * Find paginated.
	 *
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @param sortField the sort field
	 * @param sortDirection the sort direction
	 * @return the page
	 */
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}
}