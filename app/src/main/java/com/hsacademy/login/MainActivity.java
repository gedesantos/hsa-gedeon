package com.hsacademy.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeIntents;
import com.hsacademy.login.adapter.ImageAdapter;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    static final String[] VIDEO_ID = new String[] {
            "DUzFd3KQnGU", "zSOUl9QmQwM", "MOaIxAmN3WM", "YYvmvgebE1I", "qM4d9Mzhd8M", "F4fyKnu5dt0", "HJ7gssA2Unw" , "4YjLMdx3YZY", "QoOvRIn4KL8" , "6jxkbsBio4I"
    , "FmpFrZqbEEM" , "_bv0USpx9Y0", "QnF-OQ-uJVk" , "vqoKoEYgl9M" , "YGVP_tedlgI", "ndxWvrqqvII"};


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
