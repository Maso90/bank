package com.hms.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hms.model.Devices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDevicesService {
	
	@Autowired
	private DevicesService devicesService;
	
	@Test
	public void testFindAll() {
		List<Devices> list = devicesService.findAll();
		assertEquals(5, list.size());
	}
}
