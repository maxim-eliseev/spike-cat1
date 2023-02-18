package com.example.tmp3;

import androidx.appcompat.app.AppCompatActivity;

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
        catImage.setScaleX(-1);


        float startX = 0f;
        float endX = 800f;
        ValueAnimator animation = ValueAnimator.ofFloat(startX, endX);
        animation.setDuration(2*1000);
        animation.start();



        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                // You can use the animated value in a property that uses the
                // same type as the animation. In this case, you can use the
                // float value in the translationX property.
                float animatedValue = (float)updatedAnimation.getAnimatedValue();
                catImage.setX(animatedValue);
            }
        });

    }


}