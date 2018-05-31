package com.mdteam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.mdteam.detailsmodel.Details;
import com.mdteam.model.Result;
import com.mdteam.playmodel.*;

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

    // Discover Resuslts handling
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

    public static List<PlayResult> processPlayingResults(Response response) {
        List<PlayResult> playresults = new ArrayList<>();
        // Result result = null;

        try {
            String jsonData = response.body().string();

            // logger.info("jsonData: " + jsonData);
            if (response.isSuccessful()) {
                JSONObject responseJson = new JSONObject(jsonData);
                JSONArray jsonArray = responseJson.getJSONArray("results");

                Type collectionType = new TypeToken<List<PlayResult>>() {}.getType();

                Gson gson = new GsonBuilder().create();
                playresults = gson.fromJson(jsonArray.toString(), collectionType);
                
            }
        } catch (JSONException | NullPointerException | IOException e) {
            e.printStackTrace();
        }

        return playresults;
    }

    public static Details processDetailResults(Response response) {
        Details detailresults = null;
        // Result result = null;

        try {
            String jsonData = response.body().string();
            logger.info("Details response: " + jsonData);
            if (response.isSuccessful()) {
                JSONObject responseJson = new JSONObject(jsonData);
                // JSONArray jsonArray = responseJson.getJSONArray("results");

                // Type collectionType = new TypeToken<List<Details>>() {}.getType();

                Gson gson = new GsonBuilder().create();
                detailresults = gson.fromJson(responseJson.toString(), Details.class);
                
            }
        } catch (JSONException | NullPointerException | IOException e) {
            e.printStackTrace();
        }

        return detailresults;
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

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            HttpUrl.Builder playingBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
            playingBuilder.addQueryParameter(Constants.VIDEO_PARAMETER,Constants.VIDEO);
            playingBuilder.addQueryParameter(Constants.ADULT_PARAMETER,Constants.ADULT);
            playingBuilder.addQueryParameter(Constants.SORT_PARAMETER,Constants.SORT);
            playingBuilder.addQueryParameter(Constants.API_PARAMETER,Constants.API);

            String url = playingBuilder.build().toString();
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


        get("/playing", (req,res)->{
            Map<String, Object> model = new HashMap<>();

            HttpUrl.Builder playingBuilder = HttpUrl.parse(Constants.PLAYING_URL_PARAMETER).newBuilder();
            playingBuilder.addQueryParameter(Constants.API_PARAMETER,Constants.API);

            String url_playing = playingBuilder.build().toString();
            logger.info("PLaying url is: "+url_playing);

            Request requestplay = new Request.Builder()
                .url(url_playing)
                .build();

            try (Response playresponse = client.newCall(requestplay).execute()) {
                List<PlayResult> playin_result = processPlayingResults(playresponse);
                if (playin_result != null) {
                    model.put("playing", playin_result);
                    // logger.info("Playing result is: "+playin_result);

                }
            } catch(IOException e) {
                e.getStackTrace();
            }

            model.put("template", "templates/playing.vtl");
            return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
        });
        get("/details/:id", (req,res)->{
            Map<String, Object> model = new HashMap<>();

            String movieID = req.params("id");

            HttpUrl.Builder detailsBuilder = HttpUrl.parse(Constants.BASE_MOVIE_URL).newBuilder();
            detailsBuilder.addPathSegments(movieID);            
            detailsBuilder.addQueryParameter(Constants.API_PARAMETER,Constants.API);
            
            // detailsBuilder.addQueryParameter(name, value)

            String url_details = detailsBuilder.build().toString();
            logger.info("Details url is: "+url_details);

            Request requestdetails= new Request.Builder()
                .url(url_details)
                .build();

            try (Response detailsresponse = client.newCall(requestdetails).execute()) {
                Details details_result = processDetailResults(detailsresponse);
                if (details_result != null) {
                    model.put("details", details_result);

                }
            } catch(IOException e) {
                e.getStackTrace();
            }

            model.put("template", "templates/details.vtl");
            return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
        });
    }
}