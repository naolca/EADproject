package com.project.domain;

public class User {
	public int id;
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	public String role;

	public User() {
	}

	public User(String first_name, String last_name, String email, String password, String role) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(int id, String first_name, String last_name, String email, String password, String role) {
		this.id = id;
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
}
