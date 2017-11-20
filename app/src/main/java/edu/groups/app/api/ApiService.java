package edu.groups.app.api;

import java.util.List;

import edu.groups.app.model.Group;
import edu.groups.app.model.User;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Kamil on 04/11/2017.
 */

public interface ApiService {

    @GET("users/me")
    Observable<User> aboutMe();

    @GET("groups/my")
    Observable<List<Group>> myGroups();
}
