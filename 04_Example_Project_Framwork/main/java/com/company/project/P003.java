package com.company.project;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.company.project.Framework.BasicsActivity;
import com.company.project.Framework.Control.AlertBoxController;
import com.company.project.Framework.EventListener.ClickEventListener;
import com.company.project.Framework.EventListener.DialogClickEventListener;
import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Facade.Tools;

public class P003 extends BasicsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial view
        this.initialView();

        // Setting action bar
        this.setActionBarTitle("Lobby");
        this.setActionBarState(BasicsActivity.ACTION_BAR_MENU);
    }

    private void initialView() {
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        TextView tv = (TextView) this.findViewById(R.id.Main_TextView);
        tv.setText("Lobby Page");

        this.initialButtonView("Alert Dialog", "onAlertDialog", 150, viewGroup);
        this.initialButtonView("Exception Dialog", "onExceptionDialog", 100, viewGroup);
        this.initialButtonView("Exception Toast", "onExceptionToast", 50, viewGroup);
        this.initialButtonView("Exception Log", "onExceptionLog", 0, viewGroup);
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
    public void onAlertDialog(View v) {
        // Show alert box
        AlertBoxController.getInstances().message("Alert Box",
                "It is alert message in dialog box.",
                AlertBoxController.STYLE_DEFAULT,
                new DialogClickEventListener().registerChain(this, "onAlertOk"),
                new DialogClickEventListener().registerChain(this, "onAlertCancel"));
    }
    public void onAlertOk(DialogInterface _dialog, int _which) {
        TextView tv = (TextView) this.findViewById(R.id.Main_TextView);
        tv.setText("Lobby Page\nClick alert box ok button.");
    }
    public void onAlertCancel(DialogInterface _dialog, int _which) {
        TextView tv = (TextView) this.findViewById(R.id.Main_TextView);
        tv.setText("Lobby Page\nClick alert box cancel button.");
    }
    public void onExceptionDialog(View v) {
        // Set exception style with Dialog box
        // It will set ExceptionBox default message style.
        ExceptionBox.getInstances().setBoxStyle(ExceptionBox.STYLE_DIAGGLO);
        ExceptionBox.getInstances().message("It is exception message in dialog box.");
    }
    public void onExceptionToast(View v) {
        // Set exception style with Toast
        // This setting will use one time, and doesn't change default style.
        ExceptionBox.getInstances().message("It is exception message in toast.", ExceptionBox.STYLE_TOAST);
    }
    public void onExceptionLog(View v) {
        // Set exception style with Log
        // This setting will use one time, and doesn't change default style.
        ExceptionBox.getInstances().message("It is exception message in debug log.", ExceptionBox.STYLE_LOG);
    }
}
