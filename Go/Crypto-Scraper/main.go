package main

import (
	"fmt"

	"github.com/gocolly/colly"
)

var url string = "https://coinmarketcap.com/all/views/all/"

type CryptoCurrency struct {
	name  string
	price string
}

var CryptoList []CryptoCurrency

func main() {
	c := colly.NewCollector()

	c.OnRequest(func(request *colly.Request) {
		fmt.Println("Visiting", request.URL)
	})

	c.OnHTML(".cmc-table__table-wrapper-outer .cmc-table-row", func(e *colly.HTMLElement) {
		CCName := e.ChildText(".cmc-table__column-name--name")
		CCPrice := e.ChildText(".sc-1ow4cwt-0")
		cc := CryptoCurrency{CCName, CCPrice}
		CryptoList = append(CryptoList, cc)
	})

	c.Visit(url)

	for _, cc := range CryptoList {
		if cc.name != "" {
			fmt.Println(cc.name, cc.price)
		}
	}
}