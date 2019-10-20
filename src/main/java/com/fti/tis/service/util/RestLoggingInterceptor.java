package com.fti.tis.service.util;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestLoggingInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestLoggingInterceptor.class);
    private static final String ENCODING = "UTF-8";

    @Override
    public ClientHttpResponse intercept(final HttpRequest httpRequest, final byte[] bytes,
                                        final ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        logRequest(httpRequest, bytes);
        final ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);
        logResponse(response);
        return response;
    }

    private void logRequest(final HttpRequest request, final byte[] body) throws IOException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("===========================request begin================================================");
            LOGGER.debug("URI         : {}", request.getURI());
            LOGGER.debug("Method      : {}", request.getMethod());
            LOGGER.debug("Headers     : {}", request.getHeaders());
            LOGGER.debug("Request body: {}", new String(body, ENCODING));
            LOGGER.debug("==========================request end================================================");
        }
    }

    private void logResponse(final ClientHttpResponse response) throws IOException {
        if (response != null & LOGGER.isDebugEnabled()) {
            LOGGER.debug("============================response begin==========================================");
            LOGGER.debug("Status code  : {}", response.getStatusCode());
            LOGGER.debug("Status text  : {}", response.getStatusText());
            LOGGER.debug("Headers      : {}", response.getHeaders());
            LOGGER.debug("Response body: {}", new String(IOUtils.toByteArray(response.getBody()), ENCODING));
            LOGGER.debug("=======================response end=================================================");
        }
    }

}
