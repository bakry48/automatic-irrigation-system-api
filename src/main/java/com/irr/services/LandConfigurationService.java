package com.irr.services;

import java.util.Date;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.irr.dto.ConfigureLandDTO;
import com.irr.model.Land;
import com.irr.model.LandConfiguration;
import com.irr.repositories.LandConfigRepo;

@Service
public class LandConfigurationService {

	@Autowired
	LandConfigRepo landconfig;
	private final ModelMapper modelMapper = new ModelMapper();

	public LandConfiguration configureLand(ConfigureLandDTO configureLandDTO, Land land) {

		LandConfiguration device = modelMapper.map(configureLandDTO, LandConfiguration.class);

		device.setLand(land);
		device.setStartDate(configureLandDTO.getStartDate());
		device.setCreatedOn(new Date());

		landconfig.save(device);
		landconfig.flush();
		return device;
	}

}
