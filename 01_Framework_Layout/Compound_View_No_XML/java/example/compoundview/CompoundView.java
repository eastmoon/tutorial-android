package example.compoundview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
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

    private String aInitText;
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
        // Setting layout
        //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflater.inflate(R.layout.activity_main, this);

        // Get attribute
        Log.d("Log", "Count : " + attrs.getAttributeCount());

        this.mPreviousButton = new Button(context);
        this.mPreviousButton.setBackgroundResource(android.R.drawable.ic_media_previous);
        this.addView(this.mPreviousButton);

        this.mText = new TextView(context);
        this.mText.setText(attrs.getAttributeValue(null, "InitText"));
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
