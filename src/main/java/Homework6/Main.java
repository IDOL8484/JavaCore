package Homework6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("295212")
                .addQueryParameter("apikey", "j4Pr5wr7tKMXa8YGHawpA5W9kkY3QlPr")
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response responseOneDay = okHttpClient.newCall(request).execute();

        String weatherResponce = responseOneDay.body().string();
//        System.out.println(weatherResponce);

        String date = weatherResponce.split("\"")[37];
        String weatherMin = weatherResponce.split("\"")[46];
        weatherMin = weatherMin.replace(",", "");
        String weatherMax = weatherResponce.split("\"")[56];
        weatherMax = weatherMax.replace(":", "");
        String weatherRain = weatherResponce.split("\"")[69];

        System.out.println(date);
        System.out.println("Температура" + weatherMin + " ~ " + weatherMax + " " + weatherRain + ".");

    }
}
