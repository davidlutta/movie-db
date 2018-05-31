
package com.lkaranja;

import java.util.HashMap;
import java.util.Map;

public class SpokenLanguage {

    private String iso6391;
    private String name;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
