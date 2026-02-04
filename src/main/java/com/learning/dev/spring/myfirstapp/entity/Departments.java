package com.learning.dev.spring.myfirstapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="departments")
public class Departments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long department_id ;
	
	private String department_name;
	private String department_address;
	private String department_code;
	
	
	public Departments() {}
	
	
	public Departments(String department_name, String department_address, String department_code) {
		super();
		this.department_name = department_name;
		this.department_address = department_address;
		this.department_code = department_code;
	}


	public long getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(long department_id) {
		this.department_id = department_id;
	}


	public String getDepartment_name() {
		return department_name;
	}


	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}


	public String getDepartment_address() {
		return department_address;
	}


	public void setDepartment_address(String department_address) {
		this.department_address = department_address;
	}


	public String getDepartment_code() {
		return department_code;
	}


	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}


	@Override
	public String toString() {
		return "Departments [department_id=" + department_id + ", department_name=" + department_name
				+ ", department_address=" + department_address + ", department_code=" + department_code + "]";
	}
}

	
	

	


