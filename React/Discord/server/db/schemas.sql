CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(32) NOT NULL,
    password_hash VARCHAR(72) NOT NULL,
    avatar_color VARCHAR(7) DEFAULT '#5865f2'
);

CREATE TABLE channels (
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE messages (
    id SERIAL PRIMARY KEY,
    channel_id INTEGER REFERENCES channels (id) NOT NULL,
    author_id INTEGER REFERENCES users (id) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ
);
