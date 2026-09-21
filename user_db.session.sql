-- Dang nhap vao database hien tai cua ban, sau do tao Schema:
CREATE SCHEMA user_schema;
CREATE SCHEMA inventory_schema;

-- Tao bang thuoc ve tung Schema:
CREATE TABLE user_schema.users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50)
);

CREATE TABLE inventory_schema.products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100)
);
