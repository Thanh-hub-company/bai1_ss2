-- 1. Tao 2 database rieng biet
CREATE DATABASE user_db;
CREATE DATABASE inventory_db;

-- 2. Khoi tao du lieu cho user_db
\c user_db;

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

INSERT INTO users (username, email) VALUES 
('nguyenvana', 'a.nguyen@example.com'),
('tranvanb', 'b.tran@example.com');

-- 3. Khoi tao du lieu cho inventory_db
\c inventory_db;

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    sku VARCHAR(50) UNIQUE,
    import_price DECIMAL(10, 2),
    sell_price DECIMAL(10, 2),
    stock_quantity INT
);

INSERT INTO products (name, sku, import_price, sell_price, stock_quantity) VALUES 
('Laptop Dell XPS', 'SKU-1001', 1500.00, 1899.00, 10),
('Chuot Logitech MX Master 3S', 'SKU-1002', 99.99, 129.99, 50);