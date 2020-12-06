package com.nileweb.healthwebapp.diseases;
 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import org.springframework.data.neo4j.core.schema.GeneratedValue;

//import org.springframework.data.neo4j.core.schema.Id;
//import org.springframework.data.neo4j.core.schema.Node;
//import org.springframework.data.neo4j.core.schema.Property;
//import org.springframework.data.neo4j.core.schema.Relationship;
//import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import com.nileweb.healthwebapp.symptoms.Symptoms;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
//import org.neo4j.*;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.neo4j.core.schema.Relationship.Direction; 

@NodeEntity 
@Data
public class Diseases implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue
	private Long id;
	@Property(name = "name")
	private String name;
	@Property(name = "description")
	private String description;

	@Relationship(type  = "HAS" ,  direction = Direction.OUTGOING   )
	 
	@JsonIgnoreProperties({"diseases"})
	private List<Symptoms> symptoms = new ArrayList<>();

	 
	public Diseases(String name,String description,Long id) {

		this.name = name;
		this.description=description;
		this.id=id;
	}
	public Diseases() {

	}
public void addSymptoms(Symptoms symptom) {
	List<Symptoms> symptoms=this.getSymptoms();
	if(symptoms==null)
		symptoms=new ArrayList<Symptoms>();
	symptoms.add(symptom); 
	
}
}
