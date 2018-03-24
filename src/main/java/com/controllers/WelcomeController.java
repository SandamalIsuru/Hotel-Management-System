package com.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entities.RoomDetail;
import com.entities.RoomReservation;
import com.google.gson.Gson;
import com.services.ReservationDetailService;
import com.services.RoomService;

@Controller
@RequestMapping(value="welcome")
public class WelcomeController {

	@Autowired
	RoomService roomService;
	@Autowired
	ReservationDetailService reservationDetailService;
	
	@RequestMapping(value="/welcomePage.htm", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView model = new ModelAndView("common/welcomePage");
		return model;
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
		System.out.println(checkin);
		List<RoomReservation> allReservations = reservationDetailService.getAllRoomReservation(checkin);
		List<RoomDetail> allRooms = roomService.getAllRooms();
		String allReservationsToString = new Gson().toJson(allReservations);
		String allRoomDetailToString = new Gson().toJson(allRooms);
		model.addAttribute("allReservations", allReservationsToString);
		model.addAttribute("allRooms", allRoomDetailToString);
	}
}
