package org.application.core.http;

public class Request {
    protected URI uri;
    protected Methods method;

    public Request() {
        uri = null;
        method = Methods.GET;
    }

    public Methods getMethod() {
        return method;
    }

    public void setMethod(Methods method) {
        this.method = method;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public void setUri(String uri) {
        this.uri = new URI(uri);
    }
}
