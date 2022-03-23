package com.app.noteapp.database;

import com.app.noteapp.misc.Logger;
import com.app.noteapp.model.Note;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseConnection {

    private final Connection connection;

    public DatabaseConnection() throws SQLException, ClassNotFoundException {
        Logger.info("Trying to connect to the database");
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:notes.db");
        try{
            createTable();
        }catch (SQLException ignored){}
        Logger.success("Connection successfully made to database");
    }

    public void createTable() throws SQLException {
        Logger.info("Creating table 'note'");
        String sql = "CREATE TABLE note (" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "note_name VARCHAR(100) NOT NULL," +
                    "note_body VARCHAR(500) NOT NULL," +
                    "created_on DATE NOT NULL)";
        connection.createStatement().executeUpdate(sql);
        Logger.success("Successfully created table 'note'");
    }

    public Note save(Note note) throws SQLException {
        Logger.info(String.format("Attempting to save %s", note.toString()));
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO note (note_name, note_body, created_on) VALUES(?, ?, ?)");
        preparedStatement.setString(1, note.getNoteName());
        preparedStatement.setString(2, note.getNoteBody());
        preparedStatement.setString(3, new SimpleDateFormat("E, MMM dd yyyy hh:mm:ss").format(note.getCreatedOn()));
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        Logger.success("Successfully saved data");
        if (resultSet.next()){
            int id = resultSet.getInt(1);
            note.setId(id);
            return note;
        }
        return null;
    }

    public List<Note> fetchAll() throws SQLException, ParseException {
        Logger.info("Fetching all data from database");
        String sql = "SELECT * FROM note";
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        ArrayList<Note> data = new ArrayList<>();
        while (resultSet.next()){
            Integer id = resultSet.getInt(1);
            String noteName = resultSet.getString(2);
            String noteBody = resultSet.getString(3);
            Date createdOn = new SimpleDateFormat("E, MMM dd yyyy hh:mm:ss").parse(resultSet.getString(4));
            Note note = new Note(id, noteName, noteBody, createdOn);
            data.add(note);
        }
        Logger.success("Fetching successful");
        return data;
    }

    public void delete (Integer id) throws SQLException {
        Logger.info("Attempting to delete note with id: "+id);
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM note WHERE note.id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        Logger.success("Successfully deleted note");
    }

    public void deleteAll() throws SQLException {
        Logger.info("Attempting to delete all notes");
        connection.createStatement().executeUpdate("DELETE FROM note");
        Logger.success("Successfully deleted all notes");
    }

    public void update (Note oldNote, Note newNote) throws SQLException {
        Logger.info(String.format("Attempting to update %s with %s", oldNote.toString(), newNote.toString()));
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE note SET note_name=?, note_body=? where id=?");
        preparedStatement.setString(1, newNote.getNoteName());
        preparedStatement.setString(2, newNote.getNoteBody());
        preparedStatement.setInt(3, oldNote.getId());
        preparedStatement.executeUpdate();
        Logger.success("Successfully updated note");
    }

}
