package com.example.zplay.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zanimation.ZAnimationUtil;
import com.example.zplay.R;
import com.example.zplay.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.anim_content)
    TextView animContent;
    @BindView(R.id.begin_anim_btn)
    Button beginAnimBtn;
    @BindView(R.id.frame_anim_iv)
    ImageView frameAnimIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        AnimationDrawable animationDrawable = (AnimationDrawable) frameAnimIV.getBackground();
//        animationDrawable.start();

        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (int i = 1; i < 10; i++) {
            int drawableResId = getResources().getIdentifier("now_playing_matrix_0" + i, "drawable", getPackageName());
            animationDrawable.addFrame(getResources().getDrawable(drawableResId), 200);
        }
        frameAnimIV.setImageDrawable(animationDrawable);
        animationDrawable.start();
    }

    @OnClick(R.id.begin_anim_btn)
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.begin_anim_btn:
//                ZAnimationUtil.startTranslateAnimation(animContent, 0f, UIUtils.getScreenWith(this) - animContent.getPaint().measureText(animContent.getText().toString().trim()), 0f, 0f);
//                ZAnimationUtil.startTranslateAnimationByXML(this, animContent, R.anim.translate_animation);
//                ZAnimationUtil.startAlphaAnimation(animContent, 1, 0);
                ZAnimationUtil.atartAlphaAnimationByXML(animContent, R.anim.scale_animation);
                break;
        }

    }
}
