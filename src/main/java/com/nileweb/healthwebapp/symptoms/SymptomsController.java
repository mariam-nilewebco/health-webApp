package com.nileweb.healthwebapp.symptoms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nileweb.healthwebapp.diseases.Diseases;

@Controller
@RequestMapping("/Symptoms") 
public class SymptomsController {
	@Autowired
	SymptomsService symtpomsService;
	
	 
	@GetMapping
	public ModelAndView create() {
		// ---
		System.out.println("create");
		ModelAndView mav = new ModelAndView("symptoms/symptomsAdd");
		Symptoms sym = new Symptoms();

		mav.addObject("symptom", sym);
		mav.addObject("readOnly", false);
		return mav;
	}
	@GetMapping("/list")
	public ModelAndView findAll() {
		// ---
		System.out.println("findAll");
		ModelAndView mav = new ModelAndView("symptoms/symptomsList");
		mav.addObject("symptoms", symtpomsService.findAll()); 
		return mav;
	}
	@PostMapping("/save")
	public String save( Symptoms symptom, BindingResult result,ModelMap m) {
		// ---
		System.out.println("create");
		System.err.println(symptom);

		// Diseases disease=new Diseases("Cough","Cough",5L);
		try {
			symptom = symtpomsService.save(symptom);
			m.addAttribute("symptoms", symtpomsService.findAll()); 
			return "symptoms/symptomsList";//create();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("errorMsg"," name/id exist , please check the name or ID");
			m.addAttribute("symptom",symptom);
			return "symptoms/symptomsAdd";
		}
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView update(@PathVariable(name = "id") Long id) {
		// ---
		
		System.out.println("gotoUpdate "+id);
		 
		 			ModelAndView mav = new ModelAndView("symptoms/symptomsAdd");
		 		try {
		 			 

		 			mav.addObject("symptom", symtpomsService.get(id));
		 			mav.addObject("readOnly", false);
		 			mav.addObject("edit", true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 mav.addObject("errorMsg","call Admin");
		}return mav;
	}
	@GetMapping("/{id}")
	public ModelAndView getSymptom(@PathVariable(name = "id") Long id) {

		ModelAndView mav = new ModelAndView("symptoms/symptomsAdd");
		Symptoms sym = symtpomsService.get(id);

		mav.addObject("symptom", sym);
		mav.addObject("readOnly", false);
		return mav;
	}
	@GetMapping("/delete/{id}")
	public ModelAndView deleteSymptom(@PathVariable(name = "id") Long id) {
		System.out.println("delete "+id);
		 
		
		ModelAndView mav = new ModelAndView("symptoms/symptomsList");
		Symptoms sym = symtpomsService.get(id);
		symtpomsService.delete(sym); 
		mav.addObject("readOnly", false);
		return mav;
	}
}
