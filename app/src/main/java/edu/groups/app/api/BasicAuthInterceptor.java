package edu.groups.app.api;

import java.io.IOException;

import edu.groups.app.model.UserCredentials;
import edu.groups.app.utils.CredentialsUtils;
import io.realm.Realm;
import java8.util.Optional;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Kamil on 05/11/2017.
 */

public class BasicAuthInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Optional<UserCredentials> credentials = getUserCredentials();
        if (credentials.isPresent()) {
            String basicAuthHeader
                    = CredentialsUtils.createBasicAuthHeader(credentials.get());
            request = request.newBuilder()
                    .addHeader("Authorization", basicAuthHeader)
                    .build();
        }

        return chain.proceed(request);
    }

    private Optional<UserCredentials> getUserCredentials() {
        try(Realm realm = Realm.getDefaultInstance()) {
            UserCredentials userCredentials = realm.where(UserCredentials.class)
                    .equalTo("id", UserCredentials.ID)
                    .findFirst();

            return userCredentials == null ? Optional.empty()
                    : Optional.ofNullable(realm.copyFromRealm(userCredentials));
        }
    }
}
