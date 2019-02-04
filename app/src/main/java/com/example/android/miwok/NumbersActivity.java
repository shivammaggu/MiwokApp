/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        final ArrayList<Word> num = new ArrayList<Word>();

        num.add(new Word("One", "lutti", R.drawable.number_one, R.raw.number_one));
        num.add(new Word("Two", "otiiko", R.drawable.number_two, R.raw.number_two));
        num.add(new Word("Three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        num.add(new Word("Four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        num.add(new Word("Five", "massokka", R.drawable.number_five, R.raw.number_five));
        num.add(new Word("Six", "temmokka", R.drawable.number_six, R.raw.number_six));
        num.add(new Word("Seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        num.add(new Word("Eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        num.add(new Word("Nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        num.add(new Word("Ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter WordView = new WordAdapter(this, num, R.color.category_numbers);
        ListView viewList = (ListView) findViewById(R.id.list);
        viewList.setAdapter(WordView);

        viewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();
                Word words = num.get(i);
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, words.getmMusicResID());
                mediaPlayer.start();
                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}