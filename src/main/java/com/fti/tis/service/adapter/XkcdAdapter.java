package com.fti.tis.service.adapter;

import com.fti.tis.service.adapter.model.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Component
public class XkcdAdapter {

    private final RestTemplate xkcdRestTemplate;

    @Autowired
    public XkcdAdapter(final RestTemplate xkcdRestTemplate) {
        Assert.notNull(xkcdRestTemplate, "xkcdRestTemplate can't be null");
        this.xkcdRestTemplate = xkcdRestTemplate;
    }

    public Summary getSummary() {
        return xkcdRestTemplate.getForObject("/info.0.json", Summary.class);
    }
}
