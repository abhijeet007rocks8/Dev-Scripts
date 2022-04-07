import requests
from tkinter import *
from datetime import datetime
import pytz
from tkinter import messagebox
import mysql.connector

# sql
mysqlusername = 'root'
mysqlpassword = 'root'      # Enter your own sql password

# checking if database is there or not
try:
    mydb = mysql.connector.connect(host='localhost', username=mysqlusername,
                                   password=mysqlpassword,
                                   database='weatherapp')
    mycursor = mydb.cursor()

# if not making database and table to store location names
except mysql.connector.errors.ProgrammingError:
    mydb = mysql.connector.connect(host='localhost', username=mysqlusername,
                                   password=mysqlpassword)
    mycursor = mydb.cursor()
    mycursor.execute("Create database weatherapp")
    mydb = mysql.connector.connect(host='localhost', username=mysqlusername,
                                   password=mysqlpassword,
                                   database='weatherapp')
    mycursor = mydb.cursor()
    mycursor.execute("Create table location(name char(20) )")

# gui
root = Tk()
root.geometry("1156x650")
bg = PhotoImage(file="weather.png")
label1 = Label(root, image=bg).place(x=0, y=0)
root.title("Weather")
root.iconbitmap("Papirus-Team-Papirus-Apps-Weather.ico")


label_temp = Label(root, text="26°",  fg="white", bg="#78b6db",
                   font=("bold", 80))
label_temp.place(x=110, y=453)

city_name = Label(root, text="@BeLimitLess", fg="white", bg="#83b9de",
                  font=("bold", 35))
city_name.place(x=300, y=480)

date = datetime.now().strftime("%I:%M - %A,%d %b '%y")

time = Label(root, text=date, fg="white", bg="#90c1df",
             font=("Arial", 11))
time.place(x=300, y=533)

weathertypenear = Label(root, text="Sunny", fg="white", bg="#97c4e1",
                        font=("Arial", 11))
weathertypenear.place(x=530, y=533)

text = StringVar()
text.set("Enter location")
location = Entry(root, width=20, border=0, bg="#3f698a", textvariable=text,
                 fg="#96aab8", font=("Arial", 11))
location.place(x=772, y=65)

line = Label(root, text="-"*130, fg="white", bg="#3f698a",
             font=("Arial", 4)).place(x=770, y=85)

list1 = Listbox(root, fg="#96aab8", bg="#3f698a", highlightcolor="#3f698a", borderwidth=0, border=0, highlightthickness=0,
                font=("Arial", 11), width=40, height=10)
list1.place(x=770, y=115)

line2 = Label(root, text="-"*160, fg="white", bg="#3f698a",
              font=("Arial", 4)).place(x=770, y=330)
weather_details = Label(root, text="Weather Details", fg="white", bg="#3f698a",
                        font=("Arial", 11))
weather_details.place(x=770, y=370)

cloud = Label(root, text="Cloudy", fg="#96aab8", bg="#3f698a",
              font=("Arial", 11))
cloud.place(x=770, y=430)

cloudval = Label(root, text="12%", fg="white", bg="#3f698a",
                 font=("Arial", 11))
cloudval.place(x=1070, y=430)

humidity = Label(root, text="Humidity", fg="#96aab8", bg="#3f698a",
                 font=("Arial", 11))
humidity.place(x=770, y=478)

humidity_value = Label(root, text="78%", fg="white", bg="#3f698a",
                       font=("Arial", 11))
humidity_value.place(x=1070, y=478)

wind = Label(root, text="Wind", fg="#96aab8", bg="#3f698a",
             font=("Arial", 11))
wind.place(x=770, y=526)

wind_value = Label(root, text="1km/h", fg="white", bg="#3f698a",
                   font=("Arial", 11))
wind_value.place(x=1063, y=526)

rain = Label(root, text="Rain", fg="#96aab8", bg="#3f698a",
             font=("Arial", 11))
rain.place(x=770, y=574)

rain_value = Label(root, text="0mm", fg="white", bg="#3f698a",
                   font=("Arial", 11))
rain_value.place(x=1063, y=574)

line3 = Label(root, text="-"*175, fg="white", bg="#3f698a",
              font=("Arial", 4)).place(x=768, y=611)

exitimg = PhotoImage(file="exit.png")
exit_button = Button(root, width=35, bg="#3f698a",
                     height=32, borderwidth=0, image=exitimg, command=root.quit).place(x=1118, y=614)

# adding all values from table to list
mycursor.execute("Select * from location")
for x in mycursor:
    a = str((x))
    list1.insert(0, "")
    list1.insert(0, a.strip("()'',"))


def weatherdata():
    if(location.get()):            # getting location name from entry
        City = location.get()
    elif(list1.get(ACTIVE)):            # getting location name from list
        City = list1.get(ACTIVE)
        list1.select_clear(END)
    else:                               # if not avaible show error
        messagebox.showerror("Error", "Enter the location!!")

    Api_Key = "c00bce2c88c5489da4d120729211011"  # Enter your own api key
    Final_Url = "http://api.weatherapi.com/v1/current.json?key={}&q={}".format(
        Api_Key, City)
    Result = requests.get(Final_Url)
    Data = Result.json()

    key = 'error'
    if key in Data:                     # checking if data is correct that we want
        messagebox.showerror("Error", "Invalid Location")
    else:
        tempreature = "{:.0f}".format(Data["current"]["temp_c"])
        cityname = Data["location"]["name"]

        # adding location name to sql
        mycursor.execute(f"Insert into location values('{cityname}') ")
        mydb.commit()

        # getting and sorting the values from data which we got from api
        weathertypeneardate = Data["current"]["condition"]["text"]
        humidityupdated = str(Data["current"]["humidity"]) + "%"
        wind_speed = str(Data["current"]["wind_kph"])+"kph"
        cloudperc = str(Data["current"]["cloud"]) + "%"
        rainval = str(Data["current"]["precip_mm"]) + "mm"

        # getting time according to timezone
        converted = pytz.timezone(Data["location"]["tz_id"])
        dateTimeObj = datetime.now(converted)
        datenew = dateTimeObj.strftime("%I:%M - %A,%d %b '%y")

        # updating all gui values
        label_temp.config(text=tempreature+"°")
        city_name.config(text=cityname)
        time.config(text=datenew)
        cloudval.config(text=cloudperc)
        humidity_value.config(text=humidityupdated)
        wind_value.config(text=wind_speed)
        weathertypenear.config(text=weathertypeneardate)
        rain_value.config(text=rainval)
        location.delete(0, END)
        location.insert(0, "")
        list1.insert(0, "")
        list1.insert(0, cityname)


search = PhotoImage(file="search2.png")
search_button = Button(root, width=90,
                       height=85, border=0, image=search, command=weatherdata).place(x=1063, y=3)


root.mainloop()
