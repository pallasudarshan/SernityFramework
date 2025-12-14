@Component:Fetal-Heart-Rate
Feature:Fetal-Heart-Rate

  Scenario Outline: Verify the FHR and MHR Waveforms are displaying as per the configurations

    Given a patient with 'active','male' and other auto generated data is admitted
    Then publish the waveform "<WaveformPayload>" as 'LIVE' waveform
    And navigate to SPV page of admitted patient
    When Click on 'FHR-Strip' tab
    And Click on Hamburger Menu

#Verifying the configvalue and HR strip with uom enabled,Least and high value along with scale label, global icon displayed
    And  click on FhrConfig dropdown and select '<ConfigValue>'
    And Update widthperminutepixed '<widthpermin>'
    And Scroll 'UP' the Navigation Menu '8' times
    And click on update config
    Then verify the displayed layout "<uomenabled>" with threshold "0.85" in the application
    Then verify the displayed layout "<leastValueHRStrip>" with threshold "0.85" in the application
    Then verify the displayed layout "<highvalueHRStrip>" with threshold "0.85" in the application
    Then verify the displayed layout "<scalelabel>" with threshold "0.85" in the application
    Then verify the displayed layout "<globalIconenabled>" with threshold "0.90" in the application
    When Click on Hamburger Menu

##Updating and Verifying icon size, color,uom interval, uom disabled, scaleLabel text color, size, safe range
    And disable the time preview bar
    And  Scroll 'UP' the Navigation Menu '2' times
    And disable the uom
    And Scroll 'UP' the Navigation Menu '4' times
    And click on update config
    When Click on Hamburger Menu
    And enable the time preview bar
    And Scroll 'UP' the Navigation Menu '6' times
    And click on update config
    When Click on Hamburger Menu
    And  Scroll 'UP' the Navigation Menu '1' times
    And Update Icon color '#873600'
    And click on iconsize dropdown and select '12.0' size
    And Scroll 'UP' the Navigation Menu '2' times
    And Update scale label text size '12'
    And Update scale label text color '#a9cce3'
    And Scroll 'UP' the Navigation Menu '1' times
    And Update Ymin '60' and Ymax '300' with default uom interval
    And  Scroll 'UP' the Navigation Menu '2' times
    And click on update config
    Then verify the displayed layout "<globalIconColor>" with threshold "0.90" in the application
    Then verify the displayed layout "<scalelabeltextcolor>" with threshold "0.85" in the application
    Then verify the displayed layout "<secondlowvalue>" with threshold "0.90" in the application
    Then verify the displayed layout "<secondhighvalue>" with threshold "0.90" in the application
    Then verify the displayed layout "<uomdisabled>" with threshold "0.85" in the application
    Then verify the displayed layout "<saferange>" with threshold "0.85" in the application
    When Click on Hamburger Menu
    And  Scroll 'UP' the Navigation Menu '3' times
    And  enable the uom
    And Scroll 'UP' the Navigation Menu '4' times

#Updating and verifyingDefault waveForm orders, color   for FHR1,FHR2,FHR3 and MHR
    And click on update config
    Then verify the displayed layout "<waveformorderandcolor>" with threshold "0.65" in the application
    When Click on Hamburger Menu
    And Scroll 'UP' the Navigation Menu '8' times
    And Update the waveform color '#196f3d,fhr1,1,1,#d4ac0d,fhr2,2,1,#2e86c1,fhr3,3,1,#196f3d,mhr,4,1'
    And click on update config
    Then verify the displayed layout "<waveformupdatedcolor>" with threshold "0.70" in the application

#Updating and Verifying the viewport, saferange enable and disable
    When Click on Hamburger Menu
    And  Scroll 'UP' the Navigation Menu '1' times
    And disable the Viewport
    And Scroll 'UP' the Navigation Menu '5' times
    And click on update config
    Then verify the displayed layout "<StripViewPort>" with threshold "0.90" in the application
    When Click on Hamburger Menu
    And Scroll 'UP' the Navigation Menu '1' times
    And enable the Viewport
    And Scroll 'UP' the Navigation Menu '6' times
    And disable saferange
    And click on update config
    Then verify the displayed layout "<saferangedisabled>" with threshold "0.75" in the application
    When Click on Hamburger Menu
    And Scroll 'UP' the Navigation Menu '7' times
    And enable saferange
    And Update saferange '120,160'
    And click on update config
    Then verify the displayed layout "<updatedsaferange>" with threshold "0.80" in the application

###Verifying Landscapemode
    When rotate the screen to 'landscape' mode
    Then verify the displayed layout '<landScapeMode>' with threshold "0.65" in the application for orientation

#Rotate to portraitMode
    When rotate the screen to 'portrait' mode

#Verifying the themeing
    When user update the page into 'Dark' theme
    Then verify the displayed layout "<portraitmodedarktheme>" with threshold "0.65" in the application

    Examples:
      | WaveformPayload                         | waveformorderandcolor                                 | uomdisabled                                    | uomenabled                                    | ConfigValue | widthpermin | leastValueHRStrip                                           | highvalueHRStrip                                           | globalIconenabled                                     | scalelabel                                         | globalIconColor                                            | landScapeMode                                    | updatedsaferange                                    | scalelabeltextcolor                               | secondlowvalue                                            | secondhighvalue                                            | saferange                                        | waveformupdatedcolor                                     | portraitmodedarktheme                       | StripViewPort                                       | saferangedisabled                                    |
      | /testData/waveformData_for_FHR_MHR.json | /src/test/resources/Documents/waveFormOrder_Color_3cm | /src/test/resources/Documents/uom_disabled_3cm | /src/test/resources/Documents/uom_enabled_3cm | 3CM         | 30          | /src/test/resources/Documents/default_secondLeast_Value_3cm | /src/test/resources/Documents/default_secondHigh_Value_3cm | /src/test/resources/Documents/global_Icon_enabled_3cm | /src/test/resources/Documents/Scale_labelValue_3cm | /src/test/resources/Documents/global_Icon_colorUpdated_3cm | /src/test/resources/Documents/landscape_Mode_3cm | /src/test/resources/Documents/updated_saferange_3cm | /src/test/resources/Documents/Scale_textColor_3cm | /src/test/resources/Documents/updated_secondLow_Value_3cm | /src/test/resources/Documents/updated_secondHigh_Value_3cm | /src/test/resources/Documents/safeRangeValue_3cm | /src/test/resources/Documents/updated_waveFormColor_3cm  | /src/test/resources/Documents/darkTheme_3cm | /src/test/resources/Documents/viewport_disabled_3cm | /src/test/resources/Documents/saferange_disabled_3cm |
      | /testData/waveformData_for_FHR_MHR.json | /src/test/resources/Documents/waveFormOrder_Color_1cm | /src/test/resources/Documents/uom_disabled_1cm | /src/test/resources/Documents/uom_enabled_1cm | 1CM         | 28          | /src/test/resources/Documents/least_value_1cm               | /src/test/resources/Documents/highest_value_1cm            | /src/test/resources/Documents/global_Icon_enabled_1cm | /src/test/resources/Documents/scale_LabelValue_1cm | /src/test/resources/Documents/global_Icon_colorUpdated_1cm | /src/test/resources/Documents/landscape_Mode_1cm | /src/test/resources/Documents/updated_saferange_1cm | /src/test/resources/Documents/Scale_textColor_1cm | /src/test/resources/Documents/updated_secondLow_Value_1cm | /src/test/resources/Documents/updated_secondHigh_Value_1cm | /src/test/resources/Documents/safeRangeValue_1cm | /src/test/resources/Documents/updated_waveForm_Color_1cm | /src/test/resources/Documents/darkTheme_1cm | /src/test/resources/Documents/viewport_disabled_1cm | /src/test/resources/Documents/saferange_disabled_1cm |



