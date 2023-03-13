package interfaces.hotel;

public class LoginRegisterJourneyPageUI {
    public static final String LOGIN_OR_SIGNUP_JOURNEY_POP_UP = "//div[contains(@class, 'popupLoginRegisterV2-content')]";
    public static final String EMAIL_TEXTBOX_AT_LOGIN_OR_SIGNUP_JOURNEY_POP_UP = "//input[@name='email']";
    public static final String PASSWORD_TEXTBOX_AT_LOGIN_OR_SIGNUP_JOURNEY_POP_UP = "//input[@name='password']";
    public static final String CONTINUE_BUTTON_AT_LOGIN_OR_SIGNUP_JOURNEY_POP_UP = "//button[div[text()='Continue']]";

    public static final String CONDITION_CHARACTER_LONG_CHECKBOX = "//p[contains(@class, 'ConditionInputPassword_active') and text()='Between 8-64 characters long']";
    public static final String CONDITION_LOWERCASE_CHECKBOX = "//p[contains(@class, 'ConditionInputPassword_active') and text()='At least one lowercase letter (a-z)']";
    public static final String CONDITION_UPPERCASE_CHECKBOX = "//p[contains(@class, 'ConditionInputPassword_active') and text()='At least one uppercase letter (A-Z)']";
    public static final String CONDITION_NUMERAL_CHECKBOX = "//p[contains(@class, 'ConditionInputPassword_active') and text()='At least one numeral (0-9)']";
    public static final String CONDITION_SPECIAL_CHARACTER_CHECKBOX = "//p[contains(@class, 'ConditionInputPassword_active') and text()='At least one special character (e.g. !@#$%)']";
    public static final String CONDITION_WHITE_SPACE_CHECKBOX = "//p[contains(@class, 'ConditionInputPassword_active') and text()='Whitespace not allowed']";

    public static final String VERIFICATION_CODE_TEXTBOX = "//input[@name='digit_code']";
    public static final String SUBMIT_BUTTON = "//button[div[text()='Submit']]";
    public static final String OK_BUTTON_AT_REGISTER_SUCCESS_POP_UP = "//div[text()='Success']/following-sibling::button[div[text()='Explore']]";
    public static final String EMAIL_VERIFICATION_CODE_COUNTDOWN = "//div[contains(@class, 'EmailCodeConfirm_countdown')]";
    public static final String CLOSE_BUTTON_ON_SIGN_UP_JOURNEY_POP_UP = "//img[contains(@class,'LoginRegisterPopupV2_close')]";

}
