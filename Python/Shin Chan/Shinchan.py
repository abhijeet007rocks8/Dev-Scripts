from turtle import *

s=Screen()
s.screensize(700,1000)
speed(5)
def myPosition(x, y):
    penup()
    goto(x, y)
    pendown()
    
pensize(2)

def ankur():
    fillcolor('#ffec40')
    begin_fill()
    right(25)
    forward(20)
    right(45)
    forward(20)
    left(70)
    forward(90)
    left(95)
    forward(75)
    left(85)
    forward(175)
    left(85)
    forward(75)
    left(95)
    forward(90)
    left(85)
    forward(18)
    end_fill()