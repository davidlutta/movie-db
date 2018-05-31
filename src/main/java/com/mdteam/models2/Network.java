
package com.mdteam.models2;

import java.util.HashMap;
import java.util.Map;

public class Network {

    private String name;
    private int id;
    private String logoPath;
    private String originCountry;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Network() {
    }

    /**
     * 
     * @param id
     * @param originCountry
     * @param name
     * @param logoPath
     */
    public Network(String name, int id, String logoPath, String originCountry) {
        super();
        this.name = name;
        this.id = id;
        this.logoPath = logoPath;
        this.originCountry = originCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
