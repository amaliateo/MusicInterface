package com.example.android.musicinterface;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    private Song currentSong;

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        currentSong = getItem(position);

        //set the song's artist name
        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_name_textView);
        artistName.setText(currentSong.getArtistName());

        //set the song's title
        TextView songTitle = (TextView) listItemView.findViewById(R.id.song_title_textView);
        songTitle.setText(currentSong.getSongTitle());

        //activate imageButton and send Intent for CurrentlyPlayingSong.class
        ImageButton maximize = (ImageButton) listItemView.findViewById(R.id.maximize_imageButton);
        maximize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSong = getItem(position);
                Intent i = new Intent(view.getContext(), CurrentlyPlayingSong.class);
                i.putExtra("song name", currentSong.getSongTitle());
                i.putExtra("artist", currentSong.getArtistName());
                i.putExtra("song duration", currentSong.getSongDuration());
                i.putExtra("position", position);
                view.getContext().startActivity(i);
            }
        });


        return listItemView;
    }

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        //initialize the ArrayAdapter's internal storage for the context and the list.
        super(context, 0, songs);
    }
}
