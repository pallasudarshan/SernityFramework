package bdd.framework.service;

import com.ge.hc.kyma.FilterItem;
import com.ge.hc.kyma.bdd.model.streaming.WaveformData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class FSWaveformDataService {

    private RestTemplate restTemplate;
    private String restURL = System.getProperty("rest.url");
    private String baseURL = System.getProperty("base.path");
    private final String API_PATH = "bdd/waveforms";
    private final String API_PATH_SPLIT = "waveforms/split";
    private String resourcePath;
    private String resourcePathSplit;
    private String liveWaveResourcePath;
    private String liveWaveResourcePathSplit;

    FSWaveformDataService() {
        restTemplate = new RestTemplate(DataService.getClientHttpRequestFactory());
        resourcePath = this.restURL + API_PATH;
        resourcePathSplit = this.restURL + API_PATH_SPLIT;
        liveWaveResourcePath = this.baseURL + API_PATH;
        liveWaveResourcePathSplit = this.baseURL + API_PATH_SPLIT;
    }

    /**
     * @param data
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    boolean create(String uuid, List<WaveformData> data, String type,String waveformType) {
        UriComponents uriComponents = null;
        if(waveformType.equalsIgnoreCase("HISTORICAL")) {
            System.out.println("resourcePath :: " + resourcePath);
            if ("nonGe".equals(type)) {
                uriComponents = UriComponentsBuilder.fromHttpUrl(resourcePath).path("/" + "nonGE" + "/" + uuid).build();

            } else if ("Split".equals(type)) {
                uriComponents = UriComponentsBuilder.fromHttpUrl(resourcePathSplit).path("/" + uuid).build();
            } else {
                uriComponents = UriComponentsBuilder.fromHttpUrl(resourcePath).path("/" + uuid).build();
            }
        } else if (waveformType.equalsIgnoreCase("LIVE")) {
            System.out.println("livewaveresourcePath :: "+liveWaveResourcePath);
            if ("nonGe".equals(type)) {
                uriComponents = UriComponentsBuilder.fromHttpUrl(liveWaveResourcePath).path("/" + "nonGE" + "/" + uuid).build();

            } else if ("Split".equals(type)) {
                uriComponents = UriComponentsBuilder.fromHttpUrl(liveWaveResourcePathSplit).path("/" + uuid).build();
            } else {
                uriComponents = UriComponentsBuilder.fromHttpUrl(liveWaveResourcePath).path("/" + uuid).build();
            }

        } else {
            System.out.println("Invalid waveform type provided: " + waveformType);
            return false;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(data, headers);
        if (uriComponents != null) {
            try {
                restTemplate.put(uriComponents.toUri(), entity);
                return true;
            } catch (RestClientException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
    /**
     * @param patient_uuid
     * @param param_name
     * @param index
     * @param sub_param
     * @return
     */
    boolean delete(String patient_uuid, String param_name, String index, String sub_param) {
        UriComponents uriComponents = null;

        if (patient_uuid != null && param_name != null && index != null) {
            if (sub_param != null) {
                uriComponents = UriComponentsBuilder.fromHttpUrl(liveWaveResourcePath).path("/").path(patient_uuid).path("/")
                        .path(param_name).path("/").path(sub_param).build();
            } else {
                uriComponents = UriComponentsBuilder.fromHttpUrl(liveWaveResourcePath).path("/").path(patient_uuid).path("/")
                        .path(param_name).path("/").path(index).build();
            }
        } else if (null != patient_uuid && param_name != null) {
            uriComponents = UriComponentsBuilder.fromHttpUrl(liveWaveResourcePath).path("/").path(patient_uuid).path("/").path(param_name).build();
        } else if (null != patient_uuid) {
            uriComponents = UriComponentsBuilder.fromHttpUrl(liveWaveResourcePath).path("/").path(patient_uuid).build();
        }

        if (null != uriComponents) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>("",headers);
            restTemplate.exchange(uriComponents.toUri(), HttpMethod.DELETE, entity, new ParameterizedTypeReference<>(){});
            return true;
        }
        return false;
    }
}


