package fr.formation.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/enigme")
public class EnigmeController {
	@RequestMapping(method = RequestMethod.GET)
	public String testEnigme() {
		return "enigme";
	}

@RequestMapping(method=RequestMethod.POST,path="/envoi")
public ModelAndView envoiPost(String reponse) {	
ModelAndView mov=new ModelAndView ("enigme","msg",reponse);
return mov;
}
	}
