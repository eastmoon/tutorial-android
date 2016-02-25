package example.fragment;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // During initial setup, plug in the details fragment.
            BlankFragment1 bf1 = new BlankFragment1();
            bf1.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(R.id.Main_Fragment_1, bf1).commit();

            BlankFragment2 bf2 = new BlankFragment2();
            bf2.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(R.id.Main_Fragment_2, bf2).commit();
        }
    }

    public void changeFragment(View v) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        BlankFragment2 bf2 = new BlankFragment2();
        fragmentTransaction.replace(R.id.Main_Fragment_1, bf2);
        fragmentTransaction.commit();
    }
}
