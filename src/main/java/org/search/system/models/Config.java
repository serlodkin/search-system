package org.search.system.models;

/**
 * @author Daniil Matkov
 * @since 13.07.2017
 */
public class Config {

    private String loggingType;

    private String loggingUrl;

    private String fromName;

    private String status;

    public Config(String loggingType, String loggingUrl, String fromName, String status) {
        this.loggingType = loggingType;
        this.loggingUrl = loggingUrl;
        this.fromName = fromName;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }
}
