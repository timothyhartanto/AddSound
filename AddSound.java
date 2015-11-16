package com.example.proto.addsound;

import android.app.Activity;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddSound extends Activity {

    MediaPlayer stereo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sound);
        Button button = (Button) findViewById(R.id.button1);
        you();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               stereo.stop();
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                stereo.stop();
                stereo = MediaPlayer.create(AddSound.this, R.raw.music);
                stereo.start();
            }
        });
    }

    public void you(){
        stereo = MediaPlayer.create(AddSound.this, R.raw.music);
        stereo.start();
    }

    @Override
    public void onResume(){
        super.onResume();;

        stereo.start();
    }

    @Override
    public void onPause(){
        super.onPause();

        stereo.pause();
    }
}
