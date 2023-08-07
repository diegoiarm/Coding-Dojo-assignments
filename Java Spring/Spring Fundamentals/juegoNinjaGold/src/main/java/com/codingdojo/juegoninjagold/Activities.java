package com.codingdojo.juegoninjagold;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Activities {
	private String place;
	private int gold;
	private String time;
	
	public Activities(String place, int gold, String time) {
		this.place = place;
		this.gold = gold;
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getFormattedTime() {
		DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("MMMM, d yyyy h:mm a");
		LocalDateTime dateTime = LocalDateTime.now();
		return dateTime.format(formattedTime);
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}

