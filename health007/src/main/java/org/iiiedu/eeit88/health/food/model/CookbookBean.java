package org.iiiedu.eeit88.health.food.model;

import java.io.Serializable;

public class CookbookBean implements Serializable {
	private Integer id;
	private String name;
	private String cooking;
	private String cookbookType;
	private byte[] pic;
	private Float calories;
	private String suit;
	private Boolean cookbookStatus;
	
	@Override
	public String toString() {
		return "CookbookBean [id=" + id + ", name=" + name + ", cooking=" + cooking + ", cookbookType=" + cookbookType
				+ ", calories=" + calories + ", suit=" + suit + ", cookbookStatus=" + cookbookStatus + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCooking() {
		return cooking;
	}

	public void setCooking(String cooking) {
		this.cooking = cooking;
	}

	public String getCookbookType() {
		return cookbookType;
	}

	public void setCookbookType(String cookbookType) {
		this.cookbookType = cookbookType;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public Float getCalories() {
		return calories;
	}

	public void setCalories(Float calories) {
		this.calories = calories;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public Boolean getCookbookStatus() {
		return cookbookStatus;
	}

	public void setCookbookStatus(Boolean cookbookStatus) {
		this.cookbookStatus = cookbookStatus;
	}
		
}//end of class
