from selenium import webdriver
from selenium.webdriver.common.by import By
from sys import exit
from time import sleep

readme_template :str = """
## Title: {title}

* **Video Link:** [{link}]({link})
* **Views**: {views}
* **Likes:** {likes}

* **Channel:** [{channel}]({channel_link})
* **Subs:** {sub_count}
"""

def scrap(link) -> None:
    driver = webdriver.Chrome()
    driver.get(link)
    sleep(3)

    body = driver.find_element(By.TAG_NAME, "body").text
    if "This video isn't available anymore" in body:
        print("Invalid Link")
        exit(1)

    title = [i.text for i in driver.find_elements(By.CLASS_NAME, "title") if i.text not in ["", " "]][0]
    views = driver.find_element(By.CLASS_NAME, "view-count").text
    channel = driver.find_element(By.CLASS_NAME, "ytd-channel-name").text
    channel_link = driver.find_element(By.LINK_TEXT, channel).get_attribute("href")
    sub_count = driver.find_element(By.ID, "owner-sub-count").text
    likes = driver.find_element(By.CLASS_NAME, "force-icon-button").text
    driver.quit()

    with open("stats.md", "w") as file:
        file.write(readme_template.format(
            title = title,
            link = link,
            views = views,
            likes = likes,
            channel = channel,
            channel_link = channel_link,
            sub_count = sub_count
            ).lstrip("\n"))


def main() -> None:
    link = input("Enter Youtube link > ")
    scrap(link)


# Start checkpoint
if __name__ == "__main__":
    main()
