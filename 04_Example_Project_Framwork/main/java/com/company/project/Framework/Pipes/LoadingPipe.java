package com.company.project.Framework.Pipes;

import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Progress.Pipe;
import com.company.project.Pattern.Progress.Progress;

/**
 * Created by Chen on 2016/3/17.
 */
public class LoadingPipe extends Pipe {
    @Override
    protected void onPipeStart(Progress _progress) {
        ExceptionBox.getInstances().message("Loading Pipe : onPipeStart", ExceptionBox.STYLE_LOG);
        // execute internal program in parent class.
        super.onPipeStart(_progress);
    }

    @Override
    protected void onPipeComplete(Progress _progress) {
        ExceptionBox.getInstances().message("Loading Pipe : onPipeComplete", ExceptionBox.STYLE_LOG);
        // execute internal program in parent class.
        super.onPipeComplete(_progress);
    }
}
