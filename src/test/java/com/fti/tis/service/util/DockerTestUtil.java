package com.fti.tis.service.util;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Optional;

public final class DockerTestUtil {
    private static final int DEFAULT_PORT = 8080;
    private static final String TOOLBOX_URL = "http://192.168.99.100";
    private static final String LOCAL_HOST_URL = "http://localhost";

    private DockerTestUtil() {
        //
    }

    public static int resolvePort() {
        return DEFAULT_PORT;
    }

    public static String resolveHost() {
        Optional<Socket> socket = Optional.empty();
        try {
            final URL url = new URL(TOOLBOX_URL);
            socket = Optional.of(new Socket(url.getHost(), DEFAULT_PORT));
            return TOOLBOX_URL;
        } catch (final IOException ignored) {
            return LOCAL_HOST_URL;
        } finally {
            socket.ifPresent(DockerTestUtil::closeSocket);
        }
    }

    private static void closeSocket(final Socket socket) {
        try {
            socket.close();
        } catch (final IOException ignored) {
        }
    }
}
