package com.betsole.air.info.repository;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.betsole.air.info.model.AirLine;

@Repository
public class AirLineInfoRepo implements IAirLineInfoRepo{
	
	private final Set<AirLine> alSet = new LinkedHashSet<AirLine>();

	@Override
	public Set<AirLine> getAllAirLines() {
		
		/*AirLine temp = new AirLine();
		temp.setAlId(100);
		temp.setAlInfo("this is test flite");
		temp.setAlName("Boing 007");
		alSet.add(temp);*/
		
		return alSet;
	}

	@Override
	public AirLine getAirLine(long alId) {
		for(AirLine temp:alSet){
			if(alId == temp.getAlId())
				return temp;
		}
		return null;
	}

	@Override
	public void addNewAirLine(AirLine newAl) {
		synchronized (AirLineInfoRepo.class) {
			if(newAl != null){
				alSet.add(newAl);
			}
		}
	}

}
