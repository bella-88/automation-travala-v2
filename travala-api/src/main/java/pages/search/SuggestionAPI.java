package pages.search;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class SuggestionAPI {
  public static final String ENDPOINT_SUGGESTION_API = "https://api.travala.com/suggestion/autocomplete";
  public static final String TEXT_PARAMS = "q";
  public static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";

  private HttpResponse<JsonNode> getJsonResponseListSuggestionLocation(String text) throws UnirestException {
    Map<String, Object> params = new HashMap<>();
    params.put(TEXT_PARAMS, text);
    Map<String, String> header = new HashMap<>();
    header.put(ACCEPT_LANGUAGE_HEADER, "en");
    return Unirest.get(ENDPOINT_SUGGESTION_API).headers(header).queryString(params).asJson();
  }

  public HashMap<String, Map<String, String>> getListLocationByText(String text) throws UnirestException {
    HashMap<String, Map<String, String>> location = new HashMap<>();
    Map<String, String> listLocationId = new HashMap<>();
    Map<String, String> listAccentName = new HashMap<>();

    HttpResponse<JsonNode> dataJson = getJsonResponseListSuggestionLocation(text);
    JSONObject objectData = dataJson.getBody().getObject().getJSONObject("data");
    JSONArray listCities = objectData.getJSONArray("cities");
    for(int i = 0; i < listCities.length(); i++) {
      listLocationId.put("location-id"+(i+1), listCities.getJSONObject(i).getString("id"));
      listAccentName.put("location-name"+(i+1), listCities.getJSONObject(i).getString("accent_name"));
    }
    location.put("listLocationId", listLocationId);
    location.put("listAccentName", listAccentName);
    return location;
  }

  public ArrayList<Map<String, Object>> getListPropertyByText(String text) throws UnirestException {
    ArrayList<Map<String, Object>> listProperties = new ArrayList<>();
    HttpResponse<JsonNode> dataJson = getJsonResponseListSuggestionLocation(text);
    JSONObject objectData = dataJson.getBody().getObject().getJSONObject("data");
    JSONArray listPropertyJson = objectData.getJSONArray("properties");

    for (int i=0; i<listPropertyJson.length(); i++) {
      Set<String> keys = listPropertyJson.getJSONObject(i).keySet();
      Map<String, Object> properties = new HashMap<>();
      for (String key : keys) {
        if(key.contains("star_rate")) {
          properties.put(key.toString(), listPropertyJson.getJSONObject(i).getDouble(key.toString()));
        } else {
          properties.put(key.toString(), listPropertyJson.getJSONObject(i).getString(key.toString()));
        }
      }

      listProperties.add(properties);
    }
    return listProperties;
  }
}