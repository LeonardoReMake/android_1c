package ru.smirnov.test.a1c_course_app.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ru.smirnov.test.a1c_course_app.R;
import ru.smirnov.test.a1c_course_app.models.Note;
import ru.smirnov.test.a1c_course_app.models.NoteRepository;

public class NoteDetailActivity extends AppCompatActivity {

    private TextView noteText;
    private ImageView noteImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        noteText = findViewById(R.id.note_text_dtl);
        noteImageView = findViewById(R.id.note_img_dtl);

        Note currentNote = null;
        if (getIntent().getExtras() != null) {
            String noteId = getIntent().getExtras().getString(MainActivity.NOTE_ID_EXTRAS, null);
            if (noteId != null) {
                currentNote = NoteRepository.getInstance().getNoteWithId(noteId);
            }
        }

        bindNoteView(currentNote);
    }

    private void bindNoteView(Note currentNote) {
        if (currentNote == null) {
            noteText.setText("");
        } else {
            setTitle(currentNote.getTitle());
            noteText.setText(currentNote.getText());
            noteImageView.setImageResource(currentNote.getDrawableIdRes());
        }
    }
}
