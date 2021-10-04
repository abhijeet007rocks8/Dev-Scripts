package main

import (
	"encoding/json"
	"fmt"
	"net/http"
	"path"
	"strings"
)

// level 0 rest api
// get

type User struct {
	Name   string `json:"Name"`
	Rating string `json:"Rating"`
}

type allUsers []User

var users = allUsers{
	{
		Name:   "Umar",
		Rating: "10",
	},
	{
		Name:   "Farooq",
		Rating: "9",
	},
}

// Implemented by Axel Wagner
func shiftPath(p string) (head, tail string) {
	// outputs (cleaned path with from root ie /)
	p = path.Clean("/" + p)
	// find next occurence of /
	i := strings.Index(p[1:], "/") + 1
	//check if not empty next
	if i <= 0 {
		return p[1:], "/"
	}
	// return head and tail
	return p[1:i], p[i:]
}

func server(w http.ResponseWriter, r *http.Request) {
	var head string
	head, r.URL.Path = shiftPath(r.URL.Path)
	switch head {
	case "users":
		userPage(w, r)
	default:
		homePage(w, r)
	}
}


func homePage(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Landing Page!")
	fmt.Println("All rendered:yes")
}

func userPage(w http.ResponseWriter, r *http.Request) {
// implement all user data show here
	json.NewEncoder(w).Encode(users)
	fmt.Println("All rendered:yes")
}

func main() {
	mux := http.NewServeMux()
	mux.Handle("/", http.HandlerFunc(server))

	s := http.Server{
		Addr:    ":3000",
		Handler: mux,
	}
	fmt.Println("serve up at 3000")
	s.ListenAndServe()
}
