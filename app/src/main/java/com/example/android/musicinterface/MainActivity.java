package com.example.android.musicinterface;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int position=0;
    TextView nowPlaying;
    TextView pause;
    String artistAndSong;
    ArrayList <Song> songs;
Song song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songs = new ArrayList<Song>();
        songs.add(new Song("Calvin Harris & Disciples", "How deep is your love", "3:15"));
        songs.add(new Song("Avicii", "Waiting for love", "3:56"));
        songs.add(new Song("Martin Garrix & Tiesto", "The only way is up", "2:54"));
        songs.add(new Song("Armin van Buuren feat. Nadia Ali", "Feels so good", "4:20"));
        songs.add(new Song("Disclosure feat. Lorde", "Magnets", "4:44"));
        songs.add(new Song("Rudimental feat. Ed Sheeran", "Lay it all on me", "3:13"));
        songs.add(new Song("Joseph Salvat", "Open Season", "3:43"));
        songs.add(new Song("Tinie Tempah feat. Jess Glynne", "Not letting go", "2:55"));
        songs.add(new Song("Sigala feat. Bryn Christopher", "Sweet lovin", "3:21"));
        songs.add(new Song("Y'akoto", "Withou you", "3:54"));
        songs.add(new Song("Blonde feat. Melissa Steel", "I loved you", "2:56"));
        songs.add(new Song("Alex Parker", "Tropical sun", "5:01"));
        songs.add(new Song("Zwette feat. Molly", "Rush", "4:34"));
        songs.add(new Song("Netsky feat. Digital Farm Animals", "Rio", "4:21"));
        songs.add(new Song("Fedde Le Grand feat. Niels Geusebroek", "Falling", "3:31"));

        SongAdapter itemsAdapter = new SongAdapter(this, songs);

        final ListView listView = (ListView) findViewById(R.id.track_list);

        listView.setAdapter(itemsAdapter);
        nowPlaying = (TextView) findViewById(R.id.artist_name_textViewThree);
        song = songs.get(position);
        artistAndSong= song.getArtistName() + "  - " + song.getSongTitle();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                song = songs.get(i);
                position = i;
                artistAndSong= song.getArtistName() + "  - " + song.getSongTitle();

                nowPlaying.setText(artistAndSong);
                nowPlaying.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.slide_in_left));


            }
        });

        TextView next = (TextView) findViewById(R.id.next_textView);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((position + 1) < (songs.size())) {
                    position++;
                    song = songs.get(position);
                    artistAndSong= song.getArtistName() + "  - " + song.getSongTitle();
                    nowPlaying.setText(artistAndSong);
                }
            }
        });
        TextView previous = (TextView) findViewById(R.id.previous_textView);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position > 0) {
                    position--;
                    song = songs.get(position);
                    artistAndSong= song.getArtistName() + "  - " + song.getSongTitle();
                    nowPlaying.setText(artistAndSong);
                }
            }
        });
        pause = (TextView) findViewById(R.id.pause_textView);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((pause.getText().toString()).equals("pause")) {
                    pause.setText("play");
                } else pause.setText("pause");
            }
        });

Bundle fromMaximize = getIntent().getExtras();
if(fromMaximize!= null){
    position = fromMaximize.getInt("position");
}
    song = songs.get(position);
    artistAndSong= song.getArtistName() + "  - " + song.getSongTitle();
    nowPlaying.setText(artistAndSong);

    }
}