package com.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="register")
public class UserRegisterController {
	
	@RequestMapping(value="/register.htm", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView model = new ModelAndView("common/register");
		model.addObject("msg", "Hello Isuru Sandamal");
		return model;
	}
	
}
