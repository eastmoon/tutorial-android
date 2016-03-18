package com.company.project.Pattern.Progress;

import com.company.project.Pattern.Core.IPatternObject;

/**
 * Created by Jacky on 2016/3/14.
 */
public interface IFilter extends IPatternObject {
    // Execute filter functional
    void execute(Progress _progress);
}
