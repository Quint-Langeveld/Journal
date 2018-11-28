package com.example.qlangeveld.journal;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class EntryAdapter extends ResourceCursorAdapter {

    public EntryAdapter(Context context, Cursor cursor) {
        super(context, R.layout.entry_row, cursor);
    }


    @Override
    public void bindView(View convertView, Context context, Cursor cursor)  {

        ((ImageView) convertView.findViewById(R.layout.))
    }
}
