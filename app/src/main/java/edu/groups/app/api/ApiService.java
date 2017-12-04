package edu.groups.app.api;

import java.util.List;

import edu.groups.app.model.SimpleUser;
import edu.groups.app.model.User;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Kamil on 04/11/2017.
 */

public interface ApiService {

    @GET("users/me")
    Observable<User> aboutMe();

    @GET("/users/{userNames}")
    Observable<List<SimpleUser>> getUsers(@Path("userNames") String users);

}
