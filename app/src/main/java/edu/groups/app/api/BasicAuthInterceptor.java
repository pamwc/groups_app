package edu.groups.app.api;

import android.support.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;

import edu.groups.app.model.BasicCredentials;
import edu.groups.app.model.User;
import edu.groups.app.repository.UserRealmRepository;
import io.realm.Realm;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Kamil on 05/11/2017.
 */

public class BasicAuthInterceptor implements Interceptor {


    @Inject
    UserRealmRepository userRealmRepository;

    private static volatile String credentials;

    public static String getCredentials() {
        return credentials;
    }

    public void storeCredentials(@NonNull BasicCredentials basicCredentials) {
        credentials = Credentials.basic(
                basicCredentials.getUsername(), basicCredentials.getPassword()
        );
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (credentials == null) {
            User user = userRealmRepository.get().get();
            credentials = Credentials.basic(user.getCredentials().getUsername(), user.getCredentials().getPassword());
        }
        if (credentials != null) {
            request = request.newBuilder()
                    .addHeader("Authorization", credentials)
                    .build();
        }

        return chain.proceed(request);
    }
}
