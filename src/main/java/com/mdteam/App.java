package com.mdteam;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mdteam.models.Results;
import com.mdteam.models2.Details;
import com.mdteam.models3.LatestResult;

import com.google.gson.reflect.TypeToken;
import com.mdteam.detailsmodel.*;
import com.mdteam.model.Result;
import com.mdteam.playmodel.*;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static spark.debug.DebugScreen.enableDebugScreen;
import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App{
    //To Log all the Json Data That we are receiving
    static Logger logger = LoggerFactory.getLogger(App.class);
    //TOP RATED
    //Converitng JSON Object to TV Series Object using JSONOBJECT and GSON Library
    public static List<Results> processTvSeriesResult(Response response){
        //Putting all our results in an Array List
        List<Results> results= new ArrayList<>();

        //Trying to convert JSON Object to Tv Series Object
        try{
            //Converting response Json data to a String
            String jsonData = response.body().string();

            //Checking if our Response is Successful
            if (response.isSuccessful()){
                //Converting our JSON String (jsondata) to A JSON Object
                JSONObject responseJson = new JSONObject(jsonData);
                JSONArray jsonArray = responseJson.getJSONArray("results");

                Type collectionType = new TypeToken<List<Results>>(){}.getType();
                //Converting JSON Object to a java Object using GSON library
                //instance of the class GSON
                Gson gson = new GsonBuilder().create();
                //Converting JSON STRING (responseJson) to Tv Series java object
                results = gson.fromJson(jsonArray.toString(),collectionType );
            }
        } catch (JSONException | NullPointerException | IOException e){
            //Catching Resposes
            e.printStackTrace();
        }
        return results;
    }

    //POPULAR
    public static List<LatestResult> processLatestTvResult(Response response){
        List<LatestResult> LatestResults= new ArrayList<>();
        try{
            String jsonData3 = response.body().string();

            if (response.isSuccessful()){
                JSONObject responseJson = new JSONObject(jsonData3);
                JSONArray jsonArray = responseJson.getJSONArray("results");

                Type collectionType = new TypeToken<List<LatestResult>>(){}.getType();
                Gson gson = new GsonBuilder().create();
                LatestResults = gson.fromJson(jsonArray.toString(),collectionType );
            }
        } catch (JSONException | NullPointerException | IOException e){
            e.printStackTrace();
        }
        return LatestResults;
    }

    //DETAILS
    public static Details processTvSeriesDetails(Response response){
        Details details= null;
        try{
            String jsonData2 = response.body().string();
            if (response.isSuccessful()){
                JSONObject responseJson = new JSONObject(jsonData2);
                Gson gson = new GsonBuilder().create();
                details = gson.fromJson(responseJson.toString(), Details.class);
            }
        } catch (JSONException | NullPointerException | IOException e){
            e.printStackTrace();
        }
        return details;
    }
  
  ////MOVIES/////
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


   public static void main(String[] args){

        //Creating a New OkHttp Request
       OkHttpClient client = new OkHttpClient();

       //Debugging Screen
       enableDebugScreen();

       staticFileLocation("/public");

       //layout template
       String layout = "templates/layout.vtl";

       //INDEX PAGE // Top rated
     get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            HttpUrl.Builder playingBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
            // playingBuilder.addQueryParameter(Constants.VIDEO_PARAMETER,Constants.VIDEO);
            // playingBuilder.addQueryParameter(Constants.ADULT_PARAMETER,Constants.ADULT);
            // playingBuilder.addQueryParameter(Constants.SORT_PARAMETER,Constants.SORT);
            playingBuilder.addQueryParameter(Constants.API_PRE,Constants.API_KEY);

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
     
       get("/tv", (request, response1) -> {
           Map<String, Object> model = new HashMap<>();
           //HttpUrlBuilder for Latest Movies
           HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
           //Adding My Api Key To get A request1
           urlBuilder.addQueryParameter(Constants.API_PRE,Constants.API_KEY);
           //Building and storing it in a Variable called url
           String url = urlBuilder.build().toString();
           //Creating a request1 using OkHttp Library and Building
           Request request1 = new Request.Builder()
                   .url(url)
                   .build();
           //Trying to get a response from server
           try(Response response = client.newCall(request1).execute()){
               List<Results> result = processTvSeriesResult(response);
               //Checking if result is null or not
               if (result != null){
                   model.put("results", result);
               }
           } catch (IOException e){
               e.getStackTrace();
               //Catching an IOException
           }
           model.put("template", "templates/tv.vtl");
           return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
       });

        get("/playing", (req,res)->{
            Map<String, Object> model = new HashMap<>();

            HttpUrl.Builder playingBuilder = HttpUrl.parse(Constants.PLAYING_URL_PARAMETER).newBuilder();
            playingBuilder.addQueryParameter(Constants.API_PRE,Constants.API_KEY);

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
            detailsBuilder.addQueryParameter(Constants.API_PRE,Constants.API_KEY);
            
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

       get("/popular", (request, response1) -> {
           Map<String, Object> model = new HashMap<>();
           HttpUrl.Builder urlBuilder3 = HttpUrl.parse(Constants.BASE_POPULAR_URL).newBuilder();
           urlBuilder3.addQueryParameter(Constants.API_PRE,Constants.API_KEY);
           String url3 = urlBuilder3.build().toString();
           Request request3 = new Request.Builder()
                   .url(url3)
                   .build();
           try(Response response = client.newCall(request3).execute()){
               List<LatestResult> LatestResults = processLatestTvResult(response);
               if (LatestResults != null){
                   model.put("LatestResults", LatestResults);
               }
           } catch (IOException e){
               e.getStackTrace();
           }
           model.put("template", "templates/popular.vtl");
           return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
       });

       get("/series/:id", (request, response) -> {
           Map<String, Object> model = new HashMap<>();
           HttpUrl.Builder urlBuilder2 = HttpUrl.parse(Constants.BASE_DETAILS_URL).newBuilder();
           LatestResult stID = new LatestResult();
           String ID = request.params("id");
           urlBuilder2.addPathSegment(ID);
           urlBuilder2.addQueryParameter(Constants.API_PRE,Constants.API_KEY);
           String url2 = urlBuilder2.build().toString();
           Request request2 = new Request.Builder()
                   .url(url2)
                   .build();
           try(Response response2 = client.newCall(request2).execute()){
               Details details = processTvSeriesDetails(response2);
               if (details != null){
                   model.put("details", details);
               }
           } catch (IOException e){
               e.getStackTrace();
           }
           model.put("template", "templates/viewSeries.vtl");
           return new VelocityTemplateEngine().render(new ModelAndView(model, layout));
       });
   }
    }
