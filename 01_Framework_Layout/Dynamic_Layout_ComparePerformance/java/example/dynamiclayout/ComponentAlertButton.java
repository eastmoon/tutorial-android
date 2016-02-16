package example.dynamiclayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * TODO: document your custom view class.
 */
public class ComponentAlertButton extends LinearLayout {
    public ComponentAlertButton(Context context) {
        super(context);
        init(context, 0);
    }

    public ComponentAlertButton(Context context, int a_startnumber) {
        super(context);
        init(context, a_startnumber);
    }

    public ComponentAlertButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, 0);
    }

    public ComponentAlertButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, 0);
    }

    private void init(final Context context, int a_startnumber) {
        // Initial button amount
        int btnAmount = 5;

        // Setting Linear Layout
        this.setOrientation(HORIZONTAL);

        // Create Button and Setting event
        Button btn = null;
        for( int i = 1 ; i <= btnAmount ; i++ ) {
            // 1. Create button.
            btn = new Button(context, null, android.R.attr.buttonStyleSmall);
            // 2. Setting button.
            btn.setText(String.format("%05d", a_startnumber * btnAmount + i));
            // 3. Setting button event.
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 4. When button click, alert message.
                    new AlertDialog.Builder(context)
                            .setTitle("Alert Message")
                            .setMessage("Button number is " + ((Button) v).getText().toString())
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            });
            this.addView(btn);
        }
    }


    // 	Called after a view and all of its children has been inflated from XML.
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("Log", "onFinishInflate");
    }
}
