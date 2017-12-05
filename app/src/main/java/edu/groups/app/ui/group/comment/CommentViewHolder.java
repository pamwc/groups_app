package edu.groups.app.ui.group.comment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.groups.app.R;

/**
 * Created by Piotr Borczyk on 05.12.2017.
 */

public class CommentViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.userPhoto)
    ImageView userPhoto;

    @BindView(R.id.nameAndSurname)
    TextView nameAndSurname;

    @BindView(R.id.user_comment)
    TextView userComment;

    public CommentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setCommentContent(String commentContent) {
        userComment.setText(commentContent);
    }

    public void setUserName(String userName) {
        nameAndSurname.setText(userName);
    }
}
