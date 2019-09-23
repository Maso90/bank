package com.hms.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hms.model.Result;
import com.hms.model.Usage;
import com.hms.repository.UsageRepository;

@Service
public class UsageService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UsageService.class);
	
	@Resource
    private UsageRepository usageRepository;
	
	public List<Result> findTheBestDeviceOfYearList() {
		LOGGER.info("3. 각 년도별로 인터넷뱅킹을 가장 많이 이용하는 접속기기를 출력하는 API 를 개발하세요.");
		return usageRepository.findTheBestDeviceOfYearList();
	}
	
	public Result findTheBestDeviceOfYear(int year) {
		LOGGER.info("4. 특정 년도를 입력받아 그 해에 인터넷뱅킹에 가장 많이 접속하는 기기 이름을 출력하세요.");
		return usageRepository.findTheBestDeviceOfYear(year).get(0);
	}
	
	public Result findTheBestYearOfDevice(String device_id) {
		LOGGER.info("5. 디바이스 아이디를 입력받아 인터넷뱅킹에 접속 비율이 가장 많은 해를 출력하세요.");
		return usageRepository.findTheBestYearOfDevice(device_id).get(0);
	}
}
