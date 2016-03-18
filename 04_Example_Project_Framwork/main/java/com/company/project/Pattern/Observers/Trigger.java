package com.company.project.Pattern.Observers;

import com.company.project.Pattern.Facade.ExceptionBox;

import java.lang.reflect.Method;

/**
 * Created by Jacky on 2016/3/8.
 */
public class Trigger {
    // Member variable
    private Object mTarget;
    private String mMethod;
    private Class[] mTypes;
    // Constructor
    public Trigger(Object _target, String _method) {
        this.mTarget = _target;
        this.mMethod = _method;
        this.mTypes = null;
    }

    // Set target method param type.
    public void setTypes(Class[] _types) {
        this.mTypes = _types;
    }

    public Object getTarget() {
        return this.mTarget;
    }

    public String getMethod() {
        return this.mMethod;
    }

    // Equals method
    public boolean equals(Object _target, String _method) {
        return this.mTarget.equals(_target) && this.mMethod.equals(_method);
    }
    public boolean equals(Trigger _target) {
        return this.mTarget.equals(_target.getTarget()) && this.mMethod.equals(_target.getMethod());
    }

    // Invoke method
    public void execute(Class[] _types, Object... args) {
        this.setTypes(_types);
        this.execute(args);
    }
    public void execute(Object... args) {
        try{
            // Retrieve method in target object.
            Method method = this.mTarget.getClass().getDeclaredMethod(this.mMethod, this.mTypes);
            // if method exist, than invoke.
            method.invoke(this.mTarget, args);
        } catch ( Exception e ) {
            ExceptionBox.getInstances().message(e.toString());
        }
    }
}
