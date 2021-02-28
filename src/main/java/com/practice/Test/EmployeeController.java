package com.practice.Test;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Test.model.Employee;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List getAllEmplList() {
		System.out.println("in here");
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getEmployeebyId(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyEmployeeById(@PathVariable("id") ObjectId id, @Validated @RequestBody Employee employees) {
		employees.set_id(id);
		repository.save(employees);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)

	public Employee createEmployee(@Validated @RequestBody Employee employees) {
		employees.set_id(ObjectId.get());
		repository.save(employees);
		return employees;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
}
