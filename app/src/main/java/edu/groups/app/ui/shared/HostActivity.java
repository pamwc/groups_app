package edu.groups.app.ui.shared;

import android.app.FragmentManager;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Kamil on 09/11/2017.
 */

public abstract class HostActivity extends DaggerAppCompatActivity {

    @Inject
    protected FragmentManager fragmentManager;

    protected final void replaceFragment(@IdRes int containerViewId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerViewId, fragment)
                .commit();
    }
}
