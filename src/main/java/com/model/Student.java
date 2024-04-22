package com.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Student {

	@Id
	private Long sid;//If PK is not String then ID must be given manually
	
	private String sname;
	
	private Double sfees;
}
