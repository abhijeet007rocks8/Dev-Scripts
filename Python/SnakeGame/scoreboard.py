from turtle import Turtle

class Scoreboard(Turtle):
    def __init__(self):
        super().__init__()
        self.ht()
        self.highscore = 0
        with open("data.txt") as file:
            x= file.read()
            self.highscore = int(x)
        self.penup()
        self.goto(x=0, y=270)
        self.score=0
        self.color("white")
        self.write(f"Score: {self.score} High Score: {self.highscore}", align="center", font=("Ariel", 15, "normal"))

    def increase(self):
        self.score+=1
        self.clear()
        self.write(f"Score: {self.score} High Score: {self.highscore}", align="center", font=("Ariel", 15, "normal"))

    def reset(self):
        if self.score>self.highscore:
            self.highscore=self.score
            with open("data.txt", mode="w") as file:
                file.write(str(self.highscore))
        self.score=0
    # def gameover(self):
    #     self.goto(x=0, y=0)
    #     self.write("Game Over", align="center", font=("Ariel", 30, "normal"))
    #     self.goto(x=0, y=-20)
    #     self.write(f"Score: {self.score}", align="center", font=("Ariel", 15, "normal"))
    #