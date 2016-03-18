package com.company.project.Pattern.Progress;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jacky on 2016/3/14.
 */
public class Pipe {
    // Static variable
    public static String STEP_START = "pipe.step.start";
    public static String STEP_END = "pipe.step.end";
    // Member variable
    private HashMap mPipes;
    private ArrayList mRoutes;
    private ArrayList mProgress;
    // Constructor
    public Pipe() {
        // Filter store
        this.mPipes = new HashMap();
        // Routing map
        this.mRoutes = new ArrayList();
        // Progress thread
        this.mProgress = new ArrayList();
    }
    // Operation method : register.
    public boolean register(IFilter _source) {
        // 1. Duplicate object could not register
        if(!this.has(_source.getKeyID())) {
            // 2. Add in container
            this.mPipes.put(_source.getKeyID(), _source);
            this.mRoutes.add(_source.getKeyID());
            return true;
        }
        return false;
    }

    // Operation method : remove.
    public boolean remove(String _keyID) {
        // 1. Remove target object in map.
        boolean result = this.mPipes.remove(_keyID) != null;
        // 2. Remove success, than remove index in routes.
        if( result ) {
            this.mRoutes.remove(_keyID);
        }
        return result;
    }

    // Operation method : retrieve.
    public IFilter retrieve(String _keyID) {
        return (IFilter)this.mPipes.get(_keyID);
    }

    // Operation method : check filter is exist or not.
    public boolean has(String _keyID) {
        return this.mPipes.containsKey(_keyID);
    }

    // Operation method : how many trigger in container.
    public int count() {
        return this.mPipes.size();
    }

    // Get / Set method
    public Progress getProgress(int _indexID) {
        if(_indexID >= 0 && _indexID < this.mProgress.size()) {
            return (Progress)this.mProgress.get(_indexID);
        }
        return null;
    }
    public int getProgressIndex(Progress _progress) {
        return this.mProgress.indexOf(_progress);
    }
    public ArrayList getRoutes() {
        return this.mRoutes;
    }

    // Execute progress
    public void execute(Progress _progress) {
        this.execute(_progress, Pipe.STEP_START);
    }
    public void execute(Progress _progress, String _state) {
        // 1. progress could not be null.
        if(_progress == null) {
            _progress = new Progress();
        }
        // 2. if state is Strat, execute onPipeStart
        if(_state.equals(Pipe.STEP_START)) {
            this.onPipeStart(_progress);
        }
        // 3. if state is End, execute onPipeComplete
        else if(_state.equals(Pipe.STEP_END)) {
            this.onPipeComplete(_progress);
        }
    }
    // on Pipe complete
    protected void onPipeComplete(Progress _progress) {
        // Progress ending, clear progress variable.
        this.mProgress.remove(_progress);
    }
    protected void onPipeStart(Progress _progress) {
        // Progress starting, save progress variable
        // don't duplicate
        if(this.mProgress.indexOf(_progress) < 0) {
            // Saving progress
            this.mProgress.add(_progress);
            // Setting progress
            _progress.setPipe(this);
        }
        // Start progress
        _progress.nextStep();
    }
}
