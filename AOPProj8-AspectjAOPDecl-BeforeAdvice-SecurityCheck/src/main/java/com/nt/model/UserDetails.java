package com.nt.model;

public class UserDetails {
  public String username;
  public String password;

public UserDetails() {
System.out.println("UserDetails::0-param constructor");
}  
  public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
  
}
