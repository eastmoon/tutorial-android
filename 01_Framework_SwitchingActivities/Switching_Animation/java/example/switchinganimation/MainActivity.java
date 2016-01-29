package example.switchinganimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) this.findViewById(R.id.Main_Button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, SubActivity.class);
                startActivity(next);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // The activity is about to become visible.
        // Animation with animation resource XML file.
        Button btn = (Button) this.findViewById(R.id.Main_Button);
        Animation slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        btn.startAnimation(slideInAnimation);

        // Animation with ObjectAnimator
        TextView label = (TextView) this.findViewById(R.id.Main_TextView);
        ObjectAnimator anim = ObjectAnimator.ofFloat(label, "alpha", 0f, 1f);
        anim.setDuration(1000);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("Log", "Animation complete.");
            }
        });
        anim.start();
    }
}
