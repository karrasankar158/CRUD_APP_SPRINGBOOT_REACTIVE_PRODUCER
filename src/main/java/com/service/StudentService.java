package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Student;
import com.repo.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	/**
	 * MONO used to get Single record
	 * Saving Student  Object into Database
	 * @param student
	 * @return
	 */
	public Mono<Student> createStudent(Student student){
		return repo.save(student);
	}

	/**
	 * MONO used to get Single record
	 * Find Student Object by using ID value
	 * @param id
	 * @return
	 */
	public Mono<Student> fetchOneStudent(Long id){
		return repo.findById(id).switchIfEmpty(Mono.empty());// switchIfEmpty(Flux.empty()) return empty object if no data available.
	}

	/**
	 * FLUX used to get all records
	 * @return
	 */
	public Flux<Student> fetchAllStudents(){
		return repo.findAll().switchIfEmpty(Flux.empty());// switchIfEmpty(Flux.empty()) return empty object if no data available.
	}
	
	/**
	 * MONO used to get Single record
	 * Remove Student Object by using ID value
	 * @param id
	 * @return
	 */
	public Mono<Void> removeOneStudent(Long id){
		return repo.deleteById(id);
	}
}
