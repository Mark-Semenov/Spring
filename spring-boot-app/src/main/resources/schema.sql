BEGIN;

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255),
    password VARCHAR(255)
);

INSERT INTO users (name, password)
VALUES ('user1', '$2y$12$f06iCJFDF0z88mTLSVYFSOVACgG4ybjFk6bxvZhFFlggsBzVsLr4S'),
       ('user2', '$2y$12$AF2njjC7.9E68LxqAl.iUey.YE9G6Nj3iPc0Myc/YZGDo0cZN.14y'),
       ('user3', '$2y$12$QcQIP.KdBL2HhXcs9WzTP.AiapNF8QLoPM4.fstAsqZCj0fTehAM6');

DROP TABLE IF EXISTS roles CASCADE;
CREATE TABLE roles
(
    id       BIGSERIAL PRIMARY KEY,
    title     VARCHAR(255)
);

INSERT INTO roles (title)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN'),
       ('ROLE_SUPER_ADMIN');

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
       ('RAM', 250),
       ('SSD', 250),
       ('HDD', 250),
       ('display', 250),
       ('headphone', 250),
       ('cartridge', 250),
       ('USB', 250),
       ('microphone', 250),
       ('keyboard', 250),
       ('keyboard', 250),
       ('keyboard', 250);

DROP TABLE IF EXISTS user_orders CASCADE;
CREATE TABLE user_orders
(
    user_id    BIGINT REFERENCES users (id) ON DELETE CASCADE,
    product_id BIGINT REFERENCES products (id)
);

INSERT INTO user_orders (user_id, product_id)
VALUES (1, 1),
       (2, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (2, 1);


DROP TABLE IF EXISTS user_roles CASCADE;
CREATE TABLE user_roles
(
    user_id    BIGINT REFERENCES users (id) ON DELETE CASCADE,
    roles_id BIGINT REFERENCES roles (id)
);

INSERT INTO user_roles (user_id, roles_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);

COMMIT;




