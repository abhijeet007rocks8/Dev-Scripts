from bs4 import BeautifulSoup
import requests
import sys

def scrape_pages(url):
    '''
    For scraping article and getting its title and body(p tags content)
    '''
    try:
        res = requests.get(url)

        if res.status_code == 200:
            soup = BeautifulSoup(res.content, 'html.parser')

            title = soup.title.text

            p_content = soup.findAll('p')
            p_content = " ".join([p.text for p in p_content])

    except:
        print("Some exception occured.")

    return title, p_content


if __name__ == '__main__':

    for i,url in enumerate(sys.argv[1:]):
        title, body = scrape_pages(url)
        with open(f'{i}.txt', 'w') as f:
            f.write(title+'\n\n')
            f.write(body)
        print(title)
        print(body)




#***********************  Made By: Vishesh  ************************ #
#*************** https://github.com/visheshks04 *********************#