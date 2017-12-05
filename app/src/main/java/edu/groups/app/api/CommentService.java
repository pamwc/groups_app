package edu.groups.app.api;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Piotr Borczyk on 05.12.2017.
 */

public interface CommentService {
    @POST("groups/posts/{postId}/comments")
    Observable<Long> createNewComment(@Path("postId") Long postId, @Body String commentContent);

    @PUT("groups/posts/comments/{commentId}")
    Completable editComment(@Path("commentId") Long commentId, @Body String comment);

    @DELETE("groups/posts/comments/{commentId}")
    Completable deleteComment(@Path("commentId") Long commentId);

}
