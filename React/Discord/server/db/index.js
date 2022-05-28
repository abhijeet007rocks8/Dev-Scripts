const { Client } = require("pg");

const isProduction = process.env.NODE_ENV === "production";
const connectionString = `postgresql://${process.env.PG_USER}:${process.env.PG_PASSWORD}@${process.env.PG_HOST}:${process.env.PG_PORT}/${process.env.PG_DATABASE}`;

const client = new Client({
  connectionString: isProduction ? process.env.DATABASE_URL : connectionString,
  ssl: isProduction ? { rejectUnauthorized: false } : false,
});

const query = async (text, params) => {
  return await client.query(text, params);
};

module.exports = {
  client,
  query,
};
