package com.company.project.Pattern.Progress.Filters;

import com.company.project.Pattern.Observers.Trigger;
import com.company.project.Pattern.Progress.Filter;
import com.company.project.Pattern.Progress.Progress;

/**
 * Created by Chen on 2016/3/15.
 */
public class TriggerFilter extends Filter {
    // Member variable
    private Trigger mTrigger;

    // Constructor
    public TriggerFilter(String _keyID, Object _target, String _method) {
        super(_keyID);
        this.mTrigger = new Trigger(_target, _method);
    }
    public TriggerFilter(String _keyID, Trigger _trigger) {
        super(_keyID);
        this.mTrigger = _trigger;
    }

    // Execute method
    @Override
    public void execute(Progress _progress) {
        this.mTrigger.execute(new Class[]{Progress.class}, _progress);
    }
}
