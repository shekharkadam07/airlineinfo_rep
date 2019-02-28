package com.betsole.air.info.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betsole.air.info.model.AirLine;
import com.betsole.air.info.repository.IAirLineInfoRepo;

@Service
public class AirInfoService implements IAirInfoService {
	
	@Autowired
	IAirLineInfoRepo airLineInfoRepo;

	@Override
	public Set<AirLine> getAllAirLines() {
		return airLineInfoRepo.getAllAirLines();
	}

	@Override
	public AirLine getAirLine(long alId) {
		return airLineInfoRepo.getAirLine(alId);
	}

	@Override
	public void addNewAirLine(AirLine newAl) {
		airLineInfoRepo.addNewAirLine(newAl);
	}

}
