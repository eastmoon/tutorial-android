package com.company.project.Framework.EventListener;

import android.content.DialogInterface;

import com.company.project.Pattern.Observers.Subject;

/**
 * Created by Jacky on 2016/3/18.
 */
public class DialogClickEventListener extends Subject implements DialogInterface.OnClickListener{
    public DialogClickEventListener() {
        super();
        this.setTypes(new Class[]{DialogInterface.class, Integer.TYPE});
    }
    public DialogClickEventListener registerChain(Object _target, String _method) {
        this.register(_target, _method);
        return this;
    }
    @Override
    public void onClick(DialogInterface dialog, int which) {
        this.notifyTrigger(dialog, which);
    }
}
