package bdd.framework.service;

import com.ge.hc.kyma.bdd.model.registry.AssociationData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class AssociationDataService {

	private RestTemplate restTemplate;
	private final String API_PATH = "bdd/assoc";
	private String resourcePath ;
	private String baseURL = System.getProperty("base.path");

	AssociationDataService() {
		restTemplate = new RestTemplate(DataService.getClientHttpRequestFactory());
		resourcePath = baseURL+API_PATH;
	}

	private SimpleClientHttpRequestFactory getClientHttpRequestFactory()
	{
		SimpleClientHttpRequestFactory clientHttpRequestFactory
				= new SimpleClientHttpRequestFactory();
		//Connect timeout
		clientHttpRequestFactory.setConnectTimeout(10_000);

		//Read timeout
		clientHttpRequestFactory.setReadTimeout(10_000);
		return clientHttpRequestFactory;
	}

	List<AssociationData> get(String uuid, String type){
		UriComponents uriComponents = null;
		if(uuid!=null){
			UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
			if(type.equals("PATIENT")){
				uriComponentsBuilder.path("/getByPatientId/"+uuid);
				uriComponents = uriComponentsBuilder.build();
			}else if(type.equals("ASSOC")){
				uriComponentsBuilder.path("/getByAssocId/");
				uriComponents = uriComponentsBuilder.queryParam("association_uuid", uuid).build();
			}
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity requestEntity = new HttpEntity("{}",headers);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e){
				System.out.println(e.getMessage());
			}

			ResponseEntity<AssociationData> response = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, requestEntity, new ParameterizedTypeReference<AssociationData>(){});
			AssociationData assocData = response.getBody();
			List<AssociationData> assocDataList = new ArrayList<>(); 
			assocDataList.add(assocData);
			return assocDataList;
		}
		return null;
	}


	Boolean updateAssociationStatus(String uuid, String type) {
		UriComponents uriComponents = null;
		if (uuid != null) {
			UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
			uriComponentsBuilder.path("/updateStatus/" + uuid);
			if (type.equalsIgnoreCase("DISCHARGED")) {
				uriComponents = uriComponentsBuilder.queryParam("status", false).build();
			} else if (type.equalsIgnoreCase("ADMITTED")) {
				uriComponents = uriComponentsBuilder.queryParam("status", true).build();
			}
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity requestEntity = new HttpEntity("{}", headers);

			ResponseEntity<Boolean> response = restTemplate.exchange(uriComponents.toUri(), HttpMethod.PUT, requestEntity, Boolean.class);

			return response.getBody();
		}
		return false;
	}
}
