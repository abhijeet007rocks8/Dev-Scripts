from tkinter import *
from tkinter import ttk
from random import randint


root = Tk()
root.title('Rock, Papper, Scissors!')
root.geometry("600x700")
# change background color
root.config(bg='white')

# defining images
home = PhotoImage(file='public/rps.png')
rock = PhotoImage(file='public/rock.png')
paper = PhotoImage(file='public/paper.png')
scissors = PhotoImage(file='public/scissors.png')

image_list = [home,rock,paper,scissors]

# pick random number
pick_number = 0

# print the image
image_label = Label(root,image=image_list[pick_number],bd=0)
image_label.pack(pady=20)



# start function
def start():
    pick_number = randint(1,3)
    image_label.config(image=image_list[pick_number],bd=0)
    # 1 = Rock
    # 2 = Paper
    # 3 = Scissors

    user_picked = user_choice.get()

    # Determine the result
    if user_picked == 'Rock':
        if pick_number == 1:
            result.config(text = "It's a Draw")
        elif pick_number == 2:
            result.config(text = "You Loose")
        else:
            result.config(text = "You Won")

    elif user_picked == 'Paper':
        if pick_number == 1:
            result.config(text = "You Won")

        elif pick_number == 2:
            result.config(text = "It's a Draw")
        else:
            result.config(text = "You Loose")
    else:
        if pick_number == 1:
            result.config(text = "You Loose")

        elif pick_number == 2:
            result.config(text = "You Won")
        else:
            result.config(text = "It's a Draw")

# exit function
def exit():
    root.quit()

# reset function
def reset():
    user_picked = 0
    image_label.config(image=image_list[pick_number],bd=0)
    result.config(text="")


# chose our option
user_choice = ttk.Combobox(root,value=('Rock','Paper','Scissors'))
user_choice.current(0)
user_choice.pack(pady=20)


# create a start button
start_button = Button(root,text="Play!",command = start,bg="white")
start_button.pack(pady=10)


# Result
result = Label(root,text="",bg="white")
result.pack()

#reset button
reset_button = Button(root,text='Reset Game',command = reset,bg="white")
reset_button.pack()


#exit button
exit_button = Button(root,text='Exit',command = exit,bg="white")
exit_button.pack()


root.mainloop()
