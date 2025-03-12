package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.google.gson.Gson;

public class PracticeTask4 implements PracticeTask {
    public class ApiResponse{
        public Map<String, String> headers;
    }

    public void run(){
        System.out.println("Задача 4");
        System.out.println(getAcceptableAnswerTypes("https://httpbin.org/anything") + "\n");
    }

    private String getAcceptableAnswerTypes(String url){
        var headers = getHeadersFromJSON(url);
        return headers.get("Accept");
    }

    private Map<String, String> getHeadersFromJSON(String url){
        var gson = new Gson();
        return gson.fromJson(getHttpRequestResponse(url), ApiResponse.class).headers;
    }

    private String getHttpRequestResponse(String url) {
        try {
            var connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            var responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                var in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                var response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}