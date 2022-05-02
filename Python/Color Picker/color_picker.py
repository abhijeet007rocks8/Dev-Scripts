from tkinter import *
from tkinter import colorchooser ,filedialog
from PIL import Image, ImageTk
import PIL

root=Tk()
root.title(" Click on any where on image to pick a color  ")
c=Canvas(root)


def _from_rgb(rgb):
    return "#%02x%02x%02x" % rgb


def colorpic(e):
    global width,height
    global entry,entry1,disp
    global newFrame
    b1=Image.open(glb_img_name).resize((width,height),Image.ANTIALIAS).convert("RGB")
    pixs=b1.getpixel((e.x,e.y))
    ds=_from_rgb((pixs))
    color=ds
    
    entry.delete(0,END)
    entry.insert(0,str(pixs))

    entry1.delete(0,END)
    entry1.insert(0,str(color))

    disp.config(bg=color,fg=color)
    newFrame.grid(row=0,column=1)
    
    
    
def width_height(owidth,oheight):
    while((oheight>680 )):
        owidth,oheight=int(owidth/1.1),int(oheight/1.1)
    while((owidth>930 )):
        owidth,oheight=int(owidth/1.1),int(oheight/1.1)
    return owidth,oheight


def open_another():
    global c
    global newFrame
    global myimg
    global glb_img_name
    global width,height
    
    newFrame.grid_forget()
    imgname=filedialog.askopenfilename(initialdir="/Desktop/python codes",title="open images",filetypes=(("png files","*.png"),("jpg files","*.jpg"),("jpeg files","*.jpeg")))
    copy=Image.open(imgname)
    owidth,oheight=copy.size
    width,height=width_height(owidth,oheight)
    myimg=ImageTk.PhotoImage(Image.open(imgname).resize((width,height),Image.ANTIALIAS))
    c.grid_forget()
    glb_img_name=imgname
    c.config(width=width,height=height)
    c.create_image(0,0,anchor=NW,image=myimg)
    c.grid(row=0,column=0)


imgname=filedialog.askopenfilename(initialdir="/Desktop/python codes",title="open images",filetypes=(("png files","*.png"),("jpg files","*.jpg"),("jpeg files","*.jpeg")))
imagename=imgname
glb_img_name=imagename
copy=Image.open(imagename)
owidth,oheight=copy.size
width,height=width_height(owidth,oheight)
myimg=ImageTk.PhotoImage(Image.open(glb_img_name).resize((width,height),Image.ANTIALIAS))
c.config(width=width,height=height)
c.create_image(0,0,anchor=NW,image=myimg)
c.grid(row=0,column=0)
c.bind("<Button-1>",colorpic)

newFrame=Frame(root)
entry= Entry(newFrame, width= 10)
entry.grid(row=0,column=0,padx=10)
entry1= Entry(newFrame, width= 10)
entry1.grid(row=0,column=1,padx=10)
disp=Button(newFrame,text="  ")
disp.grid(row=0,column=2,padx=10)
sel=Button(newFrame,text="Open",command=open_another)
sel.grid(row=0,column=3)


root.mainloop()
    




