
package com.mdteam.models2;

import java.util.HashMap;
import java.util.Map;

public class CreatedBy {

    private int id;
    private String name;
    private String profilePath;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CreatedBy() {
    }

    /**
     * 
     * @param id
     * @param profilePath
     * @param name
     */
    public CreatedBy(int id, String name, String profilePath) {
        super();
        this.id = id;
        this.name = name;
        this.profilePath = profilePath;
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

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
