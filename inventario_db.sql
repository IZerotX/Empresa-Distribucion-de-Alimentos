-- =========================================================
-- Base de datos: Sistema de Gestión de Inventarios
-- Empresa de distribución de alimentos
-- =========================================================

CREATE DATABASE IF NOT EXISTS inventario_alimentos;
USE inventario_alimentos;

-- Tabla Sucursales
CREATE TABLE IF NOT EXISTS Sucursales (
    id_sucursal   INT AUTO_INCREMENT PRIMARY KEY,
    nombre        VARCHAR(100) NOT NULL,
    direccion     VARCHAR(200) NOT NULL,
    telefono      VARCHAR(20)  NOT NULL
);

-- Tabla Productos
CREATE TABLE IF NOT EXISTS Productos (
    id_producto   INT AUTO_INCREMENT PRIMARY KEY,
    nombre        VARCHAR(100) NOT NULL,
    descripcion   VARCHAR(255),
    precio        DECIMAL(10,2) NOT NULL
);

-- Tabla Transaccion (encabezado general de cada operación)
CREATE TABLE IF NOT EXISTS Transaccion (
    id_transaccion INT AUTO_INCREMENT PRIMARY KEY,
    fecha          DATE NOT NULL,
    hora           TIME NOT NULL,
    id_sucursal    INT NOT NULL,
    tipo           ENUM('COMPRA','VENTA') NOT NULL,
    CONSTRAINT fk_transaccion_sucursal
        FOREIGN KEY (id_sucursal) REFERENCES Sucursales(id_sucursal)
);

-- Tabla Compra (detalle de transacciones de compra)
CREATE TABLE IF NOT EXISTS Compra (
    id_compra      INT AUTO_INCREMENT PRIMARY KEY,
    id_transaccion INT NOT NULL,
    id_producto    INT NOT NULL,
    cantidad       INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_compra_transaccion
        FOREIGN KEY (id_transaccion) REFERENCES Transaccion(id_transaccion),
    CONSTRAINT fk_compra_producto
        FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);

-- Tabla Venta (detalle de transacciones de venta)
CREATE TABLE IF NOT EXISTS Venta (
    id_venta       INT AUTO_INCREMENT PRIMARY KEY,
    id_transaccion INT NOT NULL,
    id_producto    INT NOT NULL,
    cantidad       INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_venta_transaccion
        FOREIGN KEY (id_transaccion) REFERENCES Transaccion(id_transaccion),
    CONSTRAINT fk_venta_producto
        FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);

-- Datos de ejemplo
INSERT INTO Sucursales (nombre, direccion, telefono) VALUES
('Sucursal Bogotá Norte', 'Cra 15 # 100-20', '6011234567'),
('Sucursal Medellín Centro', 'Cl 50 # 45-30', '6042345678');

INSERT INTO Productos (nombre, descripcion, precio) VALUES
('Arroz 500g', 'Arroz blanco empacado', 2500.00),
('Aceite 1L', 'Aceite vegetal', 8500.00);
