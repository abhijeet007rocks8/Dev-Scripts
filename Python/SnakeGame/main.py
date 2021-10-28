from turtle import Screen, Turtle
import time
from Snake import Snake
from food import Food
from scoreboard import Scoreboard

screen = Screen()
screen.setup(width=600, height=600)
screen.bgcolor("black")
screen.title("Snake Game")
screen.tracer(0)
scoreboard = Scoreboard()

segsnake = Snake()
food = Food()
screen.listen()
screen.onkey(segsnake.Up, "Up")
screen.onkey(segsnake.Down, "Down")
screen.onkey(segsnake.Left, "Left")
screen.onkey(segsnake.Right, "Right")
screen.update()

game_is_on = 1
while game_is_on:

    screen.update()
    if segsnake.head.distance(food) <20:
        food.refresh()
        segsnake.addbox()
        scoreboard.increase()
    time.sleep(0.1)
    segsnake.move()

    if segsnake.head.xcor() >290 or segsnake.head.xcor() < -290 or segsnake.head.ycor() >290 or segsnake.head.ycor() <-290:
        scoreboard.reset()
        segsnake.reset()

    for segment in segsnake.all_box[1:]:
        if segsnake.head.distance(segment) < 10:
            scoreboard.reset()
            segsnake.reset()
        

screen.exitonclick()