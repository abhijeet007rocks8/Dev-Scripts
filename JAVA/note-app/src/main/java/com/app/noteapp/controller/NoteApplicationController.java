package com.app.noteapp.controller;

import com.app.noteapp.database.DatabaseConnection;
import com.app.noteapp.listener.NoteEventListener;
import com.app.noteapp.model.Note;
import com.app.noteapp.view.NoteView;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

public class NoteApplicationController implements NoteEventListener {

    @FXML private VBox vBoxNoteSection;

    @FXML private Label lblNoNoteSelected;
    @FXML private TextArea txtScribble;
    private Button btnAdd;

    private ObservableList<NoteView> noteViews;
    private DatabaseConnection databaseConnection;
    private NoteView selectionNoteView;

    @FXML
    public void initialize(){
        try{
            noteViews = FXCollections.observableArrayList();
            databaseConnection = new DatabaseConnection();
            selectionNoteView = null;
            btnAdd = (Button) vBoxNoteSection.getChildren().get(0);

            noteViews.addListener((ListChangeListener<? super NoteView>) observable -> {
                if (observable.next()){
                    if (observable.wasRemoved()){
                        vBoxNoteSection.getChildren().remove(observable.getRemoved().get(0).getView());
                    }
                    if (observable.wasAdded()){
                        vBoxNoteSection.getChildren().add(0, observable.getAddedSubList().get(0).getView());
                    }
                }
            });

            databaseConnection.fetchAll().forEach(note -> {
                NoteView noteView = new NoteView(note, this);
                noteViews.add(noteView);
            });

        }catch (SQLException | ClassNotFoundException | ParseException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void onAddNoteClicked(){
        noteViews.forEach(NoteView::deselectNote);
        noteViews.forEach(NoteView::hideEditTextInput);
        Note note = new Note(null, "New Note", "What's on your mind?", new Date());
        NoteView noteView = new NoteView(note, this);
        noteViews.add(noteView);
        noteView.selectNoteView();
        noteView.showEditTextInput();
        selectionNoteView = noteView;
        enableScribbleZone();
        txtScribble.setText(note.getNoteBody());
        try {
            selectionNoteView.setNote(databaseConnection.save(note));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onDeleteAllClicked(){
        new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete all the notes? This process is irreversible.", ButtonType.YES, ButtonType.NO)
                .showAndWait()
                .ifPresent(buttonType -> {
                    if (buttonType == ButtonType.YES){
                        try {
                            databaseConnection.deleteAll();
                            noteViews.clear();
                            vBoxNoteSection.getChildren().clear();
                            vBoxNoteSection.getChildren().add(btnAdd);
                            disableScribbleZone();
                            selectionNoteView = null;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @FXML
    public void onScribbleAreaTextChanged() {
        Note oldNote = selectionNoteView.getNote();
        selectionNoteView.getNote().setNoteBody(txtScribble.getText().trim());
        try {
            databaseConnection.update(oldNote, selectionNoteView.getNote());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onNoteNameEdited(Note oldNote, Note newNote) {
        try {
            databaseConnection.update(oldNote, newNote);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDeleteNoteClicked(NoteView noteView) {
        Optional<ButtonType> b = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this note?", ButtonType.YES, ButtonType.NO).showAndWait();
        if (b.isPresent() && b.get() == ButtonType.YES){
            noteViews.remove(noteView);
            disableScribbleZone();
        }
        try {
            databaseConnection.delete(noteView.getNote().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMouseClicked(NoteView n) {
        noteViews.forEach(NoteView::deselectNote);
        noteViews.forEach(NoteView::hideEditTextInput);
        selectionNoteView = n;
        enableScribbleZone();
        txtScribble.setText(n.getNote().getNoteBody());
    }

    private void enableScribbleZone(){
        lblNoNoteSelected.setVisible(false);
        txtScribble.setVisible(true);
        txtScribble.setDisable(false);
    }

    private void disableScribbleZone(){
        lblNoNoteSelected.setVisible(true);
        txtScribble.setVisible(false);
        txtScribble.setDisable(true);
    }

}
