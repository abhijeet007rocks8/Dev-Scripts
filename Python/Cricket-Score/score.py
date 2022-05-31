
# PYTHON CRICKET SCORE UPDATE:
import requests



from bs4 import BeautifulSoup


import requests

import time

url="https://www.cricbuzz.com/cricket-series/3806/west-indies-tour-of-netherlands-2022"

while True:

    time.sleep(10)

    response=requests.get(url)



    soup=BeautifulSoup(response.text,'lxml')




    score_card=soup.find('div',class_='cb-font-20 text-bold inline-block ng-binding').span.text









    print("current Score is \n {}".format(score_card))
