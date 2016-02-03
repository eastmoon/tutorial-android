package example.compoundview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * TODO: document your custom view class.
 */
public class CompoundView extends LinearLayout {
    private Button mPreviousButton;
    private TextView mText;
    private Button mNextButton;

    private String aInitText;
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

    private void initializeViews(Context context, AttributeSet attrs) {
        // Setting layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sample_compound_view, this);

        // Get attribute
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CompoundView, 0, 0);
        aInitText = a.getString(R.styleable.CompoundView_InitText);
        a.recycle();
    }

    @Override
    protected void onFinishInflate() {
        // 	Called after a view and all of its children has been inflated from XML.
        super.onFinishInflate();

        // Sets the images for the previous and next buttons. Uses built-in images so you don't need to add images.
        mPreviousButton = (Button) this.findViewById(R.id.compound_view_previous);
        mPreviousButton.setBackgroundResource(android.R.drawable.ic_media_previous);

        mText = (TextView) this.findViewById(R.id.compound_view_current_value);
        mText.setText(this.aInitText);

        mNextButton = (Button)this.findViewById(R.id.compound_view_next);
        mNextButton.setBackgroundResource(android.R.drawable.ic_media_next);
    }
}
