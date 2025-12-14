package bdd.framework.service;

import com.ge.hc.kyma.WaveformCollection;
import com.ge.hc.kyma.WaveformDescriptor;
import com.ge.hc.kyma.WaveformParameter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class WaveFormMetaDataService {

	private RestTemplate restTemplate;
	private final String API_PATH = "waveforms/meta";
	private String resourcePath;

	WaveFormMetaDataService(String baseUrl) {
		restTemplate = new RestTemplate(DataService.getClientHttpRequestFactory());
		resourcePath = baseUrl + API_PATH;
	}

	/**
	 * @param patient_uuid
	 * @param param_name
	 * @param index
	 * @param sub_param
	 * @return
	 */
	<T> T get(String patient_uuid, String param_name, String index, String sub_param) {
		UriComponents uriComponents = null;
		T waveformsUpdateList = null;
		if (null != patient_uuid && null != param_name && null != index) {
			if (sub_param == null) {
				uriComponents = UriComponentsBuilder.fromHttpUrl(resourcePath).path("/").path(patient_uuid).path("/")
						.path(param_name).path("/").path(index).build();
				
				if (null != uriComponents) {
					ResponseEntity<WaveformParameter> response = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, null,
							new ParameterizedTypeReference<WaveformParameter>() {
							});
					waveformsUpdateList = (T) response.getBody();
				}
				
				
			} else {
				uriComponents = UriComponentsBuilder.fromHttpUrl(resourcePath).path("/").path(patient_uuid).path("/").
						path(param_name).path("/").path(index).path("/").path(sub_param).build();
				
				if (null != uriComponents) {
					ResponseEntity<WaveformDescriptor> response = restTemplate.exchange(uriComponents.toUri(), HttpMethod.GET, null,
							new ParameterizedTypeReference<WaveformDescriptor>() {
							});
					waveformsUpdateList = (T) response.getBody();
				}
			}
		}
		return waveformsUpdateList;
	}

	/**
	 * @param patient_uuid
	 * @param param_name
	 * @param index
	 * @param sub_param
	 * @param waveFormsUpdate
	 * @return
	 */
	<T> boolean update(String patient_uuid, String param_name, String index, String sub_param,
			T data) {
		UriComponents uriComponents = null;
		if (null != patient_uuid && null != param_name && null != index && null != sub_param) {
			uriComponents = UriComponentsBuilder.fromHttpUrl(resourcePath).path("/").path(patient_uuid).path("/").path(param_name).path("/")
					.path(index).path("/").path(sub_param).build();
			
		} else if (null != patient_uuid) {
			uriComponents = UriComponentsBuilder.fromHttpUrl(resourcePath).path("/").path(patient_uuid).build();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(data,headers);
		if (null != uriComponents) {
			try {
				restTemplate.put(uriComponents.toUri(),entity);
				return true;
			} catch (RestClientException e) {
				e.printStackTrace();
				return false;
			}
		}

		return false;
	}

	/**
	 * @param data
	 * @return
	 */
	@SuppressWarnings("unchecked")
	List<String> create(List<WaveformCollection> waveformCollection) {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(resourcePath).path("/").build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(waveformCollection,headers);
		return restTemplate.postForObject(uriComponents.toUri(), entity, List.class);
	}

	/**
	 * @param patient_uuid
	 * @param param_name
	 * @param index
	 * @param sub_param
	 * @return
	 */
	List<String> delete(String patient_uuid, String param_name, String index, String sub_param) {
		UriComponents uriComponents = null;
		List<String> waveFormIdList = new ArrayList<String>();
		if (null != patient_uuid && null != param_name && null != index) {
			if (sub_param != null) {
				uriComponents = UriComponentsBuilder.fromHttpUrl(resourcePath).path("/").path(patient_uuid)
						.path(param_name).path(index).path(sub_param).build();
			} else {
				uriComponents = UriComponentsBuilder.fromHttpUrl(resourcePath).path("/").path(patient_uuid)
						.path(param_name).path(index).build();
			}
		}

		ResponseEntity<List<String>> response;
		if (null != uriComponents) {
			response = restTemplate.exchange(uriComponents.toUri(), HttpMethod.DELETE, null,
					new ParameterizedTypeReference<List<String>>() {
					});
			waveFormIdList = response.getBody();
		}

		return waveFormIdList;
	}

}
