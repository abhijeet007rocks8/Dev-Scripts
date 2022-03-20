package com.app.noteapp.view;

import com.app.noteapp.listener.NoteEventListener;
import com.app.noteapp.model.Note;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class NoteView{

    private Note note;
    private final NoteEventListener noteEventListener;
    private boolean isSelected;

    @FXML private Label lblNoteName;
    @FXML private Label lblCreatedOn;
    @FXML private Button btnEditNoteName;
    @FXML private Button btnDeleteNote;
    @FXML private TextField txtEditNoteName;

    private AnchorPane anchorPane;

    public NoteView(Note note, NoteEventListener noteEventListener){
        this.note = note;
        this.noteEventListener = noteEventListener;
        initializeView();
    }

    private void initializeView(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/layout/note-view.fxml")));
            fxmlLoader.setController(this);
            Parent parent = fxmlLoader.load();
            isSelected = false;

            anchorPane = new AnchorPane(parent);
            anchorPane.setOnMouseClicked(mouseEvent -> {
                selectNoteView();
            });

            anchorPane.setOnMouseEntered(mouseEvent -> {
                showEditAndDeleteButtons();
                onNoteMouseEntered();
            });

            anchorPane.setOnMouseExited(mouseEvent -> {
                hideEditAndDeleteButtons();
                onNoteMouseExited();
            });

            btnEditNoteName.setOnAction(actionEvent -> {onEditNoteNameClicked();});
            btnDeleteNote.setOnAction(actionEvent -> {onDeleteNoteClicked();});
            txtEditNoteName.setOnKeyPressed(this::onKeyPressed);

            lblNoteName.setText(note.getNoteName());
            lblCreatedOn.setText(new SimpleDateFormat("E, dd MMMM yyyy hh:mm:ss").format(note.getCreatedOn()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void selectNoteView() {
        noteEventListener.onMouseClicked(this);
        isSelected = true;
        setNoteSelectedStyle();
    }

    public void deselectNote(){
        isSelected = false;
        setNoteDeselectedStyle();
    }

    public void onNoteMouseEntered() {
        if (!isSelected)
            setNoteMouseEnteredStyle();
    }

    public void onNoteMouseExited() {
        if (!isSelected)
            setNoteMouseExitedStyle();
    }

    private void setNoteMouseEnteredStyle() {
        anchorPane.setStyle("-fx-background-color: #d9d9d9");
    }

    private void setNoteMouseExitedStyle() {
        anchorPane.setStyle("-fx-background-color: #ffffff");
    }

    private void setNoteSelectedStyle(){
        anchorPane.setStyle("-fx-background-color: #219ced;");
        lblCreatedOn.setStyle("-fx-text-fill: #ffffff;");
        lblNoteName.setStyle("-fx-text-fill: #ffffff;");
    }

    private void setNoteDeselectedStyle(){
        anchorPane.setStyle("-fx-background-color: #ffffff;");
        lblCreatedOn.setStyle("-fx-text-fill: #000000;");
        lblNoteName.setStyle("-fx-text-fill: #000000;");
    }

    public AnchorPane getView() {
        return anchorPane;
    }

    public Note getNote(){
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void showEditTextInput() {
        lblNoteName.setVisible(false);
        lblNoteName.setDisable(true);
        txtEditNoteName.setVisible(true);
        txtEditNoteName.setDisable(false);
        txtEditNoteName.setText(note.getNoteName());
        txtEditNoteName.requestFocus();
    }

    public void hideEditTextInput() {
        lblNoteName.setVisible(true);
        lblNoteName.setDisable(false);
        txtEditNoteName.setVisible(false);
        txtEditNoteName.setDisable(true);
        lblNoteName.setText(note.getNoteName());
    }

    private void showEditAndDeleteButtons(){
        btnEditNoteName.setVisible(true);
        btnDeleteNote.setVisible(true);
    }

    private void hideEditAndDeleteButtons(){
        btnEditNoteName.setVisible(false);
        btnDeleteNote.setVisible(false);
    }

    public void onKeyPressed(KeyEvent keyEvent){
        if (keyEvent.getCode() == KeyCode.ENTER){
            Note oldNote = note;
            note.setNoteName(txtEditNoteName.getText().trim());
            noteEventListener.onNoteNameEdited(oldNote, note);
            hideEditTextInput();
        }
    }

    public void onEditNoteNameClicked() {
        showEditTextInput();
    }

    public void onDeleteNoteClicked() {
        noteEventListener.onDeleteNoteClicked(this);
    }

}
