
from tkinter import *
import tkinter.messagebox as tmsg
import random
from random import shuffle

# ^ <============== List of Words ==================>

answers = ["america", "india", "australia", "deepraj", 'klaus', 'dark', 'witcher',
           'originals', 'superman', 'thor', 'transformers', 'damon', 'stefan', 'vervain', 'werewolf']
questions = []

for i in answers:
    words = list(i)
    shuffle(words)
    questions.append(words)

num = random.randint(0, len(questions)-1)

# * --------------------------- Backend ----------------------------------


def initial():
    global questions, num
    lb1.configure(text=questions[num])


def resetswitch():
    global questions, answers, num
    num = random.randint(0, len(questions)-1)
    lb1.configure(text=questions[num])
    e1.delete(0, END)


def answercheck():
    global questions, num, answers
    userinput = e1.get()
    if userinput == answers[num]:
        tmsg.showinfo('Success', 'You Guessed it Right')
        resetswitch()
    else:
        tmsg.showinfo('Error', 'Your answer is wrong\n Guess it Again')
        e1.delete(0, END)


# % <------------------------ Main UI Body ------------------------------>

root = Tk()
root.geometry("400x400")
root.configure(background='#2C3335')
root.title("JumbleWord Game")
root.iconbitmap(r"mainicon.ico")

lb1 = Label(root, font='Hack 20', bg='#2C3335', fg='#DAE0E2')
lb1.pack(pady=30, ipady=10, ipadx=10, fill=BOTH)

answer = StringVar()
e1 = Entry(root, textvariable=answer, font="Firacode 15")
e1.pack(ipady=5, ipadx=5)

button1 = Button(root, text="Check", bg='#75DA8B',
                 width=20, command=answercheck)
button1.pack(pady=35)

button3 = Button(root, text="Change Word", bg="#75DA8B",
                 width=20, command=resetswitch)
button3.pack(pady=20)

button2 = Button(root, text="Exit", bg="#EA425C",
                 width=20, command=quit)
button2.pack(pady=20)


initial()
root.mainloop()
