from tkinter import *

def adddetail(name,i,root,check_box_list,entry):
    Checkbutton1 = IntVar()
    f = Frame(root)
    Button1 = Checkbutton(f, text=entry.get(),
                          variable=Checkbutton1,
                          onvalue=1,
                          offvalue=0, selectcolor="powder blue")
    Button1.pack(side='left')
    Button(f, text='✕', command=f.destroy).pack(side='left')
    check_box_list.append(f)
    print(check_box_list)
    if (name == 'today'):
        f.place(x=50, y=270 + i)
    elif (name == 'tomorrow'):
        f.place(x=380, y=270 + i)
    elif (name == 'thisweek'):
        f.place(x=710, y=270 + i)
    elif (name == 'custom'):
        f.place(x=1039, y=270 + i)
    i = i + 30
    return i
