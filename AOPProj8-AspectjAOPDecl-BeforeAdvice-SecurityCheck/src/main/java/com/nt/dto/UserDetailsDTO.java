package com.nt.dto;

import java.io.Serializable;

public class UserDetailsDTO implements Serializable {
 public String username;
 public String pwd;
 
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
 
 
}
