package com.company.project.Framework.Pipes;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.company.project.Framework.Model.Login;
import com.company.project.P001;
import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Progress.Filters.TriggerFilter;
import com.company.project.Pattern.Progress.IFilter;
import com.company.project.Pattern.Progress.Pipe;
import com.company.project.Pattern.Progress.Progress;
import com.company.project.Pattern.Proxy.WaitsProxy;
import com.company.project.Pattern.Proxy.WebServiceProxy;

import java.util.ArrayList;

/**
 * Created by Chen on 2016/3/17.
 */
public class SwitchingPipe extends Pipe {
    // Member variable
    private Context mSourceActivity;
    private Class mTargetActivity;
    private ProgressDialog mProgressDialog;
    private Handler mHandler;
    private LoadingPipe mLoadingPipe;
    private Progress mProgress;
    // Constructor
    public SwitchingPipe(Context _source, Class _target) {
        // Initial
        this.initialSwitchingPipe(_source, _target);
    }
    public SwitchingPipe(Context _source, Class _target, IFilter... _filters) {
        // Initial
        this.initialSwitchingPipe(_source, _target);
        // Saving filter in loading pipe.
        for(int i = 0 ; i < _filters.length ; i++) {
            if(_filters[i] != null)
                this.mLoadingPipe.register(_filters[i]);
        }
    }
    private void initialSwitchingPipe(Context _source, Class _target) {
        // Saving activity information.
        this.mSourceActivity = _source;
        this.mTargetActivity = _target;
        // Create progress dialog
        this.mProgressDialog = new ProgressDialog(_source);
        this.mProgressDialog.setTitle("Dialog title");
        this.mProgressDialog.setIcon(android.R.drawable.ic_dialog_info);
        this.mProgressDialog.setMessage("Dialog message");
        this.mProgressDialog.setIndeterminate(true);
        this.mProgressDialog.setCancelable(false);
        // Create thread handler
        this.mHandler = new Handler();
        // Create loading pipe
        this.mLoadingPipe = new LoadingPipe();
    }
    @Override
    protected void onPipeStart(Progress _progress) {
        ExceptionBox.getInstances().message("Switching Pipe : onPipeStart", ExceptionBox.STYLE_LOG);
        // check have filter need to loading
        if(this.mLoadingPipe.count() > 0)
            this.register(new TriggerFilter("ProgressShowStep", this, "onProgressShow"));
        // execute internal program in parent class.
        super.onPipeStart(_progress);
    }

    public void onProgressShow(Progress _progress) {
        // Saving progress controller.
        this.mProgress = _progress;
        // Show progress dialog.
        this.mProgressDialog.show();
        // Start lengthy operation in a background thread
        Thread t = new Thread(new Runnable() {
            public void run() {
                mLoadingPipe.execute(new Progress());
                // Update the progress bar, or finish progress.
                // use runOnUiThread or Handler
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mProgressDialog.dismiss();
                        mProgress.nextStep();
                    }
                });
            }
        });
        t.start();
    }

    @Override
    protected void onPipeComplete(Progress _progress) {
        ExceptionBox.getInstances().message("Switching Pipe : onPipeComplete", ExceptionBox.STYLE_LOG);
        // Switching activity.
        Intent i = new Intent(this.mSourceActivity, this.mTargetActivity);
        this.mSourceActivity.startActivity(i);
        // execute internal program in parent class.
        super.onPipeComplete(_progress);
    }
}
