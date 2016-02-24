package example.webapi;

import java.io.IOException;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

// Import OkHttp library
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.Main_Button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(postInfo).start();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", "OkHttp Headers.java")
                .header("Cookie", "PHPSESSID=123456789")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        Log.d("Log", response.toString());
        return response.body().string();
    }

    String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    String bowlingJson(String player1, String player2) {
        return "{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}";
    }

    private Runnable postInfo = new Runnable() {
        @Override
        public void run() {
            String json = bowlingJson("Jesse", "Jake");
            try {
                Log.d("Log", json);
                //String response = post("http://172.16.106.106/phone.php?A=999&B=111", json);
                String response = post("http://www.roundsapp.com/post", json);
                Log.d("Log", response);
            } catch (Exception e) {
                Log.d("Log-exception", e.toString());
            }
        }
    };
}
