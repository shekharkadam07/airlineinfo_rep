package com.betsole.air.info.ctrl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.betsole.air.info.exception.UserNotFoundException;
import com.betsole.air.info.model.AirLine;
import com.betsole.air.info.service.IAirInfoService;

@RestController
public class AirLineInfoController {
	
	@Autowired
	IAirInfoService airInfoServ;
	
	@RequestMapping(value = "/info/airlines", method = RequestMethod.GET)
	public ResponseEntity<Set<AirLine>> getAllAirLinesInfo(){
		Set<AirLine> als = airInfoServ.getAllAirLines();
        if(als.isEmpty()){
            return new ResponseEntity<Set<AirLine>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<AirLine>>(als, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/info/airlines/{alId}", method = RequestMethod.GET)
	public AirLine getAirLine(@PathVariable("alId") long alId){
		AirLine al = airInfoServ.getAirLine(alId);
        if(al==null){
        	System.out.println("Airline with alId " + alId + " not found");
        	throw new UserNotFoundException("id="+alId);
        }
       return al;
	}
	
	@RequestMapping(value = "/info/airlines/new", method = RequestMethod.POST)	
	public ResponseEntity<Void> createAirLine(@RequestBody AirLine al,    UriComponentsBuilder ucBuilder) {
		System.out.println("Creating AirLine " + al.getAlName());
		 
		Set<AirLine> als = airInfoServ.getAllAirLines();		 
        if (als.contains(al)) {
            System.out.println("A AirLine with name " + al.getAlName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        airInfoServ.addNewAirLine(al);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/info/airlines/new/{alId}").buildAndExpand(al.getAlName()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/info/airlines/{alId}", method = RequestMethod.DELETE)
	public  ResponseEntity<Void> deleteAirLine(@PathVariable("alId") long alId,  UriComponentsBuilder ucBuilder){
		AirLine al = airInfoServ.getAirLine(alId);
        if(al==null){
        	System.out.println("Airline with alId " + alId + " not found");
        	 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        
        Set<AirLine> it = airInfoServ.getAllAirLines();
        it.remove(al);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/info/airlines/new/{alId}").buildAndExpand(al.getAlName()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

}
