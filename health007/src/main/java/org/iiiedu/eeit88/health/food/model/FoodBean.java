package org.iiiedu.eeit88.health.food.model;

import java.io.Serializable;

public class FoodBean implements Serializable {
	private Integer id;
	private String name;
	private String foodType;
	private byte[] pic;
	private Float calories;
	private Boolean foodStatus;
	
	@Override
	public String toString() {
		return "FoodBean [id=" + id + ", name=" + name + ", foodType=" + foodType + ", calories=" + calories
				+ ", foodStatus=" + foodStatus + "]";
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

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
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

	public Boolean getFoodStatus() {
		return foodStatus;
	}

	public void setFoodStatus(Boolean foodStatus) {
		this.foodStatus = foodStatus;
	}
	
	
	
}
