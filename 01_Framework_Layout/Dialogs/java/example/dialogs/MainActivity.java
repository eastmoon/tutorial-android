package example.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] list = {"Red", "Green", "Blue", "Yellow"};
    private View cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = null;

        // Default call alert dialog builder.
        btn = (Button) this.findViewById(R.id.Main_Button_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use the Builder class for convenient dialog construction
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alert Dialog Example")
                        .setMessage("Message content.")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User accept the dialog
                            }
                        })
                        .setNeutralButton(android.R.string.copy, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User accept the dialog
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                AlertDialog ad = builder.create();
                ad.show();
            }
        });

        // Call alert dialog and insert list item.
        btn = (Button) this.findViewById(R.id.Main_Button_2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alert Dialog Example")
                        .setItems(list, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position of the selected item
                                Log.d("App-Log", "Choose " + list[which]);
                            }
                        });
                AlertDialog ad = builder.create();
                ad.show();
            }
        });

        // Call alert dialog and insert multi choice list item.
        btn = (Button) this.findViewById(R.id.Main_Button_3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alert Dialog Example")
                        .setMultiChoiceItems(list, null, new DialogInterface.OnMultiChoiceClickListener() {
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                // The 'which' argument contains the index position of the selected item
                                Log.d("App-Log", "Choose " + list[which] + ", " + isChecked);
                            }
                        })
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // User clicked OK, so save the select results somewhere or return them to the component that opened the dialog
                            }
                        });
                AlertDialog ad = builder.create();
                ad.show();
            }
        });

        // Call alert dialog ,and insert single choice list, and have default select.
        btn = (Button) this.findViewById(R.id.Main_Button_4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alert Dialog Example")
                        .setSingleChoiceItems(list, 1, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position of the selected item
                                Log.d("App-Log", "Choose " + list[which]);
                            }
                        })
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // User clicked OK, so save the select results somewhere or return them to the component that opened the dialog
                            }
                        });
                AlertDialog ad = builder.create();
                ad.show();
            }
        });

        // Call alert dialog ,and insert custom view.
        btn = (Button) this.findViewById(R.id.Main_Button_5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                cv = getLayoutInflater().inflate(R.layout.dialog_signin, null);
                builder.setTitle("Alert Dialog Example")
                        .setView(cv)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                String username = ((EditText) cv.findViewById(R.id.username)).getText().toString();
                                String password = ((EditText) cv.findViewById(R.id.password)).getText().toString();
                                Log.d("App-Log", username + ", " + password);
                            }
                        });
                AlertDialog ad = builder.create();
                ad.show();
            }
        });
    }
}
