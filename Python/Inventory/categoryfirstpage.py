from cProfile import label
from tkinter import *
from PIL import ImageTk

import clothing
import electronic
import grocery
import sports

def mainscreen(root):
    def electronics():
        elec=Toplevel(root)
        electronic.content(elec)

    def clothings():
        cloth=Toplevel(root)
        clothing.content(cloth)

    def groceries():
        groc=Toplevel(root)
        grocery.content(groc)
    def sport():
        s=Toplevel(root)
        sports.content(s)

    root.title("Inventory management system")
    root.geometry("1350x800+0+0")
    root.iconbitmap('C:/Users/vrush/OneDrive/Desktop/Mini_Proj/loginicon.ico')
    root.bg=ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/download (1).jpg")
    root.bg_image=Label(root, image=root.bg).place(x=0,y=0,relwidth=1,relheight=1)

    lbltitle=Label(root,text="Inventory management system",bg="#EEE1C6",fg="#25172d",bd=10,relief=RIDGE,font=("lobster",50,"bold"),padx=2,pady=6)
    lbltitle.pack(side=TOP,fill=X)

    buttonviewdetail = Button(root, text="Electronic", padx=50, pady=50, bd=10,bg='white',fg='black',
                          font=("times new roman", 20, "bold"),command=electronics)
    buttonviewdetail.place(x=40, y=280)
#=====================================================
    buttonviewdetail = Button(root, text=" Clothing ", padx=50, pady=50, bd=10,bg='white',fg='black',
                          font=("times new roman", 20, "bold"),command=clothings)
    buttonviewdetail.place(x=370, y=280)
#================================================================
    buttonviewdetail = Button(root, text="  Grocery ", padx=50, pady=50, bd=10, bg='white',fg='black',
                          font=("times new roman", 20, "bold"),command=groceries)
#=====================================================================================================
    buttonviewdetail.place(x=700, y=280)
    buttonviewdetail = Button(root, text="Sports  ", padx=50, pady=50, bd=10, bg='white',fg='black',
                          font=("times new roman", 20, "bold"),command= sport)
    buttonviewdetail.place(x=1030, y=280)

    root.mainloop()