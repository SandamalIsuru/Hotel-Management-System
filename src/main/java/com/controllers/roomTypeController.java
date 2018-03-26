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

import com.entities.RoomType;
import com.services.RoomTypeService;

@Controller
@RequestMapping(value="rooms")
public class roomTypeController {

	@Autowired
	RoomTypeService roomTypeService;
	
	@RequestMapping(value="/roomType.htm", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView model = new ModelAndView("common/roomType");
		RoomType roomType = new RoomType();
		model.addObject("roomTypeForm", roomType);
		model.addObject("msg", "Hello Isuru Sandamal");
		return model;
	}
	
	@RequestMapping(value="/addRoomType", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateRoomType(@ModelAttribute("roomTypeForm") @Validated RoomType roomType,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:roomType.htm");
		Map<String,Object> map = new HashMap<String,Object>();
		boolean isRoomAdded = roomTypeService.addRoomType(roomType);
		return modelAndView;
	}
}