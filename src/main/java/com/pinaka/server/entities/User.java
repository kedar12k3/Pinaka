package com.pinaka.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int userid;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private boolean isactive;
	
	//@OneToMany
	//private Role role;
	
	public User() {
		
	}
	public User(int userId, String username, String password, String email, boolean isactive, Role role) {
		this.userid = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isactive = isactive;
		//this.role = role;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	/*public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}*/
}
