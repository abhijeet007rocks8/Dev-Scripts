from tkinter import *
from tkmacosx import Button

w = Tk()
w.title('Calculator')
w.configure(bg='#2cafdb')

fr = LabelFrame(w, pady=20)
fr.pack(padx=5, pady=5)
fr.configure(bg='#1a535c')
e = Entry(fr, width=40, borderwidth=4, font=('Verdana', 15))
e.grid(column=0, row=0, columnspan=3, padx=5, pady=(60, 30))
ls = []


def num_append(n):
    current = e.get()
    e.delete(0, END)
    e.insert(0, str(current) + str(n))


def clear():
    e.delete(0, END)


def numop(op):
    if 'ERROR.....!!!' in e.get():
        clear()
        return
    if '.' not in str(e.get()):
        num = int(str(e.get()))
    else:
        num = float(str(e.get()))
    e.delete(0, END)
    global ls
    ls.append(num)
    ls.append(op)


def eq():
    if 'ERROR.....!!!' in e.get():
        clear()
        return
    elif len(e.get()) == 0:
        return

    if '.' not in str(e.get()):
        num = int(str(e.get()))
    else:
        num = float(str(e.get()))
    e.delete(0, END)
    global ls
    ls.append(num)
    e.insert(0, math(ls))
    ls.clear()


def math(l):
    bal = l[0]
    for i in range(1, len(l)):
        if l[i] == '+':
            bal += l[i + 1]
        elif l[i] == '-':
            bal -= l[i + 1]
        elif l[i] == 'x':
            bal *= l[i + 1]
        elif l[i] == '/':
            try:
                bal /= l[i + 1]
            except Exception as ex:
                print('Error', ex)
                return 'ERROR.....!!!'
    return bal


yellow = '#ffe66d'
ascent = '#1a535d'
# Button defs

but_0 = Button(
    fr,
    text='0',
    padx=25,
    pady=20,
    command=lambda: num_append(0),
    bg=yellow,
    highlightbackground=ascent)
but_1 = Button(
    fr,
    text='1',
    padx=25,
    pady=20,
    command=lambda: num_append(1),
    bg=yellow,
    highlightbackground=ascent)
but_2 = Button(
    fr,
    text='2',
    padx=25,
    pady=20,
    command=lambda: num_append(2),
    bg=yellow,
    highlightbackground=ascent)
but_3 = Button(
    fr,
    text='3',
    padx=25,
    pady=20,
    command=lambda: num_append(3),
    bg=yellow,
    highlightbackground=ascent)
but_4 = Button(
    fr,
    text='4',
    padx=25,
    pady=20,
    command=lambda: num_append(4),
    bg=yellow,
    highlightbackground=ascent)
but_5 = Button(
    fr,
    text='5',
    padx=25,
    pady=20,
    command=lambda: num_append(5),
    bg=yellow,
    highlightbackground=ascent)
but_6 = Button(
    fr,
    text='6',
    padx=25,
    pady=20,
    command=lambda: num_append(6),
    bg=yellow,
    highlightbackground=ascent)
but_7 = Button(
    fr,
    text='7',
    padx=25,
    pady=20,
    command=lambda: num_append(7),
    bg=yellow,
    highlightbackground=ascent)
but_8 = Button(
    fr,
    text='8',
    padx=25,
    pady=20,
    command=lambda: num_append(8),
    bg=yellow,
    highlightbackground=ascent)
but_9 = Button(
    fr,
    text='9',
    padx=25,
    pady=20,
    command=lambda: num_append(9),
    bg=yellow,
    highlightbackground=ascent)

but_equ = Button(
    fr,
    text='=',
    padx=106,
    pady=20,
    command=eq,
    bg=yellow,
    highlightbackground=ascent)
but_clr = Button(
    fr,
    text='clear',
    padx=106,
    pady=20,
    command=clear,
    bg=yellow,
    highlightbackground=ascent)

# math_buttons
but_add = Button(
    fr,
    text='+',
    padx=25,
    pady=20,
    command=lambda: numop('+'),
    bg=yellow,
    highlightbackground=ascent)
but_sub = Button(
    fr,
    text='-',
    padx=25,
    pady=20,
    command=lambda: numop('-'),
    bg=yellow,
    highlightbackground=ascent)
but_mul = Button(
    fr,
    text='X',
    padx=25,
    pady=20,
    command=lambda: numop('x'),
    bg=yellow,
    highlightbackground=ascent)
but_div = Button(
    fr,
    text='/',
    padx=25,
    pady=20,
    command=lambda: numop('/'),
    bg=yellow,
    highlightbackground=ascent)

# layering
but_0.grid(row='4', column='0', padx=10)

but_1.grid(row='3', column='0', padx=10)
but_2.grid(row='3', column='1', padx=10)
but_3.grid(row='3', column='2', padx=10)

but_4.grid(row='2', column='0', padx=10)
but_5.grid(row='2', column='1', padx=10)
but_6.grid(row='2', column='2', padx=10)

but_7.grid(row='1', column='0', padx=10)
but_8.grid(row='1', column='1', padx=10)
but_9.grid(row='1', column='2', padx=10)

but_add.grid(row=5, column=0, padx=10)
but_equ.grid(row=5, column=1, columnspan=2)
but_clr.grid(row=4, column=1, columnspan=2)

but_sub.grid(row=6, column=0, padx=10)
but_mul.grid(row=6, column=1, padx=10)
but_div.grid(row=6, column=2, padx=10)

w.mainloop()
