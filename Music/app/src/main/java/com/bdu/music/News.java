package com.bdu.music;

public class News {
    String date;
    String reporter;
    String location;
    String type;
    String detail;

    public News(String date, String reporter, String location, String type, String detail) {
        this.date = date;
        this.reporter = reporter;
        this.location = location;
        this.type = type;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
