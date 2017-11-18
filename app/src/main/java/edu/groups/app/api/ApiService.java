package edu.groups.app.api;

import edu.groups.app.model.User;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Kamil on 04/11/2017.
 */

public interface ApiService {

    @GET("users/me")
    Observable<User> aboutMe();
}
