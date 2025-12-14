//**************************From Release 5.0.0********************************************************
package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class KymaCommonUtil {

    static ObjectMapper objectMapper = new ObjectMapper();


    public static String randomPatientEntityID() {
        return "Patient-" + BDDCommonUtil.randomNineDigitNumber();
    }

    public static String randomPatientName() {
        return BDDCommonUtil.randomCharacter(9);
    }

    public static String generatePatientBed() {
        return "Bed"+BDDCommonUtil.randomCharacter(9);
    }

    public static String generateLocation() {
        return "L"+BDDCommonUtil.randomCharacter(9);
    }

    public static String generatePatientCareArea() {
        return "CareArea"+BDDCommonUtil.randomCharacter(9);
    }

    public static String generatePatientFacility() {
        return "Facility"+BDDCommonUtil.randomCharacter(9);
    }


    public static String convertTimeToGivenZoneName(String eventTimeFormat, String localTimeZoneName) {
        String dateTime=null;
        try {
            Instant dates = OffsetDateTime.parse(eventTimeFormat).toInstant();
            ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(dates, ZoneId.of(String.valueOf(localTimeZoneName)));
            String date = zonedDateTime.toString();
            int startingIndex = date.indexOf("[");
            dateTime = (String)date.subSequence(0,startingIndex);
        }catch(Exception e){
            dateTime = (String)eventTimeFormat.subSequence(0,eventTimeFormat.length());
        }

        return dateTime;
    }

    public static String findNumericColor(String numeric){

        HashMap<String,String> numericMap = new HashMap<>();
        numericMap.put(KymaConstants.getNumericHeartrate(),KymaConstants.getNumericHeartrateColor());
        numericMap.put(KymaConstants.getNumericStii(),KymaConstants.getNumericStiiColor());
        numericMap.put(KymaConstants.getNumericPvcrate(),KymaConstants.getNumericPvcrateColor());
        numericMap.put(KymaConstants.getNumericSato2(),KymaConstants.getNumericSato2Color());
        numericMap.put(KymaConstants.getNumericPulserate(),KymaConstants.getNumericPulserateColor());
        numericMap.put(KymaConstants.getNumericResprate(),KymaConstants.getNumericResprateColor());
        numericMap.put(KymaConstants.getNumericSystolic(),KymaConstants.getNumericSystolicColor());
        numericMap.put(KymaConstants.getNumericDiastolic(),KymaConstants.getNumericDiastolicColor());
        numericMap.put(KymaConstants.getNumericMean(),KymaConstants.getNumericMeanColor());
        numericMap.put(KymaConstants.getNumericTemp(),KymaConstants.getDefaultNumericColor());
        numericMap.put(KymaConstants.getNumericCo2endtidal(),KymaConstants.getDefaultNumericColor());

        return numericMap.get(numeric);
    }

    public static String findNumericColorForLightTheme(String numeric) {
        HashMap<String,String> numericMap = new HashMap<>();
        numericMap.put(KymaConstants.getNumericHeartrate(),KymaConstants.getNumericHeartrateColorLightTheme());
        numericMap.put(KymaConstants.getNumericStii(),KymaConstants.getNumericStiiColor());
        numericMap.put(KymaConstants.getNumericPvcrate(),KymaConstants.getNumericPvcrateColor());
        numericMap.put(KymaConstants.getNumericSato2(),KymaConstants.getNumericSato2ColorLightTheme());
        numericMap.put(KymaConstants.getNumericPulserate(),KymaConstants.getNumericPulserateColor());
        numericMap.put(KymaConstants.getNumericResprate(),KymaConstants.getNumericResprateColorLightTheme());
        numericMap.put(KymaConstants.getNumericSystolic(),KymaConstants.getNumericSystolicColor());
        numericMap.put(KymaConstants.getNumericDiastolic(),KymaConstants.getNumericDiastolicColor());
        numericMap.put(KymaConstants.getNumericMean(),KymaConstants.getNumericMeanColor());
        numericMap.put(KymaConstants.getNumericTemp(),KymaConstants.getDefaultNumericColor());
        numericMap.put(KymaConstants.getNumericCo2endtidal(),KymaConstants.getDefaultNumericColor());

        return numericMap.get(numeric);
    }
    public static String getDelayValueOfLearningModeElements(Integer index) {
//        get delay property value for learning mode enabled numeric
        String value;
        switch (index) {
            case 0:
                value = KymaConstants.getDelayValueOfLearningModeElementForIndexOne();
                break;
            case 1:
                value = KymaConstants.getDelayValueOfLearningModeElementForIndexTwo();
                break;
            case 2:
                value = KymaConstants.getDelayValueOfLearningModeElementForIndexThree();
                break;
            default:
                throw new IllegalStateException("Delay value does not exists for given index: " + index);
        }
        return value;
    }

    public static String findTrendMinScale(String parameter) {
        HashMap<String, String> numericMap = new HashMap<>();
        numericMap.put(KymaConstants.getNumericSato2(), KymaConstants.getSat02MinScale());
        numericMap.put(KymaConstants.getNumericPulserate(), KymaConstants.getPulseRateMinScale());
        numericMap.put(KymaConstants.getNumericNIBP(), KymaConstants.getNibpMinScale());
        numericMap.put(KymaConstants.getNumericST_I(), KymaConstants.getST_I_MinScale());
        return numericMap.get(parameter);
    }

    public static String findTrendMaxScale(String parameter) {
        HashMap<String, String> numericMap = new HashMap<>();
        numericMap.put(KymaConstants.getNumericSato2(), KymaConstants.getSat02MaxScale());
        numericMap.put(KymaConstants.getNumericPulserate(), KymaConstants.getPulseRateMaxScale());
        numericMap.put(KymaConstants.getNumericNIBP(), KymaConstants.getNibpMaxScale());
        numericMap.put(KymaConstants.getNumericST_I(), KymaConstants.getST_I_MaxScale());
        return numericMap.get(parameter);
    }

    public static String getLocationName(String roomNo, String bedNo){
        return roomNo+KymaConstants.getLocationStringDelimiter()+bedNo;
    }

    public static String findTrendsHexColorCode(String parameter){
        HashMap<String,String> trendsColorMap = new HashMap<>();
        trendsColorMap.put(KymaConstants.getNumericSato2(),KymaConstants.SATO2_HEX_COLOR_CODE());
        trendsColorMap.put(KymaConstants.getNumericTrendTemp(),KymaConstants.TEMP_HEX_COLOR_CODE());
        trendsColorMap.put(KymaConstants.getNumericPulserate(),KymaConstants.PULSE_HEX_RATE_COLOR_CODE());
        trendsColorMap.put(KymaConstants.getNumericNIBP(),KymaConstants.NIBP_HEX_COLOR_CODE());
        return trendsColorMap.get(parameter);
    }

    public static String expectedTrendParamToolTip(String Parameter) throws IOException
    {	Hashtable<String, String> param_tooltips = new Hashtable<String, String>();
        String expectedParamToolTip = null;
        param_tooltips.put("satO2", "satO2");
        param_tooltips.put("pulseRate", "pulseRate");
        param_tooltips.put("TEMP", "TEMP");
        param_tooltips.put("NIBP", "SYS,DIA,MEAN");
        param_tooltips.put("HR", "HR");
        param_tooltips.put("ST-I", "ST-I");
        param_tooltips.put("ST-II", "ST-II");
        param_tooltips.put("ST-III", "ST-III");
        param_tooltips.put("AVR", "AVR");
        param_tooltips.put("IP", "SYS,DIA,MEAN");
        param_tooltips.put("CO2 - RR", "CO2-RR");
        param_tooltips.put("ST-aVL", "ST-aVL");
        if (param_tooltips.containsKey(Parameter))
        {	expectedParamToolTip = param_tooltips.get(Parameter);
            return expectedParamToolTip; }
        return expectedParamToolTip;
    }

    public static String expectedTrendTimebarToolTip(String datePattern, String timebarEndtimetext, String timeSegment) throws Exception {
        String timebarTimestamp = null;
        String trendTimebarToolTip, startTime, endTime, startTimeInHHMM, endTimeInHHMM, date = "";
        Date givenDate = BDDCommonUtil.convertStringToDateFormat(datePattern, timebarEndtimetext);
        System.out.println("Pattern is: " + timebarEndtimetext);
        switch (timeSegment) {
            case "10 min":
                timebarTimestamp = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, 0, -10, 0);
                break;
            case "30 min":
                timebarTimestamp = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, 0, -30, 0);
                break;
            case "2 hr":
            case "default":
                timebarTimestamp = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -2, 0, 0);
                break;
            case "4 hr":
                timebarTimestamp = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -4, 0, 0);
                break;
            case "8 hr":
                timebarTimestamp = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -8, 0, 0);
                break;
            case "12 hr":
                timebarTimestamp = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -12, 0, 0);
                break;
            case "24 hr":
                timebarTimestamp = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -24, 0, 0);
                break;
            case "72 hr":
                timebarTimestamp = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -72, 0, 0);
                break;
        }
        // Trend timebar expected tooltip text formation
        startTime = timebarTimestamp.split(", ")[1];
        startTimeInHHMM = startTime.substring(0, startTime.length() - 3);
        endTime = timebarEndtimetext.split(", ")[1];
        endTimeInHHMM = endTime.substring(0, endTime.length() - 3);
        date = timebarTimestamp.split(",")[0];
        trendTimebarToolTip = date + " | " + startTimeInHHMM + "-" + endTimeInHHMM;
        System.out.println("Expected trendTimebarToolTip : " + trendTimebarToolTip);

        return trendTimebarToolTip;
    }

    public static String getExpectedLastButOneTimestampOnTabularTrends(String datePattern, String timeSegment, Date currentDate) throws Exception {
        String timebarTimestampForSecondLastColumn = null;
        String latestTimestamp = new SimpleDateFormat(datePattern).format(currentDate);
        String latestTime, latestTimeInHHMM;
        Date givenDate = BDDCommonUtil.convertStringToDateFormat(datePattern, latestTimestamp);
        System.out.println("Pattern is: " + latestTimestamp);
        switch (timeSegment) {
            case "1 min":
            case "default":
                timebarTimestampForSecondLastColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, 0, -1, 0);
                break;
            case "2 min":
                timebarTimestampForSecondLastColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, 0, -2, 0);
                break;
            case "5 min":
                timebarTimestampForSecondLastColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, 0, -5, 0);
                break;
            case "10 min":
                timebarTimestampForSecondLastColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, 0, -10, 0);
                break;
            case "15 min":
                timebarTimestampForSecondLastColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, 0, -15, 0);
                break;
            case "30 min":
                timebarTimestampForSecondLastColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, 0, -30, 0);
                break;
            case "1 hr":
                timebarTimestampForSecondLastColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -1, 0, 0);
                break;
        }
        // Tabular Trend timebar expected time text formation
        latestTime = timebarTimestampForSecondLastColumn.split(", ")[1];
        latestTimeInHHMM = latestTime.substring(0, latestTime.length() - 3);
        System.out.println("Expected latestTimeInHHMM : " + latestTimeInHHMM);

        return latestTimeInHHMM;
    }

    public static String getExpectedSecondTimestampOnTabularTrends(String datePattern, String timeSegment, Date currentDate) throws Exception {
        String timebarTimestampForSecondColumn = null;
        String latestTimestamp = new SimpleDateFormat(datePattern).format(currentDate);
        String latestTime, latestTimeInHHMM;
        Date givenDate = BDDCommonUtil.convertStringToDateFormat(datePattern, latestTimestamp);
        System.out.println("Pattern is: " + latestTimestamp);
        switch (timeSegment) {
            case "1 min":
            case "default":
                timebarTimestampForSecondColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -72, 1, 0);
                break;
            case "2 min":
                timebarTimestampForSecondColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -72, 2, 0);
                break;
            case "5 min":
                timebarTimestampForSecondColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -72, 5, 0);
                break;
            case "10 min":
                timebarTimestampForSecondColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -72, 10, 0);
                break;
            case "15 min":
                timebarTimestampForSecondColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -72, 15, 0);
                break;
            case "30 min":
                timebarTimestampForSecondColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -72, 30, 0);
                break;
            case "1 hr":
                timebarTimestampForSecondColumn = BDDCommonUtil.addSubtractFromAnyGivenDate(givenDate, datePattern, 0, 0, 0, -71, 0, 0);
                break;
        }
        // Tabular Trend timebar expected time text formation
        latestTime = timebarTimestampForSecondColumn.split(", ")[1];
        latestTimeInHHMM = latestTime.substring(0, latestTime.length() - 3);
        System.out.println("Expected latestTimeInHHMM : " + latestTimeInHHMM);

        return latestTimeInHHMM;
    }


    public static String getAlarmListLocationStringFormat(String careArea, String room, String bed) {
        return  String.join(" ", careArea.trim(),room.trim(),bed.trim());
    }

    public static String findToolTipTextForAlarmControlUnAckStateOnAlarmBanner(String ackType, String duration) {
        String toolTipText=KymaConstants.getTimedAlarmUnAckStateTooltipText();
        if(ackType.equalsIgnoreCase(KymaConstants.getInfiniteAcknowledgeType())){
            toolTipText=KymaConstants.getIndefAlarmUnAckStateTooltipText();
        }
        else if(!duration.isEmpty()){
            toolTipText= toolTipText.replaceAll("1",duration);
        }
        return toolTipText;
    }

    public static boolean verifyBrowserConsoleLogsError(List<LogEntry> Logs, String errorMessage) {
        for (LogEntry Log : Logs) {
            System.out.println(Log);}
        return Logs.stream().map(Log -> Log.getMessage()).anyMatch(messageJSON -> messageJSON.toLowerCase().contains(errorMessage));
    }


    public static String formatMessage(String message){
        if (message.contains(":")) {
            return (message.split(":")[0].trim() + " : " + message.split(":")[1].trim());
        } else {
            return message.trim();
        }
    }

    public static String formatPatientNameTooltipText(String namefield1, String namefield2){
        return namefield1+KymaConstants.getPatientNameTooltipStringDelimiter()+namefield2;
    }

    public static String getWaveformLabelFormat(String parameter, String subParameter) {
        return parameter+"/1/"+subParameter;
    }

    public static String getNumericLabelFormat(String parameter, String subParameter) {
        return parameter+"/1/"+subParameter;
    }
    public static String suffixTimeBarNudges(int nudgeLabels){
        return String.valueOf(nudgeLabels)+" " + "s";
    }

    public static String suffixInToolBarNudges(int nudgeLabels) {
        return String.valueOf(nudgeLabels)+ " " +"s";
    }

    public static String formatLocationWithCareAreaAndRoomAndBed(String namefield1, String namefield2){
        return namefield1+KymaConstants.getPatientNameTooltipStringDelimiter()+namefield2;
    }

    public static String fetchBrowserLogDisplayed(String logLevel, String messageToFilter, Logs logs) {
        String actualMessage =null;
        LogEntries logEntries = logs.get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            if (entry.getLevel().toString().equalsIgnoreCase(logLevel)) {
                String message = entry.getMessage();
                if (message.contains(messageToFilter)) {
                    if( messageToFilter.contains("Send To EMR report") || messageToFilter.contains("Print report")){
                        actualMessage = message.split(messageToFilter)[1].replaceAll("\\\\n", "").replaceAll("\\\\", "");
                    } else{
                        actualMessage = message.replaceAll("[(){}<>\\[\\]]",  "").split(messageToFilter)[1].replaceAll("\\\\n", "").replaceAll("\\\\", "");
                    }
                    break;
                }
            }
        }
        return actualMessage;
    }
}
