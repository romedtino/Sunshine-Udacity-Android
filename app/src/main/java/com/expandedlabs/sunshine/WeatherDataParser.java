package com.expandedlabs.sunshine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by darkamikaze on 8/19/2014.
 */
public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        JSONObject json = new JSONObject(weatherJsonStr);
       JSONArray jsonArray = json.getJSONArray("list");
        JSONObject dayObject = jsonArray.getJSONObject(dayIndex);

        return dayObject.getJSONObject("temp").getDouble("max");
    }

}