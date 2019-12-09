package com.cap.seattleemergencyhubs;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class AnnouncementDetailsActivity extends AppCompatActivity {

    private static final String TAG = "ZombieMovieDetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_announcement_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("ANNOUNCEMENTS");

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();

        //pulling elements values from key on Bundle
        String ImageUrlReceived = bundle.getString("zombieImageURL");
        String TitleReceived = bundle.getString("zombieMovieTitle");
        String YearReceived = bundle.getString("zombieMovieYear");
        String DirectReceived = bundle.getString("zombieMovieDirector");
        String DescReceived = bundle .getString("zombieMovieDescription");

        //creating layout elements
        ImageView zombieMovieImage = (ImageView) findViewById(R.id.zombieMovieImage);
        TextView zombieMovieTitle = (TextView)findViewById(R.id.zombieMovieTitle);
        TextView zombieMovieYear = (TextView)findViewById(R.id.zombieMovieYear);
        TextView zombieMovieDirector = (TextView)findViewById(R.id.zombieMovieDirector);
        TextView zombieMovieDescription = (TextView)findViewById(R.id.zombieMovieDescription);

        //setting text variables to the fields
        zombieMovieTitle.setText(TitleReceived);
        zombieMovieYear.setText(YearReceived);
        zombieMovieDirector.setText(DirectReceived);
        zombieMovieDescription.setText(DescReceived);

        //setting image URL
        Picasso p = Picasso.get();
        p.setIndicatorsEnabled(true);
        p.setLoggingEnabled(true);


        p.load(ImageUrlReceived).into(zombieMovieImage);
    }
}