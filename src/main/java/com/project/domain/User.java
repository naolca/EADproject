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

  public User(String firstName, String lastName, String email, String password, String role) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public User(int id, String firstName, String lastName, String email, String password, String role) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }
}
