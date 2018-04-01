package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entities.RoomCategory;
import com.entities.RoomDetail;
import com.entities.RoomType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.services.RoomCategoryService;
import com.services.RoomDetailService;
import com.services.RoomTypeService;

@Controller
@RequestMapping(value = "rooms")
public class RoomDetailController {

	@Autowired
	RoomDetailService roomDetailService;
	@Autowired
	RoomTypeService roomTypeService;
	@Autowired
	RoomCategoryService roomCategoryService;
	
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
			@RequestParam(value = "isHousekeeping", required = false) String isHousekeeping,
			@RequestParam(value = "hiddenRoomTypeDropDown", required = true) String roomTypeDropDown,
			@RequestParam(value = "hiddenRoomCategoryDropDown", required = true) String roomCategoryDropDown) {

		ModelAndView modelAndView = new ModelAndView("redirect:roomDetail.htm");
		Map<String, Object> map = new HashMap<String, Object>();
		roomDetail.setAvailable(isAilability != null ? true : false);
		roomDetail.setRepairing(isRepairing != null ? true : false);
		roomDetail.setHousekeeping(isHousekeeping != null ? true : false);
		System.out.println("=========="+roomTypeDropDown);
		Gson g = new Gson();
		RoomType roomType= g.fromJson(roomTypeDropDown, RoomType.class);
		RoomCategory roomCategory = g.fromJson(roomCategoryDropDown, RoomCategory.class);
		roomDetail.setRoomType(roomType); 
		roomDetail.setRoomCategory(roomCategory);
		System.out.println("////////////" + roomDetail.getRoomType().getRoomTypeID());
		System.out.println("////////////" + roomDetail.getRoomCategory().getCategoryName());
		boolean isRoomDetailsAdded = roomDetailService.addRoomDetail(roomDetail);
		return modelAndView;
	}
	
	@ModelAttribute("getPage")
	public void getAllRoomTypes(ModelMap model) {
		List<RoomType> roomTypeList = roomTypeService.getAllRoomTypes();
		for(RoomType RoomType:roomTypeList){
			System.out.println("-------------" + RoomType.getRoomDescription());
		}
		/*Gson objGson = new GsonBuilder().setPrettyPrinting().create();
		String roomTypeLisJjson = objGson.toJson(roomTypeList);
		System.out.println("-------------" + roomTypeLisJjson);*/
		String roomTypeToString = new Gson().toJson(roomTypeList);
		model.addAttribute("allRoomTypes", roomTypeToString);
	}
	
	@ModelAttribute("getPage")
	public void getAllRoomCategories(ModelMap model) {
		List<RoomCategory> roomCategoryList = roomCategoryService.getAllRoomCategories();
		for(RoomCategory roomCategory:roomCategoryList){
			System.out.println("-------------" + roomCategory.getCategoryName());
		}
		String roomTypeToString = new Gson().toJson(roomCategoryList);
		model.addAttribute("allRoomCategories", roomTypeToString);
	}
}
