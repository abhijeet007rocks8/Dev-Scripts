from tkinter import *
from PIL import ImageTk
import sqlite3

def selectgrp(group,title):
  global category, namezz
  category=group
  namezz=title
def add(name):
  global namezz,category,query

  if category=='electronics':
    query = "insert into" + " " + namezz + "  " + "values (?,?)"
    c.execute(query,(e1.get(),e2.get()))
    conn.commit()
    e1.delete(0, END)
    e2.delete(0, END)

  elif category == 'clothing':
    query = "insert into" + " " + namezz + "  " + "values (?,?)"
    print(query)
    co.execute(query, (e1.get(), e2.get()))
    connect.commit()
    e1.delete(0, END)
    e2.delete(0, END)
  elif category == 'grocery':
    query = "insert into" + " " + namezz + "  " + "values (?,?)"
    print(query)
    j.execute(query, (e1.get(), e2.get()))
    join.commit()
    e1.delete(0, END)
    e2.delete(0, END)

  elif category == 'sports':
    query = "insert into" + " " + namezz + "  " + "values (?,?)"
    a.execute(query, (e1.get(), e2.get()))
    addit.commit()
    e1.delete(0, END)
    e2.delete(0, END)

  elif category == 'null' and namezz == 'null':

    if name== 'mobile':
      c.execute('insert into mobile values (?,?)',(e1.get(),e2.get()))
      conn.commit()
      e1.delete(0,END)
      e2.delete(0,END)
    elif name=='Laptop':
      c.execute('insert into Laptop values (?,?)', (e1.get(), e2.get()))
      conn.commit()
      e1.delete(0, END)
      e2.delete(0, END)
    elif name=='Washing_Machine':
      c.execute('insert into WashingMachine values (?,?)', (e1.get(), e2.get()))
      conn.commit()
      e1.delete(0, END)
      e2.delete(0, END)
    elif name=='women':
      co.execute('insert into women values (?,?)', (e1.get(), e2.get()))
      connect.commit()
      e1.delete(0, END)
      e2.delete(0, END)
    elif name=='men':
      co.execute('insert into men values (?,?)', (e1.get(), e2.get()))
      connect.commit()
      e1.delete(0, END)
      e2.delete(0, END)
    elif name=='children':
      co.execute('insert into children values (?,?)', (e1.get(), e2.get()))
      connect.commit()
      e1.delete(0, END)
      e2.delete(0, END)
    elif name == 'food':
      j.execute('insert into food values (?,?)', (e1.get(), e2.get()))
      join.commit()
      e1.delete(0, END)
      e2.delete(0, END)
    elif name == 'household':
      j.execute('insert into household values (?,?)', (e1.get(), e2.get()))
      join.commit()
      e1.delete(0, END)
      e2.delete(0, END)
    elif name == 'cooking':
      j.execute('insert into cooking values (?,?)', (e1.get(), e2.get()))
      join.commit()
      e1.delete(0, END)
      e2.delete(0, END)
    elif name == 'sportsw':
      a.execute('insert into wear values (?,?)', (e1.get(), e2.get()))
      addit.commit()
      e1.delete(0, END)
      e2.delete(0, END)
    elif name == 'gym':
      a.execute('insert into gym values (?,?)', (e1.get(), e2.get()))
      addit.commit()
      e1.delete(0, END)
      e2.delete(0, END)
    elif name == 'SportsAccessories':
      a.execute('insert into accessories values (?,?)', (e1.get(), e2.get()))
      addit.commit()
      e1.delete(0, END)
      e2.delete(0, END)




def addcategories(root,group):

  global conn,c,connect,co,join,j,a,addit



  addit = sqlite3.connect('sports.db')
  a = addit.cursor()

  join=sqlite3.connect("C:/Users/vrush/OneDrive/Desktop/Mini_Proj/grocery.db")
  j=join.cursor()

  connect=sqlite3.connect("C:/Users/vrush/OneDrive/Desktop/Mini_Proj/clothing.db")
  co=connect.cursor()

  conn = sqlite3.connect("C:/Users/vrush/OneDrive/Desktop/Mini_Proj/electronics.db")
  c = conn.cursor()

  root.geometry("300x230")
  root.title("Add Item")
  root.bg=ImageTk.PhotoImage(file="C:/Users/vrush/OneDrive/Desktop/Mini_Proj/beige.webp")
  root.bg_image=Label(root, image=root.bg).place(x=0,y=0,relwidth=1,relheight=1)
  root.iconbitmap('C:/Users/vrush/OneDrive/Desktop/Mini_Proj/loginicon.ico')
#================================================================
  Name=Label(root,text="Item Name", padx=6, pady=6,fg="white", borderwidth=3, relief="solid",bg='#25172d',font=("times new roman",12,"bold"))
  Name.grid(row=0,column=0,pady=30,padx=30)
#======================================================================
  Quantity=Label(root,text="Quantity", padx=6, pady=6,fg="white", borderwidth=3, relief="solid",bg='#25172d',font=("times new roman",12,"bold"))
  Quantity.grid(row=1,column=0,padx=40)
#============================================================================
  submitmens=Button(root,text="Submit", padx=2, pady=2,bd=10,bg='#25172d',fg='white',font=("times new roman",12,"bold"),command=lambda :add(group))
  submitmens.place(x=179,y=150)

  global e1
  e1=Entry(root)
  e1.grid(row=0,column=1)
  global e2
  e2=Entry(root)
  e2.grid(row=1,column=1)

  root.mainloop()