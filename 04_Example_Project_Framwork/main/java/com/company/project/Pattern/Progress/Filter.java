package com.company.project.Pattern.Progress;

/**
 * Created by Jacky on 2016/3/14.
 */
public class Filter implements IFilter {
    // Member variable
    private String mKeyID;
    // Constructor
    public Filter(String _keyID) {
        this.mKeyID = _keyID;
    }

    // Set target method param type.
    public String getKeyID() {
        return this.mKeyID;
    }

    // Execute method
    public void execute(Progress _progress) {
    }
}
