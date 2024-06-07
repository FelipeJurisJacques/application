package org.application.core.http;

import org.application.core.util.Map;

public class URI {
    private int port;
    private String hash;
    private String host;
    private String path;
    private String protocol;
    private Map<String, String> query;

    public URI() {
        port = 0;
        hash = null;
        host = null;
        path = null;
        query = null;
        protocol = null;
    }

    public URI(String url) {
        port = 0;
        hash = null;
        host = null;
        path = null;
        query = null;
        protocol = null;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Map<String, String> getQuery() {
        return query;
    }

    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    public void resolve(URI uri) {
    }

    public void resolve(String url) {
        resolve(new URI(url));
    }

    @Override
    public String toString() {
        if (host == null || host.isEmpty()) {
            throw new IllegalStateException("illegal host");
        }
        if (protocol == null || protocol.isEmpty()) {
            throw new IllegalStateException("illegal protocol");
        }
        String url = protocol + "://" + host;
        return url;
    }

    @Override
    public void finalize() {
        port = 0;
        hash = null;
        host = null;
        path = null;
        query = null;
        protocol = null;
    }
}
