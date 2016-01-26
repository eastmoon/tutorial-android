package example.stramingvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Create video information class
    public class videoInfo {
        public String name;
        public String address;
        public videoInfo( String a_name, String a_address ) {
            this.name = a_name;
            this.address = a_address;
        }
    }
    // Video video member variable
    private VideoView vidView = null;
    // Player count.
    private int step = -1;
    // Video list.
    private videoInfo[] list = {
            new videoInfo("Https video", "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4"),
            new videoInfo("Http video", "http://81310752d5730fb4ef3c-221b4998ec12974102282b6d4a8fafbe.r2.cf1.rackcdn.com/Snowball.mp4"),
            new videoInfo("RTMP video", "rtmp://cp67126.edgefcs.net/ondemand/mp4:mediapm/ovp/content/test/video/spacealonehd_sounas_640_300.mp4")
    };

    // Implements OnClickListener event.
    @Override
    public void onClick(View v) {
        this.step++;
        if( this.step >= this.list.length )
            this.step = 0;
        // Change info
        TextView tv = (TextView)this.findViewById(R.id.textView);
        tv.setText(this.list[this.step].name);
        // Setting address
        this.vidView.setVideoURI(Uri.parse(this.list[this.step].address));
        // Player video
        this.vidView.start();
    }

    // Android framework, Initial and create Activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting Change button
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);

        // Take back video view
        this.vidView = (VideoView)findViewById(R.id.videoView);

        // Create media controller
        MediaController vidControl = new MediaController(this);

        // Setting video view and controller connection
        vidControl.setAnchorView(vidView);
        vidView.setMediaController(vidControl);

        this.onClick(null);
    }
}
