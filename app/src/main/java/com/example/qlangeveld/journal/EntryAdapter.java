package com.example.qlangeveld.journal;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.ResourceCursorAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {

    public EntryAdapter(Context context, Cursor cursor) {
        super(context, R.layout.entry_row, cursor);
    }


    @Override
    public void bindView(View convertView, Context context, Cursor cursor)  {
//
//        if (convertView == null) {
//            convertView = LayoutInflater ???
//        }

        int _Id = cursor.getInt(cursor.getColumnIndex("_id"));
        String textTitle = cursor.getString(cursor.getColumnIndex("title"));
        String textContext = cursor.getString(cursor.getColumnIndex("content"));
        String moodString =  cursor.getString(cursor.getColumnIndex("mood"));
        String intDate = cursor.getString(cursor.getColumnIndex("Timestamp"));

        ImageView Plaatje = convertView.findViewById(R.id.imageView);
        if (moodString == "Happy") {
            Plaatje.setImageResource(R.drawable.happy);
        } else if (moodString == "Sad"){
            Plaatje.setImageResource((R.drawable.sad));
        } else if (moodString == "Neutral") {
            Plaatje.setImageResource(R.drawable.surprised);
        }

        TextView Title = convertView.findViewById(R.id.Title);
        Title.setText(textTitle);

        TextView Context = convertView.findViewById(R.id.context);
        Context.setText(textContext);

        TextView Date = convertView.findViewById(R.id.daate);
        Date.setText(intDate);
    }
}
