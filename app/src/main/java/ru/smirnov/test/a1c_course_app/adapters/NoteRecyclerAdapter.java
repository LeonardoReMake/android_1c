package ru.smirnov.test.a1c_course_app.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import ru.smirnov.test.a1c_course_app.R;
import ru.smirnov.test.a1c_course_app.models.Note;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.NoteViewHolder> {

    private List<Note> notes;

    private OnNoteItemClick callback;

    public interface OnNoteItemClick {
        void onNoteClick(Note note);
    }

    public NoteRecyclerAdapter(List<Note> notes, OnNoteItemClick callback) {
        this.notes = notes;
        this.callback = callback;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        return new NoteViewHolder(inflater.inflate(R.layout.note_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);

        holder.bindView(note);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        CardView noteCardView;
        ImageView noteImageView;
        TextView noteTitle;
        TextView noteDate;
        TextView noteText;

        NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            noteCardView = itemView.findViewById(R.id.note_cv);
            noteImageView = itemView.findViewById(R.id.note_img);
            noteTitle = itemView.findViewById(R.id.note_title);
            noteDate = itemView.findViewById(R.id.note_date);
            noteText = itemView.findViewById(R.id.note_text);
        }

        @SuppressLint("SimpleDateFormat")
        void bindView(final Note note) {
            noteImageView.setImageResource(note.getDrawableIdRes());
            noteTitle.setText(note.getTitle());
            noteText.setText(note.getText());
            noteDate.setText((new SimpleDateFormat("dd.MM.yyyy").format(note.getDate())));
            noteCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callback.onNoteClick(note);
                }
            });
        }
    }

}
