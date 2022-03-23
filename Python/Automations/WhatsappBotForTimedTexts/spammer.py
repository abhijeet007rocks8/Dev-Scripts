import sys
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time
import warnings

warnings.filterwarnings('ignore')

s=Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=s)
driver.get("https://web.whatsapp.com")

def spam(message, times):
    '''
    Parameters:
        message - The message in string format
        times - time stamps to spam on
    '''
    textfield_xpath = '//*[@id="main"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[2]'

    try:
        text_field = driver.find_element(by=By.XPATH, value=textfield_xpath)

        for duration in times:
            time.sleep(duration)
            text_field.send_keys(message)
            text_field.send_keys(Keys.ENTER)

    except:
        input('Something is not right. Check if you have logged in successfully or if you are inside an inbox. Then press any key.')
        spam(message, times)

input('\n\nAt this moment, You must log into your whatsapp account and open up the inbox to spam. Then press any key.')

message = sys.argv[1]
times = list(map(int, sys.argv[2:]))

spam(message, times)

print('COMPLETED.')