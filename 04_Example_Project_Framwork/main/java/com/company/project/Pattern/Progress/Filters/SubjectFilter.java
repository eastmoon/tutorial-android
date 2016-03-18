package com.company.project.Pattern.Progress.Filters;

import com.company.project.Pattern.Observers.Subject;
import com.company.project.Pattern.Observers.Trigger;
import com.company.project.Pattern.Progress.Filter;
import com.company.project.Pattern.Progress.Progress;

/**
 * Created by Chen on 2016/3/15.
 */
public class SubjectFilter extends Filter {
    private Subject mSubject;
    public SubjectFilter(String _keyID) {
        super(_keyID);
        this.mSubject = new Subject();
    }

    // Operation method : register trigger.
    public boolean register(Object _target, String _method) {
        return this.register( new Trigger(_target, _method) );
    }
    public boolean register(Trigger _source) {
        return this.mSubject.register(_source);
    }

    // Operation method : remove trigger.
    public boolean remove(Object _target, String _method) {
        return this.mSubject.remove(_target, _method);
    }
    public boolean remove(Trigger _source) {
        return this.mSubject.remove(_source);
    }

    // Get / Set method
    protected Subject getSubject() {
        return this.mSubject;
    }

    // Execute method
    @Override
    public void execute(Progress _progress) {
        this.mSubject.notifyTrigger(new Class[]{Progress.class}, _progress);
    }
}
