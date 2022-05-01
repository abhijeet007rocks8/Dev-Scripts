import time as clock
import pyautogui as pygui

ID = input("Enter Meeting ID: ")
PASSCODE = input("Enter Meeting password: ")
DURATION = input("Enter total duration of meet in seconds")


def start():
    # opening zoom app
    pygui.hotkey("alt", "f2")
    clock.sleep(5)
    pygui.write("zoom")
    pygui.press("enter", interval=0.5)
    clock.sleep(5)

    # join button
    x_c, y_c = pygui.locateCenterOnScreen("img/join.png", confidence=0.9)
    clock.sleep(5)
    pygui.click(x_c, y_c)

    # adding ID
    clock.sleep(5)
    x_s, y_s = pygui.locateCenterOnScreen("img/s3.png", confidence=0.9)
    pygui.click(x_s, y_s)
    pygui.write(ID)

    # video off
    clock.sleep(5)
    x_s, y_s = pygui.locateCenterOnScreen("img/s2.png", confidence=0.9)
    pygui.click(x_s, y_s)

    # audio off
    clock.sleep(5)
    x_s, y_s = pygui.locateCenterOnScreen("img/s1.png", confidence=0.9)
    pygui.click(x_s, y_s)
    pygui.press("enter", interval=5)

    # entering a passcode
    pygui.write(PASSCODE)
    pygui.press("enter", interval=10)
    print("Hold (Ctrl+c) to exit the program ")

    # Total clock of zoom session
    clock.sleep(DURATION)

    # closing Zoom
    pygui.hotkey("alt", "f4")
    clock.sleep(0.5)
    pygui.hotkey("alt", "f4")


start()
