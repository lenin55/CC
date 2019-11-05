package com.bala.crazycoins.views;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bala.crazycoins.R;

public class WelcomeScreenActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private TextView tvSignIn;
    private TextView tvSignUp;
    private Handler fragmentHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentHandler = new Handler();
        setContentView(R.layout.activity_welcome);
        tvSignIn = findViewById(R.id.tv_signin);
        tvSignUp = findViewById(R.id.tv_signup);

        tvSignIn.setOnClickListener(v -> {
            addFragment(SignInFragment.newInstance(), true, false);
        });

        tvSignUp.setOnClickListener(v -> {
            addFragment(SignUpFragmet.newInstance(), true, false);
        });

    }


    /**
     * Method to inflate fragment in the activity.
     *
     * @param fragment       The fragment to be inflated.
     * @param addToBackStack The fragment is to be added in backstack or not.
     * @param fade           whether to add animation or not
     */
    public void addFragment(final Fragment fragment, final boolean addToBackStack, boolean fade) {
        Runnable mRunnable = () -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                    .beginTransaction();
            if (fade)
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in
                        , android.R.anim.fade_out);
            getSupportFragmentManager().addOnBackStackChangedListener(this);
            fragmentTransaction.replace(R.id.container, fragment,
                    fragment.getClass().getName());
            if (addToBackStack) {
                fragmentTransaction.addToBackStack(fragment.getClass().getName());
            }
            fragmentTransaction.commitAllowingStateLoss();
        };
        // If mPendingRunnable is not null, then add to the message queue
        if (null != mRunnable) {
            fragmentHandler.post(mRunnable);
        }
        // refresh toolbar menu
        invalidateOptionsMenu();
    }


    @Override
    public void onBackStackChanged() {

    }
}
