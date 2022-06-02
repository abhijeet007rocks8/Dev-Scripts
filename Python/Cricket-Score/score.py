






# Cricket Live Score Update using Python:
# TRIDIB BAG , GSSoC'22 Contributor
import requests

from bs4 import BeautifulSoup




url = "http://static.cricinfo.com/rss/livescores.xml"

r = requests.get(url)



while r.status_code != 200:


    r = requests.get(url)




soup = BeautifulSoup(r.text , 'html.parser')



data = soup.find_all('description')






score = data[1].text



print("                                                   Welcome ! to CRICKET UPDATE:")


print("********************************************************Current Live Score Score is ********************************************************")


print(score)