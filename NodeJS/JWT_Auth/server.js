require('dotenv').config()

const express = require('express')
const server = express()
const jwt = require('jsonwebtoken')

server.use(express.json())

const posts = [
  {
    username: 'Person1',
    title: 'Post 1'
  },
  {
    username: 'Person2',
    title: 'Post 2'
  }
]


server.get('/posts', authenticateToken, (req, res) => {
  res.json(posts.filter(post => post.username === req.user.name))
})


function authenticateToken(req, res, next) {
  const authHeader = req.headers['authorization']
  const token = authHeader && authHeader.split(' ')[1]
  if (token == null) return res.sendStatus(401)
  jwt.verify(token, process.env.ACCESS_TOKEN_SECRET, (err, user) => {
    console.log(err)
    if (err) return res.sendStatus(403)
    req.user = user
    next()
  })
}

server.listen(3000)