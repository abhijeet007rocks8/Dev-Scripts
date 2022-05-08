from tkinter import *
from tkinter import ttk
from tkinter import filedialog, colorchooser


x = 300
y = 300
pen_color = 'red'


def mouse_press(event):
    global prev
    prev = event


def draw(event):
    global prev, x, y
    X = []
    preX = []
    Y = []
    preY = []
    if event.x > x:
        X.append(event.x)
        X.append(x+(x-event.x))
    else:
        X.append(event.x)
        X.append(x+(x-event.x))
    if prev.x > x:
        preX.append(prev.x)
        preX.append(x+(x-prev.x))
    else:
        preX.append(prev.x)
        preX.append(x+(x-prev.x))

    if event.y > y:
        Y.append(event.y)
        Y.append(y+(y-event.y))
    else:
        Y.append(event.y)
        Y.append(y+(y-event.y))
    if prev.y > y:
        preY.append(prev.y)
        preY.append(y+(y-prev.y))
    else:
        preY.append(prev.y)
        preY.append(y+(y-prev.y))

    canvas.create_line(preX[0], preY[0], X[0], Y[0],
                       width=w.get(), fill=pen_color, capstyle=ROUND)
    canvas.create_line(preX[1], preY[0], X[1], Y[0],
                       width=w.get(), fill=pen_color, capstyle=ROUND)
    canvas.create_line(preX[0], preY[1], X[0], Y[1],
                       width=w.get(), fill=pen_color, capstyle=ROUND)
    canvas.create_line(preX[1], preY[1], X[1], Y[1],
                       width=w.get(), fill=pen_color, capstyle=ROUND)
    canvas.create_line(preY[0], preX[0], Y[0], X[0],
                       width=w.get(), fill=pen_color, capstyle=ROUND)
    canvas.create_line(preY[1], preX[0], Y[1], X[0],
                       width=w.get(), fill=pen_color, capstyle=ROUND)
    canvas.create_line(preY[0], preX[1], Y[0], X[1],
                       width=w.get(), fill=pen_color, capstyle=ROUND)
    canvas.create_line(preY[1], preX[1], Y[1], X[1],
                       width=w.get(), fill=pen_color, capstyle=ROUND)

    prev = event


def save_as_png():
    filename = filedialog.asksaveasfilename(
        initialdir="/", title="Select file", filetypes=(("PNG files", "*.eps"), ("all files", "*.*")))
    if filename:
        canvas.postscript(file=filename, colormode='color')


def select_color():
    global pen_color
    pen_color = colorchooser.askcolor(color=pen_color)[1]


root = Tk()
btn1 = ttk.Button(root, text="Pen Color", command=select_color)
btn1.grid(row=0, column=4)
btn1 = ttk.Button(root, text="Save", command=save_as_png)
btn1.grid(row=0, column=6)
w = Spinbox(root, from_=1, to=10)
w.grid(row=0, column=5)
canvas = Canvas(root, width=600, height=600,
                background='black')
canvas.grid(row=1, column=0, columnspan=11, rowspan=11)

canvas.create_rectangle(0, 0, 600, 600,
                        outline="black", fill="black")

canvas.bind('<ButtonPress>', mouse_press)
canvas.bind('<B1-Motion>', draw)


root.mainloop()
