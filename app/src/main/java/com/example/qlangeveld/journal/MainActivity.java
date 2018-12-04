package com.example.qlangeveld.journal;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EntryDatabase db;
    private EntryAdapter entryAdapter;
    private ImageView happy;
    private ImageView sad;
    private ImageView neutral;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upDateData();

        ListView listView = findViewById(R.id.ListView);
        listView.setAdapter(entryAdapter);

        listView.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            TextView Titel = view.findViewById(R.id.Title);
            String titel = Titel.getText().toString();


            TextView Context = view.findViewById(R.id.context);
            String context = Context.getText().toString();

            ImageView smiley = view.findViewById(R.id.imageView);

            Drawable Happy = getDrawable(R.drawable.happy);
            happy.setImageDrawable(Happy);

            Drawable Sad = getDrawable(R.drawable.sad);
            sad.setImageDrawable(Sad);

            Drawable Neutral = getDrawable(R.drawable.surprised);
            neutral.setImageDrawable(Neutral);

            String mood;
            if (smiley.getResources() == happy.getResources()) {
                mood = "happy";
            } else if (smiley.getResources() == sad.getResources()) {
                mood = "sad";
            } else if (smiley.getResources() == neutral.getResources()) {
                mood = "neutral";
            } else {
                mood = "mood";
            }

            JournalEntry clickedDay = new JournalEntry(titel, context, mood);

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("clicked_day", clickedDay);
            startActivity(intent);
        }
    }

    public void onFloatingButtonClicked(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }

    private void upDateData() {
        db = EntryDatabase.getInstance(this);
        Cursor curs = db.selectAll();
        entryAdapter.swapCursor(curs);
    }
}


