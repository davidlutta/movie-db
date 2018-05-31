
package com.mdteam.models2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Details {

    private String backdropPath;
    private List<CreatedBy> created_by = null;
    private List<Integer> episode_run_time = null;
    private String first_air_date;
    private List<Genre> genres = null;
    private String homepage;
    private int id;
    private boolean inProduction;
    private List<String> languages = null;
    private String lastAirDate;
    private String name;
    private List<Network> networks = null;
    private int number_of_episodes;
    private int number_of_seasons;
    private List<String> originCountry = null;
    private String originalLanguage;
    private String originalName;
    private String overview;
    private double popularity;
    private String poster_path;
    private List<ProductionCompany> productionCompanies = null;
    private List<Season> seasons = null;
    private String status;
    private String type;
    private double voteAverage;
    private int voteCount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Details() {
    }

    /**
     * 
     * @param networks
     * @param genres
     * @param status
     * @param lastAirDate
     * @param originalName
     * @param originalLanguage
     * @param numberOfSeasons
     * @param type
     * @param backdropPath
     * @param voteCount
     * @param homepage
     * @param numberOfEpisodes
     * @param id
     * @param languages
     * @param originCountry
     * @param overview
     * @param createdBy
     * @param inProduction
     * @param seasons
     * @param posterPath
     * @param name
     * @param firstAirDate
     * @param voteAverage
     * @param productionCompanies
     * @param episodeRunTime
     * @param popularity
     */
    public Details(String backdropPath, List<CreatedBy> createdBy, List<Integer> episodeRunTime, String firstAirDate, List<Genre> genres, String homepage, int id, boolean inProduction, List<String> languages, String lastAirDate, String name, List<Network> networks, int numberOfEpisodes, int numberOfSeasons, List<String> originCountry, String originalLanguage, String originalName, String overview, double popularity, String posterPath, List<ProductionCompany> productionCompanies, List<Season> seasons, String status, String type, double voteAverage, int voteCount) {
        super();
        this.backdropPath = backdropPath;
        this.created_by = createdBy;
        this.episode_run_time = episodeRunTime;
        this.first_air_date = firstAirDate;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.inProduction = inProduction;
        this.languages = languages;
        this.lastAirDate = lastAirDate;
        this.name = name;
        this.networks = networks;
        this.number_of_episodes = numberOfEpisodes;
        this.number_of_seasons = numberOfSeasons;
        this.originCountry = originCountry;
        this.originalLanguage = originalLanguage;
        this.originalName = originalName;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = posterPath;
        this.productionCompanies = productionCompanies;
        this.seasons = seasons;
        this.status = status;
        this.type = type;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<CreatedBy> getCreatedBy() {
        return created_by;
    }

    public void setCreatedBy(List<CreatedBy> createdBy) {
        this.created_by = createdBy;
    }

    public List<Integer> getEpisodeRunTime() {
        return episode_run_time;
    }

    public void getEpisodeRunTime(List<Integer> episodeRunTime) {
        this.episode_run_time = episodeRunTime;
    }

    public String getFirstAirDate() {
        return first_air_date;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.first_air_date = firstAirDate;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInProduction() {
        return inProduction;
    }

    public void setInProduction(boolean inProduction) {
        this.inProduction = inProduction;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public int getNumberOfEpisodes() {
        return number_of_episodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.number_of_episodes = numberOfEpisodes;
    }

    public int getNumberOfSeasons() {
        return number_of_seasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.number_of_seasons = numberOfSeasons;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public void setPosterPath(String posterPath) {
        this.poster_path = posterPath;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
