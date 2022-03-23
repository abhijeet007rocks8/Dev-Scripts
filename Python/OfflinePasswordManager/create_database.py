## File to handle different funtions and operations related to accessing  the data in database table as well as to initialise the databases

import sqlite3
from tkinter import messagebox
import pyperclip as pc
import pandas as pd
import os
import tkinter as tk
from tkinter import messagebox

def initialise():                                                                        # initially creates the db file
    con = sqlite3.connect('./database_folder/password.db')
    c = con.cursor()
    c.execute("""CREATE TABLE IF NOT EXISTS Userinfo (                                                               
                Title text,
                Account text,
                Username text,
                Pass text,
                Website text
    )
    """)
    con.commit()
    con.close()

def createbackup():                                                                         ## function to create a database backup
    try:
        con = sqlite3.connect('./database_folder/password.db')
        bcon = sqlite3.connect('./database_folder/passwordbackup.db')
        with bcon:
            con.backup(bcon,pages = 0)
    except sqlite3.Error as error:
        print("error occured while backing up")
    finally:
        if bcon:
            bcon.close()
            con.close()



def insertdb(title="",account="",username="",passwd="",website =""):                                                   # function to insert information into the databse 
     con = sqlite3.connect('./database_folder/password.db')
     c = con.cursor()
     c.execute("INSERT INTO Userinfo (Title,Account,Username,Pass,Website) VALUES (?, ?, ?, ? ,?)",(title,account,username,passwd,website))
     con.commit()
     con.close()


def fetchpasswordonclick(value):                                                            # function to fetch a password in the databse with the help of the title
        con = sqlite3.connect('./database_folder/password.db')
        c = con.cursor()
        d = c.execute("SELECT *  FROM Userinfo")
        for i in d:
            if i[0] == value:
                v = i[3]
                return v
                
        con.close()


def expdbtocsv():                                                                                ## function to convert db to csv file
    try:
        file = './database_folder/password.db'
        con = sqlite3.connect(file)
        c=con.cursor()
        query = "SELECT * FROM Userinfo"
        data = pd.read_sql(query,con)
        data.to_csv('export.csv')
        con.close()
    except Exception:
        messagebox.showerror("Database Error","No database found")
        

def getmasterpasswd():    
    try:                                                                      ## funtion to access the login credentials like registered main and master password                                      # function to get the master password from teh table in the database
        con = sqlite3.connect('./database_folder/password.db')
        c=con.cursor()
        d = c.execute("SELECT * FROM logincred")
        return d
    except Exception as e:
        messagebox.showerror("Error", "Databse not found")
        return None
 

def deletedb():                                                                                                    ## function to delete database
    val = messagebox.askyesno("DANGER","This action is ireversible are you sure you want to continue?? 💀💀💀")
    if val:
        try:
            path = './database_folder'
            for root,dirs ,files in os.walk(path,topdown=False):
                for name in files:
                    os.remove(os.path.join(root,name))
            os.rmdir('database_folder')
        except Exception:
            messagebox.showerror("Database Error","No database found")

