package Homework7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherModel implements WeatherModel {

    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "j4Pr5wr7tKMXa8YGHawpA5W9kkY3QlPr";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATION = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String LANGUAGE = "language";
    private static final String METRIC = "metric";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {

//            http://dataservice.accuweather.com/forecasts/v1/daily/1day
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECAST)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE, "ru-ru")
                        .addQueryParameter(METRIC, "true")
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponce = oneDayForecastResponse.body().string();

                String date = weatherResponce.split(":")[21];
                date = date.split("T")[0];
                date = date.replace("\"", "");

                String addition = weatherResponce.split("IconPhrase\":\"")[1];
                addition = addition.split("\"")[0];

                String tempMin = weatherResponce.split(":")[28];
                tempMin = tempMin.split(",")[0];
                String tempMax = weatherResponce.split(":")[32];
                tempMax = tempMax.split(",")[0];

                System.out.println("Сегодня: " + date + ". " + addition +
                        ". Температура от " + tempMin + " до " + tempMax + " градусов цельсия.\n");

                break;

            case FIVE_DAYS:
                HttpUrl httpUrl5 = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECAST)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE, "ru-ru")
                        .addQueryParameter(METRIC, "true")
                        .build();

                Request request5 = new Request.Builder()
                        .url(httpUrl5)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(request5).execute();
                String weatherResponce5 = fiveDayForecastResponse.body().string();

                for(int i = 1; i < 6; i++) {
                    String splitDays = weatherResponce5.split("\"Date\":\"")[i];
                    String date5 = splitDays.split("T")[0];

                    String addition5 = splitDays.split("IconPhrase\":\"")[1];
                    addition5 = addition5.split("\"")[0];

                    String tempMin5 = splitDays.split(":")[7];
                    tempMin5 = tempMin5.split(",")[0];
                    String tempMax5 = splitDays.split(":")[11];
                    tempMax5 = tempMax5.split(",")[0];

                    System.out.println(date5 + ". " + addition5 +
                            ". Температура от " + tempMin5 + " до " + tempMax5 + " градусов цельсия.");
                }
                System.out.println();
                break;
        }
    }

    private String detectCityKey(String selectedCity) throws IOException {
//        http://dataservice.accuweather.com/locations/v1/cities/autocomplete

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATION)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responceCity = response.body().string();

        String cityKey = objectMapper.readTree(responceCity).get(0).at("/Key").asText();

        return cityKey;
    }
}
