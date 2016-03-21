package com.company.project.Pattern.Progress.Filters;


import com.company.project.Pattern.Progress.Filter;
import com.company.project.Pattern.Progress.Progress;

/**
 * Created by Jacky on 2016/3/21.
 */
public class ErrorFilter extends Filter {
    // Member variable
    // Constructor
    public ErrorFilter(String _keyID) {
        super(_keyID);
    }

    // Execute method
    @Override
    public void execute(Progress _progress) {
        _progress.setErrorMessage("Error Filter : Progress error.");
    }
}
