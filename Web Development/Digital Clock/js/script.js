//getting time variables

const hours = document.querySelector("#hours");
const minutes = document.querySelector("#minutes");
const seconds = document.querySelector("#seconds");
const greetings = document.querySelector(".greetings");
const day = document.querySelector("#day");
const date = document.querySelector("#date");
const month = document.querySelector("#month");
const year = document.querySelector("#year");

//setting all things only first time
(function(){
    
    setSeconds();
    setMinutes(new Date());
    setHours(new Date());
    setDate();
}());

//calling second function in 1 second
setInterval(setSeconds,1000);



function setSeconds(){
    var date = new Date();
    let sec = date.getSeconds();

    if(sec<=9)
    sec = ('0'+sec);

    // and displaying seconds
    seconds.innerHTML = sec;

    //calling minutes function
    if(sec==0)
    setMinutes(date);
}

//setting minutes
function setMinutes(date){
    let min = date.getMinutes();
    if(min<=9)
    min = ('0'+min);
    
    //displaying minutes;
    minutes.innerText = min;

    //calling hours function
    if(min==0)
    setHours(date);
}

//setting hours
function setHours(date){
    let hour = date.getHours();
    
    if(hour>12)
    hour-=12;
    
    if(hour<=9)
    hour = ('0'+hour)

    if(hour==0)
    hour = 12;
    
    //displaying hours
    hours.innerText = hour;

  //setting greeting line
  setGreetings(new Date().getHours());  

  //setting date
  if(hour==12)
  setDate();
}

function setGreetings(hour){
    
    if(hour<12)
        greetings.innerText = "Good Morning.";

    else if((hour>=12) && (hour<=17))
        greetings.innerText = "Good Afternoon.";
    
    else if((hour>17) && (hour<=20))
    greetings.innerText = "Good Evening.";

    else
    greetings.innerText = "Good Night.";

}

//setting date
function setDate(){
    var $_date = new Date();
    day.innerText = ($_date.toString().slice(0,3));

    date.innerText = $_date.getDate();

    month.innerText = $_date.toString().substr(4,3);

    year.innerText = $_date.getFullYear();
}