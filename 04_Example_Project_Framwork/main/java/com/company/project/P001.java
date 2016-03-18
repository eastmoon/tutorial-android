package com.company.project;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.company.project.Framework.BasicsActivity;
import com.company.project.Framework.EventListener.ClickEventListener;
import com.company.project.Framework.Model.Login;
import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Facade.Tools;
import com.company.project.Pattern.Proxy.WaitsProxy;

public class P001 extends BasicsActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial view
        this.initialView();

        // Setting action bar
        this.setActionBarTitle("Login");
        this.setActionBarIcon(R.drawable.ic_extension_black);

        // Set exception style
        ExceptionBox.getInstances().setBoxStyle(ExceptionBox.STYLE_DIAGGLO);
        /*
        WebServiceProxy rp = new Login();
        ExceptionBox.getInstances().message("Model count : " + ModelController.getInstances().count());
        */
    }

    private void initialView() {

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        TextView tv = (TextView) this.findViewById(R.id.Main_TextView);
        tv.setText("Login Page");

        this.initialButtonView("Login", "onLogin", 50, viewGroup);
    }

    private void initialButtonView(String _text, String _method, int _position_dp, ViewGroup _rootView) {
        Button btn = null;
        RelativeLayout.LayoutParams lp = null;

        btn = new Button(this);
        btn.setText(_text);
        btn.setOnClickListener(new ClickEventListener().registerChain(this, _method));
        // Setting layout ([width], [height]) for Warp_Content or Match_Parent
        lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // Setting layout rule
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        lp.setMargins(0, 0, 0, (int) Tools.dp2px(_position_dp, this));
        _rootView.addView(btn, lp);
    }

    // Click event : Login button.
    public void onLogin(View v) {
        // Only switching activity.
        //this.switchingProgress(P002.class);
        // Loading model and Switching activity.
        this.switchingProgress(P002.class,
                new WaitsProxy("Wait1", 5000),
                new Login());
    }
}
