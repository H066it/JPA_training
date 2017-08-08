package com.h066it.dto;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER")
public class Member {

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NAME")
	private String username;
	
	//If mapping name equals null, then field name will set on column name.
	private int age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
