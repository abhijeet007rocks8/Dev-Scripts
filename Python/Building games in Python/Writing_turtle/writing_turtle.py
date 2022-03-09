from shutil import move
from turtle import Turtle, Screen

uu=Turtle()
screen=Screen()

def moveforward():
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

screen.listen()
screen.onkey(moveforward,"w")
screen.onkey(moveback,"s")
screen.onkey(moveright,"d")
screen.onkey(moveleft,"a")
screen.onkey(clear,"c")
screen.exitonclick()