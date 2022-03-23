import sys
from selenium import webdriver
import time

def spam(message, times):
    '''
    Parameters:
        message - The message in string format
        times - time stamps to spam on
    '''
    textfield_xpath = '//div[@class="_2A8P4"]'
    text_field = driver.find_element_by_xpath(textfield_xpath)

    for duration in times:
        time.sleep(duration)
        text_field.send_keys(message)
        text_field.send_keys(Keys.ENTER)

chrome_browser = webdriver.Chrome(executable_path='Python/Automations/WhatsappBotForTimedTexts/chromedriver')
chrome_browser.get("https://web.whatsapp.com")

print('At this moment, You must log into your whatsapp account and open up the inbox to spam.')

time.sleep(35)

message = sys.argv[1]
times = sys.argv[2:]

spam(message, times)

print('COMPLETED.')