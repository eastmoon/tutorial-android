package com.company.project.Framework.EventListener;

import android.view.View;

import com.company.project.Pattern.Observers.Subject;

/**
 * Created by Jacky on 2016/3/16.
 */
public class ClickEventListener extends Subject implements View.OnClickListener{
    public ClickEventListener() {
        super();
        this.setTypes(new Class[]{View.class});
    }
    public ClickEventListener registerChain(Object _target, String _method) {
        this.register(_target, _method);
        return this;
    }
    @Override
    public void onClick(View v) {
        this.notifyTrigger(v);
    }
}
