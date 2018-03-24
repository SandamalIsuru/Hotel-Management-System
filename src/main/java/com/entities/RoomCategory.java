package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room_category")
public class RoomCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="room_category_id")
	private int roomCategoryID;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="bed_type")
	private String bedType;
	
	@Column(name="no_of_bed")
	private int nomberOfBed;

	@Column(name="description")
	private String bedCategoryDescription;

	public int getRoomCategoryID() {
		return roomCategoryID;
	}

	public void setRoomCategoryID(int roomCategoryID) {
		this.roomCategoryID = roomCategoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public int getNomberOfBed() {
		return nomberOfBed;
	}

	public void setNomberOfBed(int nomberOfBed) {
		this.nomberOfBed = nomberOfBed;
	}

	public String getBedCategoryDescription() {
		return bedCategoryDescription;
	}

	public void setBedCategoryDescription(String bedCategoryDescription) {
		this.bedCategoryDescription = bedCategoryDescription;
	}
	
	
}
