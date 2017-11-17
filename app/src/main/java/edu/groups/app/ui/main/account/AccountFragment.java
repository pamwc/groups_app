package edu.groups.app.ui.main.account;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import edu.groups.app.R;
import edu.groups.app.ui.BaseViewFragment;

/**
 * Created by Kamil on 17/11/2017.
 */

public class AccountFragment extends BaseViewFragment<AccountContract.Presenter>
        implements AccountContract.View {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
