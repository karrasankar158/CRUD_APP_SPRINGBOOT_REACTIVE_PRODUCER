package com.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.model.Student;

public interface StudentRepository extends ReactiveMongoRepository<Student,Long>{

}
