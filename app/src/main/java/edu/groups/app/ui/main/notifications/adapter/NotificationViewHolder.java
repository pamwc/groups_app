package edu.groups.app.ui.main.notifications.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.groups.app.R;

/**
 * Created by Piotr Borczyk on 27.11.2017.
 */

public class NotificationViewHolder extends RecyclerView.ViewHolder {

    private View rowView;

    @BindView(R.id.comment_title)
    TextView commentTitle;

    @BindView(R.id.comment_content)
    TextView commentContent;

    public NotificationViewHolder(View itemView) {
        super(itemView);
        this.rowView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public void setCommentTitle(String title) {
        commentTitle.setText(title);
    }

    public void setCommentContent(String content) {
        commentContent.setText(content);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        rowView.setOnClickListener(listener);
    }
}
