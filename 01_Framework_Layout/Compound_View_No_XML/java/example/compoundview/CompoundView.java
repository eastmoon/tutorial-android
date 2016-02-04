package example.compoundview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Chen on 2016/2/3.
 */
public class CompoundView extends LinearLayout {
    private Button mPreviousButton;
    private TextView mText;
    private Button mNextButton;

    private String mInitText;
    // Constructor
    public CompoundView(Context context) {
        super(context);
        initializeViews(context, null);
    }

    public CompoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context, attrs);
    }

    public CompoundView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeViews(context, attrs);
    }

    // Initialize
    private void initializeViews(Context context, AttributeSet attrs) {

        // Get attribute
        Log.d("Log", "Count : " + attrs.getAttributeCount());
        mInitText = attrs.getAttributeValue(null, "InitText");
        if(mInitText == null)
            Log.d("Log", "Initial data not exist.");

        // Setting layout
        this.mPreviousButton = new Button(context);
        this.mPreviousButton.setBackgroundResource(android.R.drawable.ic_media_previous);
        this.addView(this.mPreviousButton);

        this.mText = new TextView(context);
        this.mText.setText(this.mInitText);
        this.addView(this.mText);

        this.mNextButton = new Button(context);
        this.mNextButton.setBackgroundResource(android.R.drawable.ic_media_next);
        this.addView(this.mNextButton);
    }

    // 	Called after a view and all of its children has been inflated from XML.
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("Log", "onFinishInflate");
    }
}
