package edu.groups.app.api;

import java.util.List;

import edu.groups.app.model.group.CreateGroupResponseDto;
import edu.groups.app.model.group.GroupDto;
import edu.groups.app.model.group.JoinGroupResponseDto;
import edu.groups.app.model.group.SimpleGroupDto;
import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Piotr Borczyk on 20.11.2017.
 */

public interface GroupService {

    @POST("groups")
    Observable<CreateGroupResponseDto> createGroup(@Body String groupName);

    @POST("groups/join")
    Observable<JoinGroupResponseDto> joinCurrentUserToGroup(@Body String code);

    @GET("groups/my")
    Observable<List<SimpleGroupDto>> getCurrentUserSimpleGroup();

    @DELETE("groups/{groupId}")
    Completable deleteGroup(@Path("groupId") Long groupId);

    @GET("groups/{groupId}")
    Observable<GroupDto> getGroup(@Path("groupId") Long groupId);

    @PUT("groups/{groupId}")
    Completable editGroupName(@Path("groupId") Long groupId, @Body String groupName);

    @GET("groups/{groupId}/joinCode")
    Observable<String> getJoinCode(@Path("groupId") Long groupId);

    @POST("groups/{groupId}/leave")
    Completable leaveGroup(@Path("groupId") Long groupId);

    @POST("groups/{groupId}/resetJoinCode")
    Completable resetJoinCode(@Path("groupId") Long groupId);
}
