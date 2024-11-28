CREATE DATABASE  IF NOT EXISTS dbsistemavendas;

USE dbsistemavendas;

-- DROP DATABASE dbsistemavendas;

--- Tabela para a classe SizePattern
CREATE TABLE SizePattern (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- Tabela para a classe Brand
CREATE TABLE Brand (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- Tabela para a classe Color
CREATE TABLE Color (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- Tabela para a classe Category
CREATE TABLE Category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(255) UNIQUE NOT NULL,
    sizePatternId BIGINT,
    FOREIGN KEY (sizePatternId) REFERENCES SizePattern(id)
);

-- Tabela para a classe Customer
CREATE TABLE Customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(15)
);

-- Tabela para a classe Product
CREATE TABLE Product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    size VARCHAR(50),
    costPrice DECIMAL(10, 2),
    salePrice DECIMAL(10, 2),
    date DATE,
    quantity INT NOT NULL,
    colorId BIGINT,
    categoryId BIGINT,
    brandId BIGINT,
    FOREIGN KEY (colorId) REFERENCES Color(id),
    FOREIGN KEY (categoryId) REFERENCES Category(id),
    FOREIGN KEY (brandId) REFERENCES Brand(id)
);

-- Tabela para a classe Sale
CREATE TABLE Sale (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customerId BIGINT,
    payment INT,
    installments INT,
    moment DATETIME,
    FOREIGN KEY (customerId) REFERENCES Customer(id)
);

-- Tabela para a classe SaleItem
CREATE TABLE SaleItem (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    productId BIGINT,
    quantity INT NOT NULL,
    FOREIGN KEY (productId) REFERENCES Product(id)
);

-- Tabela de relacionamento entre Sale e SaleItem (muitos para muitos)
CREATE TABLE SaleSaleItem (
    saleId BIGINT,
    saleItemId BIGINT,
    PRIMARY KEY (saleId, saleItemId),
    FOREIGN KEY (saleId) REFERENCES Sale(id),
    FOREIGN KEY (saleItemId) REFERENCES SaleItem(id)
);
