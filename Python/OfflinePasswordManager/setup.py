## Will set up the offline password manager with a registered emial and a master password to login into

import tkinter as tk
import tkinter.font
from tkinter import messagebox
import sqlite3
import create_database
import os

def enterdb():                                                                       ### creates a db file and stores the master password and the registered email, db file is stored
    os.mkdir('database_folder')                                                      ###  in the same directory within the database_folder
    eml=emailentr.get()
    passwd = cpasswdentr.get()
    con = sqlite3.connect('./database_folder/password.db')
    c = con.cursor()
    c.execute("""CREATE TABLE IF NOT EXISTS logincred(
               email text,
               password text
               )
    """)
    c.execute("INSERT INTO logincred (email,password) VALUES(?,?)",(eml,passwd))
    con.commit()
    con.close()
    setup.quit()
    create_database.initialise()
     
def notmatching():                                                                        # willl check if the password and the confirm password are same or not
    if (passwdentr.get() != cpasswdentr.get()):
        messagebox.showerror("Password","Password not matching retry!!")
    elif len(passwdentr.get())==0 or len(emailentr.get()) == 0:
        messagebox.showwarning("Empty","Fields cannot be left empty..")
    else:
        enterdb()

setup = tk.Tk()                                                                           # Gui to take the inputs for setting up the password app
setup.geometry('600x200')
setup.resizable(width=False,height=False)
setup.title("Setup")
f1 = tkinter.font.Font(family='Comic Sans Ms', size = 12,weight = "bold")


frame1 = tk.Frame(setup)
frame1.pack(fill=tk.BOTH,expand=1)

emaillbl = tk.Label(frame1,text="EMAIL:",fg = '#000000',font=f1)
emaillbl.grid(row=1,column=0,padx=20,pady=10)
emailentr = tk.Entry(frame1,width=40, border=2)
emailentr.grid(row=1,column=1)
emailentr.focus_set()
passwdlbl = tk.Label(frame1,text="PASSWORD:",font=f1,fg='#000000')
passwdlbl.grid(row=2,column=0,padx=20)
passwdentr = tk.Entry(frame1,width=40, border = 2)
passwdentr.grid(row=2,column=1)
cpasswdlbl = tk.Label(frame1,text="CONFIRM PASSWORD:",font=f1,fg='#000000')
cpasswdlbl.grid(row=3,column=0,padx=20,pady=10)
cpasswdentr = tk.Entry(frame1,width=40, border=2)
cpasswdentr.grid(row=3,column=1)
submitbtn  = tk.Button(frame1,text  = "SUBMIT",fg = '#000000',font=f1, activebackground="green", bd=2, command=notmatching, border=3, bg= '#FF8C00')
submitbtn.place(x=250,y=155)


setup.mainloop()