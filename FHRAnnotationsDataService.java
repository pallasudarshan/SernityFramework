package bdd.framework.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ge.hc.kyma.FHRAnnotation;
import com.ge.hc.kyma.TrendCollection;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class FHRAnnotationsDataService {

	private RestTemplate restTemplate;
	private String baseURL = System.getProperty("rest.url");
	private final String API_PATH = "bdd/FHRAnnotations";
	private String resourcePath;
//	private static final String TIMEZONE_API_PATH = "patient/update/timezone/%s";
//	private static final String TREND_DATA_API_PATH = "/api/patients/%s/trends?start=%s&end=%s&resource_identifier=eventType;eventState;Location;mdcCodes&resource_items=physiological;start;%s";


	FHRAnnotationsDataService() {
		this.baseURL = baseURL;
		restTemplate = new RestTemplate(DataService.getClientHttpRequestFactory());
		resourcePath = baseURL + API_PATH;
	}

	boolean create(String uuid, FHRAnnotation fhrAnnotationData, String interval, String startTime, String endTime) {
		UriComponents uriComponents;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		uriComponents = uriComponentsBuilder.path("/createFHRAnnotation/" + uuid+"/Source-1").queryParam("interval",interval).queryParam("startTime", startTime).queryParam("endTime", endTime).build();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(fhrAnnotationData,headers);
		try {
			restTemplate.postForEntity(uriComponents.toUri(), entity, List.class);
			return true;
		} catch (RestClientException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(String uuid, List<String> fhrAnnotationData, int sampleInterval) {

		UriComponents uriComponents;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		uriComponents = uriComponentsBuilder.path("/create/" + uuid).queryParam("skipTime", sampleInterval).build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(fhrAnnotationData,headers);
		try {
			restTemplate.put(uriComponents.toUri(), entity);
			return true;
		} catch (RestClientException e) {
			e.printStackTrace();
			return false;
		}
	}

	public TrendCollection getAllFhrAnnotations(String patientId, String startTime, String endTime, String resource_identifier, String resource_items) {
		UriComponents uriComponents;

		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(baseURL);
		uriComponents = uriComponentsBuilder.path("/api/patients/" + patientId + "/trends")
				.queryParam("start", startTime).queryParam("end", endTime).queryParam("resource_identifier", resource_identifier).
						queryParam("resource_items", resource_items).build();
//		ResponseEntity<TrendCollection> response = restTemplate.exchange(uriComponents.toUriString(),
//				HttpMethod.GET, null, new ParameterizedTypeReference<TrendCollection>() {
//				});
		String response = restTemplate.getForObject (uriComponents.toUriString()
				,String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		TrendCollection trendCollection;
		try {
			trendCollection = objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
					.readValue(response, new TypeReference<TrendCollection>() {
					});
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		return trendCollection;
	}

//	public boolean updatePatientTimeZone(String pid, String timeZone) {
//		String timeZoneUpdateURL = String.format(TIMEZONE_API_PATH, pid);
//		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(baseURL + timeZoneUpdateURL);
//		UriComponents uriComponents = uriComponentsBuilder.build();
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.TEXT_PLAIN);
//		HttpEntity entity = new HttpEntity(timeZone,headers);
//		try {
//			restTemplate.put(uriComponents.toUri(), entity);
//			return true;
//		} catch (RestClientException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}

}
