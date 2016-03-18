package com.company.project;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.company.project.Framework.BasicsActivity;

public class P004_detail extends BasicsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial view
        this.initialView();

        // Setting action bar
        this.setActionBarTitle("Transfer detail");
        this.setActionBarState(BasicsActivity.ACTION_BAR_BACK);

        // Setting option menu
        this.addOptionMenu("Option 1", "clickOption1", R.drawable.ic_extension_black);
        this.addOptionMenu("Option 2", "clickOption2");
    }

    public void clickOption1() {
        Toast.makeText(this, "Click Option 1", Toast.LENGTH_LONG).show();
    }

    public void clickOption2() {
        Toast.makeText(this, "Click Option 2", Toast.LENGTH_LONG).show();
        this.clearOptionMenu();
        this.addOptionMenu("Option 1", "clickOption1");
        this.invalidateOptionsMenu();
    }

    private void initialView() {
        TextView tv = (TextView) this.findViewById(R.id.Main_TextView);
        tv.setText("Transfer detail Page");
    }
}
