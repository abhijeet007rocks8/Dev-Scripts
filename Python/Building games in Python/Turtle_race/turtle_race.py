from turtle import Turtle,Screen
import random

israceon=False
screen=Screen()
screen.setup(width=500,height=400)
userbet=screen.textinput(title="make your bet", prompt="which turtle will win the race select your color: ")
colors=["red",'yellow','orange','green','purple','blue']
y_positions=[-70,-40,-10,20,50,80]
allturtles=[]


for i in range(6):
    newturtle=Turtle(shape="turtle")
    newturtle.color(colors[i])
    newturtle.penup()
    newturtle.goto(x=-230,y=y_positions[i])
    allturtles.append(newturtle)

if userbet:
    israceon=True

while israceon:
    for turtle in allturtles: 
        if turtle.xcor()>230:
            israceon=False
            winningcolor=turtle.pencolor()
            if winningcolor==userbet:
                print("you have won , the winner is "+ winningcolor)
            else:
                print("you lost the winning color is "+winningcolor )
        rand_distance=random.randint(0,10)
        turtle.forward(rand_distance)
screen.exitonclick()