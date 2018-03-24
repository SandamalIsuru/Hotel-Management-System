package com.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="booking_detail")
public class RoomReservation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="booking_id")
	private int bookingID;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="guest_id")
	private Guest guest;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="room_no")
	private RoomDetail room;
	
	@Column(name="check_in")
	private String checkin;
	
	@Column(name="check_out")
	private String checkout;

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public RoomDetail getRoom() {
		return room;
	}

	public void setRoom(RoomDetail room) {
		this.room = room;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	
	
}
