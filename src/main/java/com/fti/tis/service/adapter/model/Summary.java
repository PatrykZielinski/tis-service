package com.fti.tis.service.adapter.model;

public class Summary {

    private String title;

    public Summary() {
        // default constructor for json deserialization
    }

    public Summary(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
