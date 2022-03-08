import tkinter as tk
import tkinter.font
from PIL import Image,ImageTk
import pyperclip as pc
import sqlite3
import create_database
from tkinter import END, LEFT, TOP, messagebox, ttk, TOP, LEFT, BOTH, VERTICAL, RIGHT, Y
import sending_email
import random




### COLORS

floralwhite = '#FFFAF0'
forestgreen = '#228B22'
darkGrey = '#2F4F4F'
darkorange = '#FF8C00'
darkTurquoise = '#00CED1'
darkmode = '#282c34'
lightred = '#FF7C7C'


### FUNCTIONS DELCALRATIONS FOR THE APP

def login():        
                                                   ## function to login to the app
        txt = pass_entry.get()
        pwd = create_database.getmasterpasswd()
        if pwd != None:
            for i in pwd:
                val = i[1]
            if txt == val:
                frame1.pack_forget()
                frame2.pack()
                pass_entry.delete(0,END)
            else:
                messagebox.showwarning("Password", "WRONG PASSWORD!!!")
                pass_entry.delete(0,END)
        else:
            pass


def logout():                                                                ## functiont to log oiut of the app
    frame2.pack_forget()
    frame1.pack()
 
def gobackf1():                                                             ## function to sqitch from the add entry frame to the main frame
    Title_e.delete(0,END)
    Account_e.delete(0,END)
    Username_e.delete(0,END)
    Password_e.delete(0,END)
    Website_e.delete(0,END)

    frameaddentry.pack_forget()
    frame2.pack()

def passwordGenerator():                                                         ## genrates a random password when the generate buttoni is clicked
   clicked = True
   passwd = ""
   if clicked:
        Password_e.delete(0,END)
        generate.config(state="disabled")
        for i in range(12):
            pchar = chr(random.randint(33,126))
            passwd+=pchar
        
        Password_e.insert(0,passwd)
        pc.copy(passwd)
        generate.config(state="normal")

def addtodb():    
    ins = 1
    con = sqlite3.connect('./database_folder/password.db')                                                                   ## function to add info to the database
    c = con.cursor()
    d= c.execute("SELECT * FROM Userinfo")
    for val in d:
        if val[0] == Title_e.get():
            ins = 0
            break
    con.close()
    if Title_e.get() != '' and Password_e.get() != '' and ins:
        create_database.insertdb(Title_e.get(),Account_e.get(),Username_e.get(),Password_e.get(),Website_e.get())
        Title_e.delete(0,END)
        Account_e.delete(0,END)
        Username_e.delete(0,END)
        Password_e.delete(0,END)
        Website_e.delete(0,END)
        frameaddentry.pack_forget()
        frame2.pack()
    else:
        messagebox.showerror("Incomlplete Info", "Password and Title fields cannot be empty or passworc exiat with the same title")

def addnew():
    frame2.pack_forget()
    frameaddentry.pack()

def forgotpassword():                                                    ## forgot password funtionality funtion to send otp to registered email
    reg_val = create_database.getmasterpasswd()
    for i in reg_val:
        registered_email = i[0]
    global otp
    otp = generateotp()
    sending_email.sendEmail(registered_email,otp)
    messagebox.showinfo("OTP","Check your email an otp has been sent")

def otplogin():  
    try:                                                     ## function to login through otp
        if str(otp) == str(otpentry.get()):
            otpentry.delete(0,END)
            frame1.pack_forget()
            frame2.pack()
        else:
            messagebox.showerror("OTP","Wrong otp entered check again")
            otpentry.delete(0,END)
    except Exception as e:
        messagebox.showerror("Error", "otp not defined")

def generateotp():                                                  ## function to generate a ranodom otp
    num =0
    for i in range(6):
        digit = random.randint(0,9)
        num+=digit
        num*=10

    return num

def copypasswd():                                                          ## function to copy passqord to clipboard
    title = sfield.get()
    retpass = create_database.fetchpasswordonclick(title)
    if retpass != None:
        pc.copy(str(retpass))
    else:
        messagebox.showinfo("Invalid", "Password dosen't exist check again")
    sfield.delete(0,END)

def scrchng():
    sfield.place_forget()
    srlbl.place_forget()
    wrap.pack_forget()
    bbtn.place_forget()
    ebtn.place_forget()
    frame2.pack()

def updatepass(value):
    
    con = sqlite3.connect('./database_folder/password.db')
    c=con.cursor()
    c.execute("UPDATE logincred SET password = ?", (value,))
    con.commit()
    con.close()
    passwin.destroy()
    

def updatemail(value):
  
    con = sqlite3.connect('./database_folder/password.db')
    c=con.cursor()
    c.execute("UPDATE logincred SET email = ? ", (value,))
    con.commit()
    con.close()
    emwin.destroy

def toppass():                                          ## function to open a anew window to update the master password
    global passwin
    passwin = tk.Toplevel()
    passwin.title("Change Master Password")

    passwdlbl = tk.Label(passwin,text="PASSWORD: ",font=f1,fg='#000000')
    passwdlbl.grid(row=0,column=0,padx=10,pady=10)
    passwdentr = tk.Entry(passwin,width=40, border = 2)
    passwdentr.grid(row=0,column=1,padx=5,pady=10)
    passwdentr.focus_set()

    cpasswdlbl = tk.Label(passwin,text="CONFIRM PASSWORD: ",font=f1,fg='#000000')
    cpasswdlbl.grid(row=1,column=0,padx=10,pady=10)
    cpasswdentr = tk.Entry(passwin, width=40, border=2)
    cpasswdentr.grid(row=1,column=1,padx=5,pady=10)

    submitbtn  = tk.Button(passwin,text  = "SUBMIT",fg = '#000000',font=f1, activebackground="green", bd=2, border=3, bg= '#FF8C00',command=lambda : updatepass(cpasswdentr.get()))
    submitbtn.grid(row=3,column=0,padx=10,pady=10)
    

def topem():                                             ## function to change the registeresd email
    global emwin
    emwin = tk.Toplevel()
    emwin.title("Change Email")

    emaillbl = tk.Label(emwin,text="EMAIL:",fg = '#000000',font=f1)
    emaillbl.grid(row=0,column=0,padx=10,pady=10)
    emailentr = tk.Entry(emwin,width=40, border=2)
    emailentr.grid(row=0,column=1,padx=5,pady=10)
    emailentr.focus_set()

    submitbtn  = tk.Button(emwin,text  = "SUBMIT",fg = '#000000',font=f1, activebackground="green", bd=2, border=3, bg= '#FF8C00', command=lambda : updatemail(emailentr.get()))
    submitbtn.grid(row=1,column=0,padx=10,pady=10)

def secfrm():                           ## change frame from ecurity frame to main frame
    scfrm.pack_forget()
    frame2.pack()

def loadsec():                          ## chaancge frame from main frame to security frame
    frame2.pack_forget()
    scfrm.pack()

def dbtoframe():                          ## cahnge frame from databse frame to main frame
    dbfrm.pack_forget()
    frame2.pack()

def dbpage():                                 ## funtion that sets up the database page
    frame2.pack_forget()    
    dbfrm.pack()
    dbtofrm.grid(row=0,column=1,padx=10,pady=10)

    c2csv.grid(row=1,column=0,padx=100,pady=20)
    csvbtn.grid(row=1,column=1,padx=5,pady=20)

    backdb.grid(row=2,column=0,padx=100,pady=20)
    bckbtn.grid(row=2,column=1,padx=10,pady=10)

    deldb.grid(row=3,column=0,padx=100,pady=20)
    delbtn.grid(row=3,column=1,padx=5,pady=20)

    pddb.grid(row=4,column=0,padx=50,pady=20)
    pdbtn.grid(row=4,column=1,padx=5,pady=20)

def searchwin():                                    ## funtoin that sets up the search window
    global sfield,srlbl
    frame2.pack_forget()
    srlbl = tk.Label(window,text="Title", bg=floralwhite, fg='#000000', font = f1,border=2,width=6)
    srlbl.place(x=10,y=20)
    sfield = tk.Entry(window,width=50)
    sfield.place(x=70,y=20)
    sfield.focus_set()  
    ebtn.place(x=410,y=10)
    bbtn.place(x=450,y=10)

    global wrap
    wrap = ttk.LabelFrame(window,height=650)

    my_can = tk.Canvas(wrap)
    my_can.pack(side=LEFT,fill = BOTH,expand=1)

    my_scroll = ttk.Scrollbar(wrap,orient=VERTICAL,command=my_can.yview)
    my_scroll.pack(side=RIGHT,fill=Y)

    my_can.configure(yscrollcommand=my_scroll.set)
    my_can.bind('<Configure>', lambda e: my_can.configure(scrollregion = my_can.bbox("all")))

    global s_frm
    s_frm = tk.Frame(my_can)

    my_can.create_window((0,0),window=s_frm,anchor="nw")
    
    wrap.pack(fill=BOTH,expand=1,padx=10,pady=60)

    con = sqlite3.connect('./database_folder/password.db')
    c = con.cursor()
    data = c.execute("SELECT * FROM Userinfo")
    for i,r in enumerate(data):
       
        btn = tk.Button(s_frm,image=accimg,borderwidth=0)
        btn.grid(row=i,column=0,padx=5,pady=5)
        nline = '\n'
        tk.Label(s_frm,text=f"Title : {r[0]} {nline} Account : {r[1]}{nline} Username : {r[2]} {nline} Website : {r[4]}",font = f2).grid(row=i,column=1,pady=15)

    c.close()

def deletepass(value):
    try:
        con = sqlite3.connect('./database_folder/password.db')
        c = con.cursor()
        c.execute("DELETE FROM Userinfo WHERE Title = ?",(value,))
        con.commit()
        con.close()
        delentry.delete(0,END)
        delwin.destroy()
    except Exception:
        messagebox.showerror("Error","No Such Password Exists!!!")
    

def deletetop():
    global delwin
    delwin = tk.Toplevel()
    delwin.title("Delete Entry")

    dellbl = tk.Label(delwin,text="Title:",fg = '#000000',font=f1)
    dellbl.grid(row=0,column=0,padx=30,pady=20)

    global delentry
    delentry = tk.Entry(delwin,width=35,border=2)
    delentry.grid(row=0,column=1,padx=10,pady=20)
    delentry.focus_set()

    delbtn = tk.Button(delwin,border=2,text = "DELETE",command = lambda : deletepass(delentry.get()),bg=floralwhite,fg='#000000',font = f1)
    delbtn.grid(row=1,column=0,padx=10,pady=10)


### App and related windows

# MAIN WINDOW

window = tk.Tk()
window.geometry('500x500')
window.resizable(width=False,height=False)
window.title("My Passwords")
window.iconbitmap('./Images/appicon.ico')

##  FONTS DECLARED HERE
f=tkinter.font.Font(family='Comic Sans MS', size = 12,weight = "bold")
f1 = tkinter.font.Font(family='Comic Sans MS', size = 8,weight = "bold")
f2 = tkinter.font.Font(family='Comic Sans MS', size = 15,weight = "bold")

# FRAME 1 OR WELCOME FRAME OF THE APP

frame1 = tk.Frame(window,bg = floralwhite, width=500, height=500)
toplbl = tk.Label(frame1, text = "Password Vault", width = 49, height=3, font = f, bg = darkorange, fg = '#000000' ,anchor=tk.CENTER).place(x=0,y=0)
welclabel = tk.Label(frame1, text= "Welcome", bg = floralwhite, font=f).place(x=205,y=100)
pass_Label = tk.Label(frame1, text = "Password", bg = floralwhite, font=f).place(x=50,y=170)
pass_entry = tk.Entry(frame1,width = 45, bg = floralwhite, border=2)
pass_entry.place(x=150,y=175)
pass_entry.focus_set()
otplb = tk.Label(frame1,text = 'OTP',bg = floralwhite, font=f).place(x=50,y=235)
otpentry = tk.Entry(frame1, width = 45, bg = floralwhite, border=2)
otpentry.place(x=150,y=240)
forgotbtn = tk.Button(frame1,text= "Forgot Password?..", fg = '#000000', bg=floralwhite, bd=2, width=15,font = f1,command=forgotpassword)
forgotbtn.place(x=150,y=300)
okbtn = tk.Button(frame1, text = "OK", fg=forestgreen, bg= floralwhite, border=2, font= f1,command = otplogin)
okbtn.place(x=450,y=235)
enterbtn = tk.Button(frame1, text = "ENTER", activebackground = forestgreen, bg= darkTurquoise, font =f , fg = '#000000', width= 10, command = login)
enterbtn.place(x=180,y=400)


# FRAME 2 OR MAIN WINDOW OF THE APP

frame2 = tk.Frame(window, bg=floralwhite, width=500,height=500)

addimg = ImageTk.PhotoImage(Image.open('./Images/addpassword.png').resize((50,50)))
addentrylbl = tk.Label(frame2, text = "ADD ENTRY", fg='#000000', bg = darkTurquoise, font=f2).grid(row=2, column=0, padx=50, pady=50)
addbtn = tk.Button(frame2, image=addimg, borderwidth=0 , bg = floralwhite, command = addnew)
addbtn.grid(row = 2, column=1, padx=10)

sicon = ImageTk.PhotoImage(Image.open('./Images/search.png').resize((45,45)))
searchlbl = tk.Label(frame2, text = "SEARCH PASSWORD", fg='#000000', bg = darkTurquoise, font=f2).grid(row=3,column=0,padx=50,pady=5)
searchbtn = tk.Button(frame2,image=sicon ,borderwidth=0,bg= floralwhite,command=searchwin)
searchbtn.grid(row=3,column=1,padx=10,pady=5)

sldicon = ImageTk.PhotoImage(Image.open('./Images/shield.png').resize((45,45)))
seclbl = tk.Label(frame2,text="SECURITY",fg = '#000000',bg = darkTurquoise,font=f2).grid(row=4,column=0,padx=50,pady=55)
secbtn = tk.Button(frame2,image=sldicon,borderwidth=0,bg=floralwhite, command= loadsec)
secbtn.grid(row=4,column=1,padx=10,pady=55)

datalbl = tk.Label(frame2,text="DATABASE",fg = '#000000',bg=darkTurquoise,font=f2).grid(row=5,column=0,padx=50)
databim = ImageTk.PhotoImage(Image.open('./Images/database.png').resize((45,45)))
databtn = tk.Button(frame2,image=databim,borderwidth=0,bg=floralwhite,command=dbpage)
databtn.grid(row=5,column=1,padx=10)

logoutbtn =  tk.Button(frame2, text = "LOGOUT", borderwidth=0,bg=darkorange, font = f1, fg= '#000000',command=logout,width=8, border=3)
logoutbtn.grid(row=6,column=1,padx=10,pady = 40)

# ADD ENTRY FRAME

frameaddentry = tk.Frame(window,bg=floralwhite,width=500,height=500) 

crossimg = ImageTk.PhotoImage(Image.open('./Images/cross.png'))
crossbtn = tk.Button(frameaddentry, image=crossimg, bg= '#d75a4a',command=gobackf1)
crossbtn.grid(row=0,column=2,sticky="ne", padx=20, pady=5)

Title = tk.Label(frameaddentry, text="Title:",bg = floralwhite, font=f, fg = 'black').grid(row=4,column=0,pady=40)
Title_e = tk.Entry(frameaddentry,width = 30, border = 2)
Title_e.grid(row=4,column=1,pady=40)
Title_e.focus_set()

Account = tk.Label(frameaddentry, text="Account:",bg = floralwhite,font=f,fg = 'black').grid(row=5,column=0)
Account_e = tk.Entry(frameaddentry,width = 30, border = 2)
Account_e.grid(row=5,column=1)

Username = tk.Label(frameaddentry, text="Username:", bg = floralwhite, font=f, fg = 'black').grid(row=6,column=0,pady=40)
Username_e = tk.Entry(frameaddentry,width = 30, border = 2)
Username_e.grid(row=6,column=1,pady=40)

Password = tk.Label(frameaddentry, text="Password:", bg = floralwhite, font=f, fg = 'black').grid(row=7,column=0)
Password_e = tk.Entry(frameaddentry,width = 30, border = 2)
Password_e.grid(row=7,column=1)


Website = tk.Label(frameaddentry, text="Website:",bg = floralwhite,font=f,fg = 'black').grid(row=8,column=0,padx=2,pady=40)
Website_e = tk.Entry(frameaddentry,width = 30, border = 2)
Website_e.grid(row=8,column=1,pady=40)

generate = tk.Button(frameaddentry,text = "Generate", bg = darkGrey, fg=floralwhite, bd=3,command = passwordGenerator)
generate.grid(row=7,column=2)

submitbtn = tk.Button(frameaddentry, text= "Submit",width = 10,bd=4,activebackground='green',font=f,command=addtodb).grid(row=11, padx=40,pady=10)


# SEARCH FRAME

searchfrm = tk.Frame(window,width=500,height=750)
backar = ImageTk.PhotoImage(Image.open('./Images/bar2.png').resize((30,30)))
bbtn = tk.Button(window,image=backar,borderwidth=0,bg=floralwhite, border=2,command=scrchng)

clip = ImageTk.PhotoImage(Image.open('./Images/clipboard.png').resize((30,30)))
ebtn = tk.Button(window,fg=floralwhite,borderwidth=2,image=clip,command=copypasswd,bg=floralwhite, border=2)

accimg =ImageTk.PhotoImage(Image.open('./Images/accessdata.png').resize((30,30)))


# SECURITY FRAME
scfrm = tk.Frame(window,bg = floralwhite)
sbtn =  tk.Button(scfrm,fg=floralwhite,borderwidth=2,image=backar,command=secfrm,bg=floralwhite, border=2)
sbtn.grid(row=0,column=1,padx=10,pady=10)

chngpass = tk.Label(scfrm, bg=darkTurquoise, fg = '#000000',text = "CHANGE MASTER PASS",font = f2)
chngpass.grid(row=1,column=0,padx=10,pady=10)
chngimg = ImageTk.PhotoImage(Image.open('./Images/change.png').resize((30,30)))
passbtn =  tk.Button(scfrm,image=chngimg, borderwidth=0, bg=floralwhite, border=2, command=toppass)
passbtn.grid(row=1,column=1,padx=10,pady=10)

chngem = tk.Label(scfrm, bg=darkTurquoise, fg = '#000000',text = "CHANGE EMAIL",font = f2)
chngem.grid(row=2,column=0,padx=10,pady=10)
embtn =  tk.Button(scfrm, image=chngimg, borderwidth=0, bg=floralwhite, border=2, command=topem)
embtn.grid(row=2,column=1,padx=10,pady=10)

# DATABASE FRAME

dbfrm = tk.Frame(window,bg = floralwhite)
dbtofrm = tk.Button(dbfrm,image=backar,borderwidth=0,bg=floralwhite, border=2,command=dbtoframe)

c2csv = tk.Label(dbfrm,bg=darkTurquoise,fg = '#000000',text = "CONVERT TO CSV",font = f2)
csvimg = ImageTk.PhotoImage(Image.open('./Images/csv.png').resize((30,30)))
csvbtn = tk.Button(dbfrm,image= csvimg, bg = floralwhite,border=2, command=create_database.expdbtocsv)

# shdb = tk.Label(dbfrm,bg=darkTurquoise,fg = '#000000',text = "SHARE DATABASE",font = f2)
backdb = tk.Label(dbfrm,bg=darkTurquoise,fg = '#000000',text = "BACKUP DATABASE",font = f2)
bckimg = ImageTk.PhotoImage(Image.open('./Images/backup.png').resize((30,30)))
bckbtn = tk.Button(dbfrm,image= bckimg, bg = floralwhite,border=2,command= create_database.createbackup)

deldb = tk.Label(dbfrm,bg=darkTurquoise,fg = '#000000',text = "DELETE DATABASE",font = f2)
delimg = ImageTk.PhotoImage(Image.open('./Images/trash-bin.png').resize((30,30)))
delbtn = tk.Button(dbfrm,image= delimg, bg = floralwhite,border=2,command= create_database.deletedb)

pddb = tk.Label(dbfrm,bg=darkTurquoise,fg = '#000000',text = "DELETE PASSWD ENTRY",font = f2)
pdimg = ImageTk.PhotoImage(Image.open('./Images/delpass.png').resize((30,30))) 
pdbtn = tk.Button(dbfrm,image= pdimg, bg = floralwhite,border=2,command= deletetop)



window.configure(bg=floralwhite)
frame1.pack()
window.mainloop()




