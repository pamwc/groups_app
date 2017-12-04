package edu.groups.app.ui.group;

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
import edu.groups.app.ui.group.post.Comment;
import edu.groups.app.ui.group.post.PostAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by howor on 19.11.2017.
 */

public class GroupPresenter extends InnerPresenter<GroupFragmentContract.View> implements GroupFragmentContract.Presenter  {

    private List<Post> posts;
    private GroupService groupService;
    private PostService postService;
    private GroupContract.View groupView;
    private GroupDto group;
    private long groupId;

    @Inject
    protected GroupPresenter(GroupFragmentContract.View view, UserService userService, GroupService groupService,
                             PostService postService, GroupContract.View groupView) {
        super(view, userService);
        this.groupService = groupService;
        this.postService = postService;
        this.groupView = groupView;
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
                        this.group = group;
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
        postService.removePost(postId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).doOnComplete(()->{
            posts.remove(postPosition);
            view.notifyAdapterPostDeleted(postPosition);
        }).subscribe();
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
    public List<String> getGroupAdmins() {
        return group.getAdminsUserNames();
    }

    @Override
    public List<String> getGroupMembers() {
        return group.getMembersUserNames();
    }

    @Override
    public void leaveGroupClick() {
        view.showLeaveGroupDialog();
    }

    @Override
    public void joinCodeClick() {
        disposable.add(groupService.getJoinCode(groupId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(view::showJoinCodeDialog, throwable -> view.showError(throwable.getMessage())));
    }

    @Override
    public List<String> currentUserRole() {
        return getCurrentUser().getRoles();
    }

    @Override
    public void leaveGroup() {
        disposable.add(groupService.leaveGroup(groupId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(groupView::finish, throwable -> view.showError(throwable.getMessage())));
    }

    @Override
    public void resetCode() {
        disposable.add(groupService.resetJoinCode(groupId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showJoinCodeDialog, throwable -> view.showError(throwable.getMessage())));
    }

    @Override
    public Post getPost(int position) {
        return posts.get(position);
   }
}
