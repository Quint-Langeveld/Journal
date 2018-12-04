package com.example.qlangeveld.journal;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        Intent intent = getIntent();
        JournalEntry currentDay = (JournalEntry) intent.getSerializableExtra("clicked_day");

        TextView title = findViewById(R.id.titol);
        title.setText(currentDay.getTitle());

        TextView date = findViewById(R.id.daate);
        date.setText(currentDay.getTimeStamp());

        TextView stroy = findViewById(R.id.story);
        stroy.setText(currentDay.getContent());

        ImageView smiley = findViewById(R.id.smiley);
        String moodString = currentDay.getMood();
        if (moodString == "Happy") {
            smiley.setImageResource(R.drawable.happy);
        } else if (moodString == "Sad"){
            smiley.setImageResource((R.drawable.sad));
        } else if (moodString == "Neutral") {
            smiley.setImageResource(R.drawable.surprised);
        }
    }
}
