package com.example.android.musicinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CurrentlyPlayingSong extends AppCompatActivity {
    int position;
    int songDuration;
    private TextView time;
    private TextView artistName;
    private TextView songName;
    private TextView goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currently_playing_song);

        //identify TextViews
        artistName = (TextView) findViewById(R.id.artist_name_textViewTwo);
        songName = (TextView) findViewById(R.id.song_title_textViewTwo);
        goBack = (TextView) findViewById(R.id.back_textView);
        time = (TextView) findViewById(R.id.song_duration_textView);

        // getting intent values from the SongAdapter
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            artistName.setText(bundle.getString("artist"));
            songName.setText(bundle.getString("song name"));
            position = bundle.getInt("position");
            songDuration = Integer.parseInt(bundle.getString("song duration"));
        }

        //transform nr. of minutes in a min:sec format
        String convertMinutes = (songDuration / 60) + ":" + (songDuration - ((songDuration / 60) * 60));
        time.setText(convertMinutes);

        //go to the playlist layout, save the current position in the playlist
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(CurrentlyPlayingSong.this, Playlist.class);
                back.putExtra("position", position);
                startActivity(back);
            }
        });
    }
}



