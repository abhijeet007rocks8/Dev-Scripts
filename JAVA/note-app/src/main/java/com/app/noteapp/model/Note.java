package com.app.noteapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    private Integer id;
    private String noteName;
    private String noteBody;
    private Date createdOn;

}
