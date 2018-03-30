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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entities.RoomDetail;
import com.entities.RoomType;
import com.services.CommonService;
import com.services.RoomDetailService;

@Controller
@RequestMapping(value = "rooms")
public class RoomDetailController {

	@Autowired
	RoomDetailService roomDetailService;
	
	@RequestMapping(value = "/roomDetail.htm", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView model = new ModelAndView("common/roomDetail");
		RoomDetail roomDetail = new RoomDetail();
		model.addObject("roomDetailForm", roomDetail);
		model.addObject("msg", "Hello Isuru Sandamal");
		return model;
	}

	@RequestMapping(value = "/addRoomDetail", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateRoomType(@ModelAttribute("roomDetailForm") @Validated RoomDetail roomDetail,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes,
			@RequestParam(value = "isAilability", required = false) String isAilability,
			@RequestParam(value = "isRepairing", required = false) String isRepairing,
			@RequestParam(value = "isHousekeeping", required = false) String isHousekeeping) {

		ModelAndView modelAndView = new ModelAndView("redirect:roomDetail.htm");
		Map<String, Object> map = new HashMap<String, Object>();
		roomDetail.setAvailable(isAilability != null ? true : false);
		roomDetail.setRepairing(isRepairing != null ? true : false);
		roomDetail.setHousekeeping(isHousekeeping != null ? true : false);
		System.out.println("-------------" + roomDetail.isAvailable());
		System.out.println("-------------" + roomDetail.isRepairing());
		System.out.println("-------------" + roomDetail.isHousekeeping());
		boolean isRoomDetailsAdded = roomDetailService.addRoomDetail(roomDetail);
		return modelAndView;
	}
}
