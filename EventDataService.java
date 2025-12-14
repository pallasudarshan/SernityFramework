package bdd.framework.service;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.ge.hc.kyma.bdd.model.streaming.EventData;

public class EventDataService {

	private RestTemplate restTemplate;
	private final String API_PATH = "bdd/events";
	private String resourcePath;
	private String baseURL = System.getProperty("base.path");

	EventDataService() {
		restTemplate = new RestTemplate(DataService.getClientHttpRequestFactory());
		resourcePath = this.baseURL + API_PATH;
    }

    EventDataService(String baseUrl) {
        restTemplate = new RestTemplate(DataService.getClientHttpRequestFactory());
        resourcePath = baseUrl + API_PATH;
    }

    boolean create(String uuid, List<EventData> eventList) {
        UriComponents uriComponents;
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
        uriComponents = uriComponentsBuilder.path("/create/" + uuid).build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(eventList,headers);
        try {
            restTemplate.postForLocation((uriComponents.toUri()), entity);
            return true;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;

        }
    }

}
