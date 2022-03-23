# 💲 **CRYPTO SCRAPER**
A webscraper written in golang, it can scrape prices of the top crypto currencies.

The scraper uses https://coinmarketcap.com/ to get all the data required.

## **👩‍💻Tech Stack**
- Go

## **📦 Basic Component**

- Go Colly https://pkg.go.dev/github.com/gocolly/colly@v1.2.0

## **💻 Running on Local**

- **Fork** & Clone the Repo.
```
git clone https://github.com/{github-username}/Dev-Scripts.git
```
- `cd` to `Go/Crypto-Scraper` in the terminal.
```
cd Go/Crypto-Scraper
```
```
go mod init Crypto-Scraper
```
```
go get github.com/gocolly/colly
```
- After installing the package run `go run main.go` to get the prices of the top crypto currencies.
```
go run main.go
```

![scraper-demo](https://user-images.githubusercontent.com/87603425/156574440-1a38d6d1-a5da-468c-8467-b4837adf692b.gif)
