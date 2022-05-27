from tkinter import *
import sqlite3
from PIL import ImageTk
from tkinter import messagebox

#group is electronics
#title headphones
import additemmens
import qrcode
import table

c=0
i = 20
j = 75
k = 85
l = 77
def update(root,group,title):
    def realadding(root,group,title):
        global c,i,j,k,l
        if group=='electronics':
            if c==1:
                i = 20
                j = 75
                k = 85
                l = 77
                logic()
            else:
                logic()
        if group=='clothing':
            if c==1:
                i = 20
                j = 75
                k = 85
                l = 77
                logic()
            else:
                logic()

        if group=='grocery':
            if c==1:
                i = 20
                j = 75
                k = 85
                l = 77
                logic()
            else:
                logic()

        if group=='sports':
            if c==1:
                i = 20
                j = 75
                k = 85
                l = 77
                logic()
            else:
                logic()


    def viewdetails(group,title):
        view = Toplevel(root)
        table.selectgrp(group, title)
        table.viewdetail(view, title)


    def adddetails(group,title):
        add = Toplevel(root)
        additemmens.selectgrp(group, title)
        additemmens.addcategories(add, title)


    def qr(group,title):
        q = Toplevel(root)
        qrcode.selectgrp(title)
        qrcode.qrcode(q, group)

    def logic():
        path="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/"+group+".db"

        conn = sqlite3.connect(path)
        cs = conn.cursor()
        sqls="CREATE TABLE"+" "+title+"( ItemName TEXT PRIMARY KEY,Quantity INTEGER)"
        cs.execute(sqls)
        conn.commit()


        global c,i,j,k,l
        if c<4:
            c+=1


            if(c==1):
                inc=0
            else:
                inc=330

            i=i+inc
            j=j+inc
            k=k+inc
            l=l+inc


            Frameelectronic = LabelFrame(root, text=title, bd=12, relief=RIDGE, padx=20, bg="#EEE1C6",
                                         font=("times new roman", 12, "bold"))
            Frameelectronic.place(x=i, y=500, width=240, height=240)
            buttonviewdetail = Button(root, text="View Details", padx=2, pady=2, bd=10,  bg='white',fg='black',
                                      font=("times new roman", 12, "bold"), command=lambda: viewdetails(group,title) )
            buttonviewdetail.place(x=j, y=550)
            buttonadd = Button(root, text="QR Code", padx=2, pady=2, bd=10, bg='white',fg='black',
                               font=("times new roman", 12, "bold"), command=lambda: qr(group,title))
            buttonadd.place(x=k, y=665)
            buttonadddetail = Button(root, text="Add Details", padx=2, pady=2, bd=10, bg='white',fg='black',
                                     font=("times new roman", 12, "bold"), command=lambda: adddetails(group,title))
            buttonadddetail.place(x=l, y=610)
    realadding(root,group,title)


