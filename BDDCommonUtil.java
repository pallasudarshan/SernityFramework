package util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.support.Color;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BDDCommonUtil {

	private BDDCommonUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static String getTImeInStringUTC(Calendar calendar) {
		calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
		return DatatypeConverter.printDateTime(calendar);
	}

//**************************From Release 5.0.0********************************************************

	public static LocalDate randomDateOfBirth() {
		return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
	}

	public static String randomNineDigitNumber() {
		return String.format("%09d", new Random().nextInt(1000000000));
	}

	public static String randomCharacter(int len) {
		return RandomStringUtils.randomAlphanumeric(len).toUpperCase();
	}

	//min value is inclusive and max value is exclusive
	public static int randomDigitBetweenTwoNumbers(int min, int max){
		Random randomNumber = new Random();
		return randomNumber.nextInt(min, max);
	}

	public static String generateUUID() {
		return UUID.randomUUID().toString();
	}

	public static String rgbToHex(String rgbColor){
		return Color.fromString(rgbColor).asHex();
	}

	public static String rgbaToHex(String rgbaColor) {
		try {
			// Remove "rgba(" and ")" and splitting by comma to find each color code
			String values = rgbaColor.replace("rgba(", "").replace(")", "");
			String[] components = values.split(",");

			// Parse the individual color components and alpha
			int red = Integer.parseInt(components[0].trim());
			int green = Integer.parseInt(components[1].trim());
			int blue = Integer.parseInt(components[2].trim());
			double alpha = Double.parseDouble(components[3].trim());

			// Ensuring the alpha is within valid range 0 to 1
			alpha = Math.max(0.0, Math.min(1.0, alpha));

			Color color = new Color(red, green, blue, alpha);

			// Convert the Color object to a hexadecimal string
			String hexColor = String.format("#%02X%02X%02X%02X", color.getColor().getRed(), color.getColor().getGreen(), color.getColor().getBlue(), (int) Math.round(alpha * 255));

			return hexColor;
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.out.println("Rbga color is in invalid format hence returning rgb to hex conversion");
			return rgbToHex(rgbaColor);
		}
	}

	public static String rgbaToHexWithoutAlpha(String rgbaColor) {
		try {
			// Remove "rgba(" and ")" and splitting by comma to find each color code
			String values = rgbaColor.replace("rgba(", "").replace(")", "");
			String[] components = values.split(",");

			// Parse the individual color components and alpha
			int red = Integer.parseInt(components[0].trim());
			int green = Integer.parseInt(components[1].trim());
			int blue = Integer.parseInt(components[2].trim());
			double alpha = Double.parseDouble(components[3].trim());

			// Ensuring the alpha is within valid range 0 to 1
			alpha = Math.max(0.0, Math.min(1.0, alpha));

			Color color = new Color(red, green, blue, alpha);

			// Convert the Color object to a hexadecimal string
			String hexColorwithoutAlpha = String.format("#%02X%02X%02X", color.getColor().getRed(), color.getColor().getGreen(), color.getColor().getBlue());


			return hexColorwithoutAlpha;
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.out.println("Rbga color is in invalid format hence returning rgb to hex conversion");
			return rgbToHex(rgbaColor);
		}
	}

	public static String hexToRgba(String hexColor){
		return Color.fromString(hexColor).asRgba();
	}

	public static String getCurrentDate(String withTimeFormatting) {
		String simpleDateFormat = null;
		switch (withTimeFormatting) {
			case "ISO_DateFormat" :
				simpleDateFormat = new SimpleDateFormat(KymaConstants.DATE_FORMAT_ISO).format(new Date());
				break;
			case "Date_Only_Format":
				simpleDateFormat = new SimpleDateFormat(KymaConstants.DATE_FORMAT_YYYY_MM_DD).format(new Date());
				break;
			case "Non_ISO_Date_Format":
				simpleDateFormat = new SimpleDateFormat(KymaConstants.DATE_FORMAT_NON_ISO).format(new Date());
				break;
			case "12_Hour_Date_Format":
				simpleDateFormat = new SimpleDateFormat(KymaConstants.DATE_FORMAT_12_HOUR).format(new Date());
				break;
		}
		return  simpleDateFormat;
	}

	public static String convertTimeToGivenZoneName(String eventTimeFormat, String localTimeZoneName) {
		String dateTime=null;
		try {
			Instant dates = OffsetDateTime.parse(eventTimeFormat).toInstant();
			ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(dates, ZoneId.of(String.valueOf(localTimeZoneName)));
			String date = DateTimeFormatter.ISO_DATE_TIME.format(zonedDateTime);
//			String date = zonedDateTime.toString();
			int startingIndex = date.indexOf("[");
			dateTime = (String)date.subSequence(0,startingIndex);
		}catch(Exception e){
			dateTime = (String)eventTimeFormat.subSequence(0,eventTimeFormat.length());
		}
		return dateTime;
	}

	public static boolean isValidDateFormat(String format, String dateStr) {
		DateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public static long differenceBetweenTwoDates(String startingDate, String endingDate, String dateFormat) {
		SimpleDateFormat obj = new SimpleDateFormat(dateFormat);
		long time_difference = 0;
		try {
			Date date1 = obj.parse(startingDate);
			Date date2 = obj.parse(endingDate);

			time_difference = date2.getTime() - date1.getTime();
		} catch (ParseException exception) {
			exception.printStackTrace();
		}
		return time_difference;
	}

	public static String getTimeStamp(String eventCreatedTime,String withTimeFormatting){
		String timeFormat = null;
		int startingIndex;
		int endIndex;
		switch (withTimeFormatting) {
			case "HH:MM:SS" :
				startingIndex = eventCreatedTime.indexOf("T");
				endIndex = eventCreatedTime.indexOf("+");
				timeFormat = (String) eventCreatedTime.subSequence(startingIndex + 1, endIndex);
				break;
			case "HH:MM":
				startingIndex = eventCreatedTime.indexOf("T");
				endIndex = eventCreatedTime.indexOf("+");
				timeFormat = (String) eventCreatedTime.subSequence(startingIndex + 1, endIndex-3);
				break;
		}
		return timeFormat;
	}

//**************************From Release 5.3.0********************************************************

	public static boolean compareSVGImageFiles(String expectedImageLocation, String actualImageURL) throws IOException {
		boolean imagesSameOrNot = false;
		String fileExtension = FilenameUtils.getExtension(expectedImageLocation);
		if (fileExtension.equalsIgnoreCase("html")) {
			String simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String actualImageLocation = System.getProperty("user.dir") + "\\doc\\Actualmages\\";

			URL url = new URL(actualImageURL);
			File imageFile = new File(actualImageLocation);
			imageFile.mkdir();
			File savedImage = new File(actualImageLocation + simpleDateFormat + ".html");
			FileUtils.copyURLToFile(url, savedImage);

			String expectedImage = convertHTMLToString(expectedImageLocation);
			String actualImage = convertHTMLToString(savedImage.getPath());

			imagesSameOrNot = expectedImage.equals(actualImage);
			savedImage.delete();
		} else {
			System.out.println("This is not a SVG image file.");
		}
		return imagesSameOrNot;
	}

	public static String convertHTMLToString(String filePath) throws FileNotFoundException {
		String htmlString = "";
		StringBuilder html = new StringBuilder();
		FileReader fr = new FileReader(filePath);
		try {
			BufferedReader br = new BufferedReader(fr);

			String val;
			while ((val = br.readLine()) != null) {
				html.append(val);
			}
			htmlString = html.toString();

			br.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return htmlString;
	}

	public static Date convertStringToDateFormat(String pattern, String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
		return formatter.parse(date);
	}

	public static long differenceBetweenTwoDatesInDays(Date startDate, Date endDate){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		long difference_In_Time	= endDate.getTime() - startDate.getTime();
		return TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;
	}

	public static long differenceBetweenTwoDatesInDaysInHours(String startDate, String endDate, String dateFormat)
	{
		SimpleDateFormat date = new SimpleDateFormat(dateFormat);
		long time_difference = 0;
		try {
			Date date1 = date.parse(startDate);
			Date date2 = date.parse(endDate);

			time_difference = date2.getTime() - date1.getTime();
		} catch (ParseException exception) {
			exception.printStackTrace();
		}
		return TimeUnit.MILLISECONDS.toHours(time_difference);
	}

	public static long differenceBetweenTwoDatesInDaysInSeconds(String startDate, String endDate, String dateFormat)
	{
		SimpleDateFormat date = new SimpleDateFormat(dateFormat);
		long time_difference = 0;
		try {
			Date date1 = date.parse(startDate);
			Date date2 = date.parse(endDate);

			time_difference = date2.getTime() - date1.getTime();
		} catch (ParseException exception) {
			exception.printStackTrace();
		}
		return TimeUnit.MILLISECONDS.toSeconds(time_difference);
	}

	public static long differenceBetweenTwoDatesInDaysInMinutes(String startDate, String endDate, String dateFormat)
	{
		SimpleDateFormat date = new SimpleDateFormat(dateFormat);
		long time_difference = 0;
		try {
			Date date1 = date.parse(startDate);
			Date date2 = date.parse(endDate);

			time_difference = date2.getTime() - date1.getTime();
		} catch (ParseException exception) {
			exception.printStackTrace();
		}
		return TimeUnit.MILLISECONDS.toMinutes(time_difference);
	}

	public static long differenceBetweenTwoTimes(String startTime, String endTime)
	{
		LocalTime time1 = LocalTime.parse(startTime);
		LocalTime time2 = LocalTime.parse(endTime);

		Duration duration = Duration.between(time1, time2);
		return duration.toSecondsPart();
	}

	public static String addSubtractFromCurrentDate(int years, int months, int days, int hours, int minutes, int seconds) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");

		Date date = new Date();

		// Convert Date to Calendar
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// Perform addition/subtraction
		c.add(Calendar.YEAR, years);
		c.add(Calendar.MONTH, months);
		c.add(Calendar.DATE, days);
		c.add(Calendar.HOUR, hours);
		c.add(Calendar.MINUTE, minutes);
		c.add(Calendar.SECOND, seconds);

		// Convert calendar back to Date
		return dateFormat.format(c.getTime());
	}

	public static String addSubtractFromCurrentDate(String pattern, int years, int months, int days, int hours, int minutes, int seconds) {

		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

		Date date = new Date();

		// Convert Date to Calendar
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// Perform addition/subtraction
		c.add(Calendar.YEAR, years);
		c.add(Calendar.MONTH, months);
		c.add(Calendar.DATE, days);
		c.add(Calendar.HOUR, hours);
		c.add(Calendar.MINUTE, minutes);
		c.add(Calendar.SECOND, seconds);

		// Convert calendar back to Date
		return dateFormat.format(c.getTime());
	}

	public static String addSubtractFromAnyGivenDate(Date date, String datePattern, int years, int months, int days, int hours, int minutes, int seconds) {

		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);

		// Convert Date to Calendar
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// Perform addition/subtraction
		c.add(Calendar.YEAR, years);
		c.add(Calendar.MONTH, months);
		c.add(Calendar.DATE, days);
		c.add(Calendar.HOUR, hours);
		c.add(Calendar.MINUTE, minutes);
		c.add(Calendar.SECOND, seconds);

		// Convert calendar back to Date
		return dateFormat.format(c.getTime());
	}

	/**
	 * Returns the milliseconds for the time given in format HH:MM:SS or HH:MM
	 * Param: dateTime – the text to parse such as "10:15:30" or "10:15"
	 * Returns: milliseconds of type float
	 */
	public static float stringTimeToMillisecond(String dateTime){
		// Convert time in string to local time
		LocalTime localTime = LocalTime.parse(dateTime);

		// Convert local time to milliseconds
		float millis = localTime.toSecondOfDay() * 1000;
		return millis;
	}

	/**
	 * Returns the milliseconds for the time given in format MM:SS or M:SS
	 * Param: dateTime – the text to parse such as "2:00" or "10:00"
	 * Returns: milliseconds of type long
	 */
	public static long convertTimeToMillisecond(String timeInMMSS){
		if(timeInMMSS.equals("0")){
			return 0L;
		}
		String [] minutesSecondsArray = timeInMMSS.split(":");
		System.out.println("date time format "+timeInMMSS);
		long millis= 1000*(60L *Integer.parseInt(minutesSecondsArray[0])+Integer.parseInt(minutesSecondsArray[1]));
		return millis;
	}

	/**
	 * Reads txt file and returns the content
	 *
	 * @param fileName
	 * @return
	 */
	public static String readTextFile(String fileName) {
		File file;
		String path = "src/test/resources/testData/";
		String retValue = null;
		try {
			file = ResourceUtils.getFile(path + fileName);
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				retValue = reader.nextLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Text File not found Exception");
		}
		return retValue;
	}

	public static String convertBoxShadowToColor(String rgbInsetColor){
		int startingIndex = rgbInsetColor.indexOf("r");
		int endIndex = rgbInsetColor.indexOf(")");
		String rgbColor = (String) rgbInsetColor.subSequence(startingIndex, endIndex+1);
		return rgbColor;
	}

	public static String convertUnixToDateTimeFormat(long unixTimestamp, String dateTimePattern){

		// Convert the Unix timestamp to LocalDateTime
		LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTimestamp), ZoneId.systemDefault());

		// Define the desired date and time format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);

		// Format and return the LocalDateTime object as a string
		return dateTime.format(formatter);
	}

	public static long dateTimeToUnixTimestamp(int year, int month, int day, int hour, int minute, int second){

		// Create a LocalDateTime object with the given date and time
		LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute, second);

		// Convert the LocalDateTime object to Unix timestamp
		return dateTime.toEpochSecond(ZoneId.of("Asia/Kolkata").getRules().getOffset(LocalDateTime.now()));
	}

	public static int getMonthValue(String monthName) {
		Locale locale = Locale.getDefault();

		for (Month month : Month.values()) {
			String fullName = month.getDisplayName(TextStyle.FULL, locale);
			String shortName = month.getDisplayName(TextStyle.SHORT, locale);

			if (fullName.equalsIgnoreCase(monthName) || shortName.equalsIgnoreCase(monthName)) {
				return month.getValue();
			}
		}

		return -1; // Invalid month name
	}

	public static boolean areAllTheDatesInChronologicalOrder(List<String> dateList, String datePattern) throws ParseException {
		Date date1, date2;
		boolean isDatesAreChronologicalOrder = false;
		System.out.println("List of dates - " + dateList);
		for (int i = 0; i < dateList.size() - 1; i++) {
			date1 = convertStringToDateFormat(datePattern, dateList.get(i));
			date2 = convertStringToDateFormat(datePattern, dateList.get(i + 1));
			if (!(date1.compareTo(date2) < 0)) {
				if (dateList.get(i).split(":")[0].startsWith("0") && datePattern.equalsIgnoreCase("HH:mm")) {
					date1 = convertStringToDateFormat("d MMM y, HH:mm:ss", BDDCommonUtil.addSubtractFromAnyGivenDate(date1, "d MMM y, HH:mm:ss", 0, 0, 1, 0, 0, 0));
					System.out.println(date1 + " and " + date2);
				}
				if (dateList.get(i + 1).split(":")[0].startsWith("0") && datePattern.equalsIgnoreCase("HH:mm")) {
					date2 = convertStringToDateFormat("d MMM y, HH:mm:ss", BDDCommonUtil.addSubtractFromAnyGivenDate(date2, "d MMM y, HH:mm:ss", 0, 0, 1, 0, 0, 0));
					System.out.println(date1 + " and " + date2);
				}
			}
			isDatesAreChronologicalOrder = (date1.compareTo(date2) < 0);
			if (date1.compareTo(date2) >= 0) {
				System.out.println("Date 1 : " + dateList.get(i) + " does not occur before Date 2 : " + dateList.get(i + 1) + ". So Dates are not in chronological order");
				break;
			}
		}
		return isDatesAreChronologicalOrder;
	}

	public static boolean isTheGivenDateInTheRangeBetweenStartAndEndDate(String startDate, String endDate, String givenDate, String datePattern) throws ParseException {
		Date dateToBeChecked = convertStringToDateFormat(datePattern, givenDate);
		Date minDate = convertStringToDateFormat(datePattern, startDate);
		Date maxDate = convertStringToDateFormat(datePattern, endDate);
		if (!(dateToBeChecked.after(minDate) && dateToBeChecked.before(maxDate))) {
			if (givenDate.split(":")[0].startsWith("0") && datePattern.equalsIgnoreCase("HH:mm")) {
				dateToBeChecked = convertStringToDateFormat("d MMM y, HH:mm:ss", BDDCommonUtil.addSubtractFromAnyGivenDate(dateToBeChecked, "d MMM y, HH:mm:ss", 0, 0, 1, 0, 0, 0));
				System.out.println(dateToBeChecked + " and " + minDate + " and " + maxDate);
			}
			if (startDate.split(":")[0].startsWith("0") && datePattern.equalsIgnoreCase("HH:mm")) {
				minDate = convertStringToDateFormat("d MMM y, HH:mm:ss", BDDCommonUtil.addSubtractFromAnyGivenDate(minDate, "d MMM y, HH:mm:ss", 0, 0, 1, 0, 0, 0));
				System.out.println(dateToBeChecked + " and " + minDate + " and " + maxDate);
			}
			if (endDate.split(":")[0].startsWith("0") && datePattern.equalsIgnoreCase("HH:mm")) {
				maxDate = convertStringToDateFormat("d MMM y, HH:mm:ss", BDDCommonUtil.addSubtractFromAnyGivenDate(maxDate, "d MMM y, HH:mm:ss", 0, 0, 1, 0, 0, 0));
				System.out.println(dateToBeChecked + " and " + minDate + " and " + maxDate);
			}
		}
		return dateToBeChecked.after(minDate) && dateToBeChecked.before(maxDate);
	}

	public static String getDateTimeInGivenTimezone(Date givenDate, String dateFormat, String timezone) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(givenDate);
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		//Here set the given timezone.
		sdf.setTimeZone(TimeZone.getTimeZone(timezone));
		//Will print in given timezone
		System.out.println(sdf.format(calendar.getTime()));
		return sdf.format(calendar.getTime());
	}

	public static boolean isDifferenceBetweenEachIntegerElementIsSame(List<Integer> numbers, int differenceBetweenEachNumber) {
		boolean flag = false;
		for (int i = 1; i < numbers.size(); i++) {
			long diff = numbers.get(i) - numbers.get(i - 1);
			if (diff == differenceBetweenEachNumber) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static boolean isIntervalBetweenEachDateElementIsSame(List<String> time, int interval) {
		boolean flag = false;
		for (int i = 1; i < time.size(); i++) {
			long diff = differenceBetweenTwoDatesInDaysInSeconds(time.get(i-1), time.get(i), "HH:mm");
			if (diff == interval) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static JSONObject createJsonObjectWithKeyValue(String labParameterKey, String labParameterValue, String regex) {
		JSONObject jsonObject = new JSONObject();
		String[] labParameterJsonValues = labParameterValue.split(regex);
		String[] labParameterJsonKeys = labParameterKey.split(regex);
		for(int i=0;i<labParameterJsonValues.length;i++){
			jsonObject.put(labParameterJsonKeys[i], labParameterJsonValues[i]);
		}
		return jsonObject;
	}

	public static JSONObject updateValueInInputJSON(String payloadPath, String keys, String values) throws IOException, org.json.simple.parser.ParseException {
		JSONObject jsonObject;
		InputStream inStream = BDDCommonUtil.class.getResourceAsStream(payloadPath);
		assert inStream != null;
		InputStreamReader reader = new InputStreamReader(inStream);
		JSONParser parser = new JSONParser();
		jsonObject = (JSONObject) parser.parse(reader);
		String[] keyNames = keys.split(";");
		String[] valueNames = values.split(";");
		for (int i = 0; i <= keyNames.length - 1; i++) {
			jsonObject.put(keyNames[i], valueNames[i]);
		}
		return jsonObject;
	}

	public static JSONObject readJSONFromFile(String jsonFilePath) throws IOException, org.json.simple.parser.ParseException {
		JSONObject jsonObject;
		InputStream inStream = BDDCommonUtil.class.getResourceAsStream(jsonFilePath);
		assert inStream != null;
		InputStreamReader reader = new InputStreamReader(inStream);
		JSONParser parser = new JSONParser();
		jsonObject = (JSONObject) parser.parse(reader);
		return jsonObject;
	}

	public static JSONObject readJSONData(String JsonData) throws IOException, org.json.simple.parser.ParseException {
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		jsonObject = (JSONObject) parser.parse(JsonData);
		return jsonObject;
	}


	public static String getDateTimeInExpectedFormat(String sampleCollectionDateTime, String formatterPattern) {

		ZonedDateTime zonedDateTime = ZonedDateTime.parse(sampleCollectionDateTime);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatterPattern);
		return zonedDateTime.format(formatter.withZone(ZoneId.of("Asia/Kolkata")));
	}



	public static boolean hashMapComparator(HashMap<String, HashMap<String, String>> actualPanelGridDetails,
									  HashMap<String, HashMap<String, String>> expectedPanelGridDetails) {

		if(actualPanelGridDetails == null || expectedPanelGridDetails==null){
			return false;
		}

		if(actualPanelGridDetails.size() != expectedPanelGridDetails.size()){
			return false;
		}

		for(String key : actualPanelGridDetails.keySet()) {
			if (!expectedPanelGridDetails.containsKey(key)) {
				return false;
			}

			HashMap<String, String> innerMap1 = actualPanelGridDetails.get(key);
			HashMap<String, String> innerMap2 = expectedPanelGridDetails.get(key);
			if(!compareTwoStringHashMapsData(innerMap1, innerMap2)){
				return false;
			}
		}
		return true;
	}

	public static boolean compareTwoStringHashMapsData(HashMap<String, String> map1, HashMap<String, String> map2) {

		if(map1 == null || map2==null){
			return false;
		}

		if(map1.size() != map2.size()){
			return false;
		}
		for(String key : map1.keySet()) {
			if(!map2.containsKey(key) || !map1.get(key).equals(map2.get(key))){
				System.out.println(key + " : " + map1.get(key) + " : " + map2.get(key));
				return false;
			}
		}
		return true;
	}

	public static String convertEpochDateTimeToLocalDateTime(String epochDateTime, String dateTimeFormat){
		Date date = new Date(Long.parseLong(epochDateTime));
		DateFormat format = new SimpleDateFormat(dateTimeFormat);
		return format.format(date);
	}

	public static String formDateTimeStamp(String[] expectedDate, String[] expectedTime){
		String finalDate="", finalTime="";
		if(expectedDate!= null){
			int expectedDay = Integer.parseInt(expectedDate[0]);
			int expectedMonth = BDDCommonUtil.getMonthValue(expectedDate[1]);
			int expectedYear = Integer.parseInt(expectedDate[2]);
			finalDate = expectedYear + "-" + expectedMonth + "-" + expectedDay;
		}

		if(expectedTime != null){
			int expectedHour = Integer.parseInt(expectedTime[0]);
			int expectedMinute = Integer.parseInt(expectedTime[1]);
			int expectedSecond = Integer.parseInt(expectedTime[2]);
			finalTime =expectedHour +":"+ expectedMinute + ":" + expectedSecond;
		}

		return finalDate+ " " + finalTime;

	}

	public static String fetchCurrentTimeZone() {

		String timeZone = null;
		try{
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "tzutil /g");
			pb.redirectErrorStream(true);

			Process process = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			timeZone = reader.readLine();

			int exitCode = process.waitFor();
			if (exitCode != 0) {
				System.out.println("Error fetching timezone");
			}

			return timeZone;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeZone;
	}


	public static void changeTimeZone(String timezone) {

		try{
			String command = "tzutil /s \"" + timezone + "\"";

			ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", command);
			pb.redirectErrorStream(true);

			Process process = pb.start();
			printErrorStream(process);

			int exitCode = process.waitFor();
			if (exitCode == 0) {
				System.out.println("TimeZone changed to :" + timezone);
			} else {
				System.out.println("Error changing timezone");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printErrorStream(Process process) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void changeSystemDate(String dateCommand) {
		try{

			String[] datecmd = { "cmd.exe", "/c", dateCommand};

			Process dateProcess = Runtime.getRuntime().exec(datecmd);
			int dateExitCode = dateProcess.waitFor();
			if( dateExitCode !=0){
				System.out.println("Error executing Date change command");
				BDDCommonUtil.printErrorStream(dateProcess);
			}
			System.out.println("Changed Date to: " + dateCommand);

		}  catch(Exception e){
			e.printStackTrace();
		}
	}
	public static String convertUTCDateTimeFormat(String dateTime,String desiredFormat){
		String date=(dateTime.split("T"))[0];
		return date+" "+(dateTime.split("T"))[1].substring(0,8);
	}

	public static String getCurrentUTCDate(){
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM").withZone(ZoneOffset.UTC);
        return ZonedDateTime.now(ZoneOffset.UTC).format(dateFormatter);
    }
	public static String getCurrentUTCTime(){
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm").withZone(ZoneOffset.UTC);
		return ZonedDateTime.now(ZoneOffset.UTC).format(timeFormatter);
	}

	public static String formatForBreaksContainerDateAndTextLabels(String inputDateTime) {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("' at' HH:mm 'on' MMM d, yyyy");
		LocalDateTime dateTime = LocalDateTime.parse(inputDateTime, inputFormatter);
		return dateTime.format(outputFormatter);
	}

	public static String getUTCDateTime(String type, int amount) {
		ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);
		switch (type.toLowerCase()) {
			case "current date":
				return utcNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			case "minute":
				return utcNow.minusMinutes(amount)
						.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			case "hour":
				return utcNow.minusHours(amount)
						.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			case "day":
				return utcNow.minusDays(amount)
						.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			default:
				throw new IllegalArgumentException("Invalid type: " + type +
						". Use currentdate, minute, hour, day");
		}
	}
}
