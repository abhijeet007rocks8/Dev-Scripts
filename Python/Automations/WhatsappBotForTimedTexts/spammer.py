import sys
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import warnings

warnings.filterwarnings('ignore')

driver = webdriver.Chrome(executable_path='Python/Automations/WhatsappBotForTimedTexts/chromedriver')
driver.get("https://web.whatsapp.com")

def spam(message, times):
    '''
    Parameters:
        message - The message in string format
        times - time stamps to spam on
    '''
    textfield_xpath = '//*[@id="main"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[2]'
    text_field = driver.find_element_by_xpath(textfield_xpath)

    for duration in times:
        time.sleep(duration)
        text_field.send_keys(message)
        text_field.send_keys(Keys.ENTER)

input('At this moment, You must log into your whatsapp account and open up the inbox to spam. Then press any key.')

message = sys.argv[1]
times = list(map(int, sys.argv[2:]))

spam(message, times)

print('COMPLETED.')