import sqlite3
from tkinter import *
from tkinter import messagebox
import tkinter.font as font
from PIL import ImageTk

import categoryfirstpage


def newscreen():
    new = Toplevel(root)
    categoryfirstpage.mainscreen(new)




def Submit():
    c.execute('select * from inventory  ')
    r = c.fetchall()
    count = 1
    for i in r:
        if (i[0] == e1.get() and i[1] == int(e2.get())):
            r=1
            break
        else:
            r=0

    if(r==1):
        messagebox.showerror('Register Failed','User already exists')
    else:
            c.execute('insert into inventory values(?,?)', (e1.get(), e2.get()))
            conn.commit()
def signin():
     c.execute('select * from inventory  ')
     r = c.fetchall()
     count=1
     for i in r:
        if(i[0]==e1.get() and i[1]==int(e2.get())):
           count=1
           break
        else:
            count=0

     if(count==1):
         messagebox.showinfo("showinfo", "Valid")
         newscreen()
     elif(count==0):
         messagebox.showinfo("showinfo", "InValid")


conn=sqlite3.connect("C:/Users/vrush/OneDrive/Desktop/Mini_Proj/inventroy.db")
c=conn.cursor()
root=Tk()
root.geometry("400x400")
root.title("Login Screen")
root.iconbitmap('C:/Users/vrush/OneDrive/Desktop/Mini_Proj/loginicon.ico')
root.bg=ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/beige.webp")
root.bg_image=Label(root, image=root.bg).place(x=0,y=0,relwidth=1,relheight=1)
Name=Label(root,text="Username",font='Calibri',bg='#25172d',fg='white')
Name.place(x=15,y=30,width=120,height=40)
Password=Label(root,text="Password",font='Calibri',bg='#25172d',fg='white')
Password.place(x=15,y=100,width=120,height=40)
myFont = font.Font(family='Calibri',size=15)
Button1=Button(root,text="Register",command=Submit,font=myFont,bg='#25172d',fg='white',border=2)
Button1.place(x=135,y=270,width=100,height=40)
Button2=Button(root,text="Quit",font=myFont,bg='#25172d',fg='white',border='2',command=root.destroy)
Button2.place(x=135,y=320,width=100,height=40,)
Button3=Button(root,text="Log in",font=myFont,bg='#25172d',fg='white',border='2',command=signin)
Button3.place(x=135,y=200,width=100,height=40)

e1=Entry(root)
e1.place(x=200,y=40,width=140,height=30)

e2=Entry(root,show='*')
e2.place(x=200,y=105,width=140,height=30)

root.mainloop()