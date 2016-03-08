package example.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.getFragmentManager().beginTransaction().add(R.id.Main_Menu_Fragment, new BlankFragment1()).commit();
        this.getFragmentManager().beginTransaction().add(R.id.Main_Page_Fragment, new BlankFragment2()).commit();

        View v = this.findViewById(R.id.Main_Menu_Fragment);
        v.setVisibility(View.GONE);
        v.setAlpha(0f);
    }

    // Option menu, create and selected.
    // 1. Setting and create menu
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.option_bar, menu);
        return true;
    }


    // 3. Event processing
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                Log.d("App-Log", "Selected action settings.");

                final View v = this.findViewById(R.id.Main_Menu_Fragment);
                ObjectAnimator anim = null;
                if(v.getVisibility() == View.GONE) {
                    anim = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f);
                    v.setVisibility(View.VISIBLE);
                } else {
                    anim = ObjectAnimator.ofFloat(v, "alpha", 1f, 0f);
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            v.setVisibility(View.GONE);
                        }
                    });
                }
                anim.setDuration(500).start();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
