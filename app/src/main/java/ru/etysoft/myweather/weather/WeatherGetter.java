package ru.etysoft.myweather.weather;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherGetter {

    public static String LOCATION;

    private static OkHttpClient client = new OkHttpClient();

    private static final String KEY = "174b5b1ad29746299cf230242231505";

    static String getResponse(String location) throws IOException {
        String myUrl = "https://api.weatherapi.com/v1/forecast.json?key=" + KEY +
                "&q=metar:" + location + "&days=" + WeekForecast.WEEK + "&aqi=no&alerts=no";

        Request request = new Request.Builder()
                .url(myUrl)
                .build();

        Response response = client.newCall(request).execute();
        String jsonResponse = response.body().string();

        return jsonResponse;

    }

}
