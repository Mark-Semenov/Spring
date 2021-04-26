BEGIN;

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255),
    password VARCHAR(255)
);

INSERT INTO users (name, password)
VALUES ('user1', 'pas1'),
       ('user2', 'pas2');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255),
    price   NUMERIC,
    user_id BIGINT,
    FOREIGN KEY (user_id)
        REFERENCES users (id) ON DELETE CASCADE
);

INSERT INTO products (name, price)
VALUES ('phone', 1000),
       ('printer', 2500),
       ('notebook', 1450),
       ('mouse', 150),
       ('keyboard', 250);

DROP TABLE IF EXISTS user_orders CASCADE;
CREATE TABLE user_orders
(
    user_id    BIGINT REFERENCES users (id) ON DELETE CASCADE,
    product_id BIGINT REFERENCES products (id)
);

INSERT INTO user_orders (user_id, product_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (2, 1);

COMMIT;




