package example.switchinganimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SubActivity extends AppCompatActivity {

    private View m_view1;
    private View m_view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.m_view1 = this.getLayoutInflater().inflate(R.layout.activity_sub_1, null);
        this.m_view2 = this.getLayoutInflater().inflate(R.layout.activity_sub_2, null);
        this.setContentView(this.m_view1);

        Button btn = null;
        btn = (Button) this.m_view1.findViewById(R.id.SV1_Button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_view1.startAnimation(AnimationUtils.loadAnimation(SubActivity.this, android.R.anim.slide_out_right));
                m_view2.startAnimation(AnimationUtils.loadAnimation(SubActivity.this, android.R.anim.slide_in_left));
                setContentView(m_view2);
            }
        });

        btn = (Button) this.m_view2.findViewById(R.id.SV2_Button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_view2.startAnimation(AnimationUtils.loadAnimation(SubActivity.this, android.R.anim.slide_out_right));
                m_view1.startAnimation(AnimationUtils.loadAnimation(SubActivity.this, android.R.anim.slide_in_left));
                setContentView(m_view1);
            }
        });

        btn = (Button) this.m_view2.findViewById(R.id.SV2_Button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
}
