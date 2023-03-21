CREATE SCHEMA IF NOT EXISTS data;

CREATE TABLE IF NOT EXISTS emails
(
    email varchar(255) PRIMARY KEY,
    code  varchar(25)
);
