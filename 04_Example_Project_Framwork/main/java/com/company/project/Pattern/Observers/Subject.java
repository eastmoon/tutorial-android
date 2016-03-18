package com.company.project.Pattern.Observers;

import java.util.ArrayList;

/**
 * Created by Jacky on 2016/3/8.
 */
public class Subject {
    // Member variable
    private ArrayList mTriggers;
    private Class[] mTypes;

    // Constructor
    public Subject() {
        this.mTriggers = new ArrayList();
        this.mTypes = null;
    }

    // Operation method : register trigger.
    public boolean register(Object _target, String _method) {
        return this.register( new Trigger(_target, _method) );
    }
    public boolean register(Trigger _source) {
        // 1. Duplicate object could not register
        if(!this.has(_source)) {
            // 2. Add in container
            return this.mTriggers.add(_source);
        }
        return false;
    }

    // Operation method : remove trigger.
    public boolean remove(Object _target, String _method) {
        return this.remove( this.retrieve(_target, _method) );
    }
    public boolean remove(Trigger _source) {
        return this.mTriggers.remove(_source);
    }

    // Operation method : retrieve trigger.
    public Trigger retrieve(Object _target, String _method) {
        Trigger result = null;
        Trigger temp = null;
        for(int i = 0 ; i < this.mTriggers.size() ; i++ ) {
            temp = (Trigger) this.mTriggers.get(i);
            if(temp != null && temp.equals(_target, _method)) {
                result = temp;
                break;
            }
        }
        return result;
    }

    // Operation method : check trigger is exist or not.
    public boolean has(Trigger _source) {
        return this.retrieve(_source.getTarget(), _source.getMethod()) != null;
    }

    // Operation method : how many trigger in container.
    public int count() {
        return this.mTriggers.size();
    }

    // Set target method param type.
    public void setTypes(Class[] _types) {
        this.mTypes = _types;
    }

    // Notify trigger
    public void notifyTrigger(Class[] _types, Object... args) {
        this.setTypes(_types);
        this.notifyTrigger(args);
    }
    public void notifyTrigger(Object... args) {
        Trigger temp = null;
        for(int i = 0 ; i < this.mTriggers.size() ; i++) {
            temp = (Trigger) this.mTriggers.get(i);
            temp.setTypes(this.mTypes);
            temp.execute(args);
        }
    }
}
