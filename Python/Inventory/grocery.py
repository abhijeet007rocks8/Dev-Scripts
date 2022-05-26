from cProfile import label
from tkinter import *
from PIL import ImageTk

import addcategory
import additemmens
import qrcode
import table


def content(root):
        def qr(group):
            q=Toplevel(root)
            qrcode.qrcode(q,group)

        def viewdetails(group):
          view = Toplevel(root)
          table.viewdetail(view, group)

        def adddetails(group):
          add = Toplevel(root)
          additemmens.addcategories(add, group)

        def addcat(group,proot):
            new=Toplevel(root)
            addcategory.addc(new,group,proot)

        root.title("Inventory management system")
        root.geometry("1350x800+0+0")
        root.iconbitmap('C:/Users/vrush/OneDrive/Desktop/Mini_Proj/loginicon.ico')
        root.bg=ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/download (1).jpg")

        root.bg_image=Label(root, image=root.bg).place(x=0,y=0,relwidth=1,relheight=1)

        lbltitle=Label(root,text="Grocery",bg="#EEE1C6",fg="#25172d",bd=20,relief=RIDGE,font=("times new roman",50,"bold"),padx=2,pady=6)
        lbltitle.pack(side=TOP,fill=X)
        buttonexit1 = Button(root, text="quit", padx=2, pady=2, bd=10, bg='white', fg='black',
                            font=("times new roman", 12, "bold"), command=root.destroy)
        buttonexit1.place(x=1200, y=130)

        #===============================ele=================================

        Frameelectronic = LabelFrame(root,text="Cooking Essentials", bd=12,relief=RIDGE,padx=20,bg="#EEE1C6",font=("times new roman",12,"bold"))
        Frameelectronic.place(x=20,y=200,width=240,height=240)

        buttonviewdetail = Button(root, text="View Details", padx=2, pady=2,bd=10, bg='white', fg='black',font=("times new roman",12,"bold"),command=lambda :viewdetails("cooking"))
        buttonviewdetail.place(x=75, y=250)
        buttonadd = Button(root, text="QR Code", padx=2, pady=2,bd=10, bg='white', fg='black',font=("times new roman",12,"bold"),command=lambda :qr("cooking"))
        buttonadd.place(x=85, y=370)
        buttonadddetail = Button(root, text="Add Details", padx=2, pady=2, bd=10,  bg='white', fg='black',
                                 font=("times new roman", 12, "bold"),command=lambda: adddetails("cooking"))
        buttonadddetail.place(x=77, y=310)


        #===================================== clothing =========================================
        Frameclothing = LabelFrame(root, text="Food & Beverages", bd=12, relief=RIDGE, padx=20, bg="#EEE1C6",
                                   font=("times new roman", 12, "bold"),)
        Frameclothing.place(x=350, y=200, width=240, height=240)


        buttonviewdetail = Button(root, text="View Details", padx=2, pady=2, bd=10, bg='white', fg='black',
                                  font=("times new roman", 12, "bold"),command=lambda :viewdetails("food"))
        buttonviewdetail.place(x=405, y=250)
        buttonadd = Button(root, text="QR Code", padx=2, pady=2, bd=10, bg='white', fg='black',
                           font=("times new roman", 12, "bold"),command=lambda :qr("food"))
        buttonadd.place(x=415, y=370)

        buttonadddetail = Button(root, text="Add Details", padx=2, pady=2, bd=10, bg='white', fg='black',
                                 font=("times new roman", 12, "bold"),command=lambda: adddetails("food"))
        buttonadddetail.place(x=407, y=310)

        #=====================================grocery =====================================

        Framegrocery = LabelFrame(root, text="Household Supplies", bd=12, relief=RIDGE, padx=20, bg="#EEE1C6",
                                  font=("times new roman", 12, "bold"))
        Framegrocery.place(x=685, y=200, width=240, height=240)

        buttonviewdetail = Button(root, text="View Details", padx=2, pady=2, bd=10, bg='white', fg='black',
                                  font=("times new roman", 12, "bold"),command=lambda :viewdetails("household"))
        buttonviewdetail.place(x=745, y=250)
        buttonadd = Button(root, text="QR Code", padx=2, pady=2, bd=10, bg='white', fg='black',
                           font=("times new roman", 12, "bold"),command=lambda :qr("household"))
        buttonadd.place(x=755, y=370)

        buttonadddetail = Button(root, text="Add Details", padx=2, pady=2, bd=10,  bg='white', fg='black',
                                 font=("times new roman", 12, "bold"),command=lambda: adddetails("household"))
        buttonadddetail.place(x=747, y=310)

        #add category ==============================================================================

        Frameaddcategory = LabelFrame(root, text="Add Item", bd=12, relief=RIDGE, padx=20, bg="#EEE1C6",
                                      font=("times new roman", 12, "bold"))
        Frameaddcategory.place(x=1025, y=200, width=240, height=240)

        buttonviewdetail = Button(root, text="Add Item", padx=10, pady=10, bd=10, bg='white', fg='black',
                                  font=("times new roman", 12, "bold"), command=lambda: addcat("grocery", root))
        buttonviewdetail.place(x=1090, y=280)

        root.mainloop()