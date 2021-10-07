from selenium import webdriver
import time

chrome_browser = webdriver.Chrome(executable_path="./chromedriver")
chrome_browser.get("https://web.whatsapp.com")

time.sleep(35)

# user = "Mandariya🐒Daayan🧟"
user = input("Enter the exact name of the target as stored in your whatsapp -:")
# mess = "Testing"
message = input("Message to Spam-:")
# numberoftimes = 3
numberoftimes = int(input("Number of times to send the message-: "))

target = chrome_browser.find_element_by_xpath('//span[@title="{}"]'.format(user))
target.click()

for i in range(0, numberoftimes):
    messagebox = chrome_browser.find_element_by_xpath('//div[@class="_2A8P4"]')
    messagebox.send_keys(message+u'\u2764')
    time.sleep(10)
    send_button = chrome_browser.find_element_by_xpath('//button[@class="_1E0Oz"]')
    send_button.click()
    time.sleep(2)

messagebox = chrome_browser.find_element_by_xpath('//div[@class="_2A8P4"]')
messagebox.send_keys("Mission Accompolished")
time.sleep(10)
send_button = chrome_browser.find_element_by_xpath('//button[@class="_1E0Oz"]')
send_button.click()
