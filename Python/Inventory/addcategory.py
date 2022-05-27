from tkinter import *
from PIL import ImageTk
from tkinter import messagebox

import addnewitem


def addc(root,group,proot): #group is electronic
    def addnewcat(g,title):
        addnewitem.update(proot,g,title)


    root.geometry("400x200")
    root.title("Add Category")
    root.bg=ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/beige.webp")
    root.bg_image=Label(root, image=root.bg).place(x=0,y=0,relwidth=1,relheight=1)
    root.iconbitmap('C:/Users/vrush/OneDrive/Desktop/Mini_Proj/loginicon.ico')
    categoryname=Label(root,text="Name of Category", bd= "5", bg='white',fg='black',relief=RIDGE,
                   font=("times new roman",12,"bold"), borderwidth=2,padx=3,pady=3)
    categoryname.grid(row=0,column=0,pady=40,padx=40)


    e=Entry(root)
    e.grid(row=0,column=1, padx=5,pady=5)

    buttonadddetail = Button(root, text="Submit", padx=2, pady=2, bd=5, bg='#25172d',fg='white',
                         font=("times new roman", 12, "bold"),command=lambda : addnewcat(group,e.get()))
    buttonadddetail.place(x=150, y=150)


    root.mainloop()
