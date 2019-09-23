package com.hms.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hms.HmsApplication;
import com.hms.model.Result;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUsageService {
	
	@Autowired
	UsageService usageService;
	
	@Test
	public void testFindTheBestDeviceOfYearList() {
		List<Result> list = usageService.findTheBestDeviceOfYearList();
		Result result = list.get(0);
		assertEquals("데스크탑 컴퓨터",result.getDevice_name());
	}
	
	@Test
	public void testFindTheBestDeviceOfYear() {
		Result result = usageService.findTheBestDeviceOfYear(2011);
		assertEquals("데스크탑 컴퓨터",result.getDevice_name());
	}
	
	@Test
	public void testFindTheBestYearOfDevice() {
		Result result = usageService.findTheBestYearOfDevice("DEVICE2");
		assertEquals(2011,result.getYear());
	}
}
