package example.eventlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView m_textView;
    private View m_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // take back TextView
        this.m_textView = (TextView) this.findViewById(R.id.Main_textView);

        // take back layout view
        this.m_layout = this.getLayoutInflater().inflate(R.layout.activity_main, null);

        // Setting button event listener
        Button btn = null;

        // Type 1, Standard.
        btn = (Button) this.findViewById(R.id.Main_button_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Setting string in textView, but it could not use this.m_textView
                m_textView.setText("Click Event 1 Button");
            }
        });

        // Type 2, Create event listener object.
        btn = (Button) this.findViewById(R.id.Main_button_2);
        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Setting string in textView, but it could not use this.m_textView
                m_textView.setText("Click Event 2 Button");
            }
        };
        btn.setOnClickListener(myListener);

        // Type 3, Activity as a listener
        // 1. Setting class implements View.OnClickListener
        // 2. Defined onClick method
        // 3. Setting this to button
        btn = (Button) this.findViewById(R.id.Main_button_3_1);
        btn.setOnClickListener(this);
        btn = (Button) this.findViewById(R.id.Main_button_3_2);
        btn.setOnClickListener(this);

        // Type 4, Create listener class and assign Activity.
        // 1. Create sub class in Activity, and that class implements View.OnClickListener
        // 2. Setting new class to button
        btn = (Button)findViewById(R.id.Main_button_4);
        btn.setOnClickListener(new ButtonListener(this));

        // Type 5, Create Reflection listener class
        btn = (Button)findViewById(R.id.Main_button_5);
        btn.setOnClickListener(new ReflectionClickListener(this, "ReflectionEvent"));

    }

    @Override
    public void onClick( View v ) {
        // One listener for multi component.
        switch (v.getId()) {
            case R.id.Main_button_3_1:
                this.m_textView.setText("Click Event 3-1 Button");
                break;
            case R.id.Main_button_3_2:
                this.m_textView.setText("Click Event 3-2 Button");
                break;
        }
    }

    public void Greet() {
        this.m_textView.setText("Click Event 4 Button");
    }

    public class ButtonListener implements View.OnClickListener {
        private MainActivity m_activity;
        public ButtonListener( MainActivity a_activity ) {
            this.m_activity = a_activity;
        }
        @Override
        public void onClick( View v ) {
            this.m_activity.Greet();
        }
    }

    public void ReflectionEvent( View v ) {
        this.m_textView.setText("Click Event 5 Button " + v.getId());
    }

    public class ReflectionClickListener implements View.OnClickListener {
        private Object m_target;
        private String m_methodName;
        public ReflectionClickListener( Object a_target, String a_methodName ) {
            this.m_target = a_target;
            this.m_methodName = a_methodName;
        }
        @Override
        public void onClick( View v ) {
            try{
                Method method = this.m_target.getClass().getDeclaredMethod(this.m_methodName, View.class);
                method.invoke(this.m_target, v);
            } catch(Exception e){
                Log.d("Erro-log", e.toString());
            }
        }
    }
}