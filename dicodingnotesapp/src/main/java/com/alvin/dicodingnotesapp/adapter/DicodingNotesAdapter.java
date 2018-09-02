package com.alvin.dicodingnotesapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.alvin.dicodingnotesapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.alvin.dicodingnotesapp.db.DatabaseContract.NoteColumns.DATE;
import static com.alvin.dicodingnotesapp.db.DatabaseContract.NoteColumns.DESCRIPTION;
import static com.alvin.dicodingnotesapp.db.DatabaseContract.NoteColumns.TITLE;
import static com.alvin.dicodingnotesapp.db.DatabaseContract.getColumnString;

/**
 * Created by Alvin Tandiardi on 02/09/2018.
 */

public class DicodingNotesAdapter extends CursorAdapter {

    @BindView(R.id.tv_item_date)
    TextView tvDate;

    @BindView(R.id.tv_item_title)
    TextView tvTitle;

    @BindView(R.id.tv_item_description)
    TextView tvDescription;

    public DicodingNotesAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dicoding_note, parent, false);
        return view;
    }

    @Override
    public Cursor getCursor() {
        return super.getCursor();
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        if (cursor!= null) {
            ButterKnife.bind(this, view);

            tvTitle.setText(getColumnString(cursor, TITLE));
            tvDescription.setText(getColumnString(cursor, DESCRIPTION));
            tvDate.setText(getColumnString(cursor, DATE));
        }
    }
}
