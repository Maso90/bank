package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.model.Devices;
import com.hms.service.DevicesService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/devices")
public class DevicesController {
	@Autowired
	DevicesService devicesService;
	 
	@GetMapping(value = "/list")
	public List<Devices> list() {
	    return devicesService.findAll();
	}
}
