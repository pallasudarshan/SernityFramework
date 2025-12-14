package bdd.framework.service;

import com.ge.hc.kyma.FilterItem;
import com.ge.hc.kyma.bdd.model.streaming.NumericData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class StreamDataService {
	// default URL - localhost

	private FSWaveformDataService fsWaveformDS;

	public StreamDataService() {
		super();
		fsWaveformDS = new FSWaveformDataService();
	}

	/**
	 * @param e
	 * @param patient_uuid
	 * @param param_name
	 * @param index
	 * @param sub_param
	 * @return
	 */
	public <T> boolean delete(FilterItem.ResourceTypeEnum e, String patient_uuid, String param_name, String index,
							  String sub_param) {
		switch (e) {
			case WAVEFORMS:
				return fsWaveformDS.delete(patient_uuid, param_name, index, sub_param);

			default:
				break;
		}
		return false;
	}

}
