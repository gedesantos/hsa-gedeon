package com.hsacademy.login.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.hsacademy.login.R;

import java.net.MalformedURLException;
import java.net.URL;

import com.squareup.picasso.Picasso;


public class ImageAdapter extends BaseAdapter {
    private Context context;
    private final String[] videoIDs;
    ImageView iv_youtube_thumnail,iv_play;

    public ImageAdapter(Context context, String[] videoIDs) {
        this.context = context;
        this.videoIDs = videoIDs;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.item, null);


            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);



            try {
                String videoId = videoIDs[position];

                // Should work :(

//                String img_url="http://img.youtube.com/vi/"+videoId+"/0.jpg";
//                System.out.println("videoid: " + videoId);
//                System.out.println("img_url: " + img_url);
//
//                Picasso.with(context)
//                        .load(img_url)
//                        .placeholder(R.mipmap.ic_launcher)
//                        .into(imageView);


                if (videoId.equalsIgnoreCase("DUzFd3KQnGU")) {
                    imageView.setImageResource(R.drawable.duzfd3kqngu);
                } else if (videoId.equals("zSOUl9QmQwM")) {
                    imageView.setImageResource(R.drawable.zsoui9qmqwm);
                } else if (videoId.equals("YYvmvgebE1I")) {
                    imageView.setImageResource(R.drawable.yyvmvgebe1i);
                } else {
                    imageView.setImageResource(R.drawable.f4fyknu5dt0);
                }
            }
            catch (Exception e) {
                System.out.println("e: " + e.getMessage());
            }



        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return videoIDs.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private String extractYoutubeId(String url) throws MalformedURLException {
        String query = new URL(url).getQuery();
        String[] param = query.split("&");
        String id = null;
        for (String row : param) {
            String[] param1 = row.split("=");
            if (param1[0].equals("v")) {
                id = param1[1];
            }
        }
        return id;
    }

}