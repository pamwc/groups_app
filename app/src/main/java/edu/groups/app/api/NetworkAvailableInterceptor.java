package edu.groups.app.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

import edu.groups.app.model.exception.NoNetworkException;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Dawid Świnoga on 25.11.2017.
 */

public class NetworkAvailableInterceptor implements Interceptor {
    private Context context;

    public NetworkAvailableInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!isNetworkAvailable(context)) {
            throw new NoNetworkException("No network connection");
        }
        return chain.proceed(chain.request());
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
        } catch (Exception e) {
            return false;
        }
    }
}
