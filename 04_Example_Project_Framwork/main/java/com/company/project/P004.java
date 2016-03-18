package com.company.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.company.project.Framework.BasicsActivity;
import com.company.project.Framework.EventListener.ClickEventListener;
import com.company.project.Pattern.Facade.Tools;

public class P004 extends BasicsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial view
        this.initialView();

        // Setting action bar
        this.setActionBarTitle("Transfer");
        this.setActionBarState(BasicsActivity.ACTION_BAR_MENU);
    }

    private void initialView() {

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        TextView tv = (TextView) this.findViewById(R.id.Main_TextView);
        tv.setText("Transfer Page");

        this.initialButtonView("To transfer detail", "onToTransferDetail", 50, viewGroup);
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
    public void onToTransferDetail(View v) {
        Intent i = new Intent(P004.this, P004_detail.class);
        startActivity(i);
    }
}
