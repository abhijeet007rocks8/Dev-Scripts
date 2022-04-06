## LinkedIn Connectin Scraper

A python script that scraps linkedin connections and saves it into a CSV file.

## Tech Stack

* Python
	* Pandas
	* Selenium

## Run Local

* Clone this repository

```bash
git clone https://github.com/abhijeet007rocks8/Dev-Scripts
```

* Change Directory

```bash
cd Dev-Scripts/"Web Development/BaseX_Calculator/"
```

* Download Chrome Driver from [here](https://sites.google.com/chromium.org/driver/)
Note: Download the one with the same version as chrome you have installed on your machine.

* Place ChromeDriver in that same directory

* Install required dependencies
```bash
pip3 install selenium pandas
```

* type the following command to run the script
```bash
python3 script.py -e <email> -p <password>
```

## How it works

* The script auto-logins to your account and waits 5 seconds to make sure the login was successfull.
* It then visits the `my network` page and starts scrolling the page up and down multiple times to reveal all the connections on the account
* After finishing the scrolling, the script scraps the html content and gets the name, headline, and profile link of each connection.
* Finally, It saves the scrapped data into a CSV file with the help of Pandas DataFrame.

## Demonstration Video

https://user-images.githubusercontent.com/64689436/162074932-f1c01e01-d038-4421-b8b8-e1265a4a5546.mp4
