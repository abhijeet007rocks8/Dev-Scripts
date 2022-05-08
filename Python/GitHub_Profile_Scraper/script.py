from selenium import webdriver
from selenium.webdriver.common.by import By


link = input("Enter user URL > ")
if link[-1] == "/":
    user = link.split('/')[-2]
else:
    user = link.split('/')[-1]


# XPaths patterns
full_name_pattern = "//span[contains(@class, 'vcard-fullname')]"
user_name_pattern = "//span[contains(@class, 'vcard-username')]"
user_bio_pattern = "//div[contains(@class, 'user-profile-bio')]"
total_repos_pattern = f"//a[contains(@href, '/{user}?tab=repositories')]"
latest_activity_pattern = "//div[contains(@class, 'contribution-activity-listing')]"

# Other configs
actions = ["Created", "Reviewed", "Opened"]

def scrap(link):
    driver = webdriver.Chrome()
    driver.get(link)
    
    full_name = driver.find_element(By.XPATH, full_name_pattern).text
    user_name = driver.find_element(By.XPATH, user_name_pattern).text
    bio = driver.find_element(By.XPATH, user_bio_pattern).text
    repos = driver.find_element(By.XPATH, total_repos_pattern).text
    latest_activity = driver.find_element(By.XPATH, latest_activity_pattern).text.split("\n")
    
    latest_activity_parsed : dict = {}
    current_activity : str
    for activity in latest_activity[1:]:
        if activity.split(" ")[0] in actions:
            latest_activity_parsed[activity] = []
            current_activity = activity
        else:
            latest_activity_parsed[current_activity].append(activity)
    driver.quit()

    return full_name, user_name, bio, repos, latest_activity_parsed


def create_readme(full_name, user_name, bio, repos, latest_activity_parsed):
    Template = f"""# {full_name}
## {user_name}

### Bio
{bio}

### Repos Count: {repos}

### Activity

    """
    for action in latest_activity_parsed.keys():
        Template += f"\n#### {action}\n\n"
        for activity in latest_activity_parsed[action]:
            if "•" in activity:
                continue
            Template += f"* {activity}\n"

    with open("summary.md", "w") as file:
        file.write(Template)


if __name__ == "__main__":
    full_name, user_name, bio, repos, latest_activity_parsed = scrap(link)
    create_readme(full_name, user_name, bio, repos, latest_activity_parsed)