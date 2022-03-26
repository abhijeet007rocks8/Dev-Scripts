module com.app.noteapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires lombok;

    opens com.app.noteapp to javafx.fxml;
    exports com.app.noteapp;
    exports com.app.noteapp.controller;
    opens com.app.noteapp.controller;
    opens com.app.noteapp.view;
    exports com.app.noteapp.view;
    exports com.app.noteapp.model;
    opens com.app.noteapp.listener;
    exports com.app.noteapp.listener;
}