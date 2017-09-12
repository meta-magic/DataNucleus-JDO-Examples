package com.desire3d.examples.jdo.model;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Person {
	@PrimaryKey
	private Long id;

	private String name;

	private String address;

	private Long phone;

	public Person() {
		super();
	}

	public Person(Long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Person(Long id, String name, String address, Long phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public Long getPhone() {
		return phone;
	}

}