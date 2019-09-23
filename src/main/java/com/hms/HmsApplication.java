package com.hms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hms.model.Devices;
import com.hms.model.Usage;
import com.hms.repository.DevicesRepository;
import com.hms.repository.UsageRepository;

@SpringBootApplication
public class HmsApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(HmsApplication.class);
	private static DevicesRepository deviceRepository;
	private static UsageRepository usageRepository;

	@Autowired 
	public HmsApplication(DevicesRepository deviceRepository, UsageRepository usageRepository) {
		this.deviceRepository = deviceRepository;
		this.usageRepository = usageRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HmsApplication.class, args);		
	}
	
	@Bean
	InitializingBean setUp() {
		return () -> {
			LOGGER.info("1. 데이터 파일(서울시 인터넷뱅킹 이용률 및 이용기기 통계 데이터)에서 각 레코드를 데이터베이스에 저장하는 코드를 구현하세요.");
			String rootPath = System.getProperty("user.dir");;
			String fp = rootPath+"\\src\\main\\resources\\static\\data\\data.csv";
			LOGGER.info("Usage 테이블에 입력할 데이터 파일 경로: "+fp);
			LOGGER.info("Usage 테이블에 데이터 입력 시작");
			try{
			    File file = new File(fp);
			    FileReader file_reader = new FileReader(file);
			    BufferedReader bf = new BufferedReader(file_reader);
			    String line = "";
			    bf.readLine(); // 첫 라인 컬럼 제외
	            while((line = bf.readLine()) != null){
	            	String[] data = line.split(",");
	                
	            	for (int i = 2; i < data.length; i++) {
	                	int year = Integer.parseInt(data[0]);
	                	double rate = data[i].equals("-") ? 0 : Double.parseDouble(data[i]);
	                	String device_id = "DEVICE"+Integer.toString(i-1);
	                	
	                	Usage u = new Usage();
	                	u.setYear(year);
	                	u.setRate(rate);
	                	u.setDevice_id(device_id);
	                	
	                	usageRepository.save(u);
					}
	            }
	            LOGGER.info("Usage 테이블에 데이터 입력 완료");
			    bf.close();
	        }catch (FileNotFoundException e) {
	            e.getStackTrace();
	        }catch(IOException e){
	            e.getStackTrace();
	        }
			
			LOGGER.info("Devices 테이블에 데이터 입력 시작");
			String[] devices_name = {"스마트폰","데스크탑 컴퓨터","노트북 컴퓨터","기타","스마트패드"};
			for (int i = 0; i < devices_name.length; i++) {
				String device_id = "DEVICE"+Integer.toString(i+1);
				String device_name = devices_name[i];

				Devices dev = new Devices();
				dev.setDevice_id(device_id);
				dev.setDevice_name(device_name);
				
				deviceRepository.save(dev);
			}
			LOGGER.info("Devices 테이블에 데이터 입력 완료");
		};
	}

}
