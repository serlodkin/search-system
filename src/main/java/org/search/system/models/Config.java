package org.search.system.models;

/**
 * @author Daniil Matkov
 * @since 13.07.2017
 */
public class Config {

    private String loggingType;

    private String loggingUrl;

    public Config(String loggingType, String loggingUrl) {
        this.loggingType = loggingType;
        this.loggingUrl = loggingUrl;
    }

    public String getLoggingType() {
        return loggingType;
    }

    public void setLoggingType(String loggingType) {
        this.loggingType = loggingType;
    }

    public String getLoggingUrl() {
        return loggingUrl;
    }

    public void setLoggingUrl(String loggingUrl) {
        this.loggingUrl = loggingUrl;
    }
}
