package example.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial context menu
        this.initialContextMenu();
        // Initial popup menu
        this.initialPopupMenu();
    }

    // Option menu, create and selected.
    // 1. Setting and create menu
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.option_bar, menu);
        return true;
    }

    // 3. Event processing
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Log.d("App-Log", "Selected action favorite.");
                return true;
            case R.id.action_settings:
                Log.d("App-Log", "Selected action settings.");

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Context menu, create and selected.
    // 1. Setting
    private void initialContextMenu() {
        TextView tv = (TextView) findViewById(R.id.Main_TextView_1);
        registerForContextMenu(tv);
    }

    // 2. Create menu
    @Override
    public void onCreateContextMenu (ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.context_bar, menu);
    }

    // 3. Event processing
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Log.d("App-Log", "Selected action favorite.");
                return true;
            case R.id.action_context_copy:
                Log.d("App-Log", "Selected action copy.");
                return true;
            case R.id.action_context_paste:
                Log.d("App-Log", "Selected action paste.");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Popup menu, create and selected.
    // 1. Setting
    private void initialPopupMenu() {
        TextView tv = (TextView) findViewById(R.id.Main_TextView_2);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    // 2. Create menu and event processing
    public void showPopupMenu(View v) {
        // Create menu
        PopupMenu popup = new PopupMenu(this, v);
        // Setting menu click event
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_favorite:
                        Log.d("App-Log", "Selected action favorite.");
                        return true;
                    case R.id.action_context_paste:
                        Log.d("App-Log", "Selected action paste.");
                        return true;
                    default:
                        return false;
                }
            }
        });
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_bar, popup.getMenu());
        popup.show();
    }
}
