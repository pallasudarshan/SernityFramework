//**************************From Release 5.0.0********************************************************
package util;

import java.util.List;

public class KymaConstants {
    private static final ThreadLocal<String> PATIENT_UUID = new ThreadLocal<>();
    private static final ThreadLocal<String> PATIENT_MRN = new ThreadLocal();
    private static final ThreadLocal<String> PATIENT_FAMILYNAME = new ThreadLocal();
    private static final ThreadLocal<String> PATIENT_GIVENNAME = new ThreadLocal();
    private static final ThreadLocal<String> PATIENT_DOB = new ThreadLocal();
    private static final ThreadLocal<String> PATIENT_LOCATION_UUID = new ThreadLocal();
    private static final ThreadLocal<String> PATIENT_LOCATION_BED = new ThreadLocal();
    private static final ThreadLocal<String> PATIENT_LOCATION_CAREAREA = new ThreadLocal();
    private static final ThreadLocal<String> PATIENT_LOCATION_FACILITY = new ThreadLocal();
    private static final ThreadLocal<String> PATIENT_GENDER = new ThreadLocal();
    private static final ThreadLocal<String> PATIENT_STATE = new ThreadLocal();
    private static final ThreadLocal<String> EVENT_STARTDATE = new ThreadLocal();

    private static final String NUMERIC_SATO2 = "satO2";
    private static final String NUMERIC_PULSERATE = "pulseRate";
    private static final String NUMERIC_HEARTRATE = "heartRate";
    private static final String NUMERIC_PVCRATE = "p_v_cRate";
    private static final String NUMERIC_STI = "I";
    private static final String NUMERIC_STII = "II";
    private static final String NUMERIC_STIII = "III";
    private static final String NUMERIC_RESPRATE = "respRate";
    private static final String NUMERIC_CO2ENDTIDAL = "CO2-endTidalConc";
    private static final String NUMERIC_CO2RR = "CO2-RR";
    private static final String NUMERIC_SYSTOLIC = "systolic";
    private static final String NUMERIC_DIASTOLIC = "diastolic";
    private static final String NUMERIC_MEAN = "mean";
    private static final String NUMERIC_TEMP = "temp" ;

    private static final String NUMERIC_TEMP_TREND = "Temp" ;
    private static final String NUMERIC_NIBP = "NIBP";
    private static final String NUMERIC_ST_I = "ST-I";

    // Numeric Block - Numeric Parameters color hex codes
    private static final String NUMERIC_SATO2_COLOR = "#1EA5FF";
    private static final String NUMERIC_SATO2_COLOR_lIGHTTHEME = "#009ae3";
    private static final String NUMERIC_PULSERATE_COLOR = "#1EA5FF";
    private static final String NUMERIC_HEARTRATE_COLOR = "#32FF32";
    private static final String NUMERIC_HEARTRATE_COLOR_LIGHTTHEME = "#00d500";
    private static final String NUMERIC_PVCRATE_COLOR = "#32FF32";
    private static final String NUMERIC_STI_COLOR = "I";
    private static final String NUMERIC_STII_COLOR = "#32FF32";
    private static final String NUMERIC_STIII_COLOR = "#32FF32";
    private static final String NUMERIC_RESPRATE_COLOR = "#FFFF00";

    private static final String NUMERIC_RESPRATE_COLOR_LIGHTTHEME="#f6c118";
    private static final String NUMERIC_CO2ENDTIDAL_COLOR = "#FFFFFF";
    private static final String NUMERIC_CO2RR_COLOR = "CO2-RR";
    private static final String NUMERIC_SYSTOLIC_COLOR = "#FA0C00";
    private static final String NUMERIC_DIASTOLIC_COLOR = "#FA0C00";
    private static final String NUMERIC_MEAN_COLOR = "#FA0C00";
    private static final String DEFAULT_NUMERIC_COLOR = "#FFFFFF";
    public static final String NUMERIC_SEPARATOR_COLOR = "#fa0c00" ;


    public static final String MASTHEAD_TITLE="Kyma.io";

    public static final String NUMERIC_VALUE_FONT_SIZE = "80px";

    public static final String NUMERICBLOCKMPV_ORDER = "heartRate,respRate,CO2-endTidalConc,satO2,pulseRate,I,systolic,diastolic,mean";
    public static final String WAVEFOEMBLOCKMPV_ORDER = "II,Resp,CO2,Pleth,SpO2";

    private static String DST_BADGE_LOCATION = "";

    public static int REQUEST_CALL_COUNT = 0;

    // FSW BARS
    public static final String FSW_TOOLBAR = "toolbar";
    public static final String FSW_TIMEBAR = "timebar";
    public static final String FSW_THREE_DOTS_NUDGE = "threeDotsToolbar";
    public static final String FSW_NUDGE_SIZE_BIG = "big";
    public static final String FSW_NUDGE_SIZE_SMALL = "small";
    public static final String FSW_NUDGE_REWIND = "rewind";
    public static final String FSW_NUDGE_FORWARD = "forward";
    private static final ThreadLocal<String> MARKER_DATE_BEFORE_PRINT = new ThreadLocal();
    private static final ThreadLocal<String> MARKER_TIME_BEFORE_PRINT = new ThreadLocal();


    private static final ThreadLocal<String> WAVEFORM_START_TIME = new ThreadLocal();
    private static final ThreadLocal<String> WAVEFORM_END_TIME = new ThreadLocal();


    //Alarm priority - hex codes
    public static final String ALARM_GREEN_PRIORITY_FOREGROUND_COLOR = "#32ff32";
    public static final String ALARM_INFO_PRIORITY_FOREGROUND_COLOR = "#000000";
    public static final String ALARM_INFO_PRIORITY_LOCATION_FOREGROUND_COLOR = "#313235";
    public static final String ALARM_INFO_PRIORITY_BACKGROUND_COLOR = "#b8b9bb";
    public static final String ALARM_LOW_PRIORITY_FOREGROUND_COLOR = "#000000";
    public static final String ALARM_LOW_PRIORITY_LOCATION_FOREGROUND_COLOR = "#313235";
    public static final String ALARM_LOW_PRIORITY_BACKGROUND_COLOR = "#51bddf";
    public static final String ALARM_MEDIUM_PRIORITY_FOREGROUND_COLOR = "#000000";
    public static final String ALARM_MEDIUM_PRIORITY_LOCATION_FOREGROUND_COLOR = "#313235";
    public static final String ALARM_MEDIUM_PRIORITY_BACKGROUND_COLOR = "#ffcb24";
    public static final String ALARM_HIGH_PRIORITY_FOREGROUND_COLOR = "#ffffff";
    public static final String ALARM_HIGH_PRIORITY_LOCATION_FOREGROUND_COLOR = "#f9f9fa";
    public static final String ALARM_HIGH_PRIORITY_BACKGROUND_COLOR = "#d40000";

    public static final String ALARM_NO_PRIORITY_NUMERICBLOCK_BACKGROUND_COLOR_LIGHT = "#ffffff";
    public static final String ALARM_NO_PRIORITY_NUMERICBLOCK_BACKGROUND_COLOR_DARK = "#141415";
    public static final String ALARM_HIGH_PRIORITY_DROPDOWNICON_TIMESTAMP_FOREGROUND_COLOR_BADGE_BGCOLOR = "#f9f9fa";
    public static final String ALARM_NO_HIGH_PRIORITY_DROPDOWNICON_TIMESTAMP_FOREGROUND_COLOR_BADGE_BGCOLOR = "#313235";
    public static final String ALARM_NO_PRIORITY_BACKGROUND_COLOR = "#000000";
    public static final String ALARM_NONE_BACKGROUND_COLOR = "#ffffff";
    public static final String ALARM_N0_DATA_PRIORITY_BACKGROUND_COLOR = "#d8d8d8";

    // Numeric Block - SQI
    public static final int THREE_SQI_VALUERANGE = 90;
    public static final int TWO_SQI_VALUERANGE = 70;
    public static final int ONE_SQI_VALUERANGE = 50;
    public static final String SQI_NOTATION = "*";

    //Numeric Block css values
    public static final int SEPERATOR_MARGIN_RIGHT=5;
    public static final int SEPERATOR_MARGIN_LEFT=8;
    public static final int MEANVALUE_MARGIN_LEFT=39;


    //Numeric Block alarm
    public static final String EXPECTED_NUMERIC_ACK_ICON_HTML_PATH = "src/main/resources/kymaAssets/numericBlock/NumericAcknowledgeIcon.html";
    public static final String NUMERIICONCCONFIGPOSTOPLEFT = "top-left";
    public static final String NUMERICICONCONFIGPOSABOVELEFT = "above-left";

    //Graphical Trends Segmented duration value
    public static final String DEFAULT_SEGEMENTED_DURATION = "2 hr";

    //Tabular Trends
    public static final String DEFAULT_TABULAR_TREND_CELL_ICON_HTML_PATH = "/src/main/resources/kymaAssets/tabularTrend/icon-time.html";
    public static final String DEFAULT_TABULAR_TREND_HIGHLIGHTED_BACKGROUND_COLOR = "#b39cf1";

    // Numeric Block - Learning mode properties
    private static final String LEARNING_MODE_ANIMATION_DURATION_KEY = "animation-duration";
    private static final String LEARNING_MODE_ANIMATION_ITERATION_KEY = "animation-iteration-count";
    private static final String LEARNING_MODE_ANIMATION_COLOR_KEY = "background-color";
    private static final String LEARNING_MODE_ANIMATION_STATE_KEY = "animation-play-state";
    private static final String LEARNING_MODE_ANIMATION_DIRECTION_KEY = "animation-direction";
    private static final String LEARNING_MODE_ANIMATION_DELAY_KEY = "animation-delay";
    private static final String LEARNING_MODE_ANIMATION_DURATION_VALUE = "1.5s";
    private static final String LEARNING_MODE_ANIMATION_ITERATION_VALUE = "infinite";
    private static final String LEARNING_MODE_ANIMATION_COLOR_VALUE = "#FFFFFF";
    private static final String LEARNING_MODE_ANIMATION_STATE_VALUE = "running";
    private static final String LEARNING_MODE_ANIMATION_DIRECTION_VALUE = "normal";
    private static final String LEARNING_MODE_DELAY_VALUE_FOR_INDEX_ONE = "0s";
    private static final String LEARNING_MODE_DELAY_VALUE_FOR_INDEX_TWO = "0.3s";
    private static final String LEARNING_MODE_DELAY_VALUE_FOR_INDEX_THREE = "0.6s";

    // Numeric Block - Dashout related constants
    public static final String INVALIDLE = "-32752";
    public static final String DASHOUT_NOTATION="---";
    public static final int NUMERIC_STALE_OUT_RANGE = 8000;

    public static final String SINGLE_NUMERIC_FONT_SIZE ="80px";

    public static final String SINGLE_NUMERIC_FONT_FAMILY ="Source Sans 3";

    private static final String DISPLAY_SCALE_FACTOR_VALUE = "factor";
    private static final String LOCATION_STRING_DELIMITER = "-";

    // Patient Banner - Patient Name
    private static final String PATIENT_NAME_TOOLTIP_STRING_DELIMITER = ", ";
    private static final String PATIENT_CARD_BORDER_COLOR="#a9a0c5";

    // Waveform - waveform alarms
    private static final String LEARNING_MODE_TEXT_FOR_WAVEFORM = "Learning";
    private static final String TECHNICAL_EVENT_TYPE_TEXT = "technical";
    private static final String ARRHYTHMIA_EVENT_TYPE_TEXT = "rhythm";
    private static final String ARRHYTHMIA_ALARM_MESSAGE = "Bigeminy";
    private static final String TECHNICAL_ALARM_MESSAGE_FOR_BLANK_WAVEFORM_DATA = "No Data Available";
    private static final String TECHNICAL_ALARM_MESSAGE_FOR_DROPOUT = "Missing Packets";
    private static final int WAVEFORM_DROPOUT_TIMEOUT = 15000;
    private static final int WAVEFORM_NO_DATA_AVAILABLE_TIME = 40000;

    // Page Names
    private static final String GET_MPV_PAGE_NAME = "MPV";
    private static final String GET_SPV_PAGE_NAME = "SPV";

    //Alarm acknowledgementType
    private static final String GET_INFINITE_ALARM_TYPE = "Infinite";
    private static final String GET_TIMED_ALARM_TYPE = "Timed";

    // collapsed drop down attribute value
    public static final String ALARM_BANNER_COLLAPSE_NAME = "collapsed";
    public static final String ALARM_BANNER_EXPAND_NAME = "expanded";

    //Min & Max scale for graphicalTrends
    public static final String SAT_O2_MIN_SCALE = "80";
    public static final String SAT_O2_MAX_SCALE = "100";
    public static final String PULSE_RATE_MIN_SCALE = "0";
    public static final String PULSE_RATE_MAX_SCALE = "180";
    public static final String NIBP_MIN_SCALE = "64";
    public static final String NIBP_MAX_SCALE = "112";
    public static final String ST_I_MIN_SCALE = "0";
    public static final String ST_I_MAX_SCALE = "300";

    //Graphical Trends Custom Tool Tip Background color
    public static final String CUSTOM_TOOLTIP_VAL_LIMIT_HIGH_PRIORITY_HEX_COLOR_CODE ="#d40000";

    //Graphical Trends Data color
    public static final String SATO2_HEX_COLOR_CODE = "#6b9800";
    public static final String PULSE_HEX_RATE_COLOR_CODE = "#0098d6";
    public static final String TEMP_HEX_COLOR_CODE = "#e7e363";
    public static final String NIBP_HEX_COLOR_CODE = "#c49eed";

    //Graphical Trends Tick color
    private static final String TRENDS_DEFAULT_TICK_COLOR = "#babdc0";

    //Graphical Trends Tick offset
    private static final int TRENDS_DEFAULT_X_POSITION = 500;
    private static final int TRENDS_DEFAULT_X_POSITION_FOR_DUAL_YAXIS = 490;
    private static final int TRENDS_DEFAULT_X_POSITION_OPPOSITE_FOR_DUAL_YAXIS = 1871;

    //Graphical Trend Tick Alignment
    private static final String TRENDS_Y_AXIS_LEFT_ALIGNMENT = "left";
    private static final String TRENDS_Y_AXIS_RIGHT_ALIGNMENT = "right";
    private static final String TRENDS_Y_AXIS_LEFT_ALIGNMENT_TEXTANCHOR = "start";
    private static final String TRENDS_Y_AXIS_RIGHT_ALIGNMENT_TEXTANCHOR = "end";

    public static String SATO2_HEX_COLOR_CODE(){return SATO2_HEX_COLOR_CODE;}

    //Alarm banner font size
    public static final String ALARM_MESSAGE_FONT_SIZE = "16px";

    //Alarm banner font style
    public static final String ALARM_MESSAGE_FONT_STYLE = "Source Sans 3";

    public static final String KYMA_MPV_SLOTS_ALARM_MESSAGE_FONT_STYLE ="Source Sans 3";

    public static final String KYMA_SLOT_SELECTION_BORDER_COLOR = "209, 210, 212";
    public static final String KYMA_SLOT_SELECTION_BORDER_WIDTH = "2px";


    // Alarm Banner - Hotspot Area
    private static final String ALARM_BANNER_NON_HIGH_PRIORITY_HOTSPOT_AREA_BADGE_BG_COLOR = "#313235";
    private static final String ALARM_BANNER_HIGH_PRIORITY_ALARM_HOTSPOT_AREA_BADGE_BG_COLOR = "#f9f9fa";
    private static final String ALARM_BANNER_HOTSPOT_AREA_BADGE_HEIGHT = "20px";
    private static final String ALARM_BANNER_HOTSPOT_AREA_BADGE_WIDTH = "20px";
    private static final String ALARM_BANNER_HOTSPOT_AREA_BADGE_WIDTH_FOR_GREATER_THAN_NINE = "27px";
    private static final String ALARM_BANNER_HOTSPOT_AREA_BADGE_RADIUS = "10px";
    private static final String ALARM_BANNER_HOTSPOT_AREA_ALIGNMENT = "center";
    private static final String ALARM_BANNER_HOTSPOT_AREA_ALARM_COUNT_FONT_SIZE = "14px";
    private static final String ALARM_BANNER_HOTSPOT_AREA_ALARM_COUNT_FONT_WEIGHT = "700";
    private static final String ALARM_BANNER_NON_HIGH_PRIORITY_HOTSPOT_AREA_ALARM_COUNT_FG_COLOR = "#f9f9fa";
    private static final String ALARM_BANNER_HIGH_PRIORITY_HOTSPOT_AREA_ALARM_COUNT_FG_COLOR = "#313235";
    private static final String ALARM_BANNER_HOTSPOT_AREA_ALARM_COUNT_FOR_GREATER_THAN_NINE = "9+";
    private static final Integer ALARM_BANNER_HOTSPOT_AREA_BADGE_TEXT_MAX_COUNT = 9;
    private static final Integer ALARM_BANNER_HOTSPOT_AREA_BADGE_TEXT_MIN_COUNT = 1;
    private static final String ALARM_BANNER_DIFFERENTIATOR_LINE_GAP = "2px";

    private static final String ALARM_BANNER_ALARM_CONTROL_TIMED_ACK_TYPE="Timed";
    private static final String ALARM_BANNER_ALARM_CONTROL_INFINITE_ACK_TYPE ="Infinite";
    private static final String ALARM_BANNER_ALARM_CONTROL_ACK_STATE_TOOLTIP_TEXT="Unacknowledge";
    private static final String ALARM_BANNER_ALARM_CONTROL_TIMED_UN_ACK_STATE_TOOLTIP_TEXT="Acknowledge";
    private static final String ALARM_BANNER_ALARM_CONTROL_INDEF_UN_ACK_STATE_TOOLTIP_TEXT="Indefinite Acknowledge";
    private static final String ALARM_BANNER_PRIORITY_NOT_APPLIES_FOR_ACKNOWLEDGE="info";
    private static final String ALARM_BANNER_ALARM_CONTROL_APPLIES_FOR_LATCHED="latched";

    public static final String ALARM_BANNER_HOTSPOT_BORDER_COLOR ="0px none rgb(249, 249, 250)";
    public static int ALARM_BANNER_HOTSPOT_X_INITIAL_LOCATION = 814;
    public static int ALARM_BANNER_HOTSPOT_Y_INITIAL_LOCATION = 246;
    public static final String ALARM_BANNER_STICKY_CONTAINER_BACKGROUND_LEFT = "linear-gradient(90deg, rgb(3, 122, 166) 0px, rgb(3, 122, 166) 4px, rgba(3, 122, 166, 0.3) 4px, rgba(3, 122, 166, 0.3) 20px, rgba(0, 0, 0, 0) 20px)";
    public static final String ALARM_BANNER_STICKY_CONTAINER_BACKGROUND_BOTTOM = "linear-gradient(360deg, rgba(3, 122, 166, 0.7) 0px, rgba(3, 122, 166, 0.7) 4px, rgba(3, 122, 166, 0.3) 4px, rgba(3, 122, 166, 0.3) 20px, rgba(0, 0, 0, 0) 20px)";
    public static final String ALARM_BANNER_STICKY_CONTAINER_BACKGROUND_RIGHT = "linear-gradient(270deg, rgba(3, 122, 166, 0.7) 0px, rgba(3, 122, 166, 0.7) 4px, rgba(3, 122, 166, 0.3) 4px, rgba(3, 122, 166, 0.3) 20px, rgba(0, 0, 0, 0) 20px)";

    public static final String ALARM_BANNER_STICKY_CONTAINER_LOCATION_LEFT = "(1107, 271)";
    public static final String ALARM_BANNER_STICKY_CONTAINER_LOCATION_CENTER = "(1182, 271)";
    public static final String ALARM_BANNER_STICKY_CONTAINER_LOCATION_RIGHT = "(1274, 271)";

    public static String PULSE_HEX_RATE_COLOR_CODE(){return PULSE_HEX_RATE_COLOR_CODE;}

    public static String TEMP_HEX_COLOR_CODE(){return TEMP_HEX_COLOR_CODE;}

    public static String NIBP_HEX_COLOR_CODE(){return NIBP_HEX_COLOR_CODE;}

    // Event Directory Expand and Collapse panel Background and Border color

    private static final String EVENT_PANEL_BACKGROUND_COLOR="#141415";

    private static final String EVENT_PANEL_BORDER_COLOR="#313235";

    //Backend Server EndPoints
    public static final String KYMA_MOCK_REST = "MOCK_REST";
    public static final String KYMA_MOCK_STREAM = "MOCK_STREAM";

    //API status codes
    public static final int RESPONSE_CODE_200 =200;

    //Graphical Trends Date format
    public static final String HOURS_MIN_FORMAT = "HH:mm";
    public static final String HOURS_MIN_MON_YEAR_FORMAT = "HH:mmMMMd";
    public static final String DATE_MON_FORMAT = "dd MMM";

    public static final String DAY_CHANGE_ZERO_TIMESTAMP = "00:00";

    //Graphical Trends Alarm Priority color
    public static final String GRAPHICAL_TRENDS_LOW_ALARM_PRIORITY_COLOR = "#51bddf";
    public static final String GRAPHICAL_TRENDS_HIGH_ALARM_PRIORITY_COLOR = "#d40000";

    public static final String GRAPHICAL_TRENDS_DEFAULT_GRIDLINE_COLOR = "#3d3f42";

    //API Paths
    public static final String GET_PATIENT_BY_ID_REST = "api/patients";
    public static final String GET_SOURCE_BY_ID_REST = "api/sources";

    // Alarm List - layouts
    private static final String ALARM_LIST_HORIZONTAL_LAYOUT_NAME = "horizontal" ;
    private static final String ALARM_LIST_VERTICAL_LEFT_LAYOUT_NAME = "vertical-left";
    private static final String ALARM_LIST_VERTICAL_RIGHT_LAYOUT_NAME = "vertical-right";
    private static final String ALARM_LIST_MONITORING_STATUS_MESSAGE = "Active monitoring";
    private static final String ALARM_LIST_DISABLED_STATE_MESSAGE = "No patient admitted";
    private static final String ALARM_LIST_ALARM_MESSAGE_FONT_SIZE = "16px";
    private static final String ALARM_LIST_ALARM_MESSAGE_FONT_FAMILY = "Source Sans 3";
    private static final String ALARM_LIST_ALARM_MESSAGE_FONT_WEIGHT = "700";

    // Alarm List - Priority Hex Codes
    private static final String ALARM_LIST_NONE_PRIORITY_FOREGROUND_COLOR = "#ffffff";
    private static final String ALARM_LIST_NONE_PRIORITY_LOCATION_FOREGROUND_COLOR = "#f9f9fa";
    private static final String ALARM_LIST_NONE_PRIORITY_BACKGROUND_COLOR = "#63666a";
    private static final String DISABLED_STATE_PRIORITY_BACKGROUND_COLOR = "#2b2d2e";
    private static final String DISABLED_STATE_PRIORITY_FOREGROUND_COLOR = "#63666a";

    // EWS - Priority Color Codes
    public static final String EWS_NORMAL_DATA_PRIORITY_BACKGROUND_COLOR_FILL_BORDER_THEME ="#1e1f20";
    public static final String EWS_NORMAL_DATA_PRIORITY_BORDER_COLOR_FILL_THEME ="rgb(29, 39, 53)";
    public static final String EWS_NORMAL_DATA_PRIORITY_BORDER_COLOR_BORDER_THEME="rgb(197, 199, 201)";
    public static final String EWS_WARNING_DATA_PRIORITY_BACKGROUND_COLOR_FILL_THEME ="#dba4a4";

    public static final String EWS_OUTOFRANGE_DATA_PRIORITY_BACKGROUND_COLOR_FILL_BORDER_THEME = "#55595e";
    public static final String EWS_WARNING_DATA_PRIORITY_BACKGROUND_COLOR_BORDER_THEME ="#dba4a4";
    public static final String EWS_WARNING_DATA_PRIORITY_BORDER_COLOR_FILL_BORDER_THEME="rgb(126, 63, 215)";
    public static final String EWS_OUTDATED_DATA_BACKGROUND_COLOR="#dba4a4";
    public static final String EWS_OUTDATED_DATA_BORDER_COLOR="rgb(55, 59, 61)";
    public static final String EWS_ERROR_MESSAGE="Error: Not valid data";
    public static final String EWS_INFO_MESSAGE="Visensia Safety Index 0 = Good 1 = Warning 2 = OutOfRange";

    //FSW-Layout
    public static final String STANDARD = "Standard";
    public static final String ECG_LAYOUT = "ECG_View";
    public static final String OTHER_LAYOUT = "Other_View";
    public static final String CUSTOM_LAYOUT = "Custom View";

    //FD-Annotation
    public static final String ANNOTATION_BORDER_COLOR ="1px solid rgb(3, 122, 166)";

    public static final String ATRIAL_PACED = "option-3";
    public static final String BRADYCARDIA = "option-7";
    public static final String SINUS_ARREST = "option-35";
    public static final String SINUS_PAUSE = "option-38";
    public static final String PULSELESS= "option-26";

    public static final String APNEA = "option-0";
    public static final String DEVICE_ASSOCIATION = "option-2";
    public static final String LEAD_FAILURE = "option-35";
    public static final String HIGH_CVP = "option-19";
    public static final String LOW_CO2 = "option-36";

    //FD-Caliper
    public static final String FD_FSW_TOOLBAR_ICON_COLOR_ON_HOVER_NEW="#F9F9FA3D";
    public static final String FD_FSW_TOOLBAR_ICON_COLOR_ON_SELECT="#fafbfd";
    public static final String CALIPER_DEFAULT_RIGHT_ARM_COLOR="#b39cf1";
    public static final String CALIPER_DEFAULT_LEFT_ARM_COLOR="#b39cf1";

    public static final String CALIPER_DEFAULT_RIGHT_ARM_COLOR_NON_ECG="#878c92";
    public static final String CALIPER_DEFAULT_LEFT_ARM_COLOR_NON_ECG="#878c92";
    public static final String CALIPER_PRESSED_RIGHT_ARM_COLOR="#1e1f20";
    public static final String CALIPER_PRESSED_LEFT_ARM_COLOR="#1e1f20";
    public static final String CALIPER_GRAY_RIGHT_ARM_COLOR="#878c92";
    public static final String CALIPER_GRAY_LEFT_ARM_COLOR="#878c92";
    public static final String CALIPER_DEFAULT_MEASUREMENT_VALUE="2.000 sec";
    public static final String CALIPER_DEFAULT_MEASUREMENT_VALUE_MS="2000 ms";
    public static final String CALIPER_WAVEFORM_HIGHLIGHT_COLOR="#d1d2d4";
    public static final String CALIPER_DEFAULT_RULER_COLOR="#b39cf1";
    public static final String CALIPER_GRAY_RULER_COLOR="#878c92";
    public static final String CALIPER_ACTIVE_DOTS_COLOR="#b39cf1";
    public static final String CALIPER_GRAY_DOTS_COLOR="#878c92";
    public static final String CALIPER_MARCHING_LINES_DEFAULT_COLOR="#b39cf1";
    public static final String CALIPER_MARCHING_LINES_GRAY_COLOR="#878c92";

    public static final String CALIPER_DEFAULT_RIGHT_ARM_COLOR_SELECTED="#1e1f20";
    public static final String CALIPER_DEFAULT_LEFT_ARM_COLOR_SELECTED="#1e1f20";
    public static final String CALIPER_GRAY_RIGHT_ARM_COLOR_SELECTED="#1e1f20";
    public static final String CALIPER_GRAY_LEFT_ARM_COLOR_SELECTED="#1e1f20";

    public static final String SELECTED_LEAD_BUTTON_BG_COLOR="#313235";
    public static final String CURRENT_LEAD_BUTTON_BG_COLOR="#000000";
    public static final String SELECTED_LEAD_BUTTON_FONT_COLOR="#f9f9fa";
    public static final String CURRENT_LEAD_BUTTON_FONT_COLOR="#313235";
    public static float caliperTooltipXCoordinate;
    public static float caliperTooltipYCoordinate;

    public static final String DEFAULT_CALIPER_MAX_MSGE="Caliper measurements should be contained within ";
    public static final String CALIPER_MAX_MSGE="Overlapping caliper measurements should be contained within ";

    //Alarm List - Class Names
    private static final String DISABLED_STATE_CLASS_NAME = "disabled-state";

    // FD-FSW - Marker
    private static final String FD_FSW_WAVEFORM_MARKER_WIDTH="9px";
    private static final String FD_FSW_WAVEFORM_MARKER_COLOR="#7f8185";
    private static final String FD_FSW_WAVEFORM_MARKER_LABEL_FONT_SIZE="12px";
    private static final String FD_FSW_WAVEFORM_MARKER_LABEL_FONT_COLOR="#d7d8db";
    // FD-FSW - Label
    private static final String FD_FSW_ACTIVE_LABEL_COLOR_ForDarkTheme="#babdc0";
    private static final String FD_FSW_ACTIVE_LABEL_OPACITY="1";
    private static final String FD_FSW_IN_ACTIVE_LABEL_COLOR_ForDarkTheme="#f9f9fa";
    private static final String FD_FSW_IN_ACTIVE_LABEL_OPACITY="0.36";
    private static final String FD_FSW_ACTIVE_LABEL_COLOR_ForLightTheme="#55595e";
    private static final String FD_FSW_IN_ACTIVE_LABEL_COLOR_ForLightTheme="#313235";


    //FD-FSW - End Of Data Messages
    private static final String END_OF_DATA_HEADER_MESSAGE = "End of data";
    private static final String END_OF_DATA_AT_BEGINNING_MESSAGE= "Reached beginning of time, cannot drag further";
    private static final String END_OF_DATA_AT_END_MESSAGE = "Reached end of time, cannot drag further";

    //FD-FSW - Intermittent Data Loss
    private static final String FSW_DATA_LOSS_MESSAGE_FONT_COLOR="#f9f9fa";
    private static final String FSW_DATA_LOSS_MESSAGE_FONT_SIZE="12px";
    private static final String FSW_DATA_LOSS_MESSAGE_FONT_WEIGHT="400";
    private static final String FSW_DATA_LOSS_ICON_CONTENT_COLOR="#a32940";

    //BulkAPI
    public static final String MULTIWATCH_SUCCESS_STATUS = "SUCCESS";

    public static final String MULTIWATCH_FAILURE_STATUS = "FAILURE";
    public static String MULTIWATCH_SUCCESS_MESSAGE = "Successfully created watch for resource type : ";

    public static String MULTIWATCH_FAILURE_MESSAGE = " Watch Creation Failed";
    public static String MULTIWATCH_REQUEST_SIGNATURE = "api/watch/multiwatch/";

    //FD-Event Directory
    private static final String ED_EXPAND_COLLAPSE_FLAG_REVIEW_ICON_COLOR_ON_HOVER ="#F9F9FA";
    private static final String ED_PRIORITY_FLAG_COLOR_OPACITY_IN_INBOX_TAB="1.0";
    private static final String ED_PRIORITY_FLAG_COLOR_OPACITY_IN_DELETED_TAB="0.6";
    private static final String ED_FILTER_POPOVER_INFO_TEXT="# More applied filters";
    private static final String ED_FILTER_POPOVER_BG_COLOR="#3d3f42";
    private static final String ED_FILTER_POPOVER_BORDER_COLOR="#878C92";
    private static final String ED_FILTER_COLLAPSED_STATE_ICON_COLOR="#F9F9FA";
    private static final String ED_FILTER_EXPANDED_STATE_ICON_COLOR="#F9F9FA";
    private static final String ED_FILTER_CLEAR_ALL_TEXT="Clear All";
    private static final String ED_EVENT_TICKET_REVIEWED_ICON_COLOR="#f9f9fa";

    //FD-Strip Report
    private static final String STRIP_DURATION_ACCORDION_BACKGROUND_COLOR = "#313235";
    private static final String STRIP_DURATION_ACCORDION_BORDER_COLOR = "#f9f9fa";
    private static final String STRIP_SELECTION_FILLED_COLOR = "#b39cf1";
    private static final String STRIP_SELECTION_LINE_WIDTH = "2";
    private static final String STRIP_SELECTION_LINE_COLOR = "#b39cf1";
    private static final String STRIP_OVERLAY_LEFT_AND_RIGHT_COLOR = "#1e1f20";
    private static final String DEFAULT_DURATION_TEXT_FIELD_BACKGROUND_COLOR = "#3D3F42";
    private static final String DEFAULT_DURATION_TEXT_FIELD_BORDER_COLOR = "#878C92";
    private static final String HOVERED_DURATION_TEXT_FIELD_BACKGROUND_COLOR = "#F9F9FA";
    private static final String HOVERED_DURATION_TEXT_FIELD_BORDER_COLOR = "#878C92";
    private static final String SELECTED_DURATION_TEXT_FIELD_BACKGROUND_COLOR = "#3D3F42";
    private static final String SELECTED_DURATION_TEXT_FIELD_BORDER_COLOR = "#B39CF1";
    private static final String ERRORED_DURATION_TEXT_FIELD_BACKGROUND_COLOR = "#2c1116";
    private static final String ERRORED_DURATION_TEXT_FIELD_BORDER_COLOR = "#a32940";
    private static final String ERRORED_PRESSED_DURATION_TEXT_FIELD_BACKGROUND_COLOR = "#2C1116";
    private static final String ERRORED_PRESSED_DURATION_TEXT_FIELD_BORDER_COLOR = "#a32940";

    public static final Double Expected_StripDuration_SelectedWidth_MIN = 10.5;

    public static final Double Expected_StripDuration_SelectedWidth_MAX_FIREFOX = 12445.7;
    public static final Double Expected_StripDuration_SelectedWidth_MAX = 12394.3;


    //FD-Strip Parameter
    private static final String STRIP_PARAMETER_DEFAULT_BACKGROUND_COLOR = "#313235";
    private static final String STRIP_PARAMETER_HOVERED_BORDER_COLOR = "#f9f9fa";
    private static final String STRIP_PARAMETER_HOVERED_BACKGROUND_COLOR = "#313235";
    private static final String FOCUSED_FSW_WAVEFORM_OPACITY = "1";
    private static final String UNFOCUSED_FSW_WAVEFORM_OPACITY = "0.3";

    //Volume Slider
    public static final String DEFAULT_VOLUME_SLIDER_TICK_COLOR = "#babdc0";
    public static final String DEFAULT_VOLUME_SLIDER_THUMB_COLOR = "#f9f9fa";
    public static final String DEFAULT_VOLUME_SLIDER_TRACK_COLOR = "#f9f9fa";
    public static final String DEFAULT_VOLUME_SLIDER_MIN_MAX_LABEL_COLOR = "#babdc0";
    public static final String DEFAULT_VOLUME_SLIDER_TRACK_BACKGROUND_COLOR = "#666b70";

    public static final String DEFAULT_VOLUME_SLIDER_TICK_COLOR_LIGHT_THEME = "#55595e";
    public static final String DEFAULT_VOLUME_SLIDER_THUMB_COLOR_LIGHT_THEME = "#55595e";
    public static final String DEFAULT_VOLUME_SLIDER_TRACK_COLOR_LIGHT_THEME = "#55595e";
    public static final String DEFAULT_VOLUME_SLIDER_MIN_MAX_LABEL_COLOR_LIGHT_THEME = "#55595e";
    public static final String DEFAULT_VOLUME_SLIDER_TRACK_BACKGROUND_COLOR_LIGHT_THEME = "#babdc0";

    //FHR
    private static final String LOCATION_STRING_DELIMETER_IN_FHR = " / ";
    private static final String DEFAULT_FHR_MHR_WAVEFORM_CONFIG = ",fhr1,1,1,,fhr2,2,1,,fhr3,3,1,,mhr,4,1";
    private static final String DEFAULT_UA_WAVEFORM_CONFIG = ",ua,1,1";
    private static final String PERINATAL_PARAMETER = "perinatalHeartRate";
    private static final String FHR_PATIENT_BANNER_BACKGROUND_COLOR = "#F3F3F4";

    public static final String FHR_MAGNIFIER_ICON_HOVERED_BACKGROUND_COLOR = "#F9F9FA3D";
    public static final String FHR_MAGNIFIER_ICON_ACTIVE_BACKGROUND_COLOR = "#F9F9FA1F";
    public static final String FHR_MAGNIFIER_ICON_HOVERED_BACKGROUND_COLOR_LIGHT_THEME = "#1E1F201F";

    public static final String FHR_MAGNIFIER_ICON_ACTIVE_BACKGROUND_COLOR_LIGHT_THEME = "#1E1F203D";

    //Labs
    public static final String LABS_DEFAULT_ACCORDION_PANEL_BACKGROUND_COLOR = "#141415";
    public static final String LABS_PRESSED_ACCORDION_PANEL_BACKGROUND_COLOR = "#F9F9FA1F";
    public static final String LABS_HOVERED_ACCORDION_PANEL_BACKGROUND_COLOR = "#F9F9FA3D";
    public static final String LABS_PRESSED_FLIP_OR_OVERLAY_ICON_BACKGROUND_COLOR = "#F9F9FA1F";
    public static final String LABS_HOVERED_FLIP_OR_OVERLAY_ICON_BACKGROUND_COLOR = "#F9F9FA3D";
    public static final String LABS_FISHBONE_STRUCTURE_FOREGROUND_COLOR = "#3D3F42";
    public static final String LABS_FISHBONE_STRUCTURE_FOREGROUND_COLOR_LIGHT_THEME = "#D1D2D4";
    public static final String LABS_ACCORDION_NAME_FONT_FAMILY = "Source Sans 3";
    public static final String LABS_ACCORDION_NAME_FONT_COLOR ="#F9F9FA";
    public static final String LABS_ACCORDION_NAME_FONT_COLOR_LIGHT_THEME ="#313235";
    public static final String LABS_ACCORDION_NAME_FONT_SIZE ="16px";

    public static final String LABS_CRITICAL_SEVERITY_COLOR ="#fa0c00";

    public static final String LABS_BORDERLINE_SEVERITY_COLOR ="#ffff00";

    public static final String LABS_NORMAL_SEVERITY_COLOR ="#ffffff";
    public static final String ED_FILTER_COUNT_BACKGROUNG_COLOR ="#b39cf1";

    public static final String ED_FILTER_HIGH_PRIORITY_INDICATOR_COLOR ="#d40000";
    public static final String ED_FILTER_MEDIUM_PRIORITY_INDICATOR_COLOR ="#ffcb24";

    public static final String ED_FILTER_LOW_PRIORITY_INDICATOR_COLOR ="#51bddf";

    public static final String ED_FILTER_INFORMATIONAL_INDICATOR_COLOR ="#b8b9bb";

    public static final String ED_FILTER_NONE_INDICATOR_COLOR ="#4f5155";

    public static final String ED_FILTER_SELECTED_INDICATOR_BORDER_COLOR ="#3d3f42";

    public static final String ED_FILTER_UNSELECTED_INDICATOR_BORDER_COLOR ="#878c92";
    public static final String ED_FILTER_BORDER_AROUND_PRIORITY_BADGE ="#878c92";
    public static String getSat02MinScale(){return SAT_O2_MIN_SCALE;}

    public static String getSat02MaxScale(){return SAT_O2_MAX_SCALE;}

    public static String getPulseRateMinScale(){return PULSE_RATE_MIN_SCALE;}

    public static String getPulseRateMaxScale(){return PULSE_RATE_MAX_SCALE;}

    public static String getNibpMinScale(){return NIBP_MIN_SCALE;}

    public static String getNibpMaxScale(){return NIBP_MAX_SCALE;}

    public static String getST_I_MinScale(){return ST_I_MIN_SCALE;}

    public static String getST_I_MaxScale(){return ST_I_MAX_SCALE;}

    public static String getNumericSato2Color() {
        return NUMERIC_SATO2_COLOR;
    }

    public static String getNumericSato2ColorLightTheme() {
        return NUMERIC_SATO2_COLOR_lIGHTTHEME;
    }

    public static String getDefaultTrendTickColor() { return TRENDS_DEFAULT_TICK_COLOR;}

    public static int getDefaultTrendXPosition() { return  TRENDS_DEFAULT_X_POSITION;}

    public static int getDefaultTrendXPositionForDualYaxis() { return  TRENDS_DEFAULT_X_POSITION_FOR_DUAL_YAXIS;}

    public static int getDefaultTrendXPositionOppositeForDualYaxis() { return  TRENDS_DEFAULT_X_POSITION_OPPOSITE_FOR_DUAL_YAXIS;}

    public static String getTrendsYAxisLeftAlignment() { return TRENDS_Y_AXIS_LEFT_ALIGNMENT;}

    public static String getTrendsYAxisRightAlignment() { return TRENDS_Y_AXIS_RIGHT_ALIGNMENT;}

    public static String getTrendsYAxisLeftAlignmentTextAnchor() { return TRENDS_Y_AXIS_LEFT_ALIGNMENT_TEXTANCHOR;}

    public static String getTrendsYAxisRightAlignmentTextAnchor() { return TRENDS_Y_AXIS_RIGHT_ALIGNMENT_TEXTANCHOR;}

    public static String getNumericPulserateColor() {
        return NUMERIC_PULSERATE_COLOR;
    }

    public static String getNumericHeartrateColor() {
        return String.valueOf(NUMERIC_HEARTRATE_COLOR);
    }

    public static String getNumericHeartrateColorLightTheme() {
        return String.valueOf(NUMERIC_HEARTRATE_COLOR_LIGHTTHEME);
    }

    public static String getNumericPvcrateColor() {
        return NUMERIC_PVCRATE_COLOR;
    }

    public static String getNumericStiColor() {
        return NUMERIC_STI_COLOR;
    }

    public static String getNumericStiiColor() {
        return NUMERIC_STII_COLOR;
    }

    public static String getNumericStiiiColor() {
        return NUMERIC_STIII_COLOR;
    }

    public static String getNumericResprateColor() {
        return NUMERIC_RESPRATE_COLOR;
    }

    public static String getNumericResprateColorLightTheme() {
        return NUMERIC_RESPRATE_COLOR_LIGHTTHEME;
    }


    public static String getNumericCo2endtidalColor() {
        return NUMERIC_CO2ENDTIDAL_COLOR;
    }

    public static String getNumericCo2rrColor() {
        return NUMERIC_CO2RR_COLOR;
    }

    public static String getNumericSystolicColor() {
        return NUMERIC_SYSTOLIC_COLOR;
    }

    public static String getNumericDiastolicColor() {
        return NUMERIC_DIASTOLIC_COLOR;
    }

    public static String getNumericMeanColor() {
        return NUMERIC_MEAN_COLOR;
    }

    public static String getDefaultNumericColor() {
        return DEFAULT_NUMERIC_COLOR;
    }

    public static String getNumericSato2() { return NUMERIC_SATO2;   }

    public static String getNumericPulserate() { return NUMERIC_PULSERATE; }

    public static String getNumericNIBP() { return NUMERIC_NIBP;   }

    public static String getNumericST_I() { return NUMERIC_ST_I;   }

    public static String getNumericHeartrate() {
        return NUMERIC_HEARTRATE;
    }

    public static String getNumericPvcrate() {
        return NUMERIC_PVCRATE;
    }

    public static String getNumericSti() {
        return NUMERIC_STI;
    }

    public static String getNumericStii() {
        return NUMERIC_STII;
    }

    public static String getNumericStiii() {
        return NUMERIC_STIII;
    }

    public static String getNumericResprate() {
        return NUMERIC_RESPRATE;
    }

    public static String getNumericCo2endtidal() {
        return NUMERIC_CO2ENDTIDAL;
    }

    public static String getNumericCo2rr() {
        return NUMERIC_CO2RR;
    }

    public static String getNumericSystolic() {
        return NUMERIC_SYSTOLIC;
    }

    public static String getNumericDiastolic() {
        return NUMERIC_DIASTOLIC;
    }

    public static String getNumericMean() {
        return NUMERIC_MEAN;
    }

    public static String getNumericTemp() {
        return NUMERIC_TEMP;
    }
    public static String getNumericTrendTemp() {
        return NUMERIC_TEMP_TREND;
    }

    public static String getPatientUuid() {
        return PATIENT_UUID.get();
    }

    public static void setPatientUuid(String v) {
        PATIENT_UUID.set(v);
    }

    public static String getPatientMrn() {
        return PATIENT_MRN.get();
    }

    public static void setPatientMrn(String v) {
        PATIENT_MRN.set(v);
    }

    public static String getPatientFamilyname() {
        return PATIENT_FAMILYNAME.get();
    }

    public static void setPatientFamilyname(String v) {
        PATIENT_FAMILYNAME.set(v);
    }

    public static String getPatientGivenname() {
        return PATIENT_GIVENNAME.get();
    }

    public static void setPatientGivenname(String v) {
        PATIENT_GIVENNAME.set(v);
    }

    public static String getPatientDob() {
        return PATIENT_DOB.get();
    }

    public static void setPatientDob(String v) {
        PATIENT_DOB.set(v);
    }

    public static String getPatientGender() {
        return PATIENT_GENDER.get();
    }

    public static void setPatientGender(String v) {
        PATIENT_GENDER.set(v);
    }

    public static String getPatientState() {
        return PATIENT_STATE.get();
    }

    public static void setPatientState(String v) {
        PATIENT_STATE.set(v);
    }


    public static String getPatientLocationUuid() {
        return PATIENT_LOCATION_UUID.get();
    }

    public static void setPatientLocationUuid(String v) {
        PATIENT_LOCATION_UUID.set(v);
    }

    public static String getPatientLocationBed() {
        return PATIENT_LOCATION_BED.get();
    }

    public static void setPatientLocationBed(String v) {
        PATIENT_LOCATION_BED.set(v);
    }

    public static String getPatientLocationCarearea() {
        return PATIENT_LOCATION_CAREAREA.get();
    }

    public static void setPatientLocationCarearea(String v) {
        PATIENT_LOCATION_CAREAREA.set(v);
    }

    public static String getPatientLocationFacility() {
        return PATIENT_LOCATION_FACILITY.get();
    }

    public static void setPatientLocationFacility(String v) {
        PATIENT_LOCATION_FACILITY.set(v);
    }

    public static String getLearningModeAnimationDurationKey() {    return LEARNING_MODE_ANIMATION_DURATION_KEY;  }

    public static String getLearningModeAnimationIterationKey() {   return LEARNING_MODE_ANIMATION_ITERATION_KEY; }

    public static String getLearningModeAnimationColorKey() {   return LEARNING_MODE_ANIMATION_COLOR_KEY; }

    public static String getLearningModeAnimationStateKey() {   return LEARNING_MODE_ANIMATION_STATE_KEY; }

    public static String getLearningModeAnimationDirectionKey() {   return LEARNING_MODE_ANIMATION_DIRECTION_KEY; }

    public static String getLearningModeAnimationDelayKey() {   return LEARNING_MODE_ANIMATION_DELAY_KEY; }

    public static String getLearningModeAnimationDurationValue() {  return LEARNING_MODE_ANIMATION_DURATION_VALUE;    }

    public static String getLearningModeAnimationIterationValue() { return LEARNING_MODE_ANIMATION_ITERATION_VALUE;   }

    public static String getLearningModeAnimationColorValue() { return LEARNING_MODE_ANIMATION_COLOR_VALUE;   }

    public static String getLearningModeAnimationStateValue() { return LEARNING_MODE_ANIMATION_STATE_VALUE;   }

    public static String getLearningModeAnimationDirectionValue() { return LEARNING_MODE_ANIMATION_DIRECTION_VALUE;   }

    public static String getDelayValueOfLearningModeElementForIndexOne() {
        return LEARNING_MODE_DELAY_VALUE_FOR_INDEX_ONE;
    }
    public static String getDelayValueOfLearningModeElementForIndexTwo() {
        return LEARNING_MODE_DELAY_VALUE_FOR_INDEX_TWO;
    }
    public static String getDelayValueOfLearningModeElementForIndexThree() {
        return LEARNING_MODE_DELAY_VALUE_FOR_INDEX_THREE;
    }

    public static String getEventDate() {
        return EVENT_STARTDATE.get();
    }

    public static void setEventDate(String v) {
        EVENT_STARTDATE.set(v);
    }

    public static String getDisplayScaleFactorValue() { return DISPLAY_SCALE_FACTOR_VALUE;
    }

    public static String getEndOfDataHeaderMessage() {
        return END_OF_DATA_HEADER_MESSAGE;
    }

    public static String getEndOfDataAtBeginningMessage() {
        return END_OF_DATA_AT_BEGINNING_MESSAGE;
    }

    public static String getEndOfDataAtEndMessage() {
        return END_OF_DATA_AT_END_MESSAGE;
    }

    public static String getLearningModeTextForWaveform() {
        return LEARNING_MODE_TEXT_FOR_WAVEFORM;
    }

    public static String getTechnicalEventTypeText() {
        return TECHNICAL_EVENT_TYPE_TEXT;
    }

    public static String getArrhythmiaEventTypeText() {
        return ARRHYTHMIA_EVENT_TYPE_TEXT;
    }

    public static String getArrhythmiaAlarmMessage() {
        return ARRHYTHMIA_ALARM_MESSAGE;
    }

    public static String getAlarmMessageForNoWaveformData() {
        return TECHNICAL_ALARM_MESSAGE_FOR_BLANK_WAVEFORM_DATA;
    }

    public static String getAlarmMessageForDropout() {  return TECHNICAL_ALARM_MESSAGE_FOR_DROPOUT; }

    public static int getWaveformDropoutTime() {  return WAVEFORM_DROPOUT_TIMEOUT; }

    public static int getWaveformNoDataAvailableTime() {  return WAVEFORM_NO_DATA_AVAILABLE_TIME; }

    public static String getInfiniteAlarmType() { return GET_INFINITE_ALARM_TYPE;   }

    public static String getTimedAlarmType() { return GET_TIMED_ALARM_TYPE;   }

    public static String getMpvPageName() {  return GET_MPV_PAGE_NAME;  }

    public static String getSpvPageName() { return GET_SPV_PAGE_NAME;   }

    public static String getLocationStringDelimiter() {   return LOCATION_STRING_DELIMITER;  }

    public static String getPatientNameTooltipStringDelimiter() {   return PATIENT_NAME_TOOLTIP_STRING_DELIMITER;  }

    public static String getPatientCardBorderColor() {   return PATIENT_CARD_BORDER_COLOR;  }

    public static String getHorizontalLayoutName() { return ALARM_LIST_HORIZONTAL_LAYOUT_NAME; }

    public static String getVerticalLayoutLeftName() { return ALARM_LIST_VERTICAL_LEFT_LAYOUT_NAME; }

    public static String getVerticalLayoutRightName() { return ALARM_LIST_VERTICAL_RIGHT_LAYOUT_NAME; }

    public static String getAlarmListNonePriorityAlarmColor() { return ALARM_LIST_NONE_PRIORITY_FOREGROUND_COLOR; }

    public static String getAlarmListNonePriorityLocationAlarmColor() { return ALARM_LIST_NONE_PRIORITY_LOCATION_FOREGROUND_COLOR; }

    public static String getAlarmListNonePriorityAlarmBackgroundColor() { return ALARM_LIST_NONE_PRIORITY_BACKGROUND_COLOR; }

    public static String getDisabledStateNotAssignedPriorityAlarmBackgroundColor() { return DISABLED_STATE_PRIORITY_BACKGROUND_COLOR; }

    public static String getDisabledStateNotAssignedPriorityAlarmColor() { return DISABLED_STATE_PRIORITY_FOREGROUND_COLOR; }

    public static String getDisabledStateClassName() { return DISABLED_STATE_CLASS_NAME; }

    public static String getAlarmListMonitoringStatusMessage() { return ALARM_LIST_MONITORING_STATUS_MESSAGE;   }

    public static String getAlarmListDisabledStateMessage() { return ALARM_LIST_DISABLED_STATE_MESSAGE; }

    public static String getAlarmListMessageFontSize() { return ALARM_LIST_ALARM_MESSAGE_FONT_SIZE; }

    public static String getAlarmListMessageFontFamily() { return ALARM_LIST_ALARM_MESSAGE_FONT_FAMILY; }

    public static String getAlarmListMessageFontWeight() { return ALARM_LIST_ALARM_MESSAGE_FONT_WEIGHT; }

    public static String getAlarmBannerNonHighPriorityHotSpotAreaBadgeBGColor() { return ALARM_BANNER_NON_HIGH_PRIORITY_HOTSPOT_AREA_BADGE_BG_COLOR; }

    public static String getAlarmBannerHighPriorityHotSpotAreaBadgeBGColor() { return ALARM_BANNER_HIGH_PRIORITY_ALARM_HOTSPOT_AREA_BADGE_BG_COLOR; }

    public static String getHotSpotAreaBadgeFontWidth() { return ALARM_BANNER_HOTSPOT_AREA_BADGE_WIDTH; }

    public static String getHotSpotAreaBadgeFontWidthForGreaterThanNine() { return ALARM_BANNER_HOTSPOT_AREA_BADGE_WIDTH_FOR_GREATER_THAN_NINE; }

    public static String getHotSpotAreaBadgeRadius() { return ALARM_BANNER_HOTSPOT_AREA_BADGE_RADIUS; }

    public static String getHotSpotAreaBadgeFontHeight() { return ALARM_BANNER_HOTSPOT_AREA_BADGE_HEIGHT; }

    public static String getHotSpotAreaBadgeAlignment() { return ALARM_BANNER_HOTSPOT_AREA_ALIGNMENT; }

    public static String getHotSpotAreaAlarmCountFontSize() { return ALARM_BANNER_HOTSPOT_AREA_ALARM_COUNT_FONT_SIZE; }

    public static String getHotSpotAreaAlarmCountFontWeight() { return ALARM_BANNER_HOTSPOT_AREA_ALARM_COUNT_FONT_WEIGHT; }

    public static String getAlarmBannerHighPriorityHotSpotAreaAlarmCountFGColor() { return ALARM_BANNER_HIGH_PRIORITY_HOTSPOT_AREA_ALARM_COUNT_FG_COLOR; }

    public static String getAlarmBannerNonHighPriorityHotSpotAreaAlarmCountFGColor() { return ALARM_BANNER_NON_HIGH_PRIORITY_HOTSPOT_AREA_ALARM_COUNT_FG_COLOR; }

    public static String getAlarmCountForGreaterThanNine() { return ALARM_BANNER_HOTSPOT_AREA_ALARM_COUNT_FOR_GREATER_THAN_NINE ; }

    public static Integer getAlarmBannerHotSpotAreaBadgeMaxCount() { return ALARM_BANNER_HOTSPOT_AREA_BADGE_TEXT_MAX_COUNT; }

    public static Integer getAlarmBannerHotSpotAreaBadgeMinCount() { return ALARM_BANNER_HOTSPOT_AREA_BADGE_TEXT_MIN_COUNT; }

    public static String getAlarmBannerDifferentiatorLineGap() { return ALARM_BANNER_DIFFERENTIATOR_LINE_GAP; }

    public static String getTimedAcknowledgeType() { return ALARM_BANNER_ALARM_CONTROL_TIMED_ACK_TYPE; }

    public static String getInfiniteAcknowledgeType() { return ALARM_BANNER_ALARM_CONTROL_INFINITE_ACK_TYPE; }

    public static String getTimedAlarmUnAckStateTooltipText() { return ALARM_BANNER_ALARM_CONTROL_TIMED_UN_ACK_STATE_TOOLTIP_TEXT; }

    public static String getAlarmAckStateTooltipText() { return ALARM_BANNER_ALARM_CONTROL_ACK_STATE_TOOLTIP_TEXT; }

    public static String getIndefAlarmUnAckStateTooltipText() { return ALARM_BANNER_ALARM_CONTROL_INDEF_UN_ACK_STATE_TOOLTIP_TEXT; }

    public static String getNotApplicablePriorityForAcknowledge() { return ALARM_BANNER_PRIORITY_NOT_APPLIES_FOR_ACKNOWLEDGE;   }

    public static String getAlarmControlApplicableAlarmState() { return ALARM_BANNER_ALARM_CONTROL_APPLIES_FOR_LATCHED;   }

    public static int getResponseCode200() { return RESPONSE_CODE_200;  }

    public static String getDefaultColorOfVolumeSliderTick() {return DEFAULT_VOLUME_SLIDER_TICK_COLOR;}

    public static String getDefaultColorOfVolumeSliderThumb() {return DEFAULT_VOLUME_SLIDER_THUMB_COLOR;}

    public static String getDefaultColorOfVolumeSliderTrack() {return DEFAULT_VOLUME_SLIDER_TRACK_COLOR;}

    public static String getDefaultColorOfVolumeSliderMinMaxLabel() {return DEFAULT_VOLUME_SLIDER_MIN_MAX_LABEL_COLOR;}

    public static String getDefaultBGColorOfVolumeSliderTrack() {return DEFAULT_VOLUME_SLIDER_TRACK_BACKGROUND_COLOR;}

    public static String getDefaultColorOfVolumeSliderTickLightTheme() {return DEFAULT_VOLUME_SLIDER_TICK_COLOR_LIGHT_THEME;}

    public static String getDefaultColorOfVolumeSliderThumbLightTheme() {return DEFAULT_VOLUME_SLIDER_THUMB_COLOR_LIGHT_THEME;}

    public static String getDefaultColorOfVolumeSliderTrackLightTheme() {return DEFAULT_VOLUME_SLIDER_TRACK_COLOR_LIGHT_THEME;}

    public static String getDefaultColorOfVolumeSliderMinMaxLabelLightTheme() {return DEFAULT_VOLUME_SLIDER_MIN_MAX_LABEL_COLOR_LIGHT_THEME;}

    public static String getDefaultBGColorOfVolumeSliderTrackLightTheme() {return DEFAULT_VOLUME_SLIDER_TRACK_BACKGROUND_COLOR_LIGHT_THEME;}

    public static String getExpectedMarkerLabelFontSize() { return FD_FSW_WAVEFORM_MARKER_LABEL_FONT_SIZE;  }

    public static String getExpectedMarkerColor() { return FD_FSW_WAVEFORM_MARKER_COLOR;  }

    public static String getExpectedMarkerWidth() { return FD_FSW_WAVEFORM_MARKER_WIDTH;  }

    public static String getExpectedMarkerLabelFontColor() { return FD_FSW_WAVEFORM_MARKER_LABEL_FONT_COLOR; }

    public static String getFswDataLossMessageFontColor() { return FSW_DATA_LOSS_MESSAGE_FONT_COLOR;    }

    public static String getFswDataLossMessageFontSize() { return FSW_DATA_LOSS_MESSAGE_FONT_SIZE;    }

    public static String getFswDataLossMessageFontWeight() { return FSW_DATA_LOSS_MESSAGE_FONT_WEIGHT;    }

    public static String getFswDataLossIconContentColor() { return FSW_DATA_LOSS_ICON_CONTENT_COLOR;    }

    public static String getExpandCOllapseReviewFlagIconsColorOnHover() { return ED_EXPAND_COLLAPSE_FLAG_REVIEW_ICON_COLOR_ON_HOVER; }

    public static String getThePopoverHeaderTextAndProperties() { return ED_FILTER_POPOVER_BORDER_COLOR; }

    public static String getEventPanelBackgroundColor() { return EVENT_PANEL_BACKGROUND_COLOR; }

    public static String getEventPanelBorderColor() { return EVENT_PANEL_BORDER_COLOR; }

    public static String getExpectedPriorityFlagColorOpacityInInboxTab() { return ED_PRIORITY_FLAG_COLOR_OPACITY_IN_INBOX_TAB;  }

    public static String getExpectedPriorityFlagColorOpacityInDeletedTab() { return ED_PRIORITY_FLAG_COLOR_OPACITY_IN_DELETED_TAB;  }

    public static String getPopoverHeaderText() { return ED_FILTER_POPOVER_INFO_TEXT;
    }

    public static String getPopoverBackgroundColor() { return ED_FILTER_POPOVER_BG_COLOR;
    }

    public static String getCollapsedFilterIconColor() { return ED_FILTER_COLLAPSED_STATE_ICON_COLOR;
    }

    public static String getExpandedFilterIconColor() { return ED_FILTER_EXPANDED_STATE_ICON_COLOR;
    }

    public static String getClearAllFilterText() { return ED_FILTER_CLEAR_ALL_TEXT;
    }

    public static String getExpectedReviewedIconColor() { return ED_EVENT_TICKET_REVIEWED_ICON_COLOR;
    }

    public static String getStripDurationAccordionBackgroundColor()
    {
        return STRIP_DURATION_ACCORDION_BACKGROUND_COLOR;
    }

    public static String getBackgroundColorOfHoveredAccordionPanel() {return LABS_HOVERED_ACCORDION_PANEL_BACKGROUND_COLOR;}

    public static String getBackgroundColorOfPressedAccordionPanel() {return LABS_PRESSED_ACCORDION_PANEL_BACKGROUND_COLOR;}

    public static String getBackgroundColorOfDefaultAccordionPanel() {return LABS_DEFAULT_ACCORDION_PANEL_BACKGROUND_COLOR;}

    public static String getBackgroundColorOfHoveredFlipOrOverlayIcon() {return LABS_HOVERED_FLIP_OR_OVERLAY_ICON_BACKGROUND_COLOR;}

    public static String getForegroundColorOfFishboneStructureLightTheme() {return LABS_FISHBONE_STRUCTURE_FOREGROUND_COLOR_LIGHT_THEME;}

    public static String getForegroundColorOfFishboneStructure() {return LABS_FISHBONE_STRUCTURE_FOREGROUND_COLOR;}

    public static String getBackgroundColorOfPressedFlipOrOverlayIcon() {return LABS_PRESSED_FLIP_OR_OVERLAY_ICON_BACKGROUND_COLOR;}

    public static String getFontFamilyOfAccordianName() {return LABS_ACCORDION_NAME_FONT_FAMILY;}

    public static String getFontColorOfAccordianName() {return LABS_ACCORDION_NAME_FONT_COLOR;}

    public static String getFontColorOfAccordianNameLightTheme() {return LABS_ACCORDION_NAME_FONT_COLOR_LIGHT_THEME;}

    public static String getFontSizeOfAccordianName() {return LABS_ACCORDION_NAME_FONT_SIZE;}

    public static String getStripDurationAccordionBorderColor()
    {
        return STRIP_DURATION_ACCORDION_BORDER_COLOR;
    }

    public static String getStripSelectionFilledColor()
    {
        return STRIP_SELECTION_FILLED_COLOR;
    }

    public static String getWidthOfStripSelectionLines()
    {
        return STRIP_SELECTION_LINE_WIDTH;
    }

    public static String getColorOfStripSelectionLines()
    {
        return STRIP_SELECTION_LINE_COLOR;
    }

    public static String getColorOfStripOverlay()
    {
        return STRIP_OVERLAY_LEFT_AND_RIGHT_COLOR;
    }

    public static String getBackgroundColorOfDefaultDurationTextField() { return DEFAULT_DURATION_TEXT_FIELD_BACKGROUND_COLOR; }

    public static String getBorderColorOfDefaultDurationTextField() { return DEFAULT_DURATION_TEXT_FIELD_BORDER_COLOR; }

    public static String getBackgroundColorOfHoveredDurationTextField() { return HOVERED_DURATION_TEXT_FIELD_BACKGROUND_COLOR; }

    public static String getBorderColorOfHoveredDurationTextField() { return HOVERED_DURATION_TEXT_FIELD_BORDER_COLOR; }

    public static String getBackgroundColorOfSelectedDurationTextField() { return SELECTED_DURATION_TEXT_FIELD_BACKGROUND_COLOR; }

    public static String getBorderColorOfSelectedDurationTextField() { return SELECTED_DURATION_TEXT_FIELD_BORDER_COLOR; }

    public static String getBackgroundColorOfErroredDurationTextField() { return ERRORED_DURATION_TEXT_FIELD_BACKGROUND_COLOR; }

    public static String getBorderColorOfErroredDurationTextField() { return ERRORED_DURATION_TEXT_FIELD_BORDER_COLOR; }

    public static String getBackgroundColorOfErroredPressedDurationTextField() { return ERRORED_PRESSED_DURATION_TEXT_FIELD_BACKGROUND_COLOR; }

    public static String getBorderColorOfErroredPressedDurationTextField() { return ERRORED_PRESSED_DURATION_TEXT_FIELD_BORDER_COLOR; }
    public static String getDefaultBackgroundColorOfStripParameter() {
        return STRIP_PARAMETER_DEFAULT_BACKGROUND_COLOR;
    }
    public static String getHoveredBorderColorOfStripParameter()
    {
        return STRIP_PARAMETER_HOVERED_BORDER_COLOR;
    }
    public static String getHoveredBackgroundColorOfStripParameter()
    {
        return STRIP_PARAMETER_HOVERED_BACKGROUND_COLOR;
    }
    public static String getFocusedFswWaveformOpacity()
    {
        return FOCUSED_FSW_WAVEFORM_OPACITY;
    }
    public static String getUnfocusedFswWaveformOpacity()
    {
        return UNFOCUSED_FSW_WAVEFORM_OPACITY;
    }

    public static void setCaliperTooltipXCoordinate(float tooltipXCoordinate){
        caliperTooltipXCoordinate = tooltipXCoordinate;
    }
    public static void setCaliperTooltipYCoordinate(float tooltipYCoordinate){
        caliperTooltipYCoordinate = tooltipYCoordinate;
    }
    public static float getCaliperTooltipXCoordinate(){return caliperTooltipXCoordinate;}
    public static float getCaliperTooltipYCoordinate(){return caliperTooltipYCoordinate;}

    public static String getMarkerDateBeforePrint() {
        return MARKER_DATE_BEFORE_PRINT.get();
    }

    public static void setMarkerDateBeforePrint(String v) {
        MARKER_DATE_BEFORE_PRINT.set(v);
    }

    public static String getMarkerTimeBeforePrint() {
        return MARKER_TIME_BEFORE_PRINT.get();
    }

    public static void setMarkerTimeBeforePrint(String v) {
        MARKER_TIME_BEFORE_PRINT.set(v);
    }

    public static String getWaveformStartTime() {
        return WAVEFORM_START_TIME.get();
    }

    public static void setWaveformStartTime(String v) {
        WAVEFORM_START_TIME.set(v);
    }

    public static String getWaveformEndTime() {
        return WAVEFORM_END_TIME.get();
    }

    public static void setWaveformEndTime(String v) {
        WAVEFORM_END_TIME.set(v);
    }

    public static String getCustomTooltipValLimitHighPriorityHexColorCode() {
        return CUSTOM_TOOLTIP_VAL_LIMIT_HIGH_PRIORITY_HEX_COLOR_CODE;
    }

    public static String getLocationStringDelimeterInFhr()
    {
        return LOCATION_STRING_DELIMETER_IN_FHR;
    }

    public static String getDefaultFhrMhrWaveformConfig() {
        return DEFAULT_FHR_MHR_WAVEFORM_CONFIG;
    }

    public static String getDefaultUaWaveformConfig()
    {
        return DEFAULT_UA_WAVEFORM_CONFIG;
    }

    private static final ThreadLocal<List<String>> MONITORING_CHANNEL_IDs = new ThreadLocal<>();

    public static void setMonitoringChannelIDs(List<String> IDs){
        MONITORING_CHANNEL_IDs.set(IDs);
    }

    public static List<String> getMonitoringChannelIDs(){
        return MONITORING_CHANNEL_IDs.get();
    }
    public static String perinatalParameter()
    {
        return PERINATAL_PARAMETER;
    }
    public static String getFhrPatientBannerBGColor()
    {
        return FHR_PATIENT_BANNER_BACKGROUND_COLOR;
    }

    public static String getFSWActiveLeadLabelColorForDarkTheme() {return FD_FSW_ACTIVE_LABEL_COLOR_ForDarkTheme;}
    public static String getFSWActiveLeadLabelOpacity() {return FD_FSW_ACTIVE_LABEL_OPACITY;}
    public static String getFSWInactiveLeadLabelColorForDarkTheme() {return FD_FSW_IN_ACTIVE_LABEL_COLOR_ForDarkTheme;}
    public static String getFSWInactiveLeadLabelOpacity()
    {
        return FD_FSW_IN_ACTIVE_LABEL_OPACITY;
    }

    public static String getFSWActiveLeadLabelColorForLightTheme() {return FD_FSW_ACTIVE_LABEL_COLOR_ForLightTheme;}
    public static String getFSWInactiveLeadLabelColorForLightTheme() {return FD_FSW_IN_ACTIVE_LABEL_COLOR_ForLightTheme;}

    public static String getDstBadgeLocation() {
        return DST_BADGE_LOCATION;
    }

    public static void setDstBadgeLocation(String dstBadgeLocation) {
        DST_BADGE_LOCATION = dstBadgeLocation;
    }

    public static final String  DATE_FORMAT_ISO = "yyyy-MM-dd'T'HH:mm:ss+'05:30'";
    public static final String  DATE_FORMAT_YYYY_MM_DD ="yyyy-MM-dd";
    public static final String  DATE_FORMAT_NON_ISO ="yyyy-MM-dd'T':mm:ss+'05:30'";
    public static final String  DATE_FORMAT_12_HOUR ="yyyy-MM-dd'T'KK:mm:ss+'05:30'";
}
