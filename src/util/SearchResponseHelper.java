package util;

import domain.Restaurant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henry on 12/3/16.
 */
public class SearchResponseHelper {

    public static List<Restaurant> getRestaurants(String searchResponseJSON) {
        JSONParser parser = new JSONParser();
        JSONObject response = null;
        try {
            response = (JSONObject) parser.parse(searchResponseJSON);
        } catch (ParseException pe) {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            System.exit(1);
        }
        return parseRestaurants(response);
    }

    private static List<Restaurant> parseRestaurants(JSONObject response) {
        List<Restaurant> restaurantList = new ArrayList<>();

        JSONArray businesses = (JSONArray) response.get("businesses");
        for (int i = 0; i < businesses.size(); i++) {
            JSONObject object = (JSONObject) businesses.get(i);
            Long id = Long.parseLong(object.get("id").toString());
            String name = object.get("name").toString() ;

            Restaurant restaurant = new Restaurant();
            restaurant.setId(id);
            restaurant.setName(name);
            restaurantList.add(restaurant);
        }
        return restaurantList;
    }
}
