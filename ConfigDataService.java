package bdd.framework.service;

import com.ge.hc.kyma.bdd.model.streaming.ConfigData;
import com.ge.hc.kyma.bdd.model.streaming.EventData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class ConfigDataService {

    private RestTemplate restTemplate;
    private final String API_PATH = "bdd/config";
    private String resourcePath;
    private String baseURL = System.getProperty("base.path");

    private static String restServerUrl = System.getProperty("bdd.rest.server.url");

    ConfigDataService() {
        restTemplate = new RestTemplate(DataService.getClientHttpRequestFactory());
        resourcePath = this.baseURL + API_PATH;
    }

    boolean update(String uuid, ConfigData configData) {
        UriComponents uriComponents;
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath).path("/update");
        uriComponentsBuilder.queryParam("patientUuid", uuid);
        uriComponents = uriComponentsBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(configData,headers);
        try {
            restTemplate.postForLocation(uriComponents.toUri(), entity);
            return true;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAll(String uuid, List<ConfigData> configDatas) {

        UriComponents uriComponents;
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(resourcePath);
        uriComponentsBuilder.path("/updateAll");
        uriComponentsBuilder.queryParam("patientUuid", uuid);
        uriComponents = uriComponentsBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(configDatas,headers);
        try {
            restTemplate.postForLocation(uriComponents.toUri(), entity);
            return true;
        } catch (RestClientException e) {
            e.printStackTrace();
            return false;
        }
    }

   }
