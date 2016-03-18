package com.company.project;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.company.project.Framework.BasicsActivity;
import com.company.project.Framework.Control.ModelController;
import com.company.project.Framework.EventListener.ClickEventListener;
import com.company.project.Framework.Model.Login;
import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Facade.Tools;
import com.company.project.Pattern.Proxy.Interface.IAccessProxy;
import com.company.project.Pattern.Proxy.WebServiceProxy;

public class P002 extends BasicsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial view
        this.initialView();

        // Setting action bar
        this.setActionBarTitle("Menu");
    }

    private void initialView() {
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        String url = ((Login)ModelController.getInstances().retrieve(Login.KEY_ID)).responseURL;
        TextView tv = (TextView) this.findViewById(R.id.Main_TextView);
        tv.setText("Menu Page\n" + url);

        this.initialButtonView("To URL", "onToURL", 100, viewGroup);
        this.initialButtonView("To Lobby", "onToLobby", 50, viewGroup);
        this.initialButtonView("To Transfer", "onToTransfer", 0, viewGroup);
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

    // Click event : To lobby button.
    public void onToURL(View v) {
        String url = ((Login)ModelController.getInstances().retrieve(Login.KEY_ID)).responseURL;
        if(url != "")
        {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException anfe) {
                ExceptionBox.getInstances().message(anfe.toString());
            }
        }
    }
    public void onToLobby(View v) {
        Intent i = new Intent(P002.this, P003.class);
        startActivity(i);
    }
    // Click event : To Transfer button.
    public void onToTransfer(View v) {
        Intent i = new Intent(P002.this, P004.class);
        startActivity(i);
    }
}
