-- 1. Tạo 2 database riêng biệt
CREATE DATABASE user_db;
CREATE DATABASE inventory_db;

-- 2. Khởi tạo dữ liệu cho user_db
\c user_db;

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

INSERT INTO users (username, email) VALUES 
('nguyenvana', 'a.nguyen@example.com'),
('tranvanb', 'b.tran@example.com');

-- 3. Khởi tạo dữ liệu cho inventory_db
\c inventory_db;

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL
);

INSERT INTO products (name, price, quantity) VALUES 
('Laptop Dell XPS', 1500.00, 10),
('Chuột Logitech MX Master 3S', 99.99, 50);