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
	
	@Column(name="is_reparing")
	private boolean isReparing;
	
	@Column(name="is_housekeeping")
	private boolean isHousekeeping;
	
	@Column(name="per_day_charge")
	private float per_day_charge;

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public RoomType getRoomTypeID() {
		return roomType;
	}

	public void setRoomTypeID(RoomType roomTypeID) {
		this.roomType = roomTypeID;
	}

	public RoomCategory getRoomCategoryID() {
		return roomCategory;
	}

	public void setRoomCategoryID(RoomCategory roomCategoryID) {
		this.roomCategory = roomCategoryID;
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

	public boolean isReparing() {
		return isReparing;
	}

	public void setReparing(boolean isReparing) {
		this.isReparing = isReparing;
	}

	public boolean isHousekeeping() {
		return isHousekeeping;
	}

	public void setHousekeeping(boolean isHousekeeping) {
		this.isHousekeeping = isHousekeeping;
	}

	public float getPer_day_charge() {
		return per_day_charge;
	}

	public void setPer_day_charge(float per_day_charge) {
		this.per_day_charge = per_day_charge;
	}

}
