package com.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hms.model.Result;
import com.hms.model.Usage;

public interface UsageRepository extends JpaRepository<Usage, String>{
	
	@Query(
			"SELECT new com.hms.model.Result(d.device_name, u.device_id, u.year, u.rate) "
		   + "FROM Usage u "
      + "LEFT JOIN Devices d ON d.device_id=u.device_id "
          + "WHERE (u.year, u.rate) IN (SELECT year, MAX(rate) FROM Usage GROUP BY year) "
          + "ORDER BY u.year"
    )
	List<Result> findTheBestDeviceOfYearList();

	@Query(
			"SELECT new com.hms.model.Result(d.device_name, u.device_id, u.year, u.rate) "
			+ "FROM Usage u "
	   + "LEFT JOIN Devices d ON d.device_id=u.device_id "
	       + "WHERE u.year=:year "
	       + "ORDER BY u.rate DESC"
	)
	List<Result> findTheBestDeviceOfYear(@Param("year") int year);

	@Query(
			"SELECT new com.hms.model.Result(d.device_name, u.device_id, u.year, u.rate) "
			+ "FROM Usage u "
	   + "LEFT JOIN Devices d ON d.device_id=u.device_id "
	       + "WHERE u.device_id=:device_id "
	       + "ORDER BY u.rate DESC"
	)
	List<Result> findTheBestYearOfDevice(@Param("device_id") String device_id);
}
