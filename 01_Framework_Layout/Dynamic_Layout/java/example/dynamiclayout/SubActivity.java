package example.dynamiclayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {

    private RelativeLayout m_relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create Relative layout
        this.m_relativeLayout = new RelativeLayout(this);

        // Button to main
        Button btn = new Button(this);
        btn.setText("Back");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        RelativeLayout.LayoutParams lp = null;
        // Setting layout ([width], [height]) for Warp_Content or Match_Parent
        lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // Setting layout rule
        lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        lp.setMargins(0, 100, 0, 0);
        // Setting Id, that component can follow.
        btn.setId(1);
        this.m_relativeLayout.addView(btn, lp);

        // Create TextView
        Button btn2 = new Button(this);
        btn2.setText("Say Hello !" + btn.getId());
        // Setting layout ([width], [height]) for Warp_Content or Match_Parent
        lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // Setting layout rule, below target Id
        lp.addRule(RelativeLayout.BELOW, btn.getId());
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        lp.setMargins(0, 50, 0, 0);
        this.m_relativeLayout.addView(btn2, lp);


        // Set layout to activity content
        setContentView(this.m_relativeLayout);
    }
}
