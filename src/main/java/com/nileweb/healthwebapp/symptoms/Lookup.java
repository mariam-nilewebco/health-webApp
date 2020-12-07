package com.nileweb.healthwebapp.symptoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Lookup {
	private Long id;
	private String name;
	private List<Symptoms> symptoms=new ArrayList<Symptoms>();
	  
	public Lookup() {
		 
	}
	 public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	public List<Symptoms> getSymptoms() { 
	 
		return symptoms;
	}
	public void setSymptoms(List<Symptoms> symptoms ) { 
		 
		 this.symptoms=symptoms;
	}
	@Override
	public String toString() {
		return "Lookup [id=" + id + ", name=" + name + "]";
	}
	
	
}
