CREATE SCHEMA data;

CREATE TABLE products
(
    id               uuid PRIMARY KEY,
    date_time_create timestamp(6)   NOT NULL,
    date_time_update timestamp(6)   NOT NULL,
    title            text           NOT NULL,
    weight           numeric(19, 2) NOT NULL,
    calories         numeric(19, 2) NOT NULL,
    proteins         numeric(19, 2) NOT NULL,
    fats             numeric(19, 2) NOT NULL,
    carbohydrates    numeric(19, 2) NOT NULL
);

CREATE TABLE recipes
(
    id               uuid PRIMARY KEY,
    date_time_create timestamp(6) WITH TIME ZONE NOT NULL,
    date_time_update timestamp(6) WITH TIME ZONE NOT NULL,
    title            text                        NOT NULL
);

CREATE TABLE recipe_composition
(
    id         uuid PRIMARY KEY,
    recipe_id  uuid NOT NULL REFERENCES recipes (id),
    product_id uuid NOT NULL REFERENCES products (id),
    weight     numeric(19, 2)
);
