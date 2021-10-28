from turtle import Turtle
SIZE = 3
MOVE_DISTANCE = 20
RIGHT =0
DOWN = 270
UP = 90
LEFT = 180


class Snake:

    def __init__(self):
        self.all_box = []
        self.create_snake()
        self.head = self.all_box[0]

    def create_snake(self):
        for i in range(0, SIZE):
            tim = Turtle(shape="square")
            tim.penup()
            tim.color("white")
            tim.goto(x=(-20 * i), y=0)
            self.all_box.append(tim)

    def move(self):
        for seg in range(len(self.all_box) - 1, 0, -1):
            new_x = self.all_box[seg - 1].xcor()
            new_y = self.all_box[seg - 1].ycor()
            self.all_box[seg].goto(new_x, new_y)
        self.all_box[0].forward(MOVE_DISTANCE)

    def Up(self):
        if(self.head.heading()!=DOWN):
            self.head.setheading(UP)

    def Down(self):
        if (self.head.heading() != UP):
            self.head.setheading(DOWN)

    def Left(self):
        if (self.head.heading() != RIGHT):
            self.head.setheading(LEFT)

    def Right(self):
        if (self.head.heading() != LEFT):
            self.head.setheading(RIGHT)

    def addbox(self):
        tim = Turtle(shape="square")
        tim.penup()
        tim.color("white")
        self.all_box.append(tim)

    def reset(self):
        for seg in self.all_box:
            seg.goto(x=1000, y=1000)
        self.all_box.clear()
        self.create_snake()
        self.head=self.all_box[0]