
package com.mdteam.models2;

import java.util.HashMap;
import java.util.Map;

public class Season {

    private String airDate;
    private int episode_count;
    private int id;
    private String name;
    private String overview;
    private String posterPath;
    private int seasonNumber;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Season() {
    }

    /**
     * 
     * @param id
     * @param airDate
     * @param overview
     * @param posterPath
     * @param name
     * @param episodeCount
     * @param seasonNumber
     */
    public Season(String airDate, int episodeCount, int id, String name, String overview, String posterPath, int seasonNumber) {
        super();
        this.airDate = airDate;
        this.episode_count = episodeCount;
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.posterPath = posterPath;
        this.seasonNumber = seasonNumber;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public int getEpisodeCount() {
        return episode_count;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episode_count = episodeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
