package pages.search;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import commons.CommonTravalaPages;
import net.masterthought.cucumber.generators.AbstractPage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SearchingAPI extends CommonTravalaPages {
//  static AbstractPage abstractPage = new AbstractPage();
  private static final String API_SEARCH_BY_LOCATION = "https://api.travala.com/searching/search/search-by-location";
  private static final String API_SEARCH_BY_LOCATION_FILTER_COUNT = "https://api.travala.com/searching/search/search-by-location/filter-count";
  private static final String API_SEARCH_PROPERTY = "https://api.travala.com/searching/search/search-property";
  private static final String CHECK_IN_PARAMS = "check_in";
  private static final String CHECK_OUT_PARAMS = "check_out";
  private static final String LOCATION_ID_PARAMS = "location";
  private static final String PLACE_TYPES_PARAMS = "place_types";

  private static final String SESSION_ID_PARAMS = "session_id";
  private static final String ROOM1_PARAMS = "r1"; //If we have multiple rooms, we add number for room params. Ex: room 1 = r1, room 2 = r2
  private static final String NUMBER_PAGE_PARAMS = "page";
  private static final String NUMBER_RECORD_FOR_PAGE_PARAMS = "per_page";
  private static final String USER_CURRENCY_PARAMS = "user_currency";

  private static final String FILTER_TRUSTYOU_RATING_PARAMS = "trustyou_rating";
  private static final String FILTER_AMENITIES_PARAMS = "amenities";
  private static final String FILTER_STAR_RATING_PARAMS = "star_rating";
  private static final String FILTER_MAX_PRICE_PARAMS = "max_price";
  private static final String FILTER_MIN_PRICE_PARAMS = "min_price";
  private static final String FILTER_POPULAR_PARAMS = "popular";
  private static final String FILTER_PAYMENT_TYPES_PARAMS = "payment_types";
  private static final String FILTER_HOTEL_CHAINS_PARAMS = "hotel_chains";
  private static final String FILTER_HOTEL_TYPES_PARAMS = "hotel_types";
  private static final String FILTER_ROOM_BOARDS_PARAMS = "roomBoards";
  private static final String FILTER_ROOM_TYPES_PARAMS = "roomTypes";
  private static final String FILTER_ROOM_CLASSES_PARAMS = "roomClasses";
  private static final String SORT_PARAMS = "sort";

  private static final String CHECK_IN_DEFAULT = getDatePlus(7, "yyyy-MM-dd");
  private static final String CHECK_OUT_DEFAULT = getDatePlus(8, "yyyy-MM-dd");
  private static final String ROOM1_DEFAULT = "2";
  private static final String NUMBER_PAGE_DEFAULT = "1";
  private static final String NUMBER_RECORD_FOR_PAGE_DEFAULT = "45";
  private static final String USER_CURRENCY_DEFAULT = "USD";

  private static final String SORT_PROPERTY_RANK_VALUE = "RANK_ASC";
  private static final String SORT_RATING_HIGHEST_FIRST_VALUE = "RATING_DESC";
  private static final String SORT_RATING_LOWEST_FIRST_VALUE = "RATING_ASC";
  private static final String SORT_PRICE_HIGH_TO_LOW_VALUE = "PRICE_DESC";
  private static final String SORT_PRICE_LOW_TO_HIGH_VALUE = "PRICE_ASC";
  private static final String SORT_DISTANCE_VALUE = "DISTANCE_ASC";
  private static final String SORT_TOP_RATED = "SCORE_DESC";


  private static Map<String, Object> getDefaultParamsForSearchHotel() {
    Map<String, Object> defaultParams = new HashMap<>();
    defaultParams.put(CHECK_IN_PARAMS, CHECK_IN_DEFAULT);
    defaultParams.put(CHECK_OUT_PARAMS, CHECK_OUT_DEFAULT);
    defaultParams.put(ROOM1_PARAMS, ROOM1_DEFAULT);
    defaultParams.put(NUMBER_PAGE_PARAMS, NUMBER_PAGE_DEFAULT);
    defaultParams.put(NUMBER_RECORD_FOR_PAGE_PARAMS, NUMBER_RECORD_FOR_PAGE_DEFAULT);
    return defaultParams;
  }

  private static Map<String, Object> getFilterParams(String trustyou_rating, String amenities, String star_rating, String max_price, String min_price,
                                                     String popular, String payment_types, String roomBoards, String roomTypes, String roomClasses) {
    Map<String, Object> filterParams = new HashMap<>();
    if (!trustyou_rating.isBlank()){filterParams.put(FILTER_TRUSTYOU_RATING_PARAMS, trustyou_rating);}
    if (!amenities.isBlank()){filterParams.put(FILTER_AMENITIES_PARAMS, amenities);}
    if (!star_rating.isBlank()){filterParams.put(FILTER_STAR_RATING_PARAMS, star_rating);}
    if (!max_price.isBlank()){filterParams.put(FILTER_MAX_PRICE_PARAMS, max_price);}
    if (!min_price.isBlank()){filterParams.put(FILTER_MIN_PRICE_PARAMS, min_price);}
    if (!popular.isBlank()){filterParams.put(FILTER_POPULAR_PARAMS, popular);}
    if (!payment_types.isBlank()){filterParams.put(FILTER_PAYMENT_TYPES_PARAMS, payment_types);}
    if (!roomBoards.isBlank()){filterParams.put(FILTER_ROOM_BOARDS_PARAMS, roomBoards);}
    if (!roomTypes.isBlank()){filterParams.put(FILTER_ROOM_TYPES_PARAMS, roomTypes);}
    if (!roomClasses.isBlank()){filterParams.put(FILTER_ROOM_CLASSES_PARAMS, roomClasses);}
    return filterParams;
  }

  public HttpResponse<JsonNode> getJsonResultSearchByLocation(String locationId) throws UnirestException {
    Map<String, Object> params = getDefaultParamsForSearchHotel();
    params.put(LOCATION_ID_PARAMS, locationId);
    return Unirest.get(API_SEARCH_BY_LOCATION).queryString(params).asJson();
  }

  public HttpResponse<JsonNode> getJsonResultFilterSearchByLocation(String locationId, Map<String, Object> filterSearchData) throws UnirestException {
    filterSearchData.put(LOCATION_ID_PARAMS, locationId);
    return Unirest.get(API_SEARCH_BY_LOCATION).queryString(filterSearchData).asJson();
  }

  public HttpResponse<JsonNode> getJsonResultSearchAfterSortByProperty(String locationId, String sortProperty) throws UnirestException {
    Map<String, Object> params = new HashMap<>(getDefaultParamsForSearchHotel());
    params.put(SESSION_ID_PARAMS, getSessionIdBySessionSearch(locationId));
    params.put(LOCATION_ID_PARAMS, locationId);
    switch (sortProperty) {
      case "Property Rank" :
        params.put(SORT_PARAMS, SORT_PROPERTY_RANK_VALUE);
      case "Rating (Highest first)":
        params.put(SORT_PARAMS, SORT_RATING_HIGHEST_FIRST_VALUE);
      case "Rating (Lowest first)":
        params.put(SORT_PARAMS, SORT_RATING_LOWEST_FIRST_VALUE);
      case "Price (High to low)":
        params.put(SORT_PARAMS, SORT_PRICE_HIGH_TO_LOW_VALUE);
      case "Price (Low to high)":
        params.put(SORT_PARAMS, SORT_PRICE_LOW_TO_HIGH_VALUE);
      case "Distance from downtown":
        params.put(SORT_PARAMS, SORT_DISTANCE_VALUE);
      default:
        params.put(SORT_PARAMS, SORT_TOP_RATED);
    }

    return Unirest.get(API_SEARCH_BY_LOCATION).queryString(params).asJson();
  }

  public HttpResponse<JsonNode> getJsonListFilterDataBySessionSearchLocation(String locationId) throws UnirestException {
    Map<String, Object> filterCountParams = new HashMap<>();
    filterCountParams.put(CHECK_IN_PARAMS, CHECK_IN_DEFAULT);
    filterCountParams.put(CHECK_OUT_PARAMS, CHECK_OUT_DEFAULT);
    filterCountParams.put(LOCATION_ID_PARAMS, locationId);
    filterCountParams.put(ROOM1_PARAMS, ROOM1_DEFAULT);
    filterCountParams.put(USER_CURRENCY_PARAMS, USER_CURRENCY_DEFAULT);
    filterCountParams.put(SESSION_ID_PARAMS, getSessionIdBySessionSearch(locationId));
    return Unirest.get(API_SEARCH_BY_LOCATION_FILTER_COUNT).queryString(filterCountParams).asJson();
  }

  public List<String> getListHotelNameByLocation(String locationId) throws UnirestException {
    List<String> listResultHotel = new ArrayList<>();
    HttpResponse<JsonNode> dataJson = getJsonResultSearchByLocation(locationId);
    JSONObject objectData = dataJson.getBody().getObject();
    JSONArray listHotel = objectData.getJSONArray("data");
    int total = listHotel.length();
    for(int i = 0; i < total; i++) {
      if(listHotel.getJSONObject(i).has("hotel_id")) {
        String hotelName = listHotel.getJSONObject(i).getString("name");
        listResultHotel.add(hotelName);
      }
    }
    return listResultHotel;
  }

  protected String getSessionIdBySessionSearch(String locationId) throws UnirestException {
    return getJsonResultSearchByLocation(locationId).getBody().getObject().getJSONObject("meta").getString("searchCode");
  }

  public List<String> getListHotelNameAfterSortByProperty(String propertySort, String locationId) throws UnirestException {
    List<String> listResultHotel = new ArrayList<>();
    HttpResponse<JsonNode> dataJson = getJsonResultSearchAfterSortByProperty(locationId, propertySort);
    JSONObject objectData = dataJson.getBody().getObject();
    JSONArray listHotel = objectData.getJSONArray("data");
    int total = listHotel.length();
    for(int i = 0; i < total; i++) {
      if(listHotel.getJSONObject(i).has("hotel_id")) {
        String hotelName = listHotel.getJSONObject(i).getString("name");
        listResultHotel.add(hotelName);
      }
    }
    return listResultHotel;
  }

}