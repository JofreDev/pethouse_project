-- Insertar registros de ejemplo en la tabla category
INSERT INTO public.category (nombre) VALUES
('Alimento para perros'),
('Alimento para gatos'),
('Juguetes para mascotas'),
('Cuidado de la salud'),
('Accesorios para mascotas');

-- Insertar registros de ejemplo en la tabla customer
INSERT INTO public.customer (id_customer, apellido, celular, correo_electronico, direccion, nombre) VALUES
('1', 'García', 3123456789, 'jgarcia@gmail.com', 'Cra 10 # 20-30', 'Juan'),
('2', 'Martínez', 3001234567, 'lmartinez@yahoo.com', 'Cra 15 # 25-35', 'Luisa'),
('3', 'Pérez', 3209876543, 'aperez@hotmail.com', 'Cra 20 # 30-40', 'Ana'),
('4', 'González', 3056789123, 'jgonzalez@gmail.com', 'Cra 25 # 35-45', 'Julia'),
('5', 'Hernández', 3145678901, 'lhernandez@yahoo.com', 'Cra 30 # 40-50', 'Lina');

-- Insertar registros de ejemplo en la tabla shipment
INSERT INTO public.shipment (direccion_envio, estado, fecha_entrega, fecha_envio) VALUES
('Cra 10 # 20-30', 'En tránsito', NULL, '2023-05-05 10:00:00'),
('Cra 15 # 25-35', 'Entregado', '2023-05-06 11:00:00', '2023-05-05 10:00:00'),
('Cra 20 # 30-40', 'En tránsito', NULL, '2023-05-05 10:00:00'),
('Cra 25 # 35-45', 'Pendiente', NULL, NULL),
('Cra 30 # 40-50', 'En tránsito', NULL, '2023-05-05 10:00:00');

-- Insertar registros de ejemplo en la tabla subcategory
INSERT INTO public.subcategory (nombre, id_category) VALUES
('Alimento húmedo para perros', 1),
('Alimento seco para perros', 1),
('Alimento húmedo para gatos', 2),
('Alimento seco para gatos', 2),
('Pelotas para perros', 3),
('Ratones para gatos', 3),
('Cepillos para perros', 4),
('Cepillos para gatos', 4),
('Collares para perros', 5),
('Collares para gatos', 5);

-- Insertar registros de ejemplo en la tabla product
INSERT INTO public.product (cantidad_stock, descripcion, nombre, precio, id_subcategory) VALUES
(50, 'Alimento húmedo para perros de razas pequeñas', 'Pedigree para perros', 20000.00, 1),
(100, 'Alimento seco para perros de razas medianas', 'Hill''s para perros', 50000.00, 2),
(25, 'Alimento húmedo para gatos de todas las edades', 'Fancy Feast para gatos', 15000.00, 3),
(75, 'Alimento seco para gatos de razas grandes', 'Purina para gatos', 35000.00, 4),
(50, 'Pelota de goma resistente para perros grandes', 'Kong Classic para perros', 30000.00, 5),
(20, 'Ratón de juguete para gatos con plumas', 'Juguete para gatos', 10000.00, 6),
(30, 'Cepillo para perros de pelo corto', 'Cepillo para perros', 15000.00, 7),
(40, 'Cepillo para gatos de pelo largo', 'Cepillo para gatos', 12000.00, 8),
(60, 'Collar ajustable de cuero para perros', 'Collar de cuero para perros', 25000.00, 9),
(40, 'Collar ajustable de tela para gatos', 'Collar de tela para gatos', 15000.00, 10);
