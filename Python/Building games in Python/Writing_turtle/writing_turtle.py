
from turtle import Turtle, Screen


uu=Turtle()
screen=Screen()

def moveforward(): #create a function to move forward
    uu.forward(10)
def moveback():
    uu.back(10)
def moveright():
    uu.right(10)
def moveleft():
    uu.left(10)
def clear():
    uu.clear()
    uu.penup()
    uu.home()
    uu.pendown()

screen.listen() #take the user input 
screen.onkey(moveforward,"w")
screen.onkey(moveback,"s")
screen.onkey(moveright,"d")
screen.onkey(moveleft,"a")
screen.onkey(clear,"c")
screen.exitonclick()
