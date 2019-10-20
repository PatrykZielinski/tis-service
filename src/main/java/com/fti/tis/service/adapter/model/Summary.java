package com.fti.tis.service.adapter.model;

public class Summary {

    private String title;

    public String getTitle() {
        return title;
    }

    public static class Builder {
        private Summary instance = new Summary();

        public Builder setTitle(final String title) {
            instance.title = title;
            return this;
        }

        public Summary build() {
            return instance;
        }
    }
}
