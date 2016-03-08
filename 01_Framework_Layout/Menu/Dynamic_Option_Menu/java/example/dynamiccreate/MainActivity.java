package example.dynamiccreate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Option menu, create and selected.
    // 1. Defined menu id
    private static final int MENU_ADD = Menu.FIRST;
    private static final int MENU_LIST = Menu.FIRST + 1;
    private static final int MENU_REFRESH = Menu.FIRST + 2;
    private static final int MENU_LOGIN = Menu.FIRST + 3;

    // 2. Setting and create menu
    // Use this method when you menu is static. (i.e. unchanging)
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        menu.add(0, MENU_ADD, Menu.NONE, "ADD").setIcon(R.drawable.ic_action_name).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(0, MENU_LIST, Menu.NONE, "LIST").setIcon(R.drawable.ic_apps_black).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(0, MENU_REFRESH, Menu.NONE, "REFRESH").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        menu.add(0, MENU_LOGIN, Menu.NONE, "LOGIN").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        return true;
    }

    // 2. Setting and  create menu
    // Use this method when you menu is dynamic. (i.e. changing by some variable)
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        if(true)
            menu.add(0, MENU_ADD, Menu.NONE, "ADD").setIcon(R.drawable.ic_action_name).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        if(true)
            menu.add(0, MENU_LIST, Menu.NONE, "LIST").setIcon(R.drawable.ic_apps_black).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        if(true)
            menu.add(0, MENU_REFRESH, Menu.NONE, "REFRESH").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        if(true)
            menu.add(0, MENU_LOGIN, Menu.NONE, "LOGIN").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        return super.onPrepareOptionsMenu(menu);
    }

    // 3. Event processing
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case MENU_ADD : {
                Toast.makeText(this, "Click MENU_ADD", Toast.LENGTH_LONG).show();
                break;
            }
            case MENU_LIST : {
                Toast.makeText(this, "Click MENU_LIST", Toast.LENGTH_LONG).show();
                break;
            }
            case MENU_REFRESH : {
                Toast.makeText(this, "Click MENU_REFRESH", Toast.LENGTH_LONG).show();
                break;
            }
            case MENU_LOGIN : {
                Toast.makeText(this, "Click MENU_LOGIN", Toast.LENGTH_LONG).show();
                break;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
