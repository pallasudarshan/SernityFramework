package bdd.framework.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ge.hc.kyma.bdd.model.registry.*;
import com.ge.hc.kyma.bdd.model.streaming.ConfigData;
import com.ge.hc.kyma.bdd.model.streaming.EventData;
import com.ge.hc.kyma.bdd.model.streaming.NumericData;

import java.math.BigDecimal;
import java.util.*;

public class DataHandler {

	@SuppressWarnings("unchecked")
	public <T> T get(HashMap<String, String> properties, Class<T> clazz) {

		if (clazz.equals(PatientData.class)) {
			return (T) getPatientData(properties);
		} else if (clazz.equals(LocationData.class)) {
			return (T) getLocationData(properties);
		} else if (clazz.equals(AssociationData.class)) {
			return (T) getAssocData(properties);
		} else if (clazz.equals(NumericData.class)) {
			return (T) getNumericData(properties);
		} else if (clazz.equals(ConfigData.class)) {
			return (T) getConfigData(properties);
		}
		 else if (clazz.equals(EventData.class)) {
				return (T) getEventData(properties);
			}
		
		return null;
	}

	private AssociationData getAssocData(HashMap<String, String> assocDataMap) {
		String key;
		AssociationData assocation = new AssociationData();
		key = "uuidEntity";
		if (assocDataMap.containsKey(key)) {
			assocation.setEntityID(assocDataMap.get(key));
		}
		key = "uuidLocation";
		if (assocDataMap.containsKey(key)) {
			assocation.setLocationEntityID(assocDataMap.get(key));
		}
		key = "uuidPatient";
		if (assocDataMap.containsKey(key)) {
			assocation.setPatientEntityID(assocDataMap.get(key));
		}
		key = "uuidSource";
		if (assocDataMap.containsKey(key)) {
			assocation.setSourceEntityID(assocDataMap.get(key));
		}
		return assocation;
	}

	private LocationData getLocationData(HashMap<String, String> locationDataMap) {
		String key;
		LocationData location = new LocationData();

		key = "bed";
		if (locationDataMap.containsKey(key)) {
			location.setBed(locationDataMap.get(key));
		}
		key = "careArea";
		if (locationDataMap.containsKey(key)) {
			location.setCareArea(locationDataMap.get(key));
		}
		key = "entityID";
		if (locationDataMap.containsKey(key)) {
			location.setEntityID(locationDataMap.get(key));
		}
		key = "facility";
		if (locationDataMap.containsKey(key)) {
			location.setFacility(locationDataMap.get(key));
		}
		key = "room";
		if (locationDataMap.containsKey(key)) {
			location.setRoom(locationDataMap.get(key));
		}
		key = "group";
		if (locationDataMap.containsKey(key)) {
			location.setGroup(locationDataMap.get(key));
		}
		return location;
	}

	private PatientData getPatientData(HashMap<String, String> patientDataMap) {
		PatientData patient = new PatientData();
		String key;

		key = "birthDateTime";
		if (patientDataMap.containsKey(key)) {
			patient.setBirthDateTime(patientDataMap.get(key));
		}
		key = "uuidEntity";
		if (patientDataMap.containsKey(key)) {
			patient.setEntityID(patientDataMap.get(key));
		}
		key = "family";
		if (patientDataMap.containsKey(key)) {
			patient.setFamilyName(patientDataMap.get(key));
		}
		key = "gender";
		if (patientDataMap.containsKey(key)) {
			patient.setGender(patientDataMap.get(key));
		}
		key = "given";
		if (patientDataMap.containsKey(key)) {
			patient.setGivenName(patientDataMap.get(key));
		}
		key = "state";
		if (patientDataMap.containsKey(key)) {
			patient.setState(patientDataMap.get(key));
		}
		key = "id";
		if (patientDataMap.containsKey(key)) {
			String[] idDetails = patientDataMap.get(key).split(";");
			List<PatientId> patientIDList=new ArrayList<>();
			for (String idDetail : idDetails) {
				String[] idAndType = idDetail.split(",");
				patientIDList.add(new PatientId(idAndType[0], idAndType[1]));
			}
			patient.setId(patientIDList);
		}
		key = "implantedDeviceTypes";
		if (patientDataMap.containsKey(key)) {
			patient.setImplantedDeviceTypes(Collections.singletonList(patientDataMap.get(key)));
		}
		key = "careGiverGivenName";
		if (patientDataMap.containsKey(key)) {
			patient.setCareGiverGivenName(patientDataMap.get(key));
		}
		key = "careGiverFamilyName";
		if (patientDataMap.containsKey(key)) {
			patient.setCareGiverFamilyName(patientDataMap.get(key));
		}
		key = "typeOfCare";
		if (patientDataMap.containsKey(key)) {
			patient.setTypeOfCare(patientDataMap.get(key));
		}
		key = "note";
		if (patientDataMap.containsKey(key)) {
			patient.setNote(patientDataMap.get(key));
		}
		key = "hubID";
		if (patientDataMap.containsKey(key)) {
			patient.setHubID(patientDataMap.get(key));
		}
		key = "ageGroup";
		if (patientDataMap.containsKey(key)) {
			patient.setAgeGroup(patientDataMap.get(key));
		}
		key = "testReason";
		if (patientDataMap.containsKey(key)) {
			patient.setTestReason(patientDataMap.get(key));
		}
		key = "age";
		if (patientDataMap.containsKey(key)) {
			patient.setAge(Integer.parseInt(patientDataMap.get(key)));
		}
		key = "ageUnit";
		if (patientDataMap.containsKey(key)) {
			patient.setAgeUnit(patientDataMap.get(key));
		}
		key = "additionalFields";
		if (patientDataMap.containsKey(key)) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				AdditionalFieldsType additionalFields = mapper.readValue(patientDataMap.get(key), AdditionalFieldsType.class);
				patient.setAdditionalFields(additionalFields);
			} catch (Exception e) {
				// Log the error for debugging
				System.err.println("Failed to parse additionalFields: " + e.getMessage());
				// Optionally set empty additionalFields
				patient.setAdditionalFields(new AdditionalFieldsType());
			}
		}

		return patient;
	}

	private NumericData getNumericData(HashMap<String, String> numericDataMap) {

		String key;
		NumericData numeric = new NumericData();
		key = "entityID";
		if (numericDataMap.containsKey(key)) {
			numeric.setEntityID(numericDataMap.get(key));
		}
		key = "sourceID";
		if (numericDataMap.containsKey(key)) {
			numeric.setSourceID(numericDataMap.get(key));
		}
		key = "parameter";
		if (numericDataMap.containsKey(key)) {
			numeric.setParameter(numericDataMap.get(key));
		}
		key = "invalidLE";
		if (numericDataMap.containsKey(key)) {
			numeric.setInvalidLE(new BigDecimal(numericDataMap.get(key)));
		}
		key = "numeric";
		if (numericDataMap.containsKey(key)) {
			numeric.setNumeric(numericDataMap.get(key));
		}
		key = "uom";
		if (numericDataMap.containsKey(key)) {
			numeric.setUom(numericDataMap.get(key));
		}
		key = "value";
		if (numericDataMap.containsKey(key)) {
			numeric.setValue(new BigDecimal(numericDataMap.get(key)));
		}	
		key = "index";
		if (numericDataMap.containsKey(key)) {
			numeric.setIndex(new Integer(numericDataMap.get(key)));
		}
		return numeric;
	}
	
	private ConfigData getConfigData(HashMap<String, String> configDataMap) {
	
		String key;
		ConfigData config = new ConfigData();
		key = "entityID";
		if (configDataMap.containsKey(key)) {
			config.setEntityID(configDataMap.get(key));
		}
		key = "dateTime";
		if (configDataMap.containsKey(key)) {
			config.setDateTime(configDataMap.get(key));
		}
		key = "parameter";
		if (configDataMap.containsKey(key)) {
			config.setParameter(configDataMap.get(key));
		}
		key = "numeric";
		if (configDataMap.containsKey(key)) {
			config.setNumeric(configDataMap.get(key));
		}
		key = "highLimitValue";
		if (configDataMap.containsKey(key)) {
			try{
				config.setHighLimitValue(new BigDecimal(configDataMap.get(key)));
			}catch(NumberFormatException e){
			}
		}
		key = "lowLimitValue";
		if (configDataMap.containsKey(key)) {
			try {
				config.setLowLimitValue(new BigDecimal(configDataMap.get(key)));
			} catch (NumberFormatException e) {
			}
		}
		key = "isEnabledHighLimit";
		if (configDataMap.containsKey(key)) {
			config.setIsEnabledHighLimit(configDataMap.get(key));
		}
		key = "isEnabledLowLimit";
		if (configDataMap.containsKey(key)) {
			config.setIsEnabledLowLimit(configDataMap.get(key));
		}
		key = "isEnabledCriticalHighLimit";
		if (configDataMap.containsKey(key)) {
			config.setIsEnabledCriticalHighLimit(configDataMap.get(key));
		}
		key = "isEnabledCriticalLowLimit";
		if (configDataMap.containsKey(key)) {
			config.setIsEnabledCriticalLowLimit(configDataMap.get(key));
		}
		key = "criticalMax";
		if (configDataMap.containsKey(key)) {
			config.setCriticalMax(new BigDecimal(configDataMap.get(key)));
		}
		key = "criticalMin";
		if (configDataMap.containsKey(key)) {
			config.setCriticalMin(new BigDecimal(configDataMap.get(key)));
		}
		key = "uom";
		if (configDataMap.containsKey(key)) {
			config.setUom(configDataMap.get(key));
		}
		key = "displayScaleMode";
		if (configDataMap.containsKey(key)) {
			config.setDisplayScaleMode(configDataMap.get(key));
		}
		key = "displayScale";
		if (configDataMap.containsKey(key)) {
			config.setDisplayScale(configDataMap.get(key));
		}
		key = "displayScaleUOM";
		if (configDataMap.containsKey(key)) {
			config.setDisplayScaleUOM(configDataMap.get(key));
		}
		key = "displayScaleFactor";
		if (configDataMap.containsKey(key)) {
			config.setDisplayScaleFactor(new BigDecimal(configDataMap.get(key)));
		}
		key = "gain";
		if (configDataMap.containsKey(key)) {
			config.setGain(configDataMap.get(key));
		}
		key = "index";
		if (configDataMap.containsKey(key)) {
			config.setIndex(new Integer(configDataMap.get(key)));
		}
		key = "invalidLE";
		if (configDataMap.containsKey(key)) {
			try {
				config.setInvalidLE(new Integer(configDataMap.get(key)));
			} catch(NumberFormatException e){
			}
		}
		key = "displayScaleRangeMin";
		if (configDataMap.containsKey(key)) {
			config.setDisplayScaleRangeMin(new BigDecimal(configDataMap.get(key)));
		}
		key = "displayScaleRangeMax";
		if (configDataMap.containsKey(key)) {
			config.setDisplayScaleRangeMax(new BigDecimal(configDataMap.get(key)));
		}
		key = "waveform";
		if (configDataMap.containsKey(key)) {
			config.setWaveform(configDataMap.get(key));
		}
		return config;
	}
	private EventData getEventData(HashMap<String, String> eventDataMap) {
		
		String key;
		EventData event = new EventData();
		key = "entityID";
		if (eventDataMap.containsKey(key)) {
			event.setEntityID(eventDataMap.get(key));
		}
		key = "dateTime";
		if (eventDataMap.containsKey(key)) {
			event.setDateTime(eventDataMap.get(key));
		}
		key = "parameter";
		if (eventDataMap.containsKey(key)) {
			event.setParameter(eventDataMap.get(key));
		}
		key = "numeric";
		if (eventDataMap.containsKey(key)) {
			event.setNumeric(eventDataMap.get(key));
		}
		key = "mdcCode";
		if (eventDataMap.containsKey(key)) {
			event.setMdcCode(eventDataMap.get(key));
		}
		key = "eventState";
		if (eventDataMap.containsKey(key)) {
			event.setEventState(eventDataMap.get(key));
			
		}
		key = "eventType";
		if (eventDataMap.containsKey(key)) {
			event.setEventType(eventDataMap.get(key));
			
		}
		key = "eventMessage";
		if (eventDataMap.containsKey(key)) {
			event.setEventMessage(eventDataMap.get(key));
		}
		key = "audioPriority";
		if (eventDataMap.containsKey(key)) {
			event.setAudioPriority(eventDataMap.get(key));
			
		}
		key = "priority";
		if (eventDataMap.containsKey(key)) {
			event.setPriority(eventDataMap.get(key));

		}
		key = "highLimitValue";
		if (eventDataMap.containsKey(key)) {
			event.setHighLimitValue(new BigDecimal(eventDataMap.get(key)));
		}
		key = "lowLimitValue";
		if (eventDataMap.containsKey(key)) {
			event.setLowLimitValue(new BigDecimal(eventDataMap.get(key)));
		}
		key = "actualValue";
		if (eventDataMap.containsKey(key)) {
			event.setActualValue(eventDataMap.get(key));
		}
		key = "uom";
		if (eventDataMap.containsKey(key)) {
			event.setUomMdcCode(eventDataMap.get(key));
		}
		key = "eventId";
		if (eventDataMap.containsKey(key)) {
			event.setEventId(eventDataMap.get(key));
		}
		key = "eventMessage";
		if (eventDataMap.containsKey(key)) {
			event.setEventMessage(eventDataMap.get(key));
		}
		key = "alarmInactState";
		if (eventDataMap.containsKey(key)) {
			event.setAlarmInactState(eventDataMap.get(key));
		}
		key = "type";
		if (eventDataMap.containsKey(key)) {
			event.setType(eventDataMap.get(key));
		}
		key = "physioTech";
		if (eventDataMap.containsKey(key)) {
			event.setPhysioTech(eventDataMap.get(key));
		}
		key = "type";
		if (eventDataMap.containsKey(key)) {
			event.setType(eventDataMap.get(key));
		}
		key = "physioTech";
		if (eventDataMap.containsKey(key)) {
			event.setPhysioTech(eventDataMap.get(key));
		}
		key = "alarmState";
		if (eventDataMap.containsKey(key)) {
			event.setAlarmState(eventDataMap.get(key));
		}
		return event;
	}
}
