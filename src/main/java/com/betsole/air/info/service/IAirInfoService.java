package com.betsole.air.info.service;

import java.util.Set;

import com.betsole.air.info.model.AirLine;

public interface IAirInfoService {
	
	public Set<AirLine> getAllAirLines();
	
	public AirLine getAirLine(long alId);
	
	public void addNewAirLine(AirLine newAl); 
}
