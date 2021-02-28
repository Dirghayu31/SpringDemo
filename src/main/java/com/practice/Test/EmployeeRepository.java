package com.practice.Test;

import com.practice.Test.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	Employee findBy_id(ObjectId _id);
}
