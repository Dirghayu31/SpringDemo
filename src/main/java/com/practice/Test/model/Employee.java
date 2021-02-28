package com.practice.Test.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Employee {

	@Id
	public ObjectId _id;

	public String name;
	
	public int employee_id;

	public Employee() {
	}

	public Employee(ObjectId id, String name,int employee_id) {
		this._id = id;
		this.name = name;
		this.employee_id=employee_id;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	
}
