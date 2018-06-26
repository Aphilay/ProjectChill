package com.example.kyleku.projectchill;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainMusicActivity extends AppCompatActivity {

    private ArrayList<Music> arrayList;
    private CustomMusicAdapter adapter;
    private ListView songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songList = (ListView) findViewById(R.id.songList);
        arrayList = new ArrayList<>();
        arrayList.add(new Music("Goodnight", "Relaxation", R.raw.goodnight));
        arrayList.add(new Music("Zen Garden", "Relaxation", R.raw.zen_garden));
        arrayList.add(new Music("Passionfruit", "Guitar loop", R.raw.passionfruit));
        arrayList.add(new Music("Redbone", "Guitar loop", R.raw.redbone));
        arrayList.add(new Music("Chill-Hop", "Instrumental", R.raw.chill_hop));
        arrayList.add(new Music("Better", "Instrumental", R.raw.better));

        adapter = new CustomMusicAdapter(this, R.layout.custom_music_item, arrayList);
        songList.setAdapter(adapter);
    }
}
