package com.quarterlife.sharedelement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView txt_progress;
    public static CircleImageView profile_image;
    public static TextView user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 把手機最上面系統列隱藏起來，變成完全的全螢幕
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // initView
        progressBar = findViewById(R.id.progressBar);
        txt_progress = findViewById(R.id.txt_progress);
        profile_image = findViewById(R.id.welcome_profile_image);
        user_name = findViewById(R.id.welcome_user_name);

        // 設置動畫
        progressAnimation();
    }

    public void progressAnimation(){
        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar, txt_progress, 0f , 100f); // 記得 float 要在數字後加上 f
        anim.setDuration(5000); // 5 秒
        progressBar.setAnimation(anim); // setAnimation
    }
}