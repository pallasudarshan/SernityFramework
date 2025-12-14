package steps;

import bdd.framework.service.DataService;
import bdd.pojo.fhrAnnotations.FhrAnnotationMappingPayload;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ge.hc.kyma.FHRAnnotation;
import com.ge.hc.kyma.FilterItem;
import com.ge.hc.kyma.bdd.model.streaming.WaveformData;
import net.serenitybdd.annotations.Steps;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import pageObjects.AppPage;
import pageObjects.BasicPage;
import pageObjects.FHRAnnotationsPage;
import pageObjects.WaveformPage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class FHRAnnotationsSteps {

    FHRAnnotationsPage fhrAnnotationsPage;
    AppPage appPage;
    BasicPage basicPage;

    public void refreshFHRApplication() throws InterruptedException {
        fhrAnnotationsPage.reloadFHRApplication();
    }

    public void refreshFHRApplicationFromErrorPage() throws InterruptedException {
        fhrAnnotationsPage.reloadFHRApplicationForError();
    }

    public void isTitleDisplayed(String title) throws InterruptedException {
        Assert.assertTrue("Page header is not displaying !!", fhrAnnotationsPage.isLabelDisplayed(title));
    }

    public void verifyErrorMessage(String expectedErrorMessage){
        String actualErrorMessage = fhrAnnotationsPage.getErrorMessage();
        Assert.assertTrue("Error message is not matching !! Actual is - "+actualErrorMessage+" AND expected is - "+expectedErrorMessage, expectedErrorMessage.equals(actualErrorMessage));
    }


    public void zoomIn(int noOfTime, String position) throws InterruptedException {
        int count=0;
        while (count < noOfTime) {
            fhrAnnotationsPage.pinchOut(position);
            count++;
        }
    }

    public void zoomOut(int noOfTime, String position) throws InterruptedException {
        int count=0;
        while (count < noOfTime) {
            fhrAnnotationsPage.pinchIn(position);
            count++;
        }
    }

    public void resetConfiguration() {
        int attempt = 0;
        while (attempt < 5) {
            fhrAnnotationsPage.ScrollUpFHRConfigurationListView();
            if (appPage.isElementAvailableBySemanticsLabel("data reset button")) {
                break;
            }
            attempt++;
        }
        fhrAnnotationsPage.resetConfiguration();
    }

    public void swipeWaveformLayout(int noOfTime, String direction) throws InterruptedException {
        int count=0;
        while (count < noOfTime) {
            Thread.sleep(3000);
            fhrAnnotationsPage.swipeFHRLayout(direction);
            count++;
        }
    }

    public void rotateTheScreen(String displayMode) {
        fhrAnnotationsPage.rotateScreen(displayMode);
    }

    public void createFhrAnnotation(String fhrPayloadPath, String interval) throws IOException, InterruptedException, ParseException {
        String startTime, endTime;
        InputStream inStream = getClass().getResourceAsStream(fhrPayloadPath);
        FHRAnnotation fhrAnnotationDatas = parseFHRAnnotationDatafromJson(inStream);
        Instant currentTime = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        Instant updatedTime = currentTime.minus(Duration.ofMinutes(8));
        
        endTime = currentTime.atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
        startTime = updatedTime.atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
        System.out.println("startTime : "+startTime);
        System.out.println("endTime : "+endTime);
        DataService dataService = new DataService();
        dataService.create("Patient-0", FilterItem.ResourceTypeEnum.FHRANNOTATIONS, fhrAnnotationDatas,interval, startTime, endTime, "GE");
    }

    private FHRAnnotation parseFHRAnnotationDatafromJson(InputStream inStream)
            throws IOException, JsonParseException, JsonMappingException, ParseException {
        InputStreamReader reader = new InputStreamReader(inStream);

        JSONParser parser = new JSONParser();

        JSONObject jsonObject = (JSONObject) parser.parse(reader);
//        JSONArray fhrAnnotationData = (JSONArray) jsonObject.get("annotationMap");

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        FHRAnnotation fhrAnnotationDatas = mapper.readValue(jsonObject.toString(), FHRAnnotation.class);

//        for (Object annotationData : fhrAnnotationData) {
//            System.out.println(annotationData.toString());
//            fhrAnnotationDatas.add((FHRAnnotation) mapper.readValue(annotationData.toString(), FHRAnnotation.class));
//        }
        return fhrAnnotationDatas;
    }

    public void validateFHRData(String fhrPayloadPath, String parameter, String numeric) throws IOException, ParseException {
        InputStream inStream = getClass().getResourceAsStream(fhrPayloadPath);
        FHRAnnotation fhrAnnotationDatas = parseFHRAnnotationDatafromJson(inStream);

//        fhrAnnotationDatas.getAnnotationMap().forEach(c -> {
//            c.getFhrParameters().forEach(h -> {
//                if (h.getParameter().equals(parameter)) {
//                    h.getFhrNumerics().forEach(k -> {
//                        if (k.getNumeric().equals(numeric)) {
//                            k.getValues().getValue().equals("abc");
//                            Assert.assertEquals(k.getValues().getValue(), "");
//                            Assert.assertEquals(k.getValues().getText(), "");
//                            Assert.assertEquals(k.getValues().getUom(), "");
//                        }
//                    });
//                }
//            });
//        });

        fhrAnnotationDatas.getAnnotationMap().parallelStream().flatMap(h -> h.getFhrParameters().stream()).filter(p -> p.getParameter().equalsIgnoreCase(parameter))
                .flatMap(i -> i.getFhrNumerics().stream()).filter(o -> o.getNumeric().equalsIgnoreCase(numeric)).forEach(c -> {
                    Assert.assertEquals("Value mismatched !!",c.getValues().getValue(), BigDecimal.valueOf(95));
                    Assert.assertEquals("UOM mismatched !!", c.getValues().getUom(), "%");
                    Assert.assertEquals("Text mismatched !!", c.getValues().getText(), "test1");
                });

//        System.out.println("Text ::"+fhrAnnotationDatas.getAnnotationMap().stream().filter( p -> p.getFhrParameters().stream().filter(k -> k.getParameter().equals("Sato2")).findFirst()));
    }

    public void validateFHRAnnotationDetails(){
//        System.out.println("ha ha "+fhrAnnotationsPage.validateFHRAnnotationDetails());
       fhrAnnotationsPage.validateFHRAnnotationFlyout();
    }
}
