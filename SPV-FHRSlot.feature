@Component:FHR-SPVSlot
Feature: Fetal-Heart-Rate-Slot

Narrative:Kyma Mobile application shall be able to integrate all the components such as Patient Banner, numerics, Alarm widget and FHR Strip in FHR-SPVSlot

  @integration
  @functional
  @crs_604
  @srs_421

Scenario Outline: Verify all the components patient banner, Alarm widget,FHR Strip and Condensed Numeric were integrated in the FHR-SPVSlot

Given discharge all patients
And admit '1' patients
And Open 'Patient-0' in SPV
And Click on 'FHR-Slot' tab
And publish numerics '<parameter>' subparameter '<numerics>' with value '<values>' UOM '<uom>' SampleInterval '<sampleInterval>' and invalidLE '<numericInvalidLE>'
#Patient Banner
Then verify patient with name 'DOE, JOHN0' is available
Then Verify AlarmWidgetNotDisplayed in the Patient Banner
And Tap on Chevron Icon
Then verify "Regional Medical Center" available
And Tap on uncollapsed Chevron Icon
Then verify "Regional Medical Center" is not available
When Open Navigation Menu
When Disable the Patient Banner
And Click on close button
Then Validate patient name 'DOE, JOHN0' is not displayed
When Open Navigation Menu
And Enable the patient Banner
And Enable FHR Numerics
And Click on close button
Then Verify AlarmWidgetNotDisplayed in the Patient Banner

#Condensed Numeric
Then Validate numeric label 'NIBP' is displayed
Then Validate numeric value '60' is displayed
Then Validate numeric value '90' is displayed
Then Validate numeric value '100' is displayed
When Open Navigation Menu
And Scroll slot '<SPVPage>' 'UP' the Navigation Menu '8' times
And Disable FHR Numerics
And Scroll slot '<SPVPage>' 'DOWN' the Navigation Menu '8' times
And Click on close button
Then Validate numeric label 'NIBP' is not displayed
Then Validate numeric value '60' is not displayed
Then Validate numeric value '90' is not displayed
Then Validate numeric value '100' is not displayed

#Validate the FHR Strip enabled and disabled along with uom and Waveforms
Then verify the displayed layout "<FHRStripDisplayed>" with threshold "0.85" in the application
When Open Navigation Menu
And Scroll slot '<SPVPage>' 'UP' the Navigation Menu '1' times
And disable FHRStripWidget
And Scroll slot '<SPVPage>' 'DOWN' the Navigation Menu '1' times
And Click on close button
Then verify the displayed layout "<FHRStripNotDisplayed>" with threshold "0.85" in the application
And Open Navigation Menu
And Scroll slot '<SPVPage>' 'UP' the Navigation Menu '1' times
And Enable FHRStripWidget
And Scroll slot '<SPVPage>' 'DOWN' the Navigation Menu '1' times
And Click on close button


  Examples:
    | parameter | numerics                | values    | uom  | sampleInterval | numericInvalidLE | FHRStripDisplayed                           | FHRStripNotDisplayed                        | SPVPage             |
    | NIBP      | systolic;diastolic;mean | 60;90;100 | mmHg | 2000           | -32752           | /src/test/resources/Documents/FHRSlot_Strip | /src/test/resources/Documents/StripDisabled | FHR Slot spv drawer |


Scenario Outline: Verify the badget and bell icon in the alarm widget based on the priority in the FHR-SPVSlot Page

Given a patient with 'active','male' and other auto generated data is admitted
And navigate to SPV page of admitted patient
And Click on 'FHR-Slot' tab
And publish numerics '<parameter>' subparameter '<numerics>' with value '<values>' UOM '<uom>' SampleInterval '<sampleInterval>' and invalidLE '<numericInvalidLE>'
And Open Navigation Menu
And Enable the Alarm widget
And Click on Alarm config
And Scroll slot '<SPVPage>' 'UP' the Navigation Menu '3' times
And Select the alarm sort order dropdown '<alarmProritySortOpton>'
And Scroll 'DOWN' the Navigation Menu '8' times
And Click on close button
When publish alarms parameter '<parameter>' numeric '<numerics>' with priority '<priority>' eventType '<eventType>' type '<type>' eventState '<eventState>' alarmInactState '<alarmInactState>' and physioTech '<physioTech>' and dateTime '<dateTime>'
Then verify the displayed layout "<AlarmBackgroundPriority>" with threshold "0.85" in the application
And Open Navigation Menu
And Click on Alarm config
And Scroll slot '<SPVPage>' 'UP' the Navigation Menu '1' times
And Disable Tap Alarm widget
And Scroll slot '<SPVPage>' 'DOWN' the Navigation Menu '4' times
And Click on close button
Then verify BellIconDisplayed in the AlarmWidget
Then verify BadgetIconDisplayed in the AlarmWidget
When Tap on the Alarm widget
Then Validate an event 'Remind Me' not displayed
And Open Navigation Menu
And Click on Alarm config
And Scroll slot '<SPVPage>' 'UP' the Navigation Menu '1' times
And Enable Tap Alarm widget
And Scroll slot '<SPVPage>' 'UP' the Navigation Menu '3' times
And click on Prefix Icon size dropdown and select 'large' size
And Update color '#9966cc' for alarm priority
And Scroll slot '<SPVPage>' 'UP' the Navigation Menu '1' times
And update bellicon '#008000' color for alarm widget
And Scroll slot '<SPVPage>' 'UP' the Navigation Menu '5' times
And click on Prefix Icon dropdown and select 'priority' Icon
And Scroll slot '<SPVPage>' 'DOWN' the Navigation Menu '8' times
And disable badge icon
And Scroll slot '<SPVPage>' 'DOWN' the Navigation Menu '3' times
And Click on close button
Then verify BadgetIconNotDisplayed in the AlarmWidget
Then verify the displayed layout "<AlarmBackgroundUpdatedPriority>" with threshold "0.85" in the application
When Tap on the Alarm widget PlaceHolder
Then Validate an event 'Remind Me' is displayed

    Examples:
      | parameter | numerics                | values    | uom  | sampleInterval | numericInvalidLE | priority        | eventType | type      | eventState | alarmInactState | physioTech    | dateTime                  | alarmProritySortOpton | AlarmBackgroundPriority                            | AlarmBackgroundUpdatedPriority                           | SPVPage             |
      | NIBP      | systolic;diastolic;mean | 60;90;100 | mmHg | 2000           | -32752           | high;low;medium | limit     | limitHigh | start      | alarmAckTimed   | physiological | 2025-07-24T15:20:06+05:30 | descByPrio            | /src/test/resources/Documents/FHRSlot_HighPriority | /src/test/resources/Documents/FHRSlot_Updated_high_Color | FHR Slot spv drawer |


Scenario: Verify the alarm widget badget count in FHR-SPVSlot

Given a patient with 'active','male' and other auto generated data is admitted
And navigate to SPV page of admitted patient
And Click on 'FHR-Slot' tab
And Open Navigation Menu
And Enable the Alarm widget
And Click on close button
And publish numerics 'spO2' subparameter 'satO2' with value '90' UOM '%' SampleInterval '2000' and invalidLE '-32752'
And publish alarms parameter 'spO2' numeric 'satO2' with priority 'low' eventType 'limit' type 'limitHigh' eventState 'start' alarmInactState 'alarmAckTimed' and physioTech 'physiological' and dateTime '2025-07-24T15:20:06+05:30'
Then Validate badget count '1' is displayed
And publish numerics 'NIBP' subparameter 'systolic;diastolic;mean' with value '92;98;97' UOM 'mmHG' SampleInterval '2000' and invalidLE '-32752'
And publish alarms parameter 'NIBP' numeric 'systolic;diastolic;mean' with priority 'low;high;medium' eventType 'limit' type 'limitHigh' eventState 'start' alarmInactState 'alarmAckTimed' and physioTech 'physiological' and dateTime '2025-07-24T15:20:06+05:30;2025-07-24T15:20:06+05:30;2025-07-24T15:20:06+05:30'
Then Validate badget count '4' is displayed
And publish numerics 'ecg;temp;spO2' subparameter 'heartRate;temp;pulseRate' with value '80;82;90' UOM '%;Cel;%' SampleInterval '2000' and invalidLE '-32752'
And publish alarms parameter 'ecg;temp;spO2' numeric 'heartRate;temp;pulseRate' with priority 'low;high;medium' eventType 'limit' type 'limitHigh' eventState 'start' alarmInactState 'alarmAckTimed' and physioTech 'physiological' and dateTime '2025-07-24T15:20:06+05:30;2025-07-24T15:20:06+05:30;2025-07-24T15:20:06+05:30'
Then Validate badget count '7' is displayed
And publish numerics 'ecg;gasMon;ecgResp' subparameter 'I;CO2-endTidalConc;respRate' with value '92;99;97' UOM '/min;%;{beat}/min' SampleInterval '2000' and invalidLE '-32752'
And publish alarms parameter 'ecg;gasMon;ecgResp' numeric 'I;CO2-endTidalConc;respRate' with priority 'low;high;medium' eventType 'limit' type 'limitHigh' eventState 'start' alarmInactState 'alarmAckTimed' and physioTech 'physiological' and dateTime '2025-07-24T15:20:06+05:30;2025-07-24T15:20:06+05:30;2025-07-24T15:20:06+05:30'
Then Validate badget count '9+' is displayed