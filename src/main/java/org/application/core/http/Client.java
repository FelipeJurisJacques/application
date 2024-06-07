package org.application.core.http;

import org.application.core.Native;
import org.application.core.asynchronous.Promise;
import org.application.core.asynchronous.ActionCatch;
import org.application.core.asynchronous.ActionThen;

public class Client extends Native {
    protected URI uri;
    protected boolean errors;

    public Client() {
        uri = null;
        errors = false;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public Promise<Response> request(Request request) {
        Promise<Response> promise = new Promise<Response>();
        try {
            // Promise<Object> fetch = fetch(request.getUri().toString());
            Promise<Object> fetch = fetch("www.google.com");
            // fetch.setThen(new ActionThen<Object>() {
            //     @Override
            //     public void actionPerformed(Object value) {
            //         promise.resolve(null);
            //     }
            // });
            // fetch.setCatch(new ActionCatch() {
            //     @Override
            //     public void actionPerformed(Throwable error) {
            //         promise.reject(error);
            //     }
            // });
        } catch (Throwable error) {
            promise.reject(error);
        }
        return promise;
    }

    public Promise<Response> request(String url) {
        Request request = new Request();
        request.setUri(url);
        return request(request);
    }

    /**
     * RESPOSTAS APRESENTAM ERROS
     */
    public boolean isEnabledErrors() {
        return errors;
    }

    /**
     * RESPOSTAS DEVEM APRESENTAR ERROS
     */
    public void setEnableError(boolean error) {
        this.errors = error;
    }

    @Override
    public void finalize() {
        if (uri != null) {
            uri.finalize();
            uri = null;
        }
    }
}
