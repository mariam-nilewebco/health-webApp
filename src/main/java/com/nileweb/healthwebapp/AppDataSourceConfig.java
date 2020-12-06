package com.nileweb.healthwebapp;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 

import com.nileweb.healthwebapp.symptoms.Lookup; 
 

//@Configuration 
public class AppDataSourceConfig {
 
	 
	@Bean
	public Lookup lookup() {
		Lookup lookup=new Lookup(); 
		 lookup.setId(null);
		 lookup.setName(null);
//		 if(lookup.getSymptoms().isEmpty())
//			 lookup.setSymptoms(symtpomsService.getSLookup());
		 
		return lookup;
	 }
	
	
}
