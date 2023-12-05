CREATE SEQUENCE IF NOT EXISTS users_seq
      MINVALUE 1
      MAXVALUE 999999999
      INCREMENT BY 1
      START WITH 1;

CREATE TYPE user_role AS ENUM ('admin', 'default', 'courier');

CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(32) NOT NULL,
    second_name VARCHAR(32) NOT NULL,
    login VARCHAR(32) NOT NULL UNIQUE,
    phone_number CHAR(11) NOT NULL UNIQUE,
    email VARCHAR(64) UNIQUE,
    password VARCHAR(64) NOT NULL,
    role user_role NOT NULL
);