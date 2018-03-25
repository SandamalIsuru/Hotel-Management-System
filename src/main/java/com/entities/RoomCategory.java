package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="room_category")
public class RoomCategory {

	@TableGenerator(name = "room_category_id_gen", table = "id_generator", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "room_category_id_gen")
	@Column(name="room_category_id")
	private int roomCategoryID;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="bed_type")
	private String bedType;
	
	@Column(name="no_of_bed")
	private String numberOfBed;

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

	public String getNumberOfBed() {
		return numberOfBed;
	}

	public void setNumberOfBed(String numberOfBed) {
		this.numberOfBed = numberOfBed;
	}

	public String getBedCategoryDescription() {
		return bedCategoryDescription;
	}

	public void setBedCategoryDescription(String bedCategoryDescription) {
		this.bedCategoryDescription = bedCategoryDescription;
	}
}
