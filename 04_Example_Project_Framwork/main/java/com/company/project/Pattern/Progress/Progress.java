package com.company.project.Pattern.Progress;

import com.company.project.Pattern.Facade.ExceptionBox;

import java.util.ArrayList;

/**
 * Created by Jacky on 2016/3/14.
 */
public class Progress {
    // Member variable
    private Pipe mPipe;
    private int mProgressIndex;
    private int mRoutingIndex;
    private String mErrorMessage;
    private boolean mIsError;

    // Constructor
    public Progress() {
        // Initial variable
        this.mProgressIndex = -1;
        this.mPipe = null;
        this.mErrorMessage = "";
        this.mIsError = false;
    }

    // Method : Goto next step in pipe routes.
    public void nextStep() {
        // 1. get routes
        ArrayList routes = this.mPipe.getRoutes();
        // 2. add index, and check next step exist.
        this.mRoutingIndex++;
        if(this.mRoutingIndex < routes.size()) {
            // Take step name in routes and use name to retrieve filter.
            String step = (String)routes.get(this.mRoutingIndex);
            IFilter filter = this.mPipe.retrieve(step);
            if(filter != null) {
                // 2.1 step exist, execute.
                filter.execute(this);
            } else {
                // 2.2 step doesn't exist, error.
                this.setErrorMessage("Progress error : Step name in routes doesn't fine filter.");
            }
        } else {
            // 2.3 index is maximum, pipe complete.
            this.mPipe.execute(this, Pipe.STEP_END);
        }
    }

    // Method : Goto input step, if step in pipe.
    public void gotoStep(String _keyID) {
        // 1. if keyID is START / END
        if(_keyID.equals(Pipe.STEP_START)) {
            // change routing index.
            this.mRoutingIndex = -1;
            // execute Start
            this.mPipe.execute(this, Pipe.STEP_START);
        } else if(_keyID.equals(Pipe.STEP_END)) {
            // change routing index.
            this.mRoutingIndex = this.mPipe.getRoutes().size();
            // execute End
            this.mPipe.execute(this, Pipe.STEP_END);
        } else if(_keyID.equals(Pipe.STEP_ERROR)) {
            // Error outcome.
            this.mPipe.execute(this, Pipe.STEP_ERROR);
        } else {
            // 2. check step in routes.
            IFilter filter = this.mPipe.retrieve(_keyID);
            if(filter != null) {
                // 2.1 step exist, execute and change index.
                this.mRoutingIndex = this.mPipe.getRoutes().indexOf(_keyID);
                filter.execute(this);
            } else {
                // 2.2 step doesn't exist, error.
                this.setErrorMessage("Progress error : Input keyID doesn't fine filter.");
            }
        }
    }
    // Get / Set method
    public void setPipe(Pipe _pipe) {
        mProgressIndex = _pipe.getProgressIndex(this);
        if(mProgressIndex >= 0) {
            // save pipe, and initial routing index.
            this.mPipe = _pipe;
            this.mRoutingIndex = -1;
        }
        else
            this.setErrorMessage("Progress error : Progress doesn't in pipe.");
    }
    public Pipe getPipe() {
        return this.mPipe;
    }
    public int getProgressIndex() {
        return this.mProgressIndex;
    }
    public int getRoutingIndex() {
        return this.mRoutingIndex;
    }
    public void setErrorMessage(String _message) {
        // 1. Saving message
        this.mIsError = true;
        this.mErrorMessage = _message;
        // 2. goto error step
        this.gotoStep(Pipe.STEP_ERROR);
    }
    public String getErrorMessage() {
        if(!this.mIsError)
            return "";
        return this.mErrorMessage;
    }
}
