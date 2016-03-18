package com.company.project.Framework.Control;

import com.company.project.Pattern.Core.IPatternObject;

import java.util.HashMap;

/**
 * Created by Jacky on 2016/3/15.
 */
public class ModelController {
    // Singleton pattern
    // Static instances.
    private static ModelController mInstances = null;
    // Static get method
    public static ModelController getInstances() {
        // Instances is null, than new one.
        if(mInstances == null)
            mInstances = new ModelController();
        return mInstances;
    }

    // Static Enum
    // Member variable
    private HashMap mModelGroup;
    // Constructor
    private ModelController() {
        // IPatternObject
        this.mModelGroup = new HashMap();
    }
    // Operation method : register.
    public boolean register(IPatternObject _source) {
        // 1. Duplicate object could not register
        if(!this.has(_source.getKeyID())) {
            // 2. Add in container
            this.mModelGroup.put(_source.getKeyID(), _source);
            return true;
        }
        return false;
    }

    // Operation method : remove.
    public boolean remove(String _keyID) {
        // 1. Remove target object in map.
        boolean result = this.mModelGroup.remove(_keyID) != null;
        return result;
    }

    // Operation method : retrieve.
    public IPatternObject retrieve(String _keyID) {
        return (IPatternObject)this.mModelGroup.get(_keyID);
    }

    // Operation method : check filter is exist or not.
    public boolean has(String _keyID) {
        return this.mModelGroup.containsKey(_keyID);
    }

    // Operation method : how many trigger in container.
    public int count() {
        return this.mModelGroup.size();
    }
}
