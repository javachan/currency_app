package io.github.maxcruz.currencyapp.splash;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

import androidx.navigation.Navigation;
import io.github.maxcruz.currencyapp.R;

public class SplashFragment extends Fragment {

    private AppCompatActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = ((AppCompatActivity) getActivity());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        controlSplashAnimation((LottieAnimationView) view.findViewById(R.id.animationView));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (activity.getSupportActionBar() != null) activity.getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (activity.getSupportActionBar() != null) activity.getSupportActionBar().show();
    }

    private void controlSplashAnimation(final LottieAnimationView animationView) {
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) { }

            @Override
            public void onAnimationCancel(Animator animation) { }

            @Override
            public void onAnimationRepeat(Animator animation) { }

            @Override
            public void onAnimationEnd(Animator animation) {
                Navigation.findNavController(animationView)
                        .navigate(R.id.action_splashFragment_to_ratesFragment);
            }
        });
    }
}
