package com.example.qlangeveld.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input2);

    }

    public void onSubmitCLicked(View view) {
//        vul een object met alle info van de pagina en stop het in de insert!!!!!!!
        TextView title = findViewById(R.id.titles);
        String Title = title.getText().toString();

        TextView story = findViewById(R.id.story);
        String Story = story.getText().toString();

        ImageView happy = findViewById(R.id.checkHappy);
        ImageView sad = findViewById(R.id.checkSad);
        ImageView neutral = findViewById(R.id.checkNeutral);

        String mood;

        if (happy.getVisibility() == View.VISIBLE) {
            mood = "happy";
        } else if (sad.getVisibility() == View.VISIBLE) {
            mood = "sad";
        } else if (neutral.getVisibility() == View.VISIBLE) {
            mood = "neutral";
        } else {
            mood = "neutral";
        }

        JournalEntry journalEntry = new JournalEntry(Title, Story, mood);
        journalEntry.setMood(mood);
        EntryDatabase.getInstance(getApplicationContext()).insert(journalEntry);

        finish();
    }

    public void onSmileyClicked(View view) {
        ImageView checkHappy = findViewById(R.id.checkHappy);
        ImageView checkSad = findViewById(R.id.checkSad);
        ImageView checkNeutral = findViewById(R.id.checkNeutral);

        switch (view.getId()) {
            case R.id.smileyNeutral: {
                checkNeutral.setVisibility(View.VISIBLE);
                checkHappy.setVisibility(View.INVISIBLE);
                checkSad.setVisibility(View.INVISIBLE);
                break;
            }

            case R.id.smileyHappy: {
                checkHappy.setVisibility(View.VISIBLE);
                checkNeutral.setVisibility(View.INVISIBLE);
                checkSad.setVisibility(View.INVISIBLE);
                break;
            }

            case R.id.smileySad: {
                checkSad.setVisibility(View.VISIBLE);
                checkHappy.setVisibility(View.INVISIBLE);
                checkNeutral.setVisibility(View.INVISIBLE);
                break;
            }
        }
    }
}
