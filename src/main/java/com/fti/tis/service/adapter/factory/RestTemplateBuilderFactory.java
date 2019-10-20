package com.fti.tis.service.adapter.factory;

import com.fti.tis.service.util.RestLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBuilderFactory {

    @Bean(name = "xkcdRestTemplateBuilder")
    public RestTemplateBuilder xkcdRestTemplateBuilder(@Value("${xkcd.host.url}") final String xkcdUrl) {
        Assert.notNull(xkcdUrl, "xkcdUrl can't be null");
        return new RestTemplateBuilder()
                .rootUri(xkcdUrl);
    }

    @Bean(name = "xkcdRestTemplate")
    public RestTemplate xkcdRestTemplate(@Autowired final RestTemplateBuilder xkcdRestTemplateBuilder) {
        Assert.notNull(xkcdRestTemplateBuilder, "xkcdRestTemplateBuilder can't be null");
        final RestTemplate restTemplate = xkcdRestTemplateBuilder.build();
        restTemplate.getInterceptors().add(new RestLoggingInterceptor());
        return xkcdRestTemplateBuilder.build();
    }
}
