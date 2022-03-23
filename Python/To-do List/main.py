from tkinter import *
from PIL import ImageTk

import addbox
i=0
a=0
b=0
c=0
check_box_list1=[]
check_box_list2=[]
check_box_list3=[]
check_box_list4=[]


def add():
    global e4
    Framecustom = LabelFrame(root, text=e2.get(), bd=12, relief=RAISED, padx=20, bg="#F8C8DC",
                             font=("times new roman", 12, "bold"))
    Framecustom.place(x=1025, y=200, width=240, height=270)
    e4 = Entry(root)
    e4.place(x=1039, y=240,height=25,width=140)
    buttonupdate = Button(root, text="Clear All", padx=2, pady=2, bd=10, fg="white", bg="#0C2D48",
                          font=("times new roman", 10, "bold"), command=lambda :viewdetails('custom',c))
    buttonupdate.place(x=1100, y=370)

    submit = Button(root, text="Add", padx=2, pady=2, bd=10, fg="white", bg="#0C2D48",
                    font=("times new roman", 10, "bold"), command=lambda: adddetails('custom',e4,c))
    submit.place(x=1190, y=240)

def adddetails(name,entry,v):
        global i,a,b,c
        if name=='today':
            i=addbox.adddetail(name,v,root,check_box_list2,entry)
            print(i)
        elif name=='tomorrow':
            a=addbox.adddetail(name,v,root,check_box_list3,entry)
            print(a)
        elif name=='thisweek':
            b=addbox.adddetail(name,v,root,check_box_list4,entry)
            print(b)
        elif name=='custom':
            c=addbox.adddetail(name,v,root,check_box_list1,entry)
            print(c)



def viewdetails(name,o):
          global i,a,b,c,e4,e1,e0,e3
          if name=='custom':
              for p in check_box_list1:
                  if p.winfo_exists():
                      p.destroy()
                      e2 = Entry(root)
                      e2.place(x=1039, y=240, height=25, width=140)

                      buttonadd = Button(root, text="Done", padx=2, pady=2, bd=10, fg="white", bg="#0C2D48",
                                 font=("times new roman", 10, "bold"), command=add)
                      buttonadd.place(x=1190, y=240)
                      c = 0
                      e4.delete(0,END)
          elif name=='today':
              for p in check_box_list2:
                  if p.winfo_exists():
                    p.destroy()
                    i=0
                    e1.delete(0, END)
          elif name=='tomorrow':
              for p in check_box_list3:
                  if p.winfo_exists():
                      p.destroy()
                      a=0
                      e0.delete(0, END)
          elif name=='thisweek':
              for p in check_box_list4:
                  if p.winfo_exists():
                     p.destroy()
                     b=0
                     e3.delete(0, END)






root=Tk()
root.geometry("1290x700")
root.title("TO-DO LIST")
root.bg=ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Python/To-do list/background_solid_purple_65808_1280x960.jpg")
root.bg_image=Label(root, image=root.bg).place(x=0,y=0,relwidth=1,relheight=1)

# Heading
frame1 = Frame(root, highlightbackground="powder blue", highlightthickness=1,bg="powder blue",)
frame1.place(x=15,y=4)
Title=Label(frame1, text="ON IT!!",bg="powder blue", fg="black",font=("garamond-bold", 15,"bold"))
Title.grid(row=0,column=1,padx=10,pady=10)
img = ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Python/To-do list/manruning-removebg-preview.png")
Icon=Label(frame1,image=img,bg="powder blue")#FBEC5D
Icon.grid(row=0,column=0)

 #===============================today=================================


Frametoday = LabelFrame(root,text="Today", bd=12,relief=RAISED,padx=20,bg="#F8C8DC",font=("times new roman",12,"bold"))
Frametoday.place(x=35,y=200,width=240,height=270)
e1=Entry(root)
e1.place(x=50, y=240,height=25,width=140)

buttonupdate = Button(root, text="Clear All", padx=2, pady=2,bd=10,fg="white",bg="#0C2D48",font=("times new roman",10,"bold"),command=lambda:viewdetails('today',i))
buttonupdate.place(x=90, y=370)

submit = Button(root, text="Add", padx=2, pady=2, bd=10, fg="white", bg="#0C2D48",
                        font=("times new roman", 10, "bold"),command=lambda :adddetails("today",e1,i))
submit.place(x=200, y=240)


#===================================== tomorrow =========================================
Frametomorow = LabelFrame(root, text="Tomorrow", bd=12, relief=RAISED, padx=20, bg="#F8C8DC",
                           font=("times new roman", 12, "bold"))
Frametomorow.place(x=360, y=200, width=240, height=270)
e0=Entry(root)
e0.place(x=380, y=240,height=25,width=140)

buttonupdate = Button(root, text="Clear All", padx=2, pady=2,bd=10,fg="white",bg="#0C2D48",font=("times new roman",10,"bold"),command=lambda:viewdetails('tomorrow',a))
buttonupdate.place(x=440, y=370)

submit = Button(root, text="Add", padx=2, pady=2, bd=10, fg="white", bg="#0C2D48",
                        font=("times new roman", 10, "bold"),command=lambda:adddetails('tomorrow',e0,a))
submit.place(x=530, y=240)

# buttonviewdetail = Button(root, text="View Details", padx=2, pady=2, bd=10, fg="white", bg="#0C2D48",
#                           font=("times new roman", 12, "bold"),command=lambda :viewdetails("Laptop"))
# buttonviewdetail.place(x=415, y=250)
#
#
# buttonadddetail = Button(root, text="Add Details", padx=2, pady=2, bd=10, fg="white", bg="#0C2D48",
#                          font=("times new roman", 12, "bold"),command=lambda: adddetails("Laptop"))
# buttonadddetail.place(x=417, y=310)

#=====================================this week=====================================

Framethisweek = LabelFrame(root, text="This Week", bd=12, relief=RAISED, padx=20, bg="#F8C8DC",
                          font=("times new roman", 12, "bold"))
Framethisweek.place(x=695, y=200, width=240, height=270)
e3=Entry(root)
e3.place(x=710, y=240,height=25,width=140)

buttonupdate = Button(root, text="Clear All", padx=2, pady=2,bd=10,fg="white",bg="#0C2D48",font=("times new roman",10,"bold"),command=lambda:viewdetails('thisweek',b))
buttonupdate.place(x=755, y=370)

submit = Button(root, text="Add", padx=2, pady=2, bd=10, fg="white", bg="#0C2D48",
                        font=("times new roman", 10, "bold"),command=lambda:adddetails('thisweek',e3,b))
submit.place(x=860, y=240)
# buttonviewdetail = Button(root, text="View Details", padx=2, pady=2, bd=10, fg="white", bg="#0C2D48",
#                           font=("times new roman", 12, "bold"),command=lambda :viewdetails("Washing_Machine"))
# buttonviewdetail.place(x=755, y=250)
#
#
# buttonadddetail = Button(root, text="Add Details", padx=2, pady=2, bd=10, fg="white", bg="#0C2D48",
#                          font=("times new roman", 12, "bold"),command=lambda: adddetails("Washing_Machine"))
# buttonadddetail.place(x=759, y=310)

#=====================================custom=====================================
Framecustom = LabelFrame(root, text="Custom", bd=12, relief=RAISED, padx=20, bg="#F8C8DC",
                                  font=("times new roman", 12, "bold"))
Framecustom.place(x=1025, y=200, width=240, height=270)
e2=Entry(root)
e2.place(x=1039, y=240,height=25,width=140)

buttonadd = Button(root, text="Done", padx=2, pady=2, bd=10, fg="white", bg="#0C2D48",
                          font=("times new roman", 10, "bold"),command=add)
buttonadd.place(x=1190, y=240)

root.mainloop()
