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

import com.entities.RoomCategory;
import com.services.RoomCategoryService;

@Controller
@RequestMapping(value="rooms")
public class RoomCategoryController {

	@Autowired
	RoomCategoryService roomCategoryService;
	
	@RequestMapping(value="/roomCategory.htm", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView model = new ModelAndView("common/roomCategory");
		RoomCategory roomCategory = new RoomCategory();
		model.addObject("roomCategoryForm", roomCategory);
		model.addObject("msg", "Hello Isuru Sandamal");
		return model;
	}
	
	@RequestMapping(value="/addRoomCategory", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateUser(@ModelAttribute("roomCategoryForm") @Validated RoomCategory roomCategory,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:roomCategory.htm");
		Map<String,Object> map = new HashMap<String,Object>();
		boolean loginStatus = roomCategoryService.addRoomCategory(roomCategory);
		return modelAndView;
	}
}
