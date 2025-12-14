@Component:FHR-MPVSlot
Feature: Fetal-Heart-Rate-MPVSlot

Narrative:Kyma Mobile application shall be able to integrate all the components such as Patient Banner, numerics, Alarm widget and FHR Strip in FHR-MPVSlot

  @integration
  @functional
  @crs_604
  @srs_421

Scenario Outline: Verify all the components patient banner, Alarm widget,FHR Strip and Condensed Numeric were integrated in the FHR-MPVSlot

Given discharge all patients
When  admit '1' patients
And click on the MPV dropdown and Select 'MPV FHRSlot'
And publish numerics '<parameter>' subparameter '<numerics>' with value '<values>' UOM '<uom>' SampleInterval '<sampleInterval>' and invalidLE '<numericInvalidLE>'

#Validate the Patient Banner along with chervon icon and Tap gesture
Then verify patient with name 'DOE, JOHN0' is available
Then Verify Patient Icon is available
Then Verify AlarmWidgetNotDisplayed in the Patient Banner
Then Verify ChervoniconNotDisplayed in the Patient Banner
When Open Navigation MPV Menu
When Disable the Patient Banner
And Click on close button
Then Validate patient name 'DOE, JOHN0' is not displayed
When Open Navigation MPV Menu
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '8' times
And Enable the Alarm widget
And Scroll slot '<MPVPage>' 'DOWN' the Navigation Menu '8' times
And Click on close button
Then Verify AlarmWidgetNotDisplayed in the Patient Banner

#Validate the Condensed Numeric enabled and disabled along with numeric values and label is displayed
Then Validate numeric label 'spO2' is displayed
And Validate numeric value '80' is displayed
And Validate numeric label 'ecg' is displayed
And Validate numeric value '89' is displayed
When Open Navigation MPV Menu
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '8' times
And Disable FHR Numerics
And Scroll slot '<MPVPage>' 'DOWN' the Navigation Menu '8' times
And Click on close button
Then Validate numeric label 'spO2' is not displayed
Then Validate numeric value '80' is not displayed

#Validate the FHR Strip enabled and disabled along with uom and Waveforms
Then verify the displayed layout "<FHRStripDisplayed>" with threshold "0.85" in the application
When Open Navigation MPV Menu
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '1' times
And disable FHRStripWidget
And Scroll slot '<MPVPage>' 'DOWN' the Navigation Menu '1' times
And Click on close button
Then verify the displayed layout "<FHRStripNotDisplayed>" with threshold "0.85" in the application
When Open Navigation MPV Menu
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '1' times
And Enable FHRStripWidget
And Scroll slot '<MPVPage>' 'DOWN' the Navigation Menu '1' times
And Click on close button

  Examples:
    | parameter | numerics        | values | uom | sampleInterval | numericInvalidLE | FHRStripDisplayed                           | FHRStripNotDisplayed                               | MPVPage        |
    | spO2;ecg  | satO2;heartRate | 80;89  | %   | 2000           | -32752           | /src/test/resources/Documents/FHRSlot_Strip | /src/test/resources/Documents/FHR_MPVSlot_Disabled | FHR spv drawer |

Scenario Outline: Verify the Badget and bell icon in alarm widget based on the priority in the FHR-MPVSlot Page

Given a patient with 'active','male' and other auto generated data is admitted
And click on the MPV dropdown and Select 'MPV FHRSlot'
And publish numerics '<parameter>' subparameter '<numerics>' with value '<values>' UOM '<uom>' SampleInterval '<sampleInterval>' and invalidLE '<numericInvalidLE>'
And Open Navigation MPV Menu
And Enable the Alarm widget
And Click on Alarm config
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '3' times
And Select the alarm sort order dropdown '<alarmProritySortOpton>'
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '8' times
And Click on Bottom sheet Dropdown
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '1' times
And Update the default height as '20'
And Scroll slot '<MPVPage>' 'DOWN' the Navigation Menu '12' times
And publish alarms parameter '<parameter>' numeric '<numerics>' with priority '<priority>' eventType '<eventType>' type '<type>' eventState '<eventState>' alarmInactState '<alarmInactState>' and physioTech '<physioTech>' and dateTime '<dateTime>'
And Click on close button
Then verify the displayed layout "<MPVAlarmBackgroundPriority>" with threshold "0.50" in the application
Then verify BellIconDisplayed in the AlarmWidget
Then verify BadgetIconDisplayed in the AlarmWidget
When Tap on the Alarm widget PlaceHolder in MPV Page
Then Validate an event 'Remind Me' is displayed
When drag the bottomSheet down '1' close
And Open Navigation MPV Menu
And Click on Alarm config
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '4' times
And Update color '#a4c639' for alarm info priority
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '1' times
And update bellicon '#cd9575' color for alarm info widget
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '5' times
And click on Prefix Icon dropdown and select 'priority' Icon
And Scroll slot '<MPVPage>' 'DOWN' the Navigation Menu '7' times
And click on Prefix Icon size dropdown and select 'large' size
And Scroll slot '<MPVPage>' 'DOWN' the Navigation Menu '1' times
And disable badge icon
And Scroll slot '<MPVPage>' 'DOWN' the Navigation Menu '3' times
And Click on close button
Then verify BadgetIconNotDisplayed in the AlarmWidget
Then verify the displayed layout "<MPVUpdatedPriority>" with threshold "0.85" in the application
And Open Navigation MPV Menu
And Click on Alarm config
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '1' times
And Disable Tap Alarm widget
And Scroll slot '<MPVPage>' 'DOWN' the Navigation Menu '1' times
And Click on close button
When Tap on the Alarm widget PlaceHolder for icon
Then Validate an event 'Remind Me' not displayed

  Examples:
    | parameter | numerics        | values | uom | sampleInterval | numericInvalidLE | priority | eventType | type      | eventState | alarmInactState | physioTech    | dateTime                                            | alarmProritySortOpton | MPVAlarmBackgroundPriority                     | MPVPage        | MPVUpdatedPriority                                    |
    | spO2;ecg  | satO2;heartRate | 60;90  | %   | 2000           | -32752           | low;info | limit     | limitHigh | start      | alarmAckTimed   | physiological | 2025-07-24T15:20:06+05:30;2025-07-24T15:20:06+05:30 | ascByPrio             | /src/test/resources/Documents/FHR_MPV_Priority | FHR spv drawer | /src/test/resources/Documents/FHR_MPV_UpdatedPriority |

Scenario Outline: Verify the hug, fixed behaviour of the card and tap functionality of the patient banner in FHR-MPVSlot

When admit '1' patients
And click on the MPV dropdown and Select 'MPV FHRSlot'
And publish numerics '<parameter>' subparameter '<numerics>' with value '<values>' UOM '<uom>' SampleInterval '<sampleInterval>' and invalidLE '<numericInvalidLE>'

#  Hug Behaviour
And Open Navigation MPV Menu
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '2' times
And disable FHRStripWidget
And Disable FHR Numerics
And Scroll slot '<MPVPage>' 'DOWN' the Navigation Menu '2' times
And Click on close button
Then verify the displayed layout "<CardHugMode>" with threshold "0.85" in the application

#  Card Fixed Behaviour
When Open Navigation MPV Menu
And Update '400,200' card dimensions
And Scroll slot '<MPVPage>' 'UP' the Navigation Menu '1' times
And Scroll slot '<MPVPage>' 'DOWN' the Navigation Menu '2' times
And Click on close button
Then verify the displayed layout "<CardFixedMode>" with threshold "0.85" in the application
When Click on Patient banner
Then Validate SPV 'FHRSlot' page is displayed

  Examples:
    | parameter | numerics        | values | uom | sampleInterval | numericInvalidLE | MPVPage        | CardHugMode                           | CardFixedMode                           |
    | spO2;ecg  | satO2;heartRate | 60;90  | %   | 2000           | -32752           | FHR spv drawer | /src/test/resources/Documents/HugCard | /src/test/resources/Documents/FixedCard |
