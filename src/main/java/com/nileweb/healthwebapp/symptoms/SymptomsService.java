package com.nileweb.healthwebapp.symptoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nileweb.healthwebapp.symptoms.Lookup;
import com.nileweb.healthwebapp.symptoms.Symptoms;
import com.nileweb.healthwebapp.symptoms.SymptomsRepository;

@Service
public class SymptomsService {
	

	@Autowired
	SymptomsRepository symptomsRepository;
	
	public List<Symptoms> findAll(){
		return symptomsRepository.findAll();
	}
	public Map<Long,String> getSLookup(){
		Map<Long,String> map=new HashMap<Long,String>();
		List<Symptoms> list=findAll();
		list.forEach(sym->{
			map.put(sym.getId(), sym.getName());
		});
		return map;
		
	}
public Symptoms save(Symptoms symtpom) {
	return symptomsRepository.save(symtpom);
}
public Symptoms get(Long id) {
	// TODO Auto-generated method stub
	
	Symptoms symptom= symptomsRepository.findById(id).map(sym->{
		return sym;
	}).orElse(null);
	return symptom;
}
public void delete(Symptoms sym) {
	// TODO Auto-generated method stub
	symptomsRepository.delete(sym);
	
}
	
	}
