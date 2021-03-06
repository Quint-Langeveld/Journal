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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = EntryDatabase.getInstance(this);
        Cursor curs = db.selectAll();
        entryAdapter = new EntryAdapter(this, curs);

        ListView listView = findViewById(R.id.ListView);
        listView.setAdapter(entryAdapter);

        listView.setOnItemClickListener(new ListItemClickListener());
        listView.setOnItemLongClickListener( new OnItemLongClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Cursor cursor = (Cursor) parent.getItemAtPosition(position);

            String titel = cursor.getString(cursor.getColumnIndex("title"));
            String context = cursor.getString(cursor.getColumnIndex("content"));
            String mood =  cursor.getString(cursor.getColumnIndex("mood"));
            String date = cursor.getString(cursor.getColumnIndex("Timestamp"));

            JournalEntry clickedDay = new JournalEntry(titel, context, mood);
            clickedDay.setTimeStamp(date);

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("clicked_day", clickedDay);
            startActivity(intent);
        }
    }

    private class OnItemLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = (Cursor) parent.getItemAtPosition(position);
            long _id = cursor.getInt(cursor.getColumnIndex("_id"));

            db.removeID(_id);
            upDateData();

            return true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        upDateData();
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


