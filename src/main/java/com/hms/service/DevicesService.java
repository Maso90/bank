package com.hms.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hms.model.Devices;
import com.hms.repository.DevicesRepository;

@Service
public class DevicesService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DevicesService.class);
	
	@Resource
    private DevicesRepository devicesRepository;
	
	public List<Devices> findAll() {
		LOGGER.info("2. 인터넷뱅킹 서비스 접속 기기 목록을 출력하는 API 를 개발하세요.");
	    return devicesRepository.findAll();
	}
}
