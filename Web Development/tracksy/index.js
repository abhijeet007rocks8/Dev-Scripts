const inputBtn = document.getElementById("input-btn")
const inputEl = document.getElementById("input-el")
const ulEl = document.getElementById("ul-el")
const deleteBtn = document.getElementById("delete-btn")
const tabBtn = document.getElementById("tab-btn")
let myLeads = []
const leadsFromLocalStorage = JSON.parse(localStorage.getItem("myLeads"))

if(leadsFromLocalStorage){
  myLeads = leadsFromLocalStorage
  renderLeads()
}

tabBtn.addEventListener("click", function(){
  chrome.tabs.query({active: true, currentWindow: true}, function(tabs){
  myLeads.push(tabs[0].url)
  localStorage.setItem("myLeads", JSON.stringify(myLeads))
  renderLeads(myLeads)
})
  })



function renderLeads() {
  let listItems = " "
  for (let i = 0; i < myLeads.length; i++) {
    listItems += `<li>
   <a target = '_blank' href = '${myLeads[i]}'>
   ${myLeads[i]} 
   </a>
   </li>`
    console.log(listItems)
  }
  ulEl.innerHTML = listItems
}

deleteBtn.addEventListener('dblclick', function(){
  localStorage.clear()
  myLeads = []
  renderLeads()
})


inputBtn.addEventListener("click", function () {
  myLeads.push(inputEl.value)
  inputEl.value = " "
  localStorage.setItem("myLeads", JSON.stringify(myLeads)) //converting the stored value in string
  renderLeads()
  console.log(localStorage.getItem("myLeads"))
}) 
