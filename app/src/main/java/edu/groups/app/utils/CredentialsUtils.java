package edu.groups.app.utils;

import edu.groups.app.model.UserCredentials;
import okhttp3.Credentials;

/**
 * Created by Kamil on 05/11/2017.
 */

public class CredentialsUtils {

    public static String createBasicAuthHeader(final UserCredentials userCredentials) {
        return Credentials.basic(
                userCredentials.getUsername(), userCredentials.getPassword()
        );
    }
}
