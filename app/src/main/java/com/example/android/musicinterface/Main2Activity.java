package com.example.android.musicinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        TextView artistName =(TextView)findViewById(R.id.artist_name_textViewTwo);
        TextView songName=(TextView)findViewById(R.id.song_title_textViewTwo);
        if (bundle != null) {
            artistName.setText(bundle.getString("artist name"));
            songName.setText(bundle.getString("song name"));
            position= bundle.getInt("position");
            }
        TextView goBack = (TextView)findViewById(R.id.back_textView);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Main2Activity.this,MainActivity.class);
                back.putExtra("position",position);
                startActivity(back);
            }
        });




    }
}
