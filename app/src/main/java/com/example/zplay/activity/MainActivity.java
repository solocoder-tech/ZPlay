package com.example.zplay.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.begin_anim_btn)
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.begin_anim_btn:
                ZAnimationUtil.startAnimation(animContent, 0f, UIUtils.getScreenWith(this) - animContent.getPaint().measureText(animContent.getText().toString().trim()), 0f, 0f);
                break;
        }

    }
}
