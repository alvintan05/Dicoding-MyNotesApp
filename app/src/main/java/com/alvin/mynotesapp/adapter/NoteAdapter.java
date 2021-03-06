package com.alvin.mynotesapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alvin.mynotesapp.CustomOnItemClickListener;
import com.alvin.mynotesapp.FormAddUpdateActivity;
import com.alvin.mynotesapp.R;
import com.alvin.mynotesapp.entity.Note;

import java.util.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.alvin.mynotesapp.db.DatabaseContract.CONTENT_URI;

/**
 * Created by Alvin Tandiardi on 23/08/2018.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private Cursor listNotes;
    private Activity activity;

    public NoteAdapter(Activity activity) {
        this.activity = activity;
    }

    public void setListNotes(Cursor listNotes) {
        this.listNotes = listNotes;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        final Note note = getItem(position);
        holder.tvTitle.setText(note.getTitle());
        holder.tvDescription.setText(note.getDescription());
        holder.tvDate.setText(note.getDate());
        holder.cvNote.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(activity, FormAddUpdateActivity.class);

                Uri uri = Uri.parse(CONTENT_URI+"/"+note.getId());
                intent.setData(uri);
                activity.startActivityForResult(intent, FormAddUpdateActivity.REQUEST_UPDATE);
            }
        }));
    }

    @Override
    public int getItemCount() {
        if (listNotes == null) return 0;
        return listNotes.getCount();
    }

    private Note getItem(int position) {
        if (!listNotes.moveToPosition(position)){
            throw new IllegalStateException("Position invalid");
        }

        return new Note(listNotes);
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_title)
        TextView tvTitle;

        @BindView(R.id.tv_item_description)
        TextView tvDescription;

        @BindView(R.id.tv_item_date)
        TextView tvDate;

        @BindView(R.id.cv_item_note)
        CardView cvNote;

        public NoteViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }

}
