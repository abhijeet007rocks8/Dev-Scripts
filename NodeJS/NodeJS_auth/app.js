if(process.env.NODE_ENV != "production"){
	require("dotenv").config()
}

const express = require("express")
const bodyParser = require('body-parser')
const bcrypt = require("bcrypt")
const passport = require("passport")
const flash = require("express-flash")
const session = require("express-session")
const methodOverride = require("method-override")

// Required Options
const server = express()
const initializePassport = require("./passport-config")
initializePassport(passport,
	email => users.find(user => user.email === email),
	id => users.find(user => user.id === id)
	)

// Demo Database
const users = []

// Server Options
server.set("view-engine", "ejs")
server.set(express.urlencoded({extended: false}))
server.use(bodyParser())
server.use(flash())
server.use(session({
	secret: process.env.SESSION_SEC,
	resave: false,
	saveUninitialized: false
}))
server.use(passport.initialize())
server.use(passport.session())
server.use(methodOverride("_method"))


// --- Server Routes --- //
server.get("/", is_authenticated, (req, res) => {
	res.render("index.ejs", {"user": req.user.name })
})


server.get("/login", is_not_authenticated, (req, res) => {
	res.render("login.ejs")
})
server.post("/login", is_not_authenticated, passport.authenticate("local", {
	successRedirect: "/",
	failureRedirect: "/login",
	failureFlash: true
}))


server.get("/register", is_not_authenticated, (req, res) => {
	res.render("register.ejs")
})
server.post("/register", is_not_authenticated, async (req, res) => {
	try{
		const hash = await bcrypt.hash(req.body.password, 10)
		let user = {
			id: Date.now().toString(),
			name: req.body.name,
			email: req.body.email,
			password: hash
		}
		users.push(user)
		res.redirect("/login")
	}catch{
		res.redirect("/register")
	}
})


server.delete("/logout", (req, res) => {
	req.logOut()
	res.redirect("/login")
})
// --- Server Routes --- //


// --- MiddleWare --- //
function is_authenticated(req, res, next) {
	if (req.isAuthenticated()){
		return next()
	}
	res.redirect("/login")
}

function is_not_authenticated(req, res, next){
	if (req.isAuthenticated()){
		return res.redirect("/")
	}
	next()
}

server.listen(8080)