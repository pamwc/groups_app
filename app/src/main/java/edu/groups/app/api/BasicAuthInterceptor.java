package edu.groups.app.api;

import android.support.annotation.NonNull;

import java.io.IOException;

import edu.groups.app.model.BasicCredentials;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Kamil on 05/11/2017.
 */

public class BasicAuthInterceptor implements Interceptor {

    private volatile String credentials;

    public void storeCredentials(@NonNull BasicCredentials basicCredentials) {
        credentials = Credentials.basic(
                basicCredentials.getUsername(), basicCredentials.getPassword()
        );
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (credentials != null) {
            request = request.newBuilder()
                    .addHeader("Authorization", credentials)
                    .build();
        }

        return chain.proceed(request);
    }
}
