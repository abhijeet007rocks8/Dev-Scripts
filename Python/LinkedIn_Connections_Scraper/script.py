from selenium.webdriver.common.action_chains import ActionChains
from optparse import OptionParser
from selenium import webdriver
import pandas as pd
import time
import sys
import re

pattern_name = "\\n(.+)\\n"  # Used to extract names
pattern_headline = 'occupation\\n(.+)\\n'  # Used to extract headlines

# Help menu
usage = """
<Script> [Options]

[Options]
    -h, --help        Show this help message and exit.
    -e, --email       Enter login email
    -p, --password    Enter login password

This will scrap all LinkedIn connections list with there corresponding Name, Headline, and Profile link.
"""

# Load args
parser = OptionParser()
parser.add_option("-e", "--email", dest="email", help="Enter login email")
parser.add_option("-p", "--password", dest="password",
                  help="Enter login password")


def login(email, password):
    """LinkedIn automated login function"""
    # Get LinkedIn login page
    driver = webdriver.Chrome("chromedriver.exe")
    driver.get("https://www.linkedin.com")
    # Locate Username field and fill it
    session_key = driver.find_element_by_name("session_key")
    session_key.send_keys(email)
    # Locate Password field and fill it
    session_password = driver.find_element_by_name("session_password")
    session_password.send_keys(password)
    # Locate Submit button and click it
    submit = driver.find_element_by_class_name("sign-in-form__submit-button")
    submit.click()
    time.sleep(5)
    # Return session
    return driver


def scrap_basic(driver):
    """Returns 3 lists of Names, Headlines, and Profile Links"""
    driver.get("https://www.linkedin.com/mynetwork/invite-connect/connections/")
    # Bypassing Ajax Call through scrolling the page up and down multiple times
    # Base case is when the height of the scroll bar is constant after 2 complete scrolls
    time_to_wait = 3  # Best interval for a 512KB/Sec download speed - Change it according to your internet speed
    last_height = driver.execute_script("return document.body.scrollHeight")
    while True:
        # Scroll down to bottom
        driver.execute_script(
            "window.scrollTo(0, document.body.scrollHeight);")

        # This loop is for bypassing a small bug upon scrolling that causes the Ajax call to be cancelled
        for i in range(2):
            time.sleep(time_to_wait)
            driver.execute_script("window.scrollTo(0, 0);")  # Scroll up to top
            time.sleep(time_to_wait)
            # Scroll down to bottom
            driver.execute_script(
                "window.scrollTo(0, document.body.scrollHeight);")

        new_height = driver.execute_script(
            "return document.body.scrollHeight")  # Update scroll bar height
        if new_height == last_height:
            break
        last_height = new_height

    # Extract card without links
    extracted_scrap = driver.find_elements_by_class_name(
        "mn-connection-card__details")
    extracted_scrap = [_.text for _ in extracted_scrap]
    # Append data to a seperate list
    names = []
    headlines = []
    for card in extracted_scrap:
        # Try statements just in case of headline/name type errors
        try:
            names.append(re.search(pattern_name, card)[0])
        except:
            names.append(" ")

        try:
            headlines.append(re.search(pattern_headline, card)[0])
        except:
            headlines.append(" ")

    # Extract links
    extracted_scrap = driver.find_elements_by_tag_name('a')
    links = []
    for i in extracted_scrap:
        link = i.get_attribute("href")
        if "https://www.linkedin.com/in" in link and not link in links:
            links.append(link)
    # Return outputs
    return driver, names, headlines, links

def save_to_csv(names, headlines, links):
    # Make a dataframe and append data to it
    df = pd.DataFrame()
    for i in range(len(names)):
        df = df.append({"Name": names[i], "Headline": headlines[i],
                       "Link": links[i]}, ignore_index=True)
    # Save to CSV
    df.to_csv("scrap.csv", index=False, columns=[
              "Name", "Headline", "Link"])


# Start checkpoint
if __name__ == "__main__":
    (options, args) = parser.parse_args()

    # Inputs
    email = options.email
    password = options.password

    driver = login(email, password)  # Login Phase
    print("Successfull Login!")
    print("Commencing 'My-Connections' list scrap...")
    driver, names, headlines, links = scrap_basic(driver)  # Basic Scrap Phase
    print("Finished basic scrap, scrapped {}".format(len(names)))

    save_to_csv(names, headlines, links)  # Save to CSV

    print("Scrapping session has ended.")
    # End Session
    driver.quit()
