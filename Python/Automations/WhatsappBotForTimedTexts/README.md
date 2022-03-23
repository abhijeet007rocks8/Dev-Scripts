# Whatsapp bot for timed texts
Spams given text on WhatsApp at given time stamps

## Tech Stack
Python, Selenium

## Demonstration


## Basic Components
The script uses the selenium package.

## Running on local
1. Fork the repo clicking on the fork button in the top right corner

2. Clone the repo to your local machine using the following command 

```
git clone https://github.com/<your-github-username>/Dev-Scripts.git
```

3. Package to be installed: selenium==4.1.2. Run the following:

```
pip install selenium==4.1.2
```

4. You must add the chromedriver into the same directory according to your OS and Chrome version taken from here: https://chromedriver.chromium.org/home

5. Just run the spammer.py with command line arguments in the following format `message timestamp1 timestamp2`. There can be any number of timestamps. Message must be enclosed in string quotes and the timestamps should be stricly in number of seconds.

```
python scrape.py 'message to be spammed in string quotes' timestamp1 timestamp2 timestamp3 timestamp4 timestampN
```