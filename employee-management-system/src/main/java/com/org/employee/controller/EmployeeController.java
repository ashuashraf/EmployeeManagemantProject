package com.org.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.org.employee.model.Employee;
import com.org.employee.service.EmployeeService;

/**
 * The Class EmployeeController.
 */
@Controller
public class EmployeeController {
	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;	
	/**
	 * View home page.
	 *
	 * @param model the model
	 * @return the string
	 */
	// display list of employees
	@GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

	/**
	 * Show new employee form.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	/**
	 * Save employee.
	 *
	 * @param employee the employee
	 * @return the string
	 */
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		/* save employee to database */
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	/**
	 * Show form for update.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		/*
		 *  get employee from the service
		 */		
		Employee employee = employeeService.getEmployeeById(id);
		/*
		 * set employee as a model attribute to pre-populate the form
		 */	
		model.addAttribute("employee", employee);
		return "update_employee";
	}	
	/**
	 * Delete employee.
	 *
	 * @param id the id
	 * @return the string
	 */
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") int id) {	
		/* call delete employee method */ 
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
 	/**
 	 * Find paginated.
 	 *
 	 * @param pageNo the page no
 	 * @param sortField the sort field
 	 * @param sortDir the sort dir
 	 * @param model the model
 	 * @return the string
 	 */
 	@GetMapping("/page/{pageNo}")
	    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
	        @RequestParam("sortField") String sortField,
	        @RequestParam("sortDir") String sortDir,
	        Model model) {
	        int pageSize = 5;
	        Page < Employee > page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
	        List < Employee > listEmployees = page.getContent();
	        model.addAttribute("currentPage", pageNo);
	        model.addAttribute("totalPages", page.getTotalPages());
	        model.addAttribute("totalItems", page.getTotalElements());
	        model.addAttribute("sortField", sortField);
	        model.addAttribute("sortDir", sortDir);
	        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	        model.addAttribute("listEmployees", listEmployees);
	        return "index";
	    }
	}	