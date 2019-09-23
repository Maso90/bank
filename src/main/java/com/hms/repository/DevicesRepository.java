package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.model.Devices;

public interface DevicesRepository extends JpaRepository<Devices, String>{
	
}