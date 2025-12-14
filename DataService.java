package bdd.framework.service;

import bdd.util.RestTemplateUtil;
import com.ge.hc.kyma.FHRAnnotation;
import com.ge.hc.kyma.FilterItem;
import com.ge.hc.kyma.HistoricEvent;
import com.ge.hc.kyma.bdd.model.registry.LocationData;
import com.ge.hc.kyma.bdd.model.registry.PatientData;
import com.ge.hc.kyma.bdd.model.registry.RegistryData;
import com.ge.hc.kyma.bdd.model.streaming.ConfigData;
import com.ge.hc.kyma.bdd.model.streaming.EventData;
import com.ge.hc.kyma.bdd.model.streaming.NumericData;
import com.ge.hc.kyma.bdd.model.streaming.WaveformData;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import java.util.List;

public class DataService {

    private String resourceLocator = System.getProperty("rest.url");;
    private String baseURL = System.getProperty("base.path");

    private NumericDataService numericDS;
    private EventDataService eventDS;
    private FSWaveformDataService fsWaveformDS;
    private PatientDataService patientDS;
    private LocationDataService locationDS;
    private AssociationDataService associationDS;
    private FHRAnnotationsDataService fhrAnnotationsDS;
    private ConfigDataService configDS;

    public DataService(){
        super();
        RestTemplateUtil.ignoreCertificates();
        fhrAnnotationsDS = new FHRAnnotationsDataService();
        fsWaveformDS = new FSWaveformDataService();
        patientDS = new PatientDataService();
        locationDS = new LocationDataService();
        associationDS = new AssociationDataService();
        numericDS=new NumericDataService();
        eventDS =new EventDataService();
        configDS = new ConfigDataService();
    }

    public DataService(String url) {
        super();
        RestTemplateUtil.ignoreCertificates();
        this.baseURL = url;
        fhrAnnotationsDS = new FHRAnnotationsDataService();
        fsWaveformDS = new FSWaveformDataService();
        patientDS = new PatientDataService();
        locationDS = new LocationDataService();
        associationDS = new AssociationDataService();
        numericDS=new NumericDataService(url);
        eventDS =new EventDataService(url);
    }

    public static SimpleClientHttpRequestFactory getClientHttpRequestFactory()
    {
        SimpleClientHttpRequestFactory clientHttpRequestFactory
                = new SimpleClientHttpRequestFactory();
        //Connect timeout
        clientHttpRequestFactory.setConnectTimeout(10_000);

        //Read timeout
        clientHttpRequestFactory.setReadTimeout(10_000);
        return clientHttpRequestFactory;
    }

    public <T> boolean create(String uuid, FilterItem.ResourceTypeEnum e, List<T> data, String type, String waveformType) {
        if(waveformType.equalsIgnoreCase("LIVE")) {
            switch (e) {
                case WAVEFORMS:
                    return fsWaveformDS.create(uuid, (List<WaveformData>) data,type, waveformType);
                default:
                    break;
            }
        } else if (waveformType.equalsIgnoreCase("HISTORICAL")) {
            switch (e) {
                case WAVEFORMS:
                    return fsWaveformDS.create(uuid, (List<WaveformData>) data,type, waveformType);
                default:
                    break;
            }
        } else {
            // Handle other types of data creation
        }
        return false;
    }

    public <T> boolean create(String uuid, FilterItem.ResourceTypeEnum e, FHRAnnotation data, String interval, String startTime, String endTime, String type) {
        switch (e) {
            case FHRANNOTATIONS:
                return fhrAnnotationsDS.create(uuid, data ,interval,  startTime,  endTime);
            default:
                break;
        }
        return false;
    }


    public <T> List<T> create(FilterItem.ResourceTypeEnum e, List<T> data, int noOfPatient) {
        switch (e) {
            case PATIENTS:
                return (List<T>) patientDS.create(noOfPatient);
            default:
                break;
        }
        return null;
    }

    public <T> boolean create(FilterItem.ResourceTypeEnum e, String uuid, List<T> data, boolean... testNull) {
        switch (e) {
            case LOCATIONS:
                return (boolean) locationDS.create((List<LocationData>) data);
            default:
                break;
        }
        return false;
    }


    public <T> List<T> get(FilterItem.ResourceTypeEnum e, String uuid, String type) {
        switch (e) {
            case PATIENTS:
                return (List<T>) patientDS.get(uuid);
            case LOCATIONS:
                return (List<T>) locationDS.get(uuid, type);
            case ASSOCIATIONS:
                return (List<T>) associationDS.get(uuid, type);
            default:
                break;
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> delete(FilterItem.ResourceTypeEnum e, List<String> uuidList, String deleteItem) {
        switch (e) {
            case PATIENTS:
                if (null == uuidList) {
                    return (List<T>) patientDS.deleteAllPatients();
                }
                return (List<T>) patientDS.delete(uuidList);
            default:
                break;
        }
        return null;
    }

    public <T> boolean update(FilterItem.ResourceTypeEnum e, T data, String uuid, int sampleInterval,
                              String type) throws RestClientException, InterruptedException{
        RegistryData regData = new RegistryData();
        switch (e) {

            case NUMERICS:
                if(type.equals("UPDATE")) {
                    return numericDS.update(uuid, sampleInterval, (NumericData) data);
                } else if (type.equals("UPDATEALL")) {
                    return numericDS.updateAll(uuid, sampleInterval, (List<NumericData>) data);
                }case CONFIGS:
                if(type.equals("UPDATE")) {
                    return configDS.update(uuid, (ConfigData) data);
                } else if (type.equals("UPDATEALL")) {
                    return configDS.updateAll(uuid, (List<ConfigData>) data);
                }

            default:
                break;
        }
        return false;
    }

    public <T> boolean create(FilterItem.ResourceTypeEnum e, String uuid, List<T> data) {
        switch (e) {
            case EVENTS:
                return (boolean) eventDS.create( uuid,(List<EventData>) data);
            default:
                break;
        }
        return false;
    }

    public <T> List<T> create(FilterItem.ResourceTypeEnum e, List<T> data) {
        switch (e) {
            case PATIENTS:
                return (List<T>) patientDS.create((List<PatientData>) data);
            case ASSOCIATIONS:
                return (List<T>) patientDS.createRegistry((List<RegistryData>) data);
            default:
                break;
        }
        return null;
    }

}
