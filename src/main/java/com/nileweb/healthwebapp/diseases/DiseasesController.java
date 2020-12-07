package com.nileweb.healthwebapp.diseases;



import java.util.List;
   
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation. BindingResult; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;

import com.nileweb.healthwebapp.symptoms.Symptoms;

import javax.validation.Valid;

@Controller
@RequestMapping("/Diseases") 
public class DiseasesController { 

	@Autowired
	DiseasesService disasesService; 

	int index=0;

	@GetMapping
	public ModelAndView create() {
		// ---
		System.out.println("create");
		ModelAndView mav = new ModelAndView("diseases/diseasesAdd");
		Diseases dis = new Diseases();

		mav.addObject("disease", dis);
		mav.addObject("readOnly", false);
		return mav;
	}
	
	@GetMapping("/list")
	public ModelAndView findAll() {
		// ---
		System.out.println("create");
		ModelAndView mav = new ModelAndView("diseases/diseasesList");
		 
		mav.addObject("diseases", disasesService.findAll()); 
		return mav;
	}


	@PostMapping("/save")
	public String save(@Valid Diseases disease, BindingResult result,ModelMap m) {
		// ---
		System.out.println("create");
		System.err.println(disease);

		// Diseases disease=new Diseases("Cough","Cough",5L);
		try {
			
			disease = disasesService.save(disease); 
			m.addAttribute("diseases",disasesService.findAll());
			return "diseases/diseasesList";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("errorMsg"," name/id exist , please check the name or ID");
			m.addAttribute("disease",disease);
			return  "diseases/diseasesAdd";
		}
	}
 

	@GetMapping("/{id}")
	public ModelAndView getDisaese(@PathVariable(name = "id") Long id) {

		ModelAndView mav = new ModelAndView("diseases/diseasesAdd");
		Diseases dis = disasesService.get(id);

		mav.addObject("disease", dis);
		mav.addObject("readOnly", true);
		return mav;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView update(@PathVariable(name = "id") Long id) {
		// ---
		
		System.out.println("gotoUpdate "+id);
		 
		 			ModelAndView mav = new ModelAndView("diseases/diseasesAdd");
		 		try {
		 			 

		 			mav.addObject("disease", disasesService.get(id));
		 			mav.addObject("readOnly", false);
		 			mav.addObject("edit", true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 mav.addObject("errorMsg","call Admin");
		}return mav;
	}
	 
	@GetMapping("/delete/{id}")
	public ModelAndView deleteSymptom(@PathVariable(name = "id") Long id) {
		System.out.println("delete "+id);
		 
		
	 	Diseases dis = disasesService.get(id);//diseases
		disasesService.delete(dis);  
		
		return findAll();
	}

}
