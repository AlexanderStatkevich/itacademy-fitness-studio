CREATE SCHEMA IF NOT EXISTS data;

CREATE TABLE data.products
(
    uuid             uuid PRIMARY KEY,
    date_time_create timestamp(6)   NOT NULL,
    date_time_update timestamp(6)   NOT NULL,
    title            text           NOT NULL,
    weight           numeric(19, 2) NOT NULL,
    calories         numeric(19, 2) NOT NULL,
    proteins         numeric(19, 2) NOT NULL,
    fats             numeric(19, 2) NOT NULL,
    carbohydrates    numeric(19, 2) NOT NULL
);

CREATE TABLE data.recipes
(
    uuid             uuid PRIMARY KEY,
    date_time_create timestamp(6) NOT NULL,
    date_time_update timestamp(6) NOT NULL,
    title            text         NOT NULL
);

CREATE TABLE data.recipe_compositions
(
    uuid       uuid PRIMARY KEY,
    recipe_id  uuid NOT NULL REFERENCES data.recipes (uuid),
    product_id uuid NOT NULL REFERENCES data.products (uuid),
    weight     numeric(19, 2)
);
