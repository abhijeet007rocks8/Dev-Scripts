
# import the turtle and random libraries
from turtle import Turtle,Screen
import random


screen=Screen() #import screen class from Screen
screen.setup(width=500,height=400). #set the height and width of the screen 
userbet=screen.textinput(title="make your bet", prompt="which turtle will win the race select your color: ") #take user input in userbet
colors=["red",'yellow','orange','green','purple','blue'] #create a list of colors so that we can have turtles of different colors.
y_positions=[-70,-40,-10,20,50,80]  #create list of positions on y axis to assign different positions to all turtles.
allturtles=[] #create list to add the newly created turtles


for i in range(6):
    newturtle=Turtle(shape="turtle"). #create new turtle
    newturtle.color(colors[i]) # assign a new color to the turtle from colors list
    newturtle.penup() # penup so that the turtle don't write anything on the screen 
    newturtle.goto(x=-230,y=y_positions[i]) #assign position to the turtle
    allturtles.append(newturtle). # append the newly created turtle to allturtles list

is_race_on=False 
if userbet:
    is_race_on=True

while is_race_on:
    for turtle in allturtles: 
        if turtle.xcor()>230:  #if turtle reaches the end loop terminates
            is_race_on=False
            winningcolor=turtle.pencolor()
            if winningcolor==userbet:
                print("you have won , the winner is "+ winningcolor)
            else:
                print("you lost the winning color is "+winningcolor )
        rand_distance=random.randint(0,10) #get a random distance for the turtle to move
        turtle.forward(rand_distance)
screen.exitonclick()
