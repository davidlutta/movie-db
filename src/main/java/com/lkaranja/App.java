package com.lkaranja;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.lkaranja.model.Result;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    static Logger logger = LoggerFactory.getLogger(App.class);

    public static List<Result> processResults(Response response) {
        List<Result> results = new ArrayList<>();
        // Result result = null;

        try {
            String jsonData = response.body().string();

            // logger.info("jsonData: " + jsonData);
            if (response.isSuccessful()) {
                JSONObject responseJson = new JSONObject(jsonData);
                JSONArray jsonArray = responseJson.getJSONArray("results");

                Type collectionType = new TypeToken<List<Result>>() {}.getType();

                Gson gson = new GsonBuilder().create();
                results = gson.fromJson(jsonArray.toString(), collectionType);
                
            }
        } catch (JSONException | NullPointerException | IOException e) {
            e.printStackTrace();
        }

        return results;
    }

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);
        // enableDebugScreen();

        staticFileLocation("/public");
        String layout = "templates/layout.vtl";


        // get("/", (req, res) -> {
        //     Map<String, Object> model = new HashMap<>();
        //     model.put("template", "templates/index.vtl");
        //     return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
        // });

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
            urlBuilder.addQueryParameter(Constants.VIDEO_PARAMETER,Constants.VIDEO);
            urlBuilder.addQueryParameter(Constants.ADULT_PARAMETER,Constants.ADULT);
            urlBuilder.addQueryParameter(Constants.SORT_PARAMETER,Constants.SORT);
            urlBuilder.addQueryParameter(Constants.API_PARAMETER,Constants.API);

            String url = urlBuilder.build().toString();
            logger.info("url is: "+url);

            Request request = new Request.Builder()
                .url(url)
                .build();

            try (Response response = client.newCall(request).execute()) {
                List<Result> result = processResults(response);
                if (result != null) {
                    model.put("movies", result);
                    // logger.info("Request is: "+request);

                }
            } catch(IOException e) {
                e.getStackTrace();
            }

            model.put("template", "templates/index.vtl");
            return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
        });
    }
}