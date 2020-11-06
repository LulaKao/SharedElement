package com.quarterlife.sharedelement;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

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
            context.startActivity(new Intent(context, HomeActivity.class),
                    ActivityOptions.makeSceneTransitionAnimation((Activity) context, MainActivity.profile_image, "shared_profile_img").toBundle());
        }
    }
}
