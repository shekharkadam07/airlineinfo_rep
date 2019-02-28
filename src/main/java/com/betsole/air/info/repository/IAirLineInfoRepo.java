package com.betsole.air.info.repository;

import java.util.Set;

import com.betsole.air.info.model.AirLine;

public interface IAirLineInfoRepo {
	
	public Set<AirLine> getAllAirLines();
	
	public AirLine getAirLine(long alId);
	
	public void addNewAirLine(AirLine newAl); 

}
