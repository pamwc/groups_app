package edu.groups.app.ui.group.comment;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.groups.app.R;

/**
 * Created by Piotr Borczyk on 05.12.2017.
 */

public class AddCommentDialog extends Dialog {
    private OnResultListener onResultListener;
    private EditText contentEditText;

    public interface OnResultListener{
        void result(String commentContent);
    }

    public AddCommentDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.add_comment_dialog);
        setTitle("Dodaj post");
        contentEditText = (EditText) findViewById(R.id.comment_content_input);
        Button okButton = (Button) findViewById(R.id.ok_button);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onResultListener != null) onResultListener.result(contentEditText.getText().toString());
                dismiss();
            }
        });
    }


    public void setOnResultListener(OnResultListener onResultListener) {
        this.onResultListener = onResultListener;
    }
}
