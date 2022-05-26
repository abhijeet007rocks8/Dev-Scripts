import tkinter as tk
import tkinter.font as tkFont

class App:
    def __init__(self, root):
        #setting title
        root.title("Python WebCam Filter GUI")
        #setting window size
        width=600
        height=500
        screenwidth = root.winfo_screenwidth()
        screenheight = root.winfo_screenheight()
        alignstr = '%dx%d+%d+%d' % (width, height, (screenwidth - width) / 2, (screenheight - height) / 2)
        root.geometry(alignstr)
        root.resizable(width=False, height=False)

        GMessage_236=tk.Message(root)
        GMessage_236["anchor"] = "center"
        GMessage_236["bg"] = "#14213d"
        ft = tkFont.Font(family='Times',size=20)
        GMessage_236["font"] = ft
        GMessage_236["fg"] = "#333333"
        GMessage_236["justify"] = "center"
        GMessage_236["text"] = ""
        GMessage_236.place(x=0,y=0,width=600,height=500)

        GMessage_892=tk.Message(root)
        GMessage_892["anchor"] = "n"
        ft = tkFont.Font(family='Times',size=25)
        GMessage_892["font"] = ft
        GMessage_892["bg"] = "#14213d"
        GMessage_892["fg"] = "#fca311"
        GMessage_892["justify"] = "center"
        GMessage_892["text"] = "Python WebCam Filter"
        GMessage_892["relief"] = "flat"
        GMessage_892.place(x=150,y=30,width=300,height=80)

        GButton_332=tk.Button(root)
        GButton_332["bg"] = "#e5e5e5"
        ft = tkFont.Font(family='Times',size=10)
        GButton_332["font"] = ft
        GButton_332["fg"] = "#000000"
        GButton_332["justify"] = "center"
        GButton_332["text"] = "Gray"
        GButton_332.place(x=40,y=310,width=80,height=25)
        GButton_332["command"] = self.GButton_332_command

        GButton_915=tk.Button(root)
        GButton_915["bg"] = "#e5e5e5"
        ft = tkFont.Font(family='Times',size=10)
        GButton_915["font"] = ft
        GButton_915["fg"] = "#000000"
        GButton_915["justify"] = "center"
        GButton_915["text"] = "Sketch"
        GButton_915.place(x=40,y=370,width=80,height=25)
        GButton_915["command"] = self.GButton_915_command

        GButton_851=tk.Button(root)
        GButton_851["bg"] = "#e5e5e5"
        ft = tkFont.Font(family='Times',size=10)
        GButton_851["font"] = ft
        GButton_851["fg"] = "#000000"
        GButton_851["justify"] = "center"
        GButton_851["text"] = "Normal Cam"
        GButton_851.place(x=250,y=200,width=100,height=25)
        GButton_851["command"] = self.GButton_851_command

        GButton_275=tk.Button(root)
        GButton_275["bg"] = "#e5e5e5"
        ft = tkFont.Font(family='Times',size=10)
        GButton_275["font"] = ft
        GButton_275["fg"] = "#000000"
        GButton_275["justify"] = "center"
        GButton_275["text"] = "Thug Life"
        GButton_275.place(x=340,y=310,width=80,height=25)
        GButton_275["command"] = self.GButton_275_command

        GButton_859=tk.Button(root)
        GButton_859["bg"] = "#e5e5e5"
        ft = tkFont.Font(family='Times',size=10)
        GButton_859["font"] = ft
        GButton_859["fg"] = "#000000"
        GButton_859["justify"] = "center"
        GButton_859["text"] = "X-Ray"
        GButton_859.place(x=180,y=370,width=80,height=25)
        GButton_859["command"] = self.GButton_859_command

        GButton_571=tk.Button(root)
        GButton_571["bg"] = "#e5e5e5"
        ft = tkFont.Font(family='Times',size=10)
        GButton_571["font"] = ft
        GButton_571["fg"] = "#000000"
        GButton_571["justify"] = "center"
        GButton_571["text"] = "Inverse"
        GButton_571.place(x=340,y=370,width=80,height=25)
        GButton_571["command"] = self.GButton_571_command

        GButton_387=tk.Button(root)
        GButton_387["bg"] = "#e5e5e5"
        ft = tkFont.Font(family='Times',size=10)
        GButton_387["font"] = ft
        GButton_387["fg"] = "#000000"
        GButton_387["justify"] = "center"
        GButton_387["text"] = "B & W"
        GButton_387.place(x=480,y=310,width=80,height=25)
        GButton_387["command"] = self.GButton_387_command

        GButton_10=tk.Button(root)
        GButton_10["bg"] = "#e5e5e5"
        ft = tkFont.Font(family='Times',size=10)
        GButton_10["font"] = ft
        GButton_10["fg"] = "#000000"
        GButton_10["justify"] = "center"
        GButton_10["text"] = "Canny"
        GButton_10.place(x=480,y=370,width=80,height=25)
        GButton_10["command"] = self.GButton_10_command

        GButton_987=tk.Button(root)
        GButton_987["bg"] = "#ffa1a1"
        ft = tkFont.Font(family='Times',size=10)
        GButton_987["font"] = ft
        GButton_987["fg"] = "#000000"
        GButton_987["justify"] = "center"
        GButton_987["text"] = "Send Email"
        GButton_987.place(x=250,y=420,width=100,height=25)
        GButton_987["command"] = self.GButton_987_command

        GButton_691=tk.Button(root)
        GButton_691["bg"] = "#e5e5e5"
        ft = tkFont.Font(family='Times',size=10)
        GButton_691["font"] = ft
        GButton_691["fg"] = "#000000"
        GButton_691["justify"] = "center"
        GButton_691["text"] = "Dr. Strange"
        GButton_691.place(x=180,y=310,width=80,height=25)
        GButton_691["command"] = self.GButton_691_command

    def GButton_332_command(self):
        import Gray


    def GButton_915_command(self):
        import Sketch


    def GButton_851_command(self):
        import Normal_camera


    def GButton_275_command(self):
        import Thug_life


    def GButton_859_command(self):
        import Xray


    def GButton_571_command(self):
        import Inverse


    def GButton_387_command(self):
        import BlackAndWhite


    def GButton_10_command(self):
        import Canny


    def GButton_987_command(self):
        import email_sender


    def GButton_691_command(self):
        import DrStrange

if __name__ == "__main__":
    root = tk.Tk()
    app = App(root)
    root.mainloop()
