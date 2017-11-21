package edu.groups.app.ui.main.group;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import edu.groups.app.api.GroupService;
import edu.groups.app.api.PostService;
import edu.groups.app.model.group.GroupDto;
import edu.groups.app.model.group.Post;
import edu.groups.app.model.post.NewPostDto;
import edu.groups.app.service.UserService;
import edu.groups.app.ui.InnerPresenter;
import edu.groups.app.ui.main.group.post.Comment;
import edu.groups.app.ui.main.group.post.PostAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by howor on 19.11.2017.
 */

public class GroupPresenter extends InnerPresenter<GroupFragmentContract.View> implements GroupFragmentContract.Presenter  {

    private List<Post> posts;
    private GroupService groupService;
    private PostService postService;
    private long groupId;

    @Inject
    protected GroupPresenter(GroupFragmentContract.View view, UserService userService, GroupService groupService,
                             PostService postService) {
        super(view, userService);
        this.groupService = groupService;
        this.postService = postService;
    }

    @Override
    public void onResume() {
        super.onResume();
        bindViews();
        Disposable groupSubscribe = getPostsFromApi();
        disposable.add(groupSubscribe);
    }

    @NonNull
    private Disposable getPostsFromApi() {
        return groupService.getGroup(groupId).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(group -> {
                        initializeLabels(group);
                        initializePosts(group);
                        setPostAdapter();
                    });
    }

    private void setPostAdapter() {
        PostAdapter adapter = new PostAdapter(this);
        view.setAdapter(adapter);
    }

    private void bindViews() {

    }

    private void initializeLabels(GroupDto group) {
        view.setGroupName(group.getName());
        view.setGroupTutor(getFormattedTutorsLabel(group));
    }

    private void initializePosts(GroupDto group) {
        posts = group.getPosts();
    }

    private String getFormattedTutorsLabel(GroupDto groupDto) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : groupDto.getAdminsUserNames()) {
            stringBuilder.append(name);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Override
    public void addPost(NewPostDto newPostDto) {
        postService.createNewPost(groupId, newPostDto).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postId ->{
                    disposable.add(getPostsFromApi());
                    view.notifyAdapterPostAdded();
                });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void deletePost(int postPosition) {
        Post post = posts.get(postPosition);
        Long postId = post.getId();
        postService.removePost(postId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                //TO DO
            }
        });
        posts.remove(postPosition);

    }

    @Override
    public void commentPost(int postId, Comment comment) {
        //MAYBE TO DO
    }

    @Override
    public int getPostCount() {
        return posts.size();
    }

    @Override
    public Post getPost(int position) {
        return posts.get(position);
   }
}