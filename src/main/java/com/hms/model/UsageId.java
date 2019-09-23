package com.hms.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class UsageId implements Serializable{
    private String device_id;
	private int year;
}
