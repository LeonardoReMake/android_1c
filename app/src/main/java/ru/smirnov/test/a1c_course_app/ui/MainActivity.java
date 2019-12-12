package ru.smirnov.test.a1c_course_app.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.smirnov.test.a1c_course_app.R;
import ru.smirnov.test.a1c_course_app.adapters.NoteRecyclerAdapter;
import ru.smirnov.test.a1c_course_app.models.Note;
import ru.smirnov.test.a1c_course_app.models.NoteRepository;

public class MainActivity extends AppCompatActivity implements NoteRecyclerAdapter.OnNoteItemClick {

    final static String NOTE_ID_EXTRAS = "node_id_extras";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NoteRepository noteRepository = NoteRepository.getInstance(10);

        RecyclerView notesRv = findViewById(R.id.notes_rv);
        notesRv.setLayoutManager(new LinearLayoutManager(this));
        NoteRecyclerAdapter noteRecyclerAdapter = new NoteRecyclerAdapter(noteRepository.getNotes(), this);
        notesRv.setAdapter(noteRecyclerAdapter);
    }

    @Override
    public void onNoteClick(Note note) {
        Intent intent = new Intent(this, NoteDetailActivity.class);
        intent.putExtra(NOTE_ID_EXTRAS, note.getId());
        startActivity(intent);
    }
}
