const express = require("express")
const bodyParser = require("body-parser")
const sqlite3 = require("sqlite3").verbose()
const sqlite = require('sqlite')
const shortId = require("shortid")
const fs = require("fs")

const server = express()

server.set("view engine", "ejs")
server.use(express.urlencoded({extended: false}))


server.get("/", async (req, res) => {
	db = await db
	let links = await db.all(`SELECT * FROM urls;`);
	res.render("home.ejs", { links:links })
})

server.post("/", async (req, res) => {
	db = await db
	let url = req.body.url
	let short = shortId.generate()
	await db.run(`INSERT INTO urls (full, short) VALUES ("${url}", "${short}")`);
	res.redirect("/")
})

server.get("/:short_url", async (req, res) => {
	db = await db
	let short = req.params.short_url
	console.log(short)
	let full = await db.get(`SELECT full FROM urls WHERE short='${short}'`)
	if (full){
		res.redirect(full.full)
	}else{
		res.sendStatus(404)
	}

})


async function OpenDB() {
  return sqlite.open({
    filename: './urls.db',
    driver: sqlite3.Database
  })
}
async function Create(){
  let query = `CREATE TABLE urls(full, short);`;
  try{
    await db.run(query);
  }catch (err){
    console.log(err.message);
  }
}

let db = OpenDB()
let check = true
if (fs.existsSync("./urls.db")){
	check = false
}
if (check){
	Create()
}

server.listen(8080)