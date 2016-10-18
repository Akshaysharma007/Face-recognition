package com.example.akshaysharma.face1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.kairos.*;
import com.kairos.Kairos;

public class MainActivity extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    // instantiate a new kairos instance
    Kairos myKairos = null;
    // set authentication
    String app_id = "d1aec416";
    String api_key = "d3dd68b4f62b2232245e2530334d8ed7";
    Bitmap image;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = BitmapFactory.decodeResource(getResources(), R.drawable.happiestdogs);

        myKairos = new Kairos();
        myKairos.setAuthentication(this, app_id, api_key);
        // ATTENTION: This was auto-generated to implement the App Indexing API
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
       // process();
        // Fine-grained Example:
// This example uses a bitmap image and also optional parameters
        String galleryId = "friends";
        String selector = "FULL";
        String threshold = "0.75";
        String minHeadScale = "0.25";
        String maxNumResults = "25";
        String image = "http://media.kairos.com/liz.jpg";
        // Create an instance of the KairosListener
        KairosListener listener = new KairosListener() {

            @Override
            public void onSuccess(String response) {
                // your code here!
                Log.d("KAIROS success", response);
            }

            @Override
            public void onFail(String response) {
                // your code here!
                Log.d("KAIROS DEMO", response);
            }
        };
        try {
            myKairos.detect(image, null, null, listener);
        }catch (Exception r)
        {
            Log.e("exception",r+"");
        }
    }

}

