# Sistema de Gestión de Inventarios - Empresa de Distribución de Alimentos

Proyecto de la actividad Semana 4 - Sistemas Transaccionales (UNIMINUTO).

## Contenido
- `sql/inventario_db.sql`: script de creación de la base de datos MySQL (tablas Sucursales, Productos, Transaccion, Compra, Venta).
- `src/Transaccion.java`, `src/Compra.java`, `src/Venta.java`: clases del sistema de transacciones distribuidas.
- `src/Productor.java`, `src/Consumidor.java`: clases del sistema de mensajería con ActiveMQ (JMS).
- `src/CacheProduct.java`, `src/CacheBranch.java`: clases del sistema de caché distribuido.

## Herramientas
- MySQL 8.0
- Netbeans (proyecto Java)
- Apache ActiveMQ

## Cómo ejecutar
1. Ejecutar `sql/inventario_db.sql` en MySQL Workbench o consola MySQL.
2. Abrir el proyecto en Netbeans, agregar las dependencias de ActiveMQ (activemq-all.jar) al classpath.
3. Iniciar el broker de ActiveMQ (`activemq start`).
4. Ejecutar `Consumidor.java` primero (queda escuchando la cola).
5. Ejecutar `Productor.java` para enviar una transacción de ejemplo.
