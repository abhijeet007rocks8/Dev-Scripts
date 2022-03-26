package com.app.noteapp.listener;

import com.app.noteapp.model.Note;
import com.app.noteapp.view.NoteView;

public interface NoteEventListener {

    void onNoteNameEdited(Note oldNote,Note newNote);
    void onDeleteNoteClicked(NoteView noteView);
    void onMouseClicked(NoteView noteView);

}
