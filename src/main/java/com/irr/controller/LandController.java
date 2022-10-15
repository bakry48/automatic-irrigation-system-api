package com.irr.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irr.dto.ConfigureLandDTO;
import com.irr.dto.LandDTO;
import com.irr.model.Land;
import com.irr.services.LandServices;

@RestController
@RequestMapping("/api/v1/land")
public class LandController {

	@Autowired
	private LandServices landService;
	private ModelMapper modelMapper = new ModelMapper();

	@PostMapping("")
	public Long add(@RequestBody LandDTO landDto) {
		Long newLandId = landService.addLand(landDto);
		return newLandId;
	}

	@PutMapping("{landId}")
	public Long edit(@RequestBody LandDTO landDto, @PathVariable Long landId) {
		Land drone = landService.editLand(landDto, landId);
		return drone.getId();

	}

	@GetMapping("")
	public List<LandDTO> getAllLands() {
		List<Land> lands = landService.getAllLands();
		List<LandDTO> landDtos = new ArrayList<>();
		Type t = new TypeToken<List<LandDTO>>() {}.getType();
		landDtos = (List<LandDTO>) modelMapper.map(lands, t);
		return landDtos;

	}

	@PostMapping("{landId}/configure")
	public String configure(@RequestBody ConfigureLandDTO configureLandDTO, @PathVariable Long landId) {
		Land land = landService.configureLand(configureLandDTO, landId);
		modelMapper.map(land, LandDTO.class);
		return "Successfully Configured";
	}
	/*
	 * @PostMapping("{landId}/configure") public ResponseEntity<LandDTO>
	 * configure(@RequestBody ConfigureLandDTO model,@PathVariable Long landId){
	 * Land land = landService.configureLand(model,landId); LandDTO landDTO =
	 * modelMapper.map(land, LandDTO.class); return new
	 * ResponseEntity<>(landDTO,HttpStatus.OK); }
	 * 
	 */
	
}
