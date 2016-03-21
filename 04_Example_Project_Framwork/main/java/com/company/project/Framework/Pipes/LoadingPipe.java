package com.company.project.Framework.Pipes;

import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Progress.Pipe;
import com.company.project.Pattern.Progress.Progress;

/**
 * Created by Jacky on 2016/3/17.
 */
public class LoadingPipe extends Pipe {
    // Member variable
    private String mErrorMessage;
    private boolean mIsError;
    // Constructor
    public LoadingPipe() {
        this.mIsError = false;
        this.mErrorMessage = "";
    }

    // Pipe method
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

    @Override
    protected void onPipeError(Progress _progress) {
        this.mErrorMessage = _progress.getErrorMessage();
        this.mIsError = true;
        super.onPipeError(_progress);
    }

    // Get / Set method
    public String getErrorMessage() {
        return this.mErrorMessage;
    }
    public boolean getIsError() {
        return this.mIsError;
    }
}
