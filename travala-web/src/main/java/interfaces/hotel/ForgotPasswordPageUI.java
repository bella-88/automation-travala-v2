package interfaces.hotel;

public class ForgotPasswordPageUI {
    public static final String FORGOT_PASSWORD_TITLE="//div[contains(@class,'forgotPassword')]/h1/span";
    public static final String FORGOT_PASSWORD_SUB="//div[contains(@class,'forgotPassword')]/p";
    public static final String FORGOT_PASSWORD_EMAIL="(//input[@type='email'])[1]";
    public static final String FORGOT_PASSWORD_CHECKBOX="//div[@class='recaptcha-checkbox-border']";
    public static final String FORGOT_PASSWORD_RESET_BTN="(//button[@type='submit'])[1]";
    public static final String FORGOT_PASSWORD_NOTICE_SENT="//p[contains(@class,'mb-1')]";
    public static final String FORGOT_PASSWORD_BACK_TO_PREVIOUS="//p[contains(@class,'mb-1')]/following-sibling::a";



}
