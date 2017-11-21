package edu.groups.app.ui.group.post;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import edu.groups.app.R;
import edu.groups.app.model.post.NewPostDto;

/**
 * Created by Piotr Borczyk on 21.11.2017.
 */

public class AddPostDialog extends Dialog {

    private OnResultListener onResultListener;
    private EditText titleEditText;
    private EditText contentEditText;
    private CheckBox commentCheckbox;

    public interface OnResultListener{
        void result(NewPostDto newPostDto);
    }

    public AddPostDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.add_post_dialog);
        setTitle("Dodaj post");
        titleEditText = (EditText) findViewById(R.id.post_title_input);
        contentEditText = (EditText) findViewById(R.id.post_content_input);
        commentCheckbox = (CheckBox) findViewById(R.id.comment_checkbox);
        Button okButton = (Button) findViewById(R.id.ok_button);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onResultListener != null) onResultListener.result(buildDto());
                dismiss();
            }
        });
    }

    private NewPostDto buildDto() {
        NewPostDto newPostDto = new NewPostDto();
        newPostDto.setTitle(titleEditText.getText().toString());
        newPostDto.setContent(contentEditText.getText().toString());
        newPostDto.setCommentEnabled(commentCheckbox.isChecked());
        return newPostDto;
    }

    public void setOnResultListener(OnResultListener onResultListener) {
        this.onResultListener = onResultListener;
    }
}
