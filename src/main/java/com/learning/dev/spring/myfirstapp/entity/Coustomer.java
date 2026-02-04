package com.learning.dev.spring.myfirstapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Coustomer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String fullname;
	private int age;
	@Column(nullable = false)
	private String address;
	
	
	
	public Coustomer() {
		
	}


	public Coustomer(String fullname, int age, String address) {
		super();
		this.fullname = fullname;
		this.age = age;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Coustomer [id=" + id + ", fullname=" + fullname + ", age=" + age + ", address=" + address + "]";
	}
	
	

	
}
