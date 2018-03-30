package com.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="room_detail")
public class RoomDetail {
	
	@TableGenerator(name = "room_detail_id_gen", table = "id_generator", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "room_detail_id_gen")
	@Column(name="room_no")
	private int roomNo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="room_type_id")
	private RoomType roomType;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="room_category_id")
	private RoomCategory roomCategory;
	
	@Column(name="room_floor")
	private String roomFloor;
	
	@Column(name="is_available")
	private boolean isAvailable;
	
	@Column(name="is_repairing")
	private boolean isRepairing;
	
	@Column(name="is_housekeeping")
	private boolean isHousekeeping;
	
	@Column(name="per_day_charge")
	private float perDayCharge;

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public RoomCategory getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(RoomCategory roomCategory) {
		this.roomCategory = roomCategory;
	}

	public String getRoomFloor() {
		return roomFloor;
	}

	public void setRoomFloor(String roomFloor) {
		this.roomFloor = roomFloor;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isRepairing() {
		return isRepairing;
	}

	public void setRepairing(boolean isRepairing) {
		this.isRepairing = isRepairing;
	}

	public boolean isHousekeeping() {
		return isHousekeeping;
	}

	public void setHousekeeping(boolean isHousekeeping) {
		this.isHousekeeping = isHousekeeping;
	}

	public float getPerDayCharge() {
		return perDayCharge;
	}

	public void setPerDayCharge(float perDayCharge) {
		this.perDayCharge = perDayCharge;
	}

}
