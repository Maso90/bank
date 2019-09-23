package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.model.Result;
import com.hms.service.UsageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/usage")
public class UsageController {
	@Autowired
	UsageService usageService; 

	@GetMapping(value = "/year/list")
	public List<Result> findTheBestDeviceOfYearList() {
		return usageService.findTheBestDeviceOfYearList();
	}
	
	@GetMapping(value = "/year/{year}")
	public Result findTheBestDeviceOfYear(@PathVariable(value = "year") int year) {
		return usageService.findTheBestDeviceOfYear(year);
	}
	
	@GetMapping(value = "/device/{device_id}")
	public Result findTheBestYearOfDevice(@PathVariable(value = "device_id") String device_id) {
		return usageService.findTheBestYearOfDevice(device_id);
	}
}
