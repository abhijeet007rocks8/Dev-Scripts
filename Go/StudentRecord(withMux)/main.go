package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

type student struct {
	ID          string `json:"ID"`
	FirstName   string `json:"FirstName"`
	LastName    string `json:"Lastname"`
	RollNumber  string `json:"RollNumber"` 
	Email       string `json:"Email"`
	PhoneNumber string `json:"PhoneNumber"`
	Maths		string `json:"Maths"`
	Science		string `json:"Science"`
	SocialScience string `json:"SocialScience"`
	English		string `json:"English"`
	Hindi		string `json:"Hindi"`

}

type allstudents []student

var students = allstudents{
	{
		ID:				"1",
        FirstName:		"Umar",
		LastName:       "Farooq",
		RollNumber : 	"B180363CS",
        Email: 			"omar1024@protonmail.com",
		PhoneNumber:    "+91 123456789",
		Maths: 			"92",
		Science: 		"92",
		SocialScience: 	"92",
		English: 		"92",
		Hindi: 			"92",

    },
	{
		ID:				"2",
        FirstName:		"Atar",
		LastName:       "k",
		RollNumber : 	"B180323CS",
        Email: 			"omar1024@protonmail.com",
		PhoneNumber:    "+91 1234567789",
		Maths: 			"92",
		Science: 		"92",
		SocialScience: 	"92",
		English: 		"92",
		Hindi: 			"92",

    },
}

func homeLink(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hey Whats up!!")
}

func createstudent(w http.ResponseWriter, r *http.Request) {
	var newstudent student
	reqBody, err := ioutil.ReadAll(r.Body)
	if err != nil {
		fmt.Fprintf(w, "Kindly enter data in correct formatt in order to update")
	}

	json.Unmarshal(reqBody, &newstudent)

	students = append(students, newstudent)

	w.WriteHeader(http.StatusCreated)
	json.NewEncoder(w).Encode(newstudent)
}

func getOnestudent(w http.ResponseWriter, r *http.Request) {
	// Get the ID from the url
	studentID := mux.Vars(r)["id"]

	for _, singlestudent := range students {
		if singlestudent.ID == studentID {
			json.NewEncoder(w).Encode(singlestudent)
		}
	}
}

func getAllstudents(w http.ResponseWriter, r *http.Request) {
	json.NewEncoder(w).Encode(students)
}

func updatestudent(w http.ResponseWriter, r *http.Request) {
	studentID := mux.Vars(r)["id"]
	var updatedstudent student
	reqBody, err := ioutil.ReadAll(r.Body)
	if err != nil {
		fmt.Fprintf(w, "Kindly enter data with the student title and description only in order to update")
	}

	json.Unmarshal(reqBody, &updatedstudent)

	for i, singlestudent := range students {
		if singlestudent.ID == studentID {
			singlestudent.FirstName = updatedstudent.FirstName
			singlestudent.LastName = updatedstudent.LastName
			singlestudent.RollNumber = updatedstudent.RollNumber
            singlestudent.Email = updatedstudent.Email
			singlestudent.PhoneNumber = updatedstudent.PhoneNumber
			singlestudent.Maths = updatedstudent.Maths
			singlestudent.Science = updatedstudent.Science
			singlestudent.SocialScience = updatedstudent.SocialScience
			singlestudent.English = updatedstudent.English
			singlestudent.Hindi = updatedstudent.Hindi

			students[i] = singlestudent
			json.NewEncoder(w).Encode(singlestudent)
		}
	}
}

func deletestudent(w http.ResponseWriter, r *http.Request) {
	studentID := mux.Vars(r)["id"]

	for i, singlestudent := range students {
		if singlestudent.ID == studentID {
			students = append(students[:i], students[i+1:]...)
			fmt.Fprintf(w, "The student with ID %v has been deleted successfully", studentID)
		}
	}
}

func main() {
	router := mux.NewRouter().StrictSlash(true)
	router.HandleFunc("/", homeLink)
	router.HandleFunc("/student", createstudent).Methods("POST")
	router.HandleFunc("/students", getAllstudents).Methods("GET")
	router.HandleFunc("/students/{id}", getOnestudent).Methods("GET")
	router.HandleFunc("/students/{id}", updatestudent).Methods("PATCH")
	router.HandleFunc("/students/{id}", deletestudent).Methods("DELETE")
	log.Fatal(http.ListenAndServe(":8080", router))
}