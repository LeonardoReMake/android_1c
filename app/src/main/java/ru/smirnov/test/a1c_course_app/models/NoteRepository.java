package ru.smirnov.test.a1c_course_app.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.smirnov.test.a1c_course_app.R;

public final class NoteRepository {

    private final static int DEFAULT_NOTE_COUNT = 10;
    private final static int[] CAT_IMAGES = {R.drawable.cat, R.drawable.cute, R.drawable.hello};

    private List<Note> notes;

    private static NoteRepository noteRepository;

    public static NoteRepository getInstance(int noteCounts) {
        if (noteRepository == null) {
            noteRepository = new NoteRepository(noteCounts);
        }

        return noteRepository;
    }

    public static NoteRepository getInstance() {
        if (noteRepository == null) {
            noteRepository = new NoteRepository(DEFAULT_NOTE_COUNT);
        }

        return noteRepository;
    }

    private NoteRepository(int noteCounts) {
        notes = new ArrayList<>();
        for (int i = 0; i < noteCounts; i++) {
            Note note = new Note(i + "", new Date(),
                    "Very intresting text about this cat!", "Длинное название " + i,
                    CAT_IMAGES[i % CAT_IMAGES.length]);

            notes.add(note);
        }
    }

    public List<Note> getNotes() {
        return notes;
    }

    public Note getNoteWithId(String id) {
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                return note;
            }
        }

        return null;
    }

}
