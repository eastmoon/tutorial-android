package com.company.project.Pattern.Facade;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Jacky on 2016/3/16.
 */
public class ExceptionBox {
    // Singleton pattern
    // Static instances.
    private static ExceptionBox mInstances = null;
    // Static get method
    public static ExceptionBox getInstances() {
        // Instances is null, than new one.
        if(mInstances == null)
            mInstances = new ExceptionBox();
        return mInstances;
    }

    // Static Enum
    public static final int STYLE_NONE = 0;
    public static final int STYLE_LOG = 1;
    public static final int STYLE_TOAST = 2;
    public static final int STYLE_DIAGGLO = 3;
    // Member variable
    private Context mContext;
    private int mStyle;
    // Constructor
    private ExceptionBox() {

    }
    // Set box style
    public void setBoxStyle(int _style) {
        switch(_style) {
            case ExceptionBox.STYLE_NONE :
            case ExceptionBox.STYLE_LOG :
            case ExceptionBox.STYLE_TOAST :
            case ExceptionBox.STYLE_DIAGGLO : {
                this.mStyle = _style;
                break;
            }
            default: {
                this.mStyle = ExceptionBox.STYLE_LOG;
                break;
            }
        }
    }
    // Set context for windows exception box
    public void setContext(Context _context) {
        this.mContext = _context;
    }
    // Exception box
    public void message(String _msg, Context _context) {
        this.setContext(_context);
        this.message(_msg, this.mStyle);
    }
    public void message(String _msg, Context _context, int _style) {
        this.setContext(_context);
        this.message(_msg, _style);
    }
    public void message(String _msg) {
        this.message(_msg, this.mStyle);
    }
    public void message(String _msg, int _style) {
        switch(_style) {
            case ExceptionBox.STYLE_NONE : {
                // do nothing.
                break;
            }
            case ExceptionBox.STYLE_LOG : {
                Log.d("Exception-Log", _msg);
                break;
            }
            case ExceptionBox.STYLE_TOAST :{
                if(this.mContext != null)
                    Toast.makeText(this.mContext, _msg, Toast.LENGTH_SHORT).show();
                break;
            }
            case ExceptionBox.STYLE_DIAGGLO : {
                if(this.mContext != null) {
                    new AlertDialog.Builder(this.mContext)
                            .setTitle("Exception Message")
                            .setMessage(_msg)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
                break;
            }
        }
    }
}
