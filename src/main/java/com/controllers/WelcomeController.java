package com.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entities.RoomDetail;
import com.entities.RoomReservation;
import com.entities.RoomType;
import com.entities.UserRegister;
import com.google.gson.Gson;
import com.services.ReservationDetailService;
import com.services.RoomDetailService;
import com.services.RoomService;
import com.services.RoomTypeService;

@Controller
@RequestMapping(value="welcome")
public class WelcomeController {

	@Autowired
	RoomTypeService roomTypeService;
	@Autowired
	RoomService roomService;
	@Autowired
	RoomDetailService roomDetailService;
	@Autowired
	ReservationDetailService reservationDetailService;
	
	@RequestMapping(value="/welcomePage.htm", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView model = new ModelAndView("common/welcomePage");
		return model;
	}
	
	@RequestMapping(value="/filterByRoomType", method = RequestMethod.POST)
	public ModelAndView filterRoomsByRoomTypeForm(@ModelAttribute("filterByRoomTypeForm") @Validated RoomDetail roomDetail,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:welcomePage.htm");
		Map<String,Object> map = new HashMap<String,Object>();
		//boolean loginStatus = commonService.addCustomer(userRegister);
		List<RoomDetail> roomDetailsList = roomDetailService.getRoomDetailsByRoomType(1);
		String roomDetailsListToString = new Gson().toJson(roomDetailsList);
		modelAndView.addObject("allRooms", roomDetailsListToString);
		System.out.println("]]]]]]]]]]]]]]]]]]"+roomDetailsListToString);
		return modelAndView;
	}
	
	@ModelAttribute("getPage")
	public void getRoomDetails(ModelMap model) {
		int available = 0;
		int occupied = 0;
		int maintenance = 0;
		int housekeeping = 0;
		List<RoomDetail> roomDetails = roomService.getAllRooms();
		for (RoomDetail roomDetail : roomDetails) {
			if(roomDetail.isAvailable() == true){
				available++;
			}if(roomDetail.isAvailable() == false){
				occupied++;
			}if(roomDetail.isHousekeeping() == true){
				housekeeping++;
			}
		}
		model.addAttribute("allRooms", roomDetails);
		model.addAttribute("availableRooms", available);
		model.addAttribute("occupiedRooms", occupied);
		model.addAttribute("maintenanceRooms", maintenance);
		model.addAttribute("housekeepingRooms", housekeeping);
	}
	
	@ModelAttribute("getPage")
	public void getAllReservationByCurrDate(ModelMap model) {
		Date date = new Date();
		String  checkin = new SimpleDateFormat("yyyy-MM-dd").format(date);
		List<RoomReservation> allReservations = reservationDetailService.getAllRoomReservation(checkin);
		List<RoomDetail> allRooms = roomService.getAllRooms();
		String allReservationsToString = new Gson().toJson(allReservations);
		String allRoomDetailToString = new Gson().toJson(allRooms);
//		System.out.println(";;;;;;;;;;;;;;;;;;"+allRoomDetailToString);
		model.addAttribute("allReservations", allReservationsToString);
		model.addAttribute("allRooms", allRoomDetailToString);
	}
	
	@ModelAttribute("getPage")
	public void getObjects(ModelMap model) {
		List<RoomReservation> allReservationsDetails = reservationDetailService.getAllRoomBookingDetails();
		List<RoomType> allRoomTypes = roomTypeService.getAllRoomTypes();
		String allReservationsDetailsToString = new Gson().toJson(allReservationsDetails);
		String allRoomTypesToString = new Gson().toJson(allRoomTypes);
		System.out.println(";;;;;;;;;;;;;;;;;;"+allRoomTypesToString);
		model.addAttribute("allReservationsDetails", allReservationsDetailsToString);
		model.addAttribute("allRoomTypes", allRoomTypesToString);
	}
}
