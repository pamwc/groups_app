package edu.groups.app.ui;

/**
 * Created by Kamil on 28/10/2017.
 */

public interface MvpContract {

    interface View {
    }

    interface Presenter {
        void onResume();
        void onDestroy();
    }
}
