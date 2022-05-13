import requests
import html
import wget
import os

def main(link) -> None:
	html_s = requests.get(link)
	html_s = html.unescape(html_s.text)
	html_s = html_s.split()
	for element in html_s:
		element = html.unescape(element)
		if "dms.licdn.com" in element:
			vid_link = 	element.split(",")[0].split('"src":')[1][1:-1]
			download = wget.download(vid_link, out="./video.mp4")
			return None
	print("Couldn't find video :\\")
	return None


if __name__ == "__main__":
	# Test URL
	# https://www.linkedin.com/posts/github_github-command-palette-activity-6927979787500101632-3Xz-?utm_source=linkedin_share&utm_medium=member_desktop_web
	link = input("Enter LinkedIn video link > ")
	main(link)