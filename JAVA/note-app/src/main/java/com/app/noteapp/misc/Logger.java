package com.app.noteapp.misc;

import java.util.Date;

public class Logger {

    public static void info(String message){
        System.out.printf("[INFO] %s %s\n", new Date().toString(), message);
    }

    public static void error(String message){
        System.out.printf("[ERROR] %s %s\n", new Date().toString(), message);
    }

    public static void success(String message){
        System.out.printf("[SUCCESS] %s %s\n", new Date().toString(), message);
    }

}
