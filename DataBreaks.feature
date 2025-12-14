@Component:FHR-slot
Feature:Data Breaks

  Narrative:Kyma Mobile application should be able to open and validate the data breaks with configurations

  @integration
    @functional

  Scenario Outline: Validate data breaks for No Data on FHR Strip in Real-Time and Historic Views
    Given a patient with 'active','male' and other auto generated data is admitted
    Then publish the waveform "<WaveformPayload>" as 'LIVE' waveform
    And navigate to SPV page of admitted patient
    When Click on 'FHR-Slot' tab
    And delete perinatal Heart Rate Waveforms
    And wait for '<WaitTime>'
#     No Data break (live)
#    Then verify the displayed layout "<GreyedOutRegionWithVerticalLines_Config>" with threshold "0.60" in the application
    Then publish the waveform "<WaveformPayload>" as 'LIVE' waveform
    And wait for '<WaitTime>'
#    Then verify the displayed layout "<AfterGreyedOut_waveform_Config>" with threshold "0.85" in the application
    When click on the cheveran button
    And slide towards 'RIGHT' direction  for 3 times
    Then verify the 'FhrGoToButton' availability is 'true'
   #  No Greyed Out in Historic view
    And wait for '<WaitTime>'
#    Then verify the displayed layout "<AfterGreyedOut_waveform_Config>" with threshold "0.85" in the application
    And click on the 'Go/Jump' button
    Then verify the 'FhrGoToButton' availability is 'false'
    Examples:
      | WaveformPayload                         | fhrStrip            | WaitTime | GreyedOutRegionWithVerticalLines_Config | AfterGreyedOut_waveform_Config |
      | /testData/waveformData_for_FHR_MHR.json | FHR Strip_displayed | 60000    | GreyedOutRegionOnlyVerticalLines        | AfterGreyedOut_waveform        |

  Scenario Outline: Validate the session break data on FHR strip
    Given a patient with 'active','male' and other auto generated data is admitted
    And navigate to SPV page of admitted patient
    When Click on 'FHR-Slot' tab
    Given Open Navigation Menu

      #  Validate Session break duration minute
    And Scroll 'UP' through Navigation Menu '1' times
    And click on the 'Fhr Strip Expansion' button
    And Scroll 'UP' through Navigation Menu '1' times
    And Set the start break 'Session Start Time' to 24 'minute' before the current date and time
    And Set the end break 'Session End Time' to 23 'minute' before the current date and time
    And click on the 'Session Break Add' button
    And Scroll 'UP' through Navigation Menu '16' times
    And click on the update config
    When click on the cheveran button
    And slide towards 'RIGHT' direction  for 2 times
    Then rotate the screen to 'landscape' mode
    Then validate break start date and time text is 'true'
    Then validate break end date and time text is 'true'
    Then rotate the screen to 'portrait' mode

    #  Validate Session break duration hours
    Given Open Navigation Menu
    And Scroll 'UP' through Navigation Menu '1' times
    And click on the 'Fhr Strip Expansion' button
    And Scroll 'UP' through Navigation Menu '1' times
    And Set the start break 'Session Start Time' to 2 'hour' before the current date and time
    And Set the end break 'Session End Time' to 29 'minute' before the current date and time
    And click on the 'Session Break Add' button
    And Scroll 'UP' through Navigation Menu '16' times
    And click on the update config
    Then rotate the screen to 'landscape' mode
    Then validate break start date and time text is 'true'
    Then validate break end date and time text is 'true'
    Then rotate the screen to 'portrait' mode

      #  updating Session break all elements size's, color's & Icon's,
    Given Open Navigation Menu
    And Scroll 'UP' through Navigation Menu '1' times
    And click on the 'Fhr Strip Expansion' button
    And Scroll 'UP' through Navigation Menu '5' times
    And update the 'Session Break Container Width' to a "<sessionBreakContainerWidth>"

      #  Start and End text's are multi language support [french language start-commencer, End Fin] and truncation should not happened.
    And update the 'Session Break Start Text' to a 'commencer'
    And update the 'Session Break End Text' to a 'Fin'
    And update the 'Session Break Container Bg' to a "<sessionBreakBgColor>"
    And update the 'Session Break Date Value color' to a "<sessionBreakTimeColor>"
    And update the 'Session Break Date Label color' to a "<sessionBreakTextColor>"
    And update the 'Session Break Data Separator Color' to a "<sessionBreakDataSeparatorColor>"
    And select the 'Session Break Right Icon' dropdown "<sessionBreakStartIcon>" option
    And select the 'Session Break Left Icon' dropdown "<sessionBreakEndIcon>" option
    And Scroll 'UP' through Navigation Menu '2' times
    And update the 'Fhr Strip Height' to a "<FhrGridHeight>"
    And Scroll 'UP' through Navigation Menu '10' times
    And click on the update config
    When click on the cheveran button
    Then rotate the screen to 'landscape' mode
    Then verify the displayed layout "/src/test/resources/Documents/SessionBreakContainer_Height_Width_BackGroundColor_EndAndStart_TextAndTimeColorsAlongWithIcon_Image" with threshold "0.95" in the application

    #  Validating the Session break white dotted line in the Dark Theme
    When user update the page into 'Dark' theme
    Then verify the displayed layout "/src/test/resources/Documents/WhiteColorDottedLines_Image" with threshold "0.85" in the application
    Then rotate the screen to 'portrait' mode
    Examples:
      | sessionBreakTextColor | sessionBreakTimeColor | sessionBreakStartIcon                   | sessionBreakEndIcon                       | sessionBreakContainerWidth | FhrGridHeight | sessionBreakBgColor | sessionBreakDataSeparatorColor |
      | #323EED               | #D232ED               | Session RightIconPath_DropdownItem_sync | Session LeftIconPath_DropdownItem_battery | 150                        | 45            | #CEF5F1             | #FF000B                        |

  Scenario Outline: Validate the visit break data on FHR strip
    Given a patient with 'active','male' and other auto generated data is admitted
    And navigate to SPV page of admitted patient
    When Click on 'FHR-Slot' tab

     #  Validate Session break duration day
    Given Open Navigation Menu
    And Scroll 'UP' through Navigation Menu '1' times
    And click on the 'Fhr Strip Expansion' button
    And Scroll 'UP' through Navigation Menu '1' times
    And Set the start break 'Visit Start Time' to 5 'hour' before the current date and time
    And Set the end break 'Visit End Time' to 23 'minute' before the current date and time
    And click on the 'Visit Break Add' button
    And Scroll 'UP' through Navigation Menu '16' times
    And click on the update config
    When click on the cheveran button
    And slide towards 'RIGHT' direction  for 2 times
    When click on the cheveran button
    Then rotate the screen to 'landscape' mode
    Then validate break start date and time text is 'true'
    Then validate break end date and time text is 'true'
    Then rotate the screen to 'portrait' mode

      #  updating Session break all elements size's, color's & Icon's,
    Given Open Navigation Menu
    And Scroll 'UP' through Navigation Menu '1' times
    And click on the 'Fhr Strip Expansion' button
    And Scroll 'UP' through Navigation Menu '6' times

    #  Start and End text's are multi language support [french language start-commencer, End Fin] and truncation should not happened.
    And update the 'Visit Break Start Text' to a 'commencer'
    And update the 'Visit Break End Text' to a 'Fin'
    And select the 'Visit Break Right Icon' dropdown "<visitBreakStartIcon>" option
    And select the 'Visit Break Left Icon' dropdown "<visitBreakEndIcon>" option
    And update the 'Visit Break Container Width' to a "<visitBreakContainerWidth>"
    And update the 'Visit break Container Bg' to a "<visitBreakContainerBgColor>"
    And update the 'Visit Break Date Value Color' to a "<visitBreakTimeColor>"
    And update the 'Visit Break Date Label Color' to a "<visitBreakTextColor>"
    And update the 'Visit Break Data Separator Color' to a "<sessionBreakDataSeparatorColor>"
    And update the 'Fhr Strip Height' to a "<FhrGridHeight>"
    And Scroll 'UP' through Navigation Menu '9' times
    And click on the update config
    Then rotate the screen to 'landscape' mode
    Then verify the displayed layout "/src/test/resources/Documents/VisitBreakZigZagImage" with threshold "0.85" in the application
    Then verify the displayed layout "/src/test/resources/Documents/VisitBreakContainer_Height_Width_BackGroundColor_EndAndStart_TextAndTimeColorsAlongWithIcon_Image" with threshold "0.85" in the application

      #   Validating the Visit break white dotted line in the Dark Theme
    When user update the page into 'Dark' theme
    Then verify the displayed layout "/src/test/resources/Documents/WhiteColorDottedLines_Image" with threshold "0.85" in the application
    Then rotate the screen to 'portrait' mode
    Examples:
      | FhrGridHeight | visitBreakTextColor | visitBreakTimeColor | visitBreakStartIcon                   | visitBreakEndIcon                       | visitBreakContainerWidth | visitBreakContainerBgColor | sessionBreakDataSeparatorColor |
      | 45            | #323EED             | #D232ED             | Visit RightIconPath_DropdownItem_sync | Visit LeftIconPath_DropdownItem_battery | 260                      | #CEF5F1                    | #FF000B                        |


  Scenario Outline:Validate the functionalities of the Go/Live Navigation button, Baseline indicator, and Monitor & Mark Line indicator
    Given a patient with 'active','male' and other auto generated data is admitted
    And navigate to SPV page of admitted patient
    When Click on 'FHR-Slot' tab
    Given Open Navigation Menu
    And Scroll 'UP' through Navigation Menu '1' times
    And click on the 'Fhr Strip Expansion' button
    And Scroll 'UP' through Navigation Menu '2' times
    And Set the 'Mark Line' to 4 'minute' before the current date and time
    And click on the 'Mark Line Add' button
    And Set the 'Monitor Status' to 3 'minute' before the current date and time
    And click on the 'Monitor Status Add' button
    And Scroll 'UP' through Navigation Menu '15' times
    And click on update config
    Then verify the displayed layout "/src/test/resources/Documents/MarkLineIndicatorImage" with threshold "0.80" in the application
    Then verify the displayed layout "/src/test/resources/Documents/MonitorLineIndicatorImage" with threshold "0.80" in the application
    Given Open Navigation Menu
    And Scroll 'UP' through Navigation Menu '1' times
    And click on the 'Fhr Strip Expansion' button
    And Scroll 'UP' through Navigation Menu '4' times
    And click on the 'Mark Line Indicator' checkbox
    And click on the 'Monitor Indicator' checkbox
    And Scroll 'UP' through Navigation Menu '15' times
    And click on update config
    Then verify that the application component "/src/test/resources/Documents/MarkLineIndicatorImage" with threshold "0.15" is not displayed in the application within 20 seconds
    Then verify that the application component "/src/test/resources/Documents/MonitorLineIndicatorImage" with threshold "0.15" is not displayed in the application within 20 seconds
    When click on the cheveran button
    And slide towards 'RIGHT' direction  for 3 times

      # Validate the Go button configurations
    Then verify the 'FhrGoToButton' availability is 'true'
    Given Open Navigation Menu
    And Scroll 'UP' through Navigation Menu '1' times
    And click on the 'Fhr Strip Expansion' button
    And Scroll 'UP' through Navigation Menu '14' times
    And update the 'Jump Button Bg Color' to a "<jumpButtonBgColor>"
    And update the 'Jump Button Border color' to a "<jumpButtonBorderColor>"
    And update the 'Jump Button Icon Color' to a "<jumpButtonIconColor>"
    And select the 'Jump Button Icon Size' dropdown "<LiveNavigationButtonIconSize>" option
    And Scroll 'UP' through Navigation Menu '2' times
    And click on update config
    Then verify the displayed layout "/src/test/resources/Documents/JumpButtonBackGroundAndBorderAndIconColor_With_Size_Image" with threshold "0.85" in the application

    # Validating the jump button in the LandScope Mode
    When click on the cheveran button
    Then rotate the screen to 'landscape' mode
    Then verify the displayed layout "/src/test/resources/Documents/JumpButtonBackGroundAndBorderAndIconColor_With_Size_Image" with threshold "0.85" in the application
    Then rotate the screen to 'portrait' mode

    # Validate the baseline indicator configurations and the baseline in the Historic page
    Given Open Navigation Menu
    And Scroll 'UP' through Navigation Menu '1' times
    And click on the 'Fhr Strip Expansion' button
    And Scroll 'UP' through Navigation Menu '14' times
    And click on the 'Baseline Indicator' checkbox
    And Scroll 'UP' through Navigation Menu '1' times
    And update the 'Left Handler Size' to a "<LeftHandlerSize>"
    And update the 'Left Handler Bg Color' to a "<LeftHandlerBgColor>"
    And update the 'Left Handler Border Color' to a "<LeftHandlerBorderColor>"
    And update the 'Inner Line color' to a "<InnerLineColor>"
    And update the 'Inner Line Stroke Width' to a "<InnerLineStrokeWidth>"
    And update the 'Reader Text Size' to a "<ReaderTextSize>"
    And update the 'Reader Dimensions' to a "<ReaderDimension>"
    And update the 'Reader Bg Color' to a "<ReaderBgColor>"
    And update the 'Reader Border Color' to a "<ReaderBorderColor>"
    And update the 'Reader Text Color' to a "<ReaderTextColor>"
    And Scroll 'UP' through Navigation Menu '1' times
    And click on update config
    Then verify the 'Baseline indicator reader' availability is 'true'
    Then verify the displayed layout "/src/test/resources/Documents/BaseLine_LeftHandler_And_Reader_BackgroundAndBorderAndTextColor_AndTextSizes_Image" with threshold "0.85" in the application
    And drag the 'Baseline indicator reader' to the 'DOWN' side
    Then verify the displayed layout "/src/test/resources/Documents/ReaderDisplaysHeartRateValue_displayed" with threshold "0.85" in the application
    And drag the 'Baseline indicator leftHandler' to the 'UP' side
    Then verify the displayed layout "/src/test/resources/Documents/ReaderDisplaysHighHeartRateValue_displayed" with threshold "0.85" in the application

    # Validate the presence of the baseline indicator in Live And Go/Jump Button should disappear
    And click on the 'Go/Jump' button
    Then verify the 'Baseline indicator reader' availability is 'true'
    Then verify the 'FhrGoToButton' availability is 'false'

  # Validate OFF configuration for baseline visibility
    Given Open Navigation Menu
    And Scroll 'UP' through Navigation Menu '1' times
    And click on the 'Fhr Strip Expansion' button
    And Scroll 'UP' through Navigation Menu '14' times
    And click on the 'Uncheck Baseline Indicator' checkbox
    And Scroll 'UP' through Navigation Menu '2' times
    And click on update config
    Then verify the 'Baseline indicator reader' availability is 'false'

    #  Allow slide gesture to view past data; gesture configurable OFF
    Given Open Navigation Menu
    And Scroll 'UP' through Navigation Menu '1' times
    And click on the 'Fhr Strip Expansion' button
    And Scroll 'UP' through Navigation Menu '3' times
    And click on the 'Historic View Enable/Disable Gesture' button
    And Scroll 'UP' through Navigation Menu '15' times
    And click on update config
    When click on the cheveran button
    And slide towards 'RIGHT' direction  for 2 times
    Then verify the 'FhrGoToButton' availability is 'false'

    #  Allow slide gesture to view past data; gesture configurable ON
    Given Open Navigation Menu
    And Scroll 'UP' through Navigation Menu '1' times
    And click on the 'Fhr Strip Expansion' button
    And Scroll 'UP' through Navigation Menu '3' times
    And click on the 'Historic View Enable/Disable Gesture' button
    And Scroll 'UP' through Navigation Menu '17' times
    And click on update config
    And slide towards 'RIGHT' direction  for 4 times
    Then verify the 'FhrGoToButton' availability is 'true'

    Examples:
      | jumpButtonBgColor | jumpButtonBorderColor | jumpButtonIconColor | LiveNavigationButtonIconSize                   | LeftHandlerSize | LeftHandlerBgColor | LeftHandlerBorderColor | InnerLineColor | InnerLineStrokeWidth | ReaderTextSize | ReaderDimension | ReaderBgColor | ReaderBorderColor | ReaderTextColor |
      | #F5273F           | #2735F5               | #42F527             | LiveNavigationButtonIconSize_DropdownItem_32.0 | 17.0,35.0       | #60909             | #2727F5                | #0EE66F        | 2                    | 16             | 40.0,20.0       | #D40EE6       | #E60E36           | #0E2BE6         |