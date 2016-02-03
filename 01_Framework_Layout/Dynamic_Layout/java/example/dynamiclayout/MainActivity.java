package example.dynamiclayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout m_linearLayout;
    private TextView m_label;
    private Button m_btn;
    private LinearLayout m_checkBoxList;
    private int m_checkNumber = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create Linear layout
        this.m_linearLayout = new LinearLayout(this);
        this.m_linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Button to next
        Button btn = new Button(this);
        btn.setText("Next Activity");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });
        this.m_linearLayout.addView(btn);

        // Label
        this.m_label = new TextView(this);
        this.m_label.setText("Dynamic Linear Layout : ");
        this.m_linearLayout.addView(this.m_label);

        // Edit Label text
        EditText et = new EditText(this);
        et.setText("Input your name");
        et.setSingleLine();
        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.d("Log", v.getText().toString());
                m_label.setText(v.getText());
                return false;
            }
        });
        this.m_linearLayout.addView(et);

        // Button to change checkbox count
        this.m_btn = new Button(this);
        this.m_btn.setText("Change CheckBox amount");
        this.m_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_checkNumber = 20;
                makeCheckBox();
            }
        });
        this.m_linearLayout.addView(this.m_btn);

        // Check box list
        this.m_checkBoxList = new LinearLayout(this);
        this.m_checkBoxList.setOrientation(LinearLayout.VERTICAL);

        // Create scroll with list
        ScrollView sv = new ScrollView(this);
        sv.addView(this.m_checkBoxList);
        this.m_linearLayout.addView(sv);

        // Set layout to activity content
        setContentView(this.m_linearLayout);

        // Create check box
        makeCheckBox();
    }

    private void makeCheckBox() {
        // Remove all old view in layout
        this.m_checkBoxList.removeAllViews();
        // Add new view in layout
        for(int i = 0; i < this.m_checkNumber; i++) {
            CheckBox cb = new CheckBox(this);
            cb.setText("Dynamic CheckBox " + i);
            this.m_checkBoxList.addView(cb);
        }
    }
}
