# Whatsapp bot for timed texts
Sends a given text message after a specified waiting time. This is different from the other [WhatsappSpamBot](https://github.com/abhijeet007rocks8/Dev-Scripts/tree/main/Python/Automations/WhatsappSpamBot) as this sends messages on specified time in contrast to the other one that spams messages instantaniously for a given number of times.

## Tech Stack
Python, Selenium

## Demonstration
![Demo Recording](Demo.gif)

## Basic Components
The script uses the selenium package.

## Running on local
1. Fork the repo clicking on the fork button in the top right corner

2. Clone the repo to your local machine using the following command 

```
git clone https://github.com/<your-github-username>/Dev-Scripts.git
```

3. Package to be installed: selenium==4.1.2, webdriver-manager==3.5.4. Run the following:

```
pip install selenium==4.1.2
pip install webdriver-manager==3.5.4
```
4. Just run the messenger.py with command line arguments in the following format `message wait_time`. Message must be enclosed in string quotes and the time should be stricly in number of seconds.

```
python messenger.py 'message to be sent in string quotes' wait_time
```