package com.hsacademy.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;

import com.google.android.youtube.player.YouTubeIntents;
import com.hsacademy.login.adapter.ImageAdapter;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    static final String[] VIDEO_ID = new String[] {
            "DUzFd3KQnGU", "zSOUl9QmQwM","YYvmvgebE1I", "F4fyKnu5dt0" };


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        gridView = (GridView) findViewById(R.id.gridView1);

        gridView.setAdapter(new ImageAdapter(this, VIDEO_ID));

        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Toast.makeText(
                        getApplicationContext(),
                        "play", Toast.LENGTH_SHORT).show();
                try {
                    Intent intentStartYoutube =
                            YouTubeIntents.createPlayVideoIntent(getApplicationContext(), VIDEO_ID[position]);

                    startActivity(intentStartYoutube);
                }
                catch (Exception e) {
                    Log.e("ERR", e.getMessage());
                }

            }
        });

    }


}
