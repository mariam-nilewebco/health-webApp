package com.nileweb.healthwebapp.diseases;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nileweb.healthwebapp.symptoms.Lookup;
import com.nileweb.healthwebapp.symptoms.Symptoms;
import com.nileweb.healthwebapp.symptoms.SymptomsService;

@Controller
@RequestMapping("/disasesSymptoms")
@SessionAttributes({"lookup","items"})
public class DiseasesSymptomController {
	@Autowired
	DiseasesService disasesService; 
	 
	@Autowired
	SymptomsService symtpomsService;
	
	@ModelAttribute("lookup")
	public Lookup createLookup() {
	Lookup lookup=	new Lookup();
		return lookup ;
	}
	@ModelAttribute("items")
	public List<Symptoms> createItems() {
	 
List<Symptoms> symptoms=symtpomsService.findAll();
		return symptoms ;
	}
	private ModelAndView navResult(String nav,Long id) {
		ModelAndView mav = new ModelAndView("diseases/diseasesSymptom.jsp");

		Map<String,Object> map=disasesService.navigate(nav,id);
		
		Diseases dis=(Diseases)map.get("disease");
		mav.addObject("disease",dis);  
		Boolean previous=new Boolean( map.get("previous").toString());
		Boolean next=new Boolean( map.get("next").toString());
		mav.addObject("previous", previous);
		mav.addObject("next", next);
		 mav.addObject("readOnly",true);
		 return mav;
	}
	
	//----------------------------
	@GetMapping
	public ModelAndView getAll() {
		System.out.println("disasesSymptoms");
			 
			ModelAndView mav= navResult("current",null);
			
			return mav;
		
	}
@PostMapping("/navigate/{id}/{nav}")
	public ModelAndView navigate(@PathVariable(name = "id") Long id,@PathVariable(name = "nav") String nav) {
		
		System.err.println(nav);
		
		try {
			ModelAndView mav= navResult(nav, id);

			return mav;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

	}
@GetMapping("/addSymptom/{id}")
public ModelAndView getDisaese(@PathVariable(name = "id") Long id) {

	ModelAndView mav = new ModelAndView("diseases/diseasesSymptom");
	Diseases dis = disasesService.get(id);

	mav.addObject("disease", dis);
	mav.addObject("readOnly", true);
	return mav;
}
	@PostMapping("/{id}/addSymptom")
	public ModelAndView addSymptom(@PathVariable(name = "id") Long id
			, @ModelAttribute("lookup") Lookup lookup) {
		// ---
		System.out.println("saveSymptom");
		System.err.println( id+","+lookup); 
		ModelAndView mav =  new ModelAndView("diseases/diseasesSymptom.jsp");


		mav.addObject("readOnly",true);
		try {
			Diseases result = disasesService.addSymptoms( id, lookup);
			
			if (result == null) {
				mav.addObject("errorMsg", "id not found");
				
			}else {

				mav.addObject("disease",result);
			}
			return mav;
//			mav.addObject("disease", disasesService.get(id));
			  
//			mav.addObject("lookup",lookup);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mav.addObject("errorMsg", "Call Admin");
			mav.addObject("disease", disasesService.get(id));
			return null;
		}
 
	}



}
