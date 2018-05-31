
package com.mdteam.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private String original_name;
    private List<Integer> genreIds = null;
    private String name;
    private double popularity;
    private List<String> originCountry = null;
    private int vote_count;
    private String firstAirDate;
    private String backdrop_path;
    private String originalLanguage;
    private int id;
    private double voteAverage;
    private String overview;
    private String poster_path;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param genreIds
     * @param originalName
     * @param originalLanguage
     * @param backdropPath
     * @param voteCount
     * @param id
     * @param originCountry
     * @param overview
     * @param posterPath
     * @param name
     * @param firstAirDate
     * @param voteAverage
     * @param popularity
     */
    public Result(String originalName, List<Integer> genreIds, String name, double popularity, List<String> originCountry, int voteCount, String firstAirDate, String backdropPath, String originalLanguage, int id, double voteAverage, String overview, String posterPath) {
        super();
        this.original_name = originalName;
        this.genreIds = genreIds;
        this.name = name;
        this.popularity = popularity;
        this.originCountry = originCountry;
        this.vote_count = voteCount;
        this.firstAirDate = firstAirDate;
        this.backdrop_path = backdropPath;
        this.originalLanguage = originalLanguage;
        this.id = id;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.poster_path = posterPath;
    }

    public String getOriginalName() {
        return original_name;
    }

    public void setOriginalName(String originalName) {
        this.original_name = originalName;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public int getVoteCount() {
        return vote_count;
    }

    public void setVoteCount(int voteCount) {
        this.vote_count = voteCount;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getBackdropPath() {
        return backdrop_path;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdrop_path = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public void setPosterPath(String posterPath) {
        this.poster_path = posterPath;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
