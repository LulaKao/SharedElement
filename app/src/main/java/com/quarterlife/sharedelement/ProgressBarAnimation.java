package com.quarterlife.sharedelement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;

public class ProgressBarAnimation extends Animation {
    private Context context;
    private ProgressBar progressBar;
    private TextView textView;
    private float from,to;

    public ProgressBarAnimation(Context context, ProgressBar progressBar, TextView textView, float from, float to) {
        this.context = context;
        this.progressBar = progressBar;
        this.textView = textView;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime,t);
        float value = from + (to - from) * interpolatedTime; // value = 0 + (100 - 0) * interpolatedTime(從 0 到 1 --> 1 代表跑完了)
        progressBar.setProgress((int)value); // 設置進度條
        textView.setText((int)value + " %"); // 設置進度文字

        if(value == to){ // 當 100 % 時，跳轉到 HomeActivity

            // 有兩個以上的共享元素
            Pair<View, String> first = new Pair<View, String>(MainActivity.profile_image, ViewCompat.getTransitionName(MainActivity.profile_image));
            Pair<View,String> second = new Pair<View, String>(MainActivity.user_name, ViewCompat.getTransitionName(MainActivity.user_name));

            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,first,second);
            context.startActivity(new Intent(context, HomeActivity.class), activityOptionsCompat.toBundle());

//            // 只有一個共享元素
//            context.startActivity(new Intent(context, HomeActivity.class),
//                    ActivityOptions.makeSceneTransitionAnimation((Activity) context, MainActivity.profile_image, "shared_profile_img").toBundle());
        }
    }
}
