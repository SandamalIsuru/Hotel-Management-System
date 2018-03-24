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

import com.entities.Login;
import com.servicesImpl.LoginServiceImpl;

@Controller
@RequestMapping(value="login")
public class UserLoginController {
	
	@Autowired
	LoginServiceImpl loginService;
	
	@RequestMapping(value="/login.htm", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView model = new ModelAndView("common/login");
		Login newLogin = new Login();
		model.addObject("userForm", newLogin);
		model.addObject("msg", "Hello Isuru Sandamal");
		return model;
	}
	
	@RequestMapping(value="/getLogin", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateUser(@ModelAttribute("userForm") @Validated Login login,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:login.htm");
		Map<String,Object> map = new HashMap<String,Object>();
		boolean loginStatus = loginService.getLoginByLoginDetails(login);
		if(loginStatus){
			map.put("status", loginStatus);
			return new ModelAndView("redirect:/welcome/welcomePage.htm");
		}else{
			map.put("status", false);
			map.put("loggingError", "Username or Password Invalied");
			redirectAttributes.addFlashAttribute("login",login);
			redirectAttributes.addFlashAttribute("loggingError","Username or Password Invalied");
			return modelAndView;
		    
		}
	}
	
}
