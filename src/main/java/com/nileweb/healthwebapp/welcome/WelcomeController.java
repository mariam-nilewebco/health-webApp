package com.nileweb.healthwebapp.welcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nileweb.healthwebapp.diseases.Diseases;
import com.nileweb.healthwebapp.diseases.DiseasesService;

@Controller
public class WelcomeController {
	@Autowired
	DiseasesService diseasesService;
	@GetMapping
	public ModelAndView welcome() {
		// ---
		System.out.println("AppRun");
		ModelAndView mav = new ModelAndView("diseases/diseasesList");
		 mav.addObject("diseases", diseasesService.findAll());
		mav.addObject("readOnly", false);
		return mav;
	}
}