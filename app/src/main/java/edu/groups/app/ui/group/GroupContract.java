package edu.groups.app.ui.group;

import android.os.Bundle;

import edu.groups.app.ui.MvpContract;

/**
 * Created by Dawid-Swinoga-Lap on 21.11.2017.
 */

public interface GroupContract extends MvpContract {

    interface View {
        void openGroupMembers(Bundle bundle);
    }
}
