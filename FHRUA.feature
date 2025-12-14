@Component:FHR
Feature: FHR

    Scenario Outline: Verify the UA Waveform is displaying as per the configurations

    Given a patient with 'active','male' and other auto generated data is admitted
    Then publish the waveform '<waveformPayload>' as 'LIVE' waveform
    And navigate to SPV page of admitted patient
#   Given Open 'Patient-0' in SPV
    When Click on 'FHR-Strip' tab
#   Validate TimePreview bar
    Given Open Navigation Menu bar
    Then Disable the Time Preview config
    And Scroll 'UP' the Navigation Menu '8' times
    Then update configurations
    Then verify the displayed layout "/src/test/resources/Documents/fhrStrip_config_disableTimePreviewBar" with threshold "0.85" in the application
    Given Open Navigation Menu bar
    Then enable the Time Preview config
    And Scroll 'UP' the Navigation Menu '8' times
    Then update configurations
#   Validate icon
    Then verify the displayed layout "/src/test/resources/Documents/fhrStrip_config_defaultGlobalIcon" with threshold "0.85" in the application
    Given Open Navigation Menu bar
    And Scroll 'UP' the Navigation Menu '1' times
    Then Disable the global icon option
    And Scroll 'UP' the Navigation Menu '8' times
    Then update configurations
#   Validate uom
    Then verify the UOM is displaying  as the '<uom>' for Lowest value of scale label
    Given Open Navigation Menu bar
    And Scroll 'UP' the Navigation Menu '2' times
    Then Disable the UOM config option
    And  Scroll 'UP' the Navigation Menu '8' times
    Then update configurations
    Then verify the displayed layout "/src/test/resources/Documents/fhrStrip_config_disableUOM" with threshold "0.85" in the application
    Given Open Navigation Menu bar
    And Scroll 'UP' the Navigation Menu '2' times
    Then  enable the UOM config option
    And  Scroll 'UP' the Navigation Menu '8' times
    Then update configurations
#   Validate 1min & 5 min label configuration
    Given Open Navigation Menu bar
    When Click on FhrConfig and select '<fhrConfig>'
    When Update widthPerMinuteinPixels '<widthPerMinpx>'
    And Scroll 'UP' the Navigation Menu '8' times
    Then update configurations
#    Validate scale label text size and color
    Given Open Navigation Menu bar
    And Scroll 'UP' the Navigation Menu '2' times
    Then enter Scale label text size "14"
    Then enter scale label text colour '#1F14BA'
    And Scroll 'UP' the Navigation Menu '8' times
    Then update configurations
    Then verify the displayed layout '<TextFontColor_Config_ScaleLabels>' with threshold "0.85" in the application
    Given Open Navigation Menu bar
    And Scroll 'UP' the Navigation Menu '8' times
#   Validate UA grid config
    And Update Ymin value '<uaYAxisMin>' Ymax value '<uaYAxisMax>'
    And Update uom interval value '<uomInterval>'
    And Update UA wave form color '<uaWaveformColor>'
    And Scroll 'UP' the Navigation Menu '8' times
    Then update configurations
    And wait for '10000'
    Then verify the displayed layout '<8pxGapBetweenHRAndUA_Config>' with threshold "0.85" in the application
    Given Open Navigation Menu bar
    And Scroll 'UP' the Navigation Menu '8' times
    And Update gap of HR and UA '0'
    Then update configurations
    Then verify the displayed layout '<0pxGapBetweenHRAndUA_Config>' with threshold "0.85" in the application
    Then verify the displayed layout '<minMaxInterval_ScaleLabelConfig>' with threshold "0.85" in the application
    Then verify the displayed layout '<uaWaveformColor_Config>' with threshold "0.78" in the application
#   Landscape mode
    Then rotate the screen to 'landscape' mode
    Given Open Navigation Menu bar
    And Scroll 'UP' the Navigation Menu '8' times
    Then update configurations
    Then verify the displayed layout '<landScapeMode>' with threshold "0.85" in the application for orientation
    Then rotate the screen to 'portrait' mode
#   Dark Theme
    When user update the page into 'Dark' theme
    Then verify the displayed layout '<darkTheme_Image>' with threshold "0.70" in the application
#   Validate greyed out area
    And delete perinatal Heart Rate Waveforms
    And wait for '<WaitTime>'
    Then verify the displayed layout '<GreyedOut_Config>' with threshold "0.60" in the application
    Then publish the waveform '<waveformPayload>' as 'LIVE' waveform
    And wait for '<WaitTime>'
    Then verify the displayed layout '<AfterGreyedOut_waveform>' with threshold "0.60" in the application

    Examples:
        | waveformPayload                             | uaWaveformColor | fhrConfig | uaYAxisMin | uaYAxisMax | uomInterval | widthPerMinpx | uom  | TextFontColor_Config_ScaleLabels                                       | minMaxInterval_ScaleLabelConfig                                              | uaWaveformColor_Config                                              | 8pxGapBetweenHRAndUA_Config                                           | 0pxGapBetweenHRAndUA_Config                                           | landScapeMode                                                     | darkTheme_Image                                              | GreyedOut_Config                                                  | AfterGreyedOut_waveform                                      | WaitTime |
        | /testData/waveformData_for_FHR_UAstrip.json | #CC6CE7,UA,1    | 3CM       | 0          | 120        | 40          | 35.0          | mmHG | /src/test/resources/Documents/fhrStrip_config_horizantalScaleLabels    | /src/test/resources/Documents/fhrStrip_config_leastAndMaxscaleLabelUpdate    | /src/test/resources/Documents/fhrStrip_config_waveformColourOfUA    | /src/test/resources/Documents/fhrStrip_config_8pxGapBetweenHRAndUA    | /src/test/resources/Documents/fhrStrip_config_0pxGapBetweenHRAndUA    | /src/test/resources/Documents/fhrStrip_config_uaLandScapeMode_3CM | /src/test/resources/Documents/fhrStrip_config_UaDarkMode_3CM | /src/test/resources/Documents/fhrStrip_config_UAGreyedOutArea_3CM | /src/test/resources/Documents/fhrStrip_config_UAWaveForm_3CM | 50000    |
        | /testData/waveformData_for_FHR_UAstrip.json | #CE7640,UA,1    | 1CM       | 0          | 150        | 50          | 15            | mmHG | /src/test/resources/Documents/fhrStrip_config_1CMhorizantalScaleLabels | /src/test/resources/Documents/fhrStrip_config_1CMleastAndMaxscaleLabelUpdate | /src/test/resources/Documents/fhrStrip_config_1CMwaveformColourOfUA | /src/test/resources/Documents/fhrStrip_config_1CM8pxGapBetweenHRAndUA | /src/test/resources/Documents/fhrStrip_config_1CM0pxGapBetweenHRAndUA | /src/test/resources/Documents/fhrStrip_config_1CMUALandScapeMode  | /src/test/resources/Documents/fhrStrip_config_UaDarkMode_1CM | /src/test/resources/Documents/fhrStrip_config_UAGreyedOutArea_1CM | /src/test/resources/Documents/fhrStrip_config_UAWaveForm_1CM | 50000    |