package pages.mailsac;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static commons.CommonDataTravala.MAILSAC_API_KEY;

public class MailsacService {
    public static final String URL_MAILSAC_API = "https://mailsac.com/api";
    public static final String ADDRESS_MAILSAC_API = "/addresses/";
    public static final String BODY_MAILSAC_API = "/body/";
    public static final String MESSAGES_MAILSAC_API = "/messages";
    public static final String MAILSAC_KEY = "Mailsac-Key";
    public static final String SUBJECT_EMAIL_REQUEST_ACTIVATE_ACCOUNT = "EMAIL_REQUEST_ACTIVATE_ACCOUNT";

    private HttpResponse<JsonNode> getAllMessagesOfEmailInbox(String email) throws UnirestException
    {
        String endPoint = URL_MAILSAC_API + ADDRESS_MAILSAC_API + email + MESSAGES_MAILSAC_API;
        return Unirest.get(endPoint).header(MAILSAC_KEY, MAILSAC_API_KEY).asJson();
    }

    public String getMessageIdBySubject(String email, String subject) throws UnirestException
    {
        String messageId = "";
        HttpResponse<JsonNode> jsonResponse = getAllMessagesOfEmailInbox(email);
        int totalMessagesInbox = jsonResponse.getBody().getArray().length();
        int i = 0;
        while (i < totalMessagesInbox)
        {
            JSONObject object = jsonResponse.getBody().getArray().getJSONObject(i);
            String getSubject = object.getString("subject");
            if(subject.contentEquals(getSubject)) {
                messageId = object.getString("_id");
                break;
            }
            i++;
        }
        return messageId;
    }

    public String getVerificationCodeInMailsacInbox(String email) throws UnirestException
    {
        String verificationCode = "";
        String endPoint = URL_MAILSAC_API + BODY_MAILSAC_API + email + "/" + getMessageIdBySubject(email, SUBJECT_EMAIL_REQUEST_ACTIVATE_ACCOUNT);
        HttpResponse<String> response =  Unirest.get(endPoint).header(MAILSAC_KEY, MAILSAC_API_KEY).asString();
        Pattern pattern = Pattern.compile("<span>\\d{0,6}</span>");
        Matcher matcher = pattern.matcher(response.getBody());
        if(matcher.find()) {
            verificationCode = matcher.group().replaceAll("[a-z<>\\/]", "");
        }
        return verificationCode;
    }
}
