package com.example.tmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView catImage = this.findViewById(R.id.imageView2);
        catImage.setScaleX(-1); // flip horizontally

        float startX = 0f;
        float endX = 800f;

        ObjectAnimator walkForward = ObjectAnimator.ofFloat(catImage, "X", startX, endX);
        walkForward.setDuration(2000);

        ObjectAnimator turnRightToLeft = ObjectAnimator.ofFloat(catImage, "ScaleX", -1, 1);
        turnRightToLeft.setDuration(100);

        ObjectAnimator walkBackward = ObjectAnimator.ofFloat(catImage, "X", endX, startX);
        walkBackward.setDuration(2000);

        ObjectAnimator turnLeftToRight = ObjectAnimator.ofFloat(catImage, "ScaleX", 1, -1);
        turnLeftToRight.setDuration(100);

        AnimatorSet walkBothWaysAnimation = new AnimatorSet();
        walkBothWaysAnimation.playSequentially(
                walkForward,
                turnRightToLeft,
                walkBackward,
                turnLeftToRight
        );

        walkBothWaysAnimation.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animation.start();
            }
        });

        walkBothWaysAnimation.start();
    }


}