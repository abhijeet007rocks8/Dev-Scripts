const api = "http://api.quotable.io/random"
const quote_dom = document.getElementById("quote")
const input_dom = document.getElementById("input")
const timer_dom = document.getElementById("timer")

input_dom.addEventListener("input", () => {
	let quote_spans = quote_dom.querySelectorAll("span")
	let input_values = input_dom.value.split("")
	let correct = true

	quote_spans.forEach((char, index) => {
		let c = input_values[index]
		if(c == null){
			char.classList.remove("correct")
			char.classList.remove("incorrect")
			correct = false
		}else if (c === char.innerText){
			char.classList.add("correct")
			char.classList.remove("incorrect")
		}else{
			char.classList.add("incorrect")
			char.classList.remove("correct")
			correct = false
		}
	})

	if (correct){
		getNextQuote()
	}
})


function getQuote(){
	return fetch(api)
			.then(response => response.json())
			.then(data => data.content)

}


async function getNextQuote(){
	let quote = await getQuote()
	quote_dom.innerHTML = ""
	quote.split("").forEach( char => {
		let char_span = document.createElement("span")
		char_span.innerText = char
		quote_dom.appendChild(char_span)

	})
	input_dom.value = null
	startTimer()
}

let startTime
function startTimer(){
	timer_dom.innerHTML = 0
	startTime = new Date()
	setInterval(() => {
		timer.innerText = getTime()
	}, 1000)
}

function getTime(){
	return Math.floor((new Date() - startTime) / 1000)
}

getNextQuote()