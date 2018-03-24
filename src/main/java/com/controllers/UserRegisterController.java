package com.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entities.UserRegister;
import com.services.CommonService;

@Controller
@RequestMapping(value="register")
public class UserRegisterController {
	
	@Autowired
	CommonService commonService;
	
	@RequestMapping(value="/register.htm", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView model = new ModelAndView("common/register");
		UserRegister userRegister = new UserRegister();
		model.addObject("customerRegisterForm", userRegister);
		model.addObject("msg", "Hello Isuru Sandamal");
		return model;
	}
	
	@RequestMapping(value="/registerCustomer", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateUser(@ModelAttribute("customerRegisterForm") @Validated UserRegister userRegister,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:register.htm");
		Map<String,Object> map = new HashMap<String,Object>();
		boolean loginStatus = commonService.addCustomer(userRegister);
		System.out.println("---------------"+ userRegister.getGuest().getFirstName());
		return modelAndView;
	}
}
