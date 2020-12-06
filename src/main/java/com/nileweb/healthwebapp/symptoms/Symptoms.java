package com.nileweb.healthwebapp.symptoms;
 

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.UniqueElements;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nileweb.healthwebapp.diseases.Diseases;

import lombok.Data;

@NodeEntity(label = "Symptoms")
@Data
public class Symptoms {

	@Id
	//@GeneratedValue
	private Long id;
	@Property("name") 
	private String name;
	@Property("description")
	private String description;
	
//	@Relationship(type = "HAS"/*, direction = Direction.INCOMING*/ )
//	@JsonIgnoreProperties({"symptoms"})
//	private List<Diseases> diseases = new ArrayList<>();
//	
//	public void addDisease(Diseases dis) {
//		this.getDiseases().add(dis);
//		
//	}

}

