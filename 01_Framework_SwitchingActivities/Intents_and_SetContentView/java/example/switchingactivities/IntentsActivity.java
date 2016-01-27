package example.switchingactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentsActivity extends AppCompatActivity {

    private View m_view1;
    private View m_view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.m_view1 = this.getLayoutInflater().inflate(R.layout.activity_sub_view_1, null);
        this.m_view2 = this.getLayoutInflater().inflate(R.layout.activity_sub_view_2, null);

        if( this.m_view1 != null ) {
            this.setContentView(this.m_view1);
        }

        Button btn = null;
        btn = (Button) this.m_view1.findViewById(R.id.SV1_Button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(m_view2);
            }
        });

        btn = (Button) this.m_view2.findViewById(R.id.SV2_Button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(m_view1);
            }
        });
    }
}
