package org.iiiedu.eeit88.health.sport.model;

import java.io.Serializable;

public class SportBean implements Serializable {
	private Integer id;
	private String name;
	private byte[] pic;
	private Float calories;
	private String sportType;
	private String content;
	private String suit;
	private Boolean sportStatus;
	
	@Override
	public String toString() {
		return "SportBean [id=" + id + ", name=" + name + ", calories=" + calories + ", sportType=" + sportType
				+ ", content=" + content + ", suit=" + suit + ", sportStatus=" + sportStatus + "]";
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

	public String getSportType() {
		return sportType;
	}

	public void setSportType(String sportType) {
		this.sportType = sportType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public Boolean getSportStatus() {
		return sportStatus;
	}

	public void setSportStatus(Boolean sportStatus) {
		this.sportStatus = sportStatus;
	}
	
	
	
}//end of class
