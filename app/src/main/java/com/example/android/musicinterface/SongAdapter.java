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
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        currentSong = getItem(position);
        TextView artistName = (TextView)listItemView.findViewById(R.id.artist_name_textView);
        artistName.setText(currentSong.getArtistName());
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView songTitle= (TextView) listItemView.findViewById(R.id.song_title_textView);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        songTitle.setText(currentSong.getSongTitle());
        ImageButton maximize = (ImageButton)listItemView.findViewById(R.id.maximize_imageButton);
        maximize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSong = getItem(position);
                Intent i = new Intent(view.getContext(), Main2Activity.class);
                i.putExtra("song name",currentSong.getSongTitle());
                i.putExtra("artist name",currentSong.getArtistName());
                i.putExtra("song duration",currentSong.getSongDuration());
                i.putExtra("position",position);
                view.getContext().startActivity(i);
            }
        });

        // Find the TextView in the list_item.xml layout with the ID version_number

        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView



        return listItemView;
    }


    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, songs);
    }
}
