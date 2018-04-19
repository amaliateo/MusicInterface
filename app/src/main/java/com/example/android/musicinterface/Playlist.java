package com.example.android.musicinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Playlist extends AppCompatActivity {
    static final String STATE_POSITION = "position";
    int position;
    ArrayList<Song> songs;
    Song song;
    private TextView pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        //declare new ArrayList and assign values to it, using Song.class
        songs = new ArrayList<Song>();
        songs.add(new Song("Calvin Harris & Disciples", "How deep is your love", "195"));
        songs.add(new Song("Avicii", "Waiting for love", "236"));
        songs.add(new Song("Martin Garrix & Tiesto", "The only way is up", "174"));
        songs.add(new Song("Armin van Buuren feat. Nadia Ali", "Feels so good", "260"));
        songs.add(new Song("Disclosure feat. Lorde", "Magnets", "264"));
        songs.add(new Song("Rudimental feat. Ed Sheeran", "Lay it all on me", "205"));
        songs.add(new Song("Joseph Salvat", "Open Season", "223"));
        songs.add(new Song("Tinie Tempah feat. Jess Glynne", "Not letting go", "175"));
        songs.add(new Song("Sigala feat. Bryn Christopher", "Sweet lovin", "201"));
        songs.add(new Song("Y'akoto", "Withou you", "236"));
        songs.add(new Song("Blonde feat. Melissa Steel", "I loved you", "176"));
        songs.add(new Song("Alex Parker", "Tropical sun", "301"));
        songs.add(new Song("Zwette feat. Molly", "Rush", "194"));
        songs.add(new Song("Netsky feat. Digital Farm Animals", "Rio", "261"));
        songs.add(new Song("Fedde Le Grand feat. Niels Geusebroek", "Falling", "211"));

        //initialize an adapter for the new arraylist
        SongAdapter itemsAdapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.track_list);
        listView.setAdapter(itemsAdapter);

        //initialize the playlist at the first item in the listView and display it in the nowPlaying textView
        displayNowPlaying(0, song);

        //change nowPlaying textView with the selected song from playlist
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                song = songs.get(i);
                position = i;
                displayNowPlaying(position, song);
            }
        });

        //go to the next song in the playlist with next textView
        TextView next = (TextView) findViewById(R.id.next_textView);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((position + 1) < (songs.size())) {
                    position++;
                    displayNowPlaying(position, song);
                }
            }
        });

        //go to the previous song in the playlist with previous textView
        TextView previous = (TextView) findViewById(R.id.previous_textView);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position > 0) {
                    position--;
                    displayNowPlaying(position, song);
                }
            }
        });

        //change "pause" textView with "play" when selected
        pause = (TextView) findViewById(R.id.pause_textView);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((pause.getText().toString()).equals("pause")) {
                    pause.setText(R.string.play);
                } else pause.setText(R.string.pause);
            }
        });

        //receive intent from CurrentlyPlayingSong and update the nowplaying textView
        Bundle fromMaximize = getIntent().getExtras();
        if (fromMaximize != null) {
            position = fromMaximize.getInt("position");
        }
        displayNowPlaying(position, song);
    }

    //set the text for nowPlaying txtView with the artist name and song name from the selected item in the listView
    private void displayNowPlaying(int songPosition, Song currentSong) {
        TextView nowPlaying = (TextView) findViewById(R.id.artist_name_textViewThree);
        currentSong = songs.get(songPosition);
        String artistAndSong = currentSong.getArtistName() + "  - " + currentSong.getSongTitle();
        nowPlaying.setText(artistAndSong);
    }

    //save the current position if the user changes landscape
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_POSITION, position);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt(STATE_POSITION);
        //song = songs.get(position);
        //String artistAndSong = song.getArtistName() + "  - " + song.getSongTitle();
        //nowPlaying.setText(artistAndSong);
        displayNowPlaying(position, song);
    }
}