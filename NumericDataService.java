package bdd.framework.service;

import com.ge.hc.kyma.bdd.model.streaming.NumericData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class NumericDataService {

	private RestTemplate restTemplate;
	private final String API_PATH = "bdd/numerics";
	private String resourcePath;
	private String baseURL = System.getProperty("base.path");

	NumericDataService() {
		restTemplate = new RestTemplate(DataService.getClientHttpRequestFactory());
		resourcePath = this.baseURL + API_PATH;
	}

	NumericDataService(String baseUrl) {
			restTemplate = new RestTemplate(DataService.getClientHttpRequestFactory());
			resourcePath = baseUrl + API_PATH;
	}

	boolean update(String uuid, int sampleInterval, NumericData numericData) throws RestClientException, InterruptedException {
		UriComponents uriComponents;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		uriComponents = uriComponentsBuilder.path("/update/" + uuid).queryParam("sampleInterval", sampleInterval).build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(numericData,headers);
		restTemplate.put(uriComponents.toUri(), entity);
		Thread.sleep(15000);
		return true;
		
	}

	public boolean updateAll(String uuid, int sampleInterval, List<NumericData> numericDatas) throws RestClientException, InterruptedException{
		
		UriComponents uriComponents;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		uriComponents = uriComponentsBuilder.path("/updateAll/" + uuid).queryParam("sampleInterval", sampleInterval).build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(numericDatas,headers);
		restTemplate.postForLocation(uriComponents.toUri(), entity);
		//restTemplate.postForEntity(uriComponents.toUri(), numericDatas, null);
		//restTemplate.postForObject(uriComponents.toUri(), numericDatas, Boolean.class);
		Thread.sleep(15000);
		return true; 
		
	}

	public <T> List<T> delete(List<String> uuidList, String deleteItem) {

		UriComponents uriComponents;
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
		uriComponents = uriComponentsBuilder.path("/remove/" + uuidList.get(0).toString() + "/" + deleteItem).build();
		try {
			restTemplate.delete(uriComponents.toUri());
			return null;
		} catch (RestClientException e) {
			e.printStackTrace();
			return null;
		}
	}
}
