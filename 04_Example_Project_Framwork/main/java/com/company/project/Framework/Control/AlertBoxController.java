package com.company.project.Framework.Control;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.company.project.Framework.EventListener.DialogClickEventListener;

/**
 * Created by Jacky on 2016/3/18.
 */
public class AlertBoxController {
    // Singleton pattern
    // Static instances.
    private static AlertBoxController mInstances = null;
    // Static get method
    public static AlertBoxController getInstances() {
        // Instances is null, than new one.
        if(mInstances == null)
            mInstances = new AlertBoxController();
        return mInstances;
    }
    // Static Enum
    public static final int STYLE_DEFAULT = 0;
    // Member variable
    private Context mContext;
    // Constructor
    private AlertBoxController() {

    }
    // Set context for windows exception box
    public void setContext(Context _context) {
        this.mContext = _context;
    }
    // Alert box
    public void message(String _title, String _msg, int _style,
                        DialogClickEventListener _okEventListener,
                        DialogClickEventListener _cancelEventListener) {
        if(this.mContext == null) {
            return;
        }
        switch(_style) {
            case AlertBoxController.STYLE_DEFAULT : {
                if(this.mContext != null) {
                    new AlertDialog.Builder(this.mContext)
                            .setTitle(_title)
                            .setMessage(_msg)
                            .setPositiveButton(android.R.string.ok, _okEventListener)
                            .setNegativeButton(android.R.string.cancel, _cancelEventListener)
                            .setCancelable(false)
                            .show();
                }
                break;
            }
        }
    }
}
