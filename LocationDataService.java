package bdd.framework.service;

import com.ge.hc.kyma.bdd.model.registry.LocationData;
import com.ge.hc.kyma.bdd.model.registry.RegistryData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class LocationDataService {

	private RestTemplate restTemplate;
	private final String API_PATH = "bdd/location";
	private String resourcePath ;
	private String baseURL = System.getProperty("base.path");

	LocationDataService() {
		restTemplate = new RestTemplate(DataService.getClientHttpRequestFactory());
		resourcePath = baseURL+API_PATH;
	}
	
	List<LocationData> get(String uuid, String type){
		UriComponents uriComponents = null;
		if(uuid!=null){
			UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
			if(type.equals("PATIENT")){
				uriComponents = uriComponentsBuilder.path("/getByPatientId/"+uuid).build();
			}else if(type.equals("LOCATION")){
				uriComponents = uriComponentsBuilder.path("/getByLocationId/"+uuid).build();
			}
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
			ResponseEntity<LocationData> response = restTemplate.exchange(uriComponents.toUri(),
					HttpMethod.GET, entity, new ParameterizedTypeReference<LocationData>(){});
			LocationData locationData = response.getBody();
			List<LocationData> locationDataList =new ArrayList<>();
			locationDataList.add(locationData);
			return locationDataList;
		}
		return null;
	}

	boolean update(String uuid, String type, RegistryData registryData){
		UriComponents uriComponents = null;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
		if(type.equals("PATIENT")){
			uriComponentsBuilder.path("/updateByPatId/"+uuid);
			uriComponents = uriComponentsBuilder.build();
		}else if(type.equals("LOCATION")){
			uriComponentsBuilder.path("/updateByLocId/"+uuid);
			uriComponents = uriComponentsBuilder.build();
		}
		try{
			if(type.equals("PATIENT") && uriComponents!=null){
				restTemplate.put(uriComponents.toUri(), registryData.getPatient());
				return true;
			}else if(type.equals("LOCATION") && uriComponents!=null){
				restTemplate.put(uriComponents.toUri(), registryData.getLocation());
				return true;
			}
			return false;
		}catch (RestClientException e) {
			e.printStackTrace();
			return false;
		}
	}

	boolean switchLocation(String uuid1, String uuid2) {
		UriComponents uriComponents = null;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
				.fromHttpUrl(resourcePath);
		uriComponentsBuilder.path("/swap/" + uuid1 + "/" + uuid2);
		uriComponents = uriComponentsBuilder.build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(headers);
		try {
			restTemplate.put(uriComponents.toUri(), entity);
			return true;
		} catch (RestClientException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	boolean create(List<LocationData> locationData){
		UriComponents uriComponents = null;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
				.fromHttpUrl(resourcePath);
		uriComponentsBuilder.path("/create");
		uriComponents = uriComponentsBuilder.queryParam("locationId", locationData.get(0).getEntityID()).queryParam("room", locationData.get(0).getRoom()).queryParam("bed", locationData.get(0).getBed())
				.queryParam("careArea", locationData.get(0).getCareArea()).queryParam("facility", locationData.get(0).getFacility()).queryParam("group", locationData.get(0).getGroup()).build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(headers);
		try {
			restTemplate.postForObject(uriComponents.encode().toUri(), entity, String.class);
			return true;
		} catch (RestClientException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
