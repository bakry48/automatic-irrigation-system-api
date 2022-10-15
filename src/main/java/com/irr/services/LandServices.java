package com.irr.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irr.dto.ConfigureLandDTO;
import com.irr.dto.LandDTO;
import com.irr.exception.BadRequestException;
import com.irr.model.Land;
import com.irr.repositories.LandRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LandServices {
	@Autowired
	private LandRepo landrepo;

	@Autowired
	private LandConfigurationService iotDeviceService;
	private final ModelMapper modelMapper = new ModelMapper();

	public Long addLand(LandDTO model) {

		Land entity = modelMapper.map(model, Land.class);
		entity.setCreatedOn(new Date());
		landrepo.save(entity);
		landrepo.flush();
		return entity.getId();
	}

	public Land editLand(LandDTO model, Long id) {
		Optional<Land> land = landrepo.findById(id);

		if (!land.isPresent()) {
			throw new BadRequestException("Land not found");
		}
		Land entity = land.get();
		entity.setCode(model.getCode());
		entity.setAgricType(model.getAgricType());
		entity.setArea(model.getArea());
		entity.setLandType(model.getLandType());

		entity.setModifiedOn(new Date());
		landrepo.save(entity);
		landrepo.flush();
		return entity;
	}

	public List<Land> getAllLands() {
		return landrepo.findAll();
	}



	public Land configureLand(ConfigureLandDTO model, Long id) {
		Optional<Land> land = landrepo.findById(id);

		if (land.isEmpty()) {
			throw new BadRequestException("Land not found");
		}

		iotDeviceService.configureLand(model, land.get());
		return land.get();
	}
}
