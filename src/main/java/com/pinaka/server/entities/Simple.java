package com.pinaka.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Simple implements Data{
	@Id
	private int id;
	@Column
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Simple(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Simple() {
		
	}
	@Override
	public String toString() {
		return "Simple [id=" + id + ", name=" + name + "]";
	}
	
}
