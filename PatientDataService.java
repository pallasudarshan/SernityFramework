package bdd.framework.service;

import com.ge.hc.kyma.bdd.model.registry.AssociationData;
import com.ge.hc.kyma.bdd.model.registry.PatientData;
import com.ge.hc.kyma.bdd.model.registry.RegistryData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PatientDataService {

	private RestTemplate restTemplate;
	private final String API_PATH = "bdd/patient";
	private String resourcePath;
	private String baseURL = System.getProperty("base.path");

	PatientDataService() {
		restTemplate = new RestTemplate(DataService.getClientHttpRequestFactory());
		resourcePath = this.baseURL + API_PATH;
	}
	
	@SuppressWarnings("unchecked")
	List<PatientData> create(List<PatientData> uuidList){
		UriComponents uriComponents;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		uriComponents = uriComponentsBuilder.path("/admit").build();
		return restTemplate.postForObject(uriComponents.toUri(), uuidList, List.class);

	}

	@SuppressWarnings("unchecked")
	List<String> create(int noOfPatient){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity("parameters", headers);
		UriComponents uriComponents;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(baseURL);
		uriComponents = uriComponentsBuilder.path("/device/start/"+noOfPatient).build();
		ResponseEntity<List<String>> response = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<String>>(){});
		return response.getBody();
	}
	
	@SuppressWarnings("unchecked")
	List<AssociationData> createRegistry(List<RegistryData> registryDataList) {
		UriComponents uriComponents;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		uriComponents = uriComponentsBuilder.path("/registry/create").build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(registryDataList,headers);
		return restTemplate.postForObject(uriComponents.toUri(), registryDataList, List.class);
	}

	List<PatientData> get(String uuid) {
		List<PatientData> patientDataList = new ArrayList<>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity("parameters", headers);
		UriComponents uriComponents = null;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		if (uuid != null) {
			uriComponentsBuilder.path("/get");
			uriComponents = uriComponentsBuilder.path(uuid).build();
			ResponseEntity<PatientData> response = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, entity, new ParameterizedTypeReference<PatientData>(){});
			PatientData patientData = response.getBody();
			patientDataList.add(patientData);
			
		} else {
			uriComponents = uriComponentsBuilder.path("/getAll").build();
			ResponseEntity<List<PatientData>> response = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<PatientData>>(){});
			patientDataList = response.getBody();
		}
		return patientDataList;
	}

	List<String> delete(List<String> uuidList) {
		UriComponents uriComponents = null;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		uriComponentsBuilder.path("/discharge");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		for(String uuid : uuidList){
			uriComponentsBuilder.queryParam("patient_uuid", uuid);
		}
		HttpEntity entity = new HttpEntity(uuidList, headers);
		uriComponents = uriComponentsBuilder.build();
		ResponseEntity<List<String>> response = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.DELETE, entity,
				new ParameterizedTypeReference<List<String>>() {
				});
		List<String> patientIdList = response.getBody();
		return patientIdList;
	}
	
	List<String> deleteAllPatients() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(baseURL);
		UriComponents uriComponents = uriComponentsBuilder.path("/device/stop").build();
		ResponseEntity<String> response = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, entity,
				new ParameterizedTypeReference<String>() {
				});
		return Collections.singletonList(response.getBody());
	}

	boolean update(String uuid, PatientData patient) {
		UriComponents uriComponents;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		uriComponents= uriComponentsBuilder.path("/update/"+uuid).build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(patient,headers);
		try {
			restTemplate.put(uriComponents.toUri(), entity);
			return true;
		} catch (RestClientException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	boolean transferPatientLocation(String patientId, String locationId) {
		UriComponents uriComponents = null;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
				.fromHttpUrl(resourcePath);
		uriComponentsBuilder.path("/transfer");
		uriComponents = uriComponentsBuilder.queryParam("patientId", patientId).queryParam("locationId", locationId).build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(headers);
		try {
			restTemplate.postForObject(uriComponents.toUri(), entity, String.class);
			return true;
		} catch (RestClientException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean publishAssociation(String patientId) {
		UriComponents uriComponents = null;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		uriComponentsBuilder.path("/device/publish/");
		uriComponentsBuilder.path(patientId);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(headers);
		uriComponents = uriComponentsBuilder.build();
		try {
			restTemplate.put(uriComponents.toUri(), entity);
			return true;
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean createFSWConfigs(String patientUuid){
		UriComponents uriComponents;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		uriComponents = uriComponentsBuilder.path("/admitFSW/"+patientUuid).build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(headers);
		try {
			restTemplate.postForObject(uriComponents.toUri(), entity,String.class);
			return true;
		} catch (RestClientException e) {
			e.printStackTrace();
			return false;
		}

	}
}
