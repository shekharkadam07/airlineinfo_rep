package com.betsole.air.airlineinfo;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.betsole.air.info.model.AirLine;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class AirlineinfoApplicationTests {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/";

		
	/* GET */
    @SuppressWarnings("unchecked")
    private static void listAllAirLines(){
        System.out.println("Testing listAllAirlines API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> airLineMap = restTemplate.getForObject(REST_SERVICE_URI+"info/airlines/", List.class);
         
        if(airLineMap!=null){
            for(LinkedHashMap<String, Object> map : airLineMap){
                System.out.println("Airline : id="+map.get("alId")+", Name="+map.get("alName")+", Info="+map.get("alInfo"));
            }
        }else{
            System.out.println("No AirLine exist----------");
        }
    }
     
    /* GET */
    private static void getAirLine(long id){
        System.out.println("Testing get specific AirLine by id ----------"+id);
        RestTemplate restTemplate = new RestTemplate();
        AirLine al = restTemplate.getForObject(REST_SERVICE_URI+"info/airlines/"+id, AirLine.class);
        System.out.println(al);
    }
    
    /* POST */
    private static void createAirLine(AirLine ar) {
        System.out.println("Testing create Airline API----------");
        RestTemplate restTemplate = new RestTemplate();
        
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"info/airlines/new", ar, AirLine.class);
        System.out.println("Location : "+uri.toASCIIString()+" new AirLine Created.");
    
    }
    
    public static void main(String[] args) {
    	AirLine ar1 = new AirLine();
        ar1.setAlId(111);
        ar1.setAlName("TEST-111");
        ar1.setAlInfo("This is created from test cases");
        
        AirLine ar2 = new AirLine();
        ar2.setAlId(777);
        ar2.setAlName("TEST-777");
        ar2.setAlInfo("This is created from test cases");
        
    	createAirLine(ar1);
    	createAirLine(ar2);
    	listAllAirLines();
    	getAirLine(111);
	}

}
