import sqlite3
import tkinter
from tkinter import *
from tkinter import ttk

from PIL import ImageTk
def selectgrp(group,title):
    global namezz, category
    namezz=title
    category=group





def tabular(root,name):
        global p,namezz,query
        query = "SELECT rowid, * FROM" + " " + namezz
        if category=='electronics':
            p=c
            c.execute(query)
        elif category=='clothing':
            p=co
            co.execute(query)
        elif category=='grocery':
            p=j
            j.execute(query)
        elif category=='sports':
            p=a
            a.execute(query)

        elif category=='null' and namezz=='null':
            if name == 'mobile':
                p=c
                c.execute('SELECT rowid, * FROM mobile')
            elif name == 'Laptop':
                p=c
                c.execute('SELECT rowid, * FROM Laptop')
            elif name == 'Washing_Machine':
                p=c
                c.execute('SELECT rowid, * FROM WashingMachine')
            elif name == 'women':
                p=co
                co.execute('SELECT rowid, * FROM women')
            elif name == 'men':
                p=co
                co.execute('SELECT rowid, * FROM men')
            elif name == 'children':
                p=co
                co.execute('SELECT rowid, * FROM children')
            elif name == 'food':
                p = j
                j.execute('SELECT rowid, * FROM food')
            elif name == 'household':
                p = j
                j.execute('SELECT rowid, * FROM household')
            elif name == 'cooking':
                p = j
                j.execute('SELECT rowid, * FROM cooking')
            elif name == 'sportsw':
                p = a
                a.execute('SELECT rowid, * FROM wear')
            elif name == 'gym':
                p = a
                a.execute('SELECT rowid, * FROM gym')
            elif name == 'SportsAccessories':
                p = a
                a.execute('SELECT rowid, * FROM accessories')



        global tree
        tree = ttk.Treeview(root)
        tree['show'] = 'headings'
        tree["columns"] = ("Id_no", "ItemName", "quantity")
        tree.column("Id_no", width=50, minwidth=50, anchor=tkinter.CENTER)
        tree.column("ItemName", width=100, minwidth=100, anchor=tkinter.CENTER)
        tree.column("quantity", width=100, minwidth=100, anchor=tkinter.CENTER)
        tree.heading("Id_no", text="Product Id No.", anchor=tkinter.CENTER)
        tree.heading("ItemName", text="Item Name", anchor=tkinter.CENTER)
        tree.heading("quantity", text="Quantity", anchor=tkinter.CENTER)
        i = 0

        for r in p:
            tree.insert('', i, text="", values=(r[0], r[1], r[2]))
            i += 1
        tree.place(x=100,y=100)


def viewdetail(root,name):
    def delete():
        global category,query
        query = "DELETE from" + " " + namezz + " " + "WHERE rowid = (?)"
        if category=='electronics':
            c.execute(query,e1.get())
            conn.commit()
        elif category=='clothing':
            co.execute(query,e1.get())
            connect.commit()
        elif category=='grocery':
            j.execute(query,e1.get())
            join.commit()
        elif category=='sports':
            a.execute(query,e1.get())
            addit.commit()


        elif category == 'null' and namezz == 'null':
            if name=='mobile':
                c.execute("DELETE from mobile WHERE rowid = (?)", e1.get())
                conn.commit()
            elif name=='Laptop':
                c.execute("DELETE from Laptop WHERE rowid = (?)", e1.get())
                conn.commit()
            elif name=='Washing_Machine':
                c.execute("DELETE from WashingMachine WHERE rowid =(?)",e1.get())
                conn.commit()

            elif name=='women':
                co.execute("DELETE from women WHERE rowid = (?)", e1.get())
                connect.commit()
            elif name=='men':
                co.execute("DELETE from men WHERE rowid = (?)", e1.get())
                connect.commit()
            elif name=='children':
                co.execute("DELETE from children WHERE rowid = (?)", e1.get())
                connect.commit()

            elif name=='food':
                j.execute("DELETE from food WHERE rowid = (?)", e1.get())
                join.commit()
            elif name=='household':
                j.execute("DELETE from household WHERE rowid = (?)", e1.get())
                join.commit()
            elif name=='cooking':
                j.execute("DELETE from cooking WHERE rowid = (?)", e1.get())
                join.commit()

            elif name == 'sportsw':
                a.execute("DELETE from wear WHERE rowid = (?)", e1.get())
                addit.commit()
            elif name == 'gym':
                a.execute("DELETE from gym WHERE rowid = (?)", e1.get())
                addit.commit()
            elif name == 'SportsAccessories':
                a.execute("DELETE from accessories WHERE rowid = (?)", e1.get())
                addit.commit()
        for t in tree.get_children():
            tree.delete(t)
        tabular(root,name)


    global j,co,c,a

    addit=sqlite3.connect('sports.db')
    a=addit.cursor()

    join = sqlite3.connect("C:/Users/vrush/OneDrive/Desktop/Mini_Proj/grocery.db")
    j = join.cursor()

    connect = sqlite3.connect("C:/Users/vrush/OneDrive/Desktop/Mini_Proj/clothing.db")
    co = connect.cursor()

    conn = sqlite3.connect("C:/Users/vrush/OneDrive/Desktop/Mini_Proj/electronics.db")
    c = conn.cursor()
    root.geometry("450x400")
    root.title("Add Item")
    root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/beige.webp")
    root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)
    root.iconbitmap('C:/Users/vrush/OneDrive/Desktop/Mini_Proj/loginicon.ico')

    b2=Button(root,text='Delete',command=delete, borderwidth=3, relief="solid", bg='#25172d',fg='white',font=("times new roman",12,"bold")).place(x=194,y=50)
    L2=Label(root,text="  Enter id number  ", borderwidth=3, relief="solid", bg='#25172d',fg='white',font=("times new roman",12,"bold")).place(x=100,y=15)
    global e1
    e1 = Entry(root)
    e1.place(x=250,y=20)
    tabular(root,name)
    root.mainloop()
