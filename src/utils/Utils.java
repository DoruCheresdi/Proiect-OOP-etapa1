package utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;
import enums.Cities;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.Locale;

public final class Utils {
    /**
     * function to transform an array of Json strings to an array of Category
     * @param categoryJson
     * @return
     */
    public static ArrayList<Category> jsonToCategory(JSONArray categoryJson) {
        ArrayList<Category> categories = new ArrayList<>();
        for (Object category : categoryJson) {
            categories.add(Category.categoryOfValue((String) category));
        }
        return categories;
    }

    /**
     * function to transform an array of Json strings to an array of Cities
     * @param citiesJson
     * @return
     */
    public static ArrayList<Cities> jsonToCities(JSONArray citiesJson) {
        ArrayList<Cities> cities = new ArrayList<>();
        for (Object city : citiesJson) {
            cities.add(Cities.cityOfValue((String) city));
        }
        return cities;
    }
}
