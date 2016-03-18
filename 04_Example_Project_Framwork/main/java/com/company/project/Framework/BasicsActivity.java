package com.company.project.Framework;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.company.project.Framework.Control.AlertBoxController;
import com.company.project.Framework.Model.Login;
import com.company.project.Framework.Pipes.SwitchingPipe;
import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.P002;
import com.company.project.Pattern.Progress.Filter;
import com.company.project.Pattern.Progress.Progress;
import com.company.project.Pattern.Proxy.WaitsProxy;
import com.company.project.R;
import com.company.project.Pattern.Observers.Trigger;

import java.util.ArrayList;

/**
 * Created by Jacky on 2016/3/7.
 */
public class BasicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Default action bar intent target activity.
        this.setIntentTargetActivity(P002.class);
        // Default screen orientation.
        this.setScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Default Alert Box context
        AlertBoxController.getInstances().setContext(this);
        // Default Exception Box context
        ExceptionBox.getInstances().setContext(this);
    }

    // Set screen orientation
    protected void setScreenOrientation(int _orientation) {
        setRequestedOrientation(_orientation);
    }
    // Disable system back button event
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Alert : You click Back button ", Toast.LENGTH_LONG).show();
    }

    // Switching action.
    public void switchingProgress(Class _target) {
        SwitchingPipe sp = new SwitchingPipe(this, _target);
        sp.execute(new Progress());
    }
    public void switchingProgress(Class _target, Filter... _filters) {
        SwitchingPipe sp = new SwitchingPipe(this, _target, _filters);
        sp.execute(new Progress());
    }

    // Action bar management variable.
    // static variable
    public static int ACTION_BAR_NONE = 1;
    public static int ACTION_BAR_MENU = 2;
    public static int ACTION_BAR_BACK = 3;
    // member variable
    private Class mIntentTargetActivity = null;
    private int mActionBarStateCode = BasicsActivity.ACTION_BAR_NONE;
    private int mActionBarIconCode = -1;
    private String mActionBarTitle = "";

    // Set action bar title content attribute.
    protected void setActionBarTitle( String _titleContent ) {
        this.mActionBarTitle = _titleContent;
        this.setActionBar();
    }
    // Set action bar action state .
    protected void setActionBarState( int _actionBarCode ) {
        this.mActionBarStateCode = _actionBarCode;
        this.setActionBar();
    }
    // Set action bar icon id.
    protected void setActionBarIcon( int _actionIconDrawableId ) {
        this.mActionBarIconCode = _actionIconDrawableId;
        this.setActionBar();
    }
    // Set action bar intent target activity.
    protected  void setIntentTargetActivity( Class _targetActivity ) {
        this.mIntentTargetActivity = _targetActivity;
    }
    // Setting action bar
    private void setActionBar() {
        // 1. Get action bar object.
        ActionBar bar = this.getSupportActionBar();

        // 2. Make sure object is exist.
        if( bar != null ) {
            // 3. Setting action bar use Icon and Title.
            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
            // 4. Set Home icon, if icon id exist
            if( this.mActionBarIconCode >= 0 )
                bar.setIcon(this.mActionBarIconCode);
            // Set Title name
            bar.setTitle(this.mActionBarTitle);
            // 4. Setting action bar state be NONE, only icon and title, it is default setting.
            if( this.mActionBarStateCode == BasicsActivity.ACTION_BAR_MENU) {
                // 4.1 Setting state be MENU
                bar.setHomeButtonEnabled(true);
                bar.setDisplayHomeAsUpEnabled(true);
                bar.setHomeAsUpIndicator(R.drawable.ic_menu);
            } else if( this.mActionBarStateCode == BasicsActivity.ACTION_BAR_BACK ) {
                // 4.2 Setting state be BACK
                bar.setHomeButtonEnabled(true);
                bar.setDisplayHomeAsUpEnabled(true);
                bar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
            }
        }
    }


    // Option menu dynamic management sub-system.
    // 1. Defined menu trigger
    public class MenuTrigger extends Trigger {
        private String mContent = "";
        private int mIconId = -1;
        private int mItemId = 0;
        private int mGroupId = 0;
        public MenuTrigger(Object _target, String _method, String _content) {
            super(_target, _method);
            this.mContent = _content;
        }
        public MenuTrigger setIcon(int _iconId) {
            this.mIconId = _iconId;
            return this;
        }
        public MenuTrigger setItemID(int _id) {
            this.mItemId = _id;
            return this;
        }
        public MenuTrigger setGroupID(int _id) {
            this.mGroupId = _id;
            return this;
        }
        public void createOptionMenu(Menu _menu) {
            // 1. Create option menu
            MenuItem mi = _menu.add(this.mGroupId, this.mItemId, Menu.NONE, this.mContent);
            // 2. If need icon, add id and chnage show action.
            if(this.mIconId > 0) {
                mi.setIcon(this.mIconId).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            } else {
                mi.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
            }
        }
    }
    // Option menu management variable
    private ArrayList mMenuTriggers = new ArrayList();
    // Set option menu, add.
    protected void addOptionMenu(String _content, String _method) {
        this.addOptionMenu(_content, _method, -1, Menu.NONE);
    }
    protected void addOptionMenu(String _content, String _method, int _iconId) {
        this.addOptionMenu(_content, _method, _iconId, Menu.NONE);
    }
    protected void addOptionMenu(String _content, String _method, int _iconId, int _groupId) {
        MenuTrigger mt = null;
        mt = new MenuTrigger(this, _method, _content);
        mt.setIcon(_iconId);
        mt.setItemID(mMenuTriggers.size() + Menu.FIRST);
        mt.setGroupID(_groupId);
        this.mMenuTriggers.add(mt);
    }
    // Set option menu, clear.
    protected void clearOptionMenu() {
        this.mMenuTriggers.clear();
    }
    // 2. Setting and create menu
    // Use this method when you menu is static. (i.e. unchanging)
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    // 2. Setting and  create menu
    // Use this method when you menu is dynamic. (i.e. changing by some variable)
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        for(int i = 0 ; i < this.mMenuTriggers.size() ; i++) {
            ((MenuTrigger)this.mMenuTriggers.get(i)).createOptionMenu(menu);
        }
        // First one menu, show on bar.
        if(menu.size() > 0)
            menu.getItem(0).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onPrepareOptionsMenu(menu);
    }
    // Action bar and option menu event processing
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home : {
                // None, do nothing.
                // Menu, switching to target activity.
                if( this.mActionBarStateCode == BasicsActivity.ACTION_BAR_MENU && this.mIntentTargetActivity != null) {
                    Intent i = new Intent(this, this.mIntentTargetActivity);
                    startActivity(i);
                }
                // Back, finish this activity.
                else if( this.mActionBarStateCode == BasicsActivity.ACTION_BAR_BACK ) {
                    finish();
                }
                break;
            }
            default: {
                int id = item.getItemId();
                if( id >= Menu.FIRST && id <= Menu.FIRST + this.mMenuTriggers.size()) {
                    ((MenuTrigger)this.mMenuTriggers.get(id - Menu.FIRST)).execute();
                } else {
                    return super.onOptionsItemSelected(item);
                }
                break;
            }
        }
        return true;
    }
}
