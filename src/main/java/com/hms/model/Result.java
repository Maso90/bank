package com.hms.model;

import lombok.Value;

@Value
public class Result {
	private final String device_name;
	private final String device_id;
	private final int year;
	private final double rate;
	
	public Result(String device_name, String device_id, int year, double rate) {
		this.device_name = device_name;
		this.device_id = device_id;
		this.year = year;
		this.rate = rate;
	}
	
	public String getDevice_name() {
		return device_name;
	}

	public String getDevice_id() {
		return device_id;
	}

	public int getYear() {
		return year;
	}

	public double getRate() {
		return rate;
	}
	
}
