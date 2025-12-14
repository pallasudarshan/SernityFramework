package steps;

import bdd.framework.handler.DataHandler;
import bdd.framework.service.DataService;
import com.ge.hc.kyma.FilterItem.ResourceTypeEnum;
import com.ge.hc.kyma.bdd.model.registry.AssociationData;
import com.ge.hc.kyma.bdd.model.registry.LocationData;
import com.ge.hc.kyma.bdd.model.registry.PatientData;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import pageObjects.AppPage;
import pageObjects.PatientPage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationSteps {

  private static String url = "http://10.177.222.137:8090";
  private static Map<PatientData, LocationData> patientLocationMap = new HashMap<PatientData, LocationData>();

	@Steps
	PatientPage patientPage;

	@Steps
	AppPage appPage;

	private AssociationData getAssociationFromServer(String uuid) {
		DataService dataService = new DataService();
		List<AssociationData> associationList = dataService.get(ResourceTypeEnum.ASSOCIATIONS, uuid, "PATIENT");
		return associationList.get(0);
	}
  
  private LocationData getLocationFromLocationId(String uuid){
	  DataService dataService = new DataService();
	  List<LocationData> locationList = new ArrayList<LocationData>();
	  locationList = dataService.get(ResourceTypeEnum.LOCATIONS, uuid, "LOCATION");
	  return locationList.get(0);
  }


	protected LocationData getLocationFromPatientId(String uuid) {
		DataService dataService = new DataService();
		List<LocationData> locationList = new ArrayList<LocationData>();
		locationList = dataService.get(ResourceTypeEnum.LOCATIONS, uuid, "PATIENT");
		return locationList.get(0);
	}
  
  @Step
  public void createLocation(String id, String room, String bed, String careArea, String facility) throws InterruptedException {
	  HashMap<String, String> locationDetails = new HashMap<String, String>();
	  locationDetails.put("entityID", id);
	  locationDetails.put("room", room);
	  locationDetails.put("bed", bed);
	  locationDetails.put("careArea", careArea);
	  locationDetails.put("facility", facility);
	  
	  DataHandler handler = new DataHandler();
	  LocationData location = handler.get(locationDetails, LocationData.class);
	  ArrayList<LocationData> locationList = new ArrayList<LocationData>();
		if (location != null) {
			locationList.add(location);
			DataService dataService = new DataService();
			boolean isLocationCreated = dataService.create(ResourceTypeEnum.LOCATIONS, null, locationList);
			if(isLocationCreated) {
				Thread.sleep(10000);
			}else {
				System.out.println("Location not created");
			}
		} else {
			System.out.println("Location reference is null");
		}

  }


@Step
	public void createLocation(String id, String room, String bed, String careArea, String facility, String group) throws InterruptedException {
		HashMap<String, String> locationDetails = new HashMap<String, String>();
		locationDetails.put("entityID", id);
		locationDetails.put("room", room);
		locationDetails.put("bed", bed);
		locationDetails.put("careArea", careArea);
		locationDetails.put("facility", facility);
	    locationDetails.put("group", group);

		DataHandler handler = new DataHandler();
		LocationData location = handler.get(locationDetails, LocationData.class);
		ArrayList<LocationData> locationList = new ArrayList<LocationData>();
		if (location != null) {
			locationList.add(location);
			DataService dataService = new DataService();
			boolean isLocationCreated = dataService.create(ResourceTypeEnum.LOCATIONS, null, locationList);
			if(isLocationCreated) {
				Thread.sleep(10000);
			}else {
				System.out.println("Location not created");
			}
		} else {
			System.out.println("Location reference is null");
		}

	}

}
