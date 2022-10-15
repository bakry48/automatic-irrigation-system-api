package com.irr.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.irr.model.LandConfiguration;

@Repository
public interface LandConfigRepo extends JpaRepository<LandConfiguration, Long> {
	//List<LandConfiguration> findByNextTimeSlotEquals(Date timeSlot);
	
	@Query("select landConfig from LandConfiguration landConfig where :irrigationDate Between  landConfig.startDate AND landConfig.endDate")
	  public List<LandConfiguration> landToBeIrrigated(@Param("irrigationDate") Date irrigationDate);
	  
}
