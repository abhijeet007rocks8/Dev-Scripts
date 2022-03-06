from tkinter import *
import random
root = Tk()
root.geometry("399x410")
root.configure(bg = "cyan")
root.title("NUMBER_GUESSING")

number = 0 
x1 = random.randint(1,100)
print(x1)
x = StringVar()
y =StringVar()


def show():
    global number
    l1.configure(text = "u have "+str(number)+"of 5 chnaces")

    
    s = e.get()
    l4.configure(text ="Hey , u r too low\n !! try again")

    number = number+1
    if( number>=5):         
        y.set(str(x1))
        # root.set("")
    # if(number >=5):
    #   # root.quit()
    if((s) == str(x1)):
        
        root.configure(bg = "green")
        l4.configure(text ="WINNER WINNER \n CHICKEN DINNER")

    
    elif(s<str(x1)):
        x.set("")
        root.configure(bg = "pink")
        l4.configure(text ="Hey , u r too low\n !! try again")
    elif(s>str(x1)):
        root.configure(bg = "blue")
        x.set("")
        l4.configure(text ="Hey , u r too high\n !! try again")
        # x.set("")
    else :          
        y.set(str(x1))



def show1():
    root.quit()




l = Label(root, text = "ENTER THE NUMBER: ",font = ("",10),fg= "red",bg = "cyan",height = 1)
l.grid(row = 1 , column = 0 ,pady = 50)
e = Entry(root , fg= "red", bg = "cyan",textvariable = x,width =5,font = ("",25))
e.grid( row = 1 , column = 1,pady = 25,sticky = E)

l4 = Label(root , text = "Hey , u r too high\n !! try again")
l4.grid(row = 2 , column = 0 ,pady =1)
# l6 = Label(root , )
# l6.grid(row = 2 , column = 0 )
b = Button(root , text = "check!", bg = "cyan",command = show,border = 5)
b.grid( row = 2 , pady = 25,column= 1,columnspan = 2)

l3 = Label(root, text = "CORRECT NUMBER IS -> ",font = ("",10),fg= "red",bg = "cyan",height = 1)
l3.grid(row = 3 , column = 0 ,pady = 50)

l2 = Entry(root  ,fg = "red",bg = "cyan",font = ("",14),textvariable = y,width = 5)
l2.grid(row = 3 ,padx = 20, column = 1,columnspan = 2)

l1 = Label(root,font = ("bold",9),height = 2)
l1.grid(pady = 25,row = 4 , column = 0)

b1 = Button( root ,text ="QUIT",bg= "cyan",fg = "red",command = show1)
b1.grid(row = 4 , column = 1)
root.mainloop()