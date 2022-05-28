const bcrypt = require("bcrypt");
const usersRouter = require("express").Router();

const db = require("../db");
const { renameKeysSnakeToCamel } = require("../utils/caseConverter");

// Get a user's profile
usersRouter.get("/:id", async (request, response) => {
  const userId = request.params.id;

  try {
    const result = await db.query(
      "SELECT id, username, avatar_color FROM users WHERE id = $1",
      [userId]
    );
    response.status(200).json(renameKeysSnakeToCamel(result.rows[0]));
  } catch (err) {
    console.log(err);
    response.status(500).send("A database error has occurred");
  }
});

// Create a new user
usersRouter.post("/", async (request, response) => {
  const { username, password } = request.body;

  let result;
  try {
    result = await db.query("SELECT * FROM users WHERE username = $1", [
      username,
    ]);
    if (result.rowCount) {
      response.status(400).send("The username has already been taken");
      return;
    }

    // Use bcrpyt to create password hash
    const saltRounds = 10;
    const passwordHash = await bcrypt.hash(password, saltRounds);

    // Pick a random color for avatar
    const avatarColors = ["#ed4245", "#f9a517", "#5865f2", "#3aa55c"];
    const avatarColor =
      avatarColors[Math.floor(Math.random() * avatarColors.length)];

    result = await db.query(
      "INSERT INTO users (username, password_hash, avatar_color) VALUES ($1, $2, $3) RETURNING id",
      [username, passwordHash, avatarColor]
    );
    const newId = result.rows[0].id;
    response.status(201).send(`User added with ID: ${newId}`);
  } catch (err) {
    console.log(err);
    response.status(500).send("A database error has occurred");
  }
});

// Authenticate a user
usersRouter.post("/login", async (request, response) => {
  const { username, password } = request.body;

  try {
    const result = await db.query("SELECT * FROM users WHERE username = $1", [
      username,
    ]);
    const isPasswordCorrect =
      result.rowCount === 0
        ? false
        : await bcrypt.compare(password, result.rows[0].password_hash);
    if (isPasswordCorrect) {
      const { password_hash, ...rest } = result.rows[0];
      response.status(200).json(renameKeysSnakeToCamel(rest));
    } else {
      response.status(401).json("Invalid username or password");
    }
  } catch (err) {
    console.log(err);
    response.status(500).send("A database error has occurred");
  }
});

module.exports = usersRouter;
