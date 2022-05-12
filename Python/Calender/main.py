from tkinter import *
import calendar


def showCalender():
    gui = Tk()
    gui.config(background='white')
    gui.title("Calender for the year")
    gui.geometry("525x550")
    year = int(year_field.get())
    gui_content = calendar.calendar(year)
    calYear = Label(gui, text=gui_content, font=("times", 10,))
    calYear.grid(row=5, column=1, padx=10)
    gui.mainloop()


if __name__ == '__main__':
    new = Tk()
    new.config(background='white')
    new.title("Calender For Any Year")
    new.geometry("410x620")
    cal = Label(new, text="Calender For Any Year", font=("times", 30, "bold",))
    year = Label(new, text="Enter year", bg='orange',
                 font=("times", 30, "bold",))
    year_field = Entry(new, font=("times", 20, "bold",))
    button = Button(new, text='Show Calender', fg='white', bg='Orange',
                    command=showCalender, font=("times", 20, "bold",))
    Exit = Button(new, text="Exit", command=new.destroy,
                  font=("times", 20, "bold",))
    cal.grid(row=1, column=1)
    year.grid(row=2, column=1)
    year_field.grid(row=3, column=1)
    button.grid(row=4, column=1)
    Exit.grid(row=5, column=1)
    new.mainloop()
