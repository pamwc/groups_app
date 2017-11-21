package edu.groups.app.api;

import edu.groups.app.model.post.EditPostDto;
import edu.groups.app.model.post.NewPostDto;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Piotr Borczyk on 21.11.2017.
 */

public interface PostService {
    @DELETE("groups/posts/{postId}")
    void removePost(@Path("postId") Long postId);

    @PUT("groups/posts/{postId}")
    void editPost(@Path("postId") Long postId, @Body EditPostDto editPostDto);

    @POST("groups/{groupId}/posts")
    Observable<Long> createNewPost(@Path("groupId") Long groupId, @Body NewPostDto newPostDto);
}
