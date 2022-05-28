import pyqrcode
import sqlite3
from PIL import Image,ImageTk
from tkinter import *



def qrcode(root,name):
    root.geometry("300x300")
    global conn, c, connect, co, join, j,addit,a

    addit = sqlite3.connect('sports.db')
    a = addit.cursor()

    join = sqlite3.connect("C:/Users/vrush/OneDrive/Desktop/Mini_Proj/grocery.db")
    j = join.cursor()

    connect = sqlite3.connect("C:/Users/vrush/OneDrive/Desktop/Mini_Proj/clothing.db")
    co = connect.cursor()

    conn = sqlite3.connect("C:/Users/vrush/OneDrive/Desktop/Mini_Proj/electronics.db")
    c = conn.cursor()
    list=[]
    global p
    if name == 'mobile':
        p = c
        c.execute('SELECT rowid, * FROM mobile')
        r = p.fetchall()
        for i in r:
            list.append("Item Name" + str(i[1]) + " " + "Quantity" + str(i[2]))
        qr = pyqrcode.create(str(list))
        qr.png('mobile.png', scale=8)
        root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/mobile.png")
        root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)

    elif name == 'Laptop':
        p = c
        c.execute('SELECT rowid, * FROM Laptop')
        r = p.fetchall()
        for i in r:
            list.append("Item Name" + str(i[1]) + " " + "Quantity" + str(i[2]))
        qr = pyqrcode.create(str(list))
        qr.png('laptop.png', scale=8)
        root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/laptop.png")
        root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)

    elif name == 'Washing_Machine':
        p = c
        c.execute('SELECT rowid, * FROM WashingMachine')
        r = p.fetchall()
        for i in r:
            list.append("Item Name" + str(i[1]) + " " + "Quantity" + str(i[2]))
        qr = pyqrcode.create(str(list))
        qr.png('washing.png', scale=8)
        root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/washing.png")
        root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)

    elif name == 'women':
        p = co
        co.execute('SELECT rowid, * FROM women')
        r = p.fetchall()
        for i in r:
            list.append("Item Name" + str(i[1]) + " " + "Quantity" + str(i[2]))
        qr = pyqrcode.create(str(list))
        qr.png('women.png', scale=8)
        root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/women.png")
        root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)

    elif name == 'men':
        p = co
        co.execute('SELECT rowid, * FROM men')
        r = p.fetchall()
        for i in r:
            list.append("Item Name" + str(i[1]) + " " + "Quantity" + str(i[2]))
        qr = pyqrcode.create(str(list))
        qr.png('men.png', scale=8)
        root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/men.png")
        root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)

    elif name == 'children':
        p = co
        co.execute('SELECT rowid, * FROM children')
        r = p.fetchall()
        for i in r:
            list.append("Item Name" + str(i[1]) + " " + "Quantity" + str(i[2]))
        qr = pyqrcode.create(str(list))
        qr.png('children.png', scale=8)
        root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/children.png")
        root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)

    elif name == 'food':
        p = j
        j.execute('SELECT rowid, * FROM food')
        r = p.fetchall()
        for i in r:
            list.append("Item Name" + str(i[1]) + " " + "Quantity" + str(i[2]))
        qr = pyqrcode.create(str(list))
        qr.png('food.png', scale=8)
        root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/food.png")
        root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)

    elif name == 'household':
        p = j
        j.execute('SELECT rowid, * FROM household')
        r = p.fetchall()
        for i in r:
            list.append("Item Name" + str(i[1]) + " " + "Quantity" + str(i[2]))
        qr = pyqrcode.create(str(list))
        qr.png('household.png', scale=8)
        root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/household.png")
        root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)

    elif name == 'cooking':
        p = j
        j.execute('SELECT rowid, * FROM cooking')
        r = p.fetchall()
        for i in r:
            list.append("Item Name" + str(i[1]) + " " + "Quantity" + str(i[2]))
        qr = pyqrcode.create(str(list))
        qr.png('cooking.png', scale=8)
        root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/cooking.png")
        root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)

    elif name == 'sportsw':
        p = a
        a.execute('SELECT rowid, * FROM wear')
        r = p.fetchall()
        for i in r:
            list.append("Item Name" + str(i[1]) + " " + "Quantity" + str(i[2]))
        qr = pyqrcode.create(str(list))
        qr.png('sportswear.png', scale=8)
        root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/sportswear.png")
        root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)

    elif name == 'gym':
        p = a
        a.execute('SELECT rowid, * FROM gym')
        r = p.fetchall()
        for i in r:
            list.append("Item Name" + str(i[1]) + " " + "Quantity" + str(i[2]))
        qr = pyqrcode.create(str(list))
        qr.png('gym.png', scale=8)
        root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/gym.png")
        root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)
    elif name == 'SportsAccessories':
        p = a
        a.execute('SELECT rowid, * FROM accessories')
        r = p.fetchall()
        for i in r:
            list.append("Item Name" + str(i[1]) + " " + "Quantity" + str(i[2]))
        qr = pyqrcode.create(str(list))
        qr.png('accossories.png', scale=8)
        root.bg = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/accossories.png")
        root.bg_image = Label(root, image=root.bg).place(x=0, y=0, relwidth=1, relheight=1)




