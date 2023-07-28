-- 1. ¿Qué consulta ejecutaría para obtener los ingresos totales para marzo de 2012?

SELECT MONTHNAME(charged_datetime) AS mes, SUM(b.amount) AS ingresos_totales
FROM billing b 
WHERE MONTHNAME(charged_datetime) = "March" && YEAR(charged_datetime) = 2012;

-- 2. ¿Qué consulta ejecutaría para obtener los ingresos totales recaudados del cliente con una identificación de 2?

SELECT c.client_id AS id_cliente, CONCAT(c.first_name, ' ', c.last_name) AS cliente, SUM(b.amount) AS ingresos_totales
FROM clients AS c
JOIN billing AS b ON b.client_id = c.client_id
WHERE c.client_id = 2;

-- 3. ¿Qué consulta ejecutaría para obtener todos los sitios que posee client = 10?

SELECT s.domain_name AS sitio, c.client_id AS id_cliente
FROM sites AS s
JOIN clients AS c ON c.client_id = s.client_id
WHERE c.client_id = 10;

-- 4. ¿Qué consulta ejecutaría para obtener el número total de sitios creados por mes por año para el cliente con una identificación de 1? 

SELECT c.client_id AS id_cliente, CONCAT(c.first_name, ' ', c.last_name) AS cliente, COUNT(s.domain_name) AS sitios_creados, MONTHNAME(s.created_datetime) AS mes, YEAR(s.created_datetime) AS ano
FROM clients AS c
JOIN sites AS s ON s.client_id = c.client_id
WHERE c.client_id = 1
GROUP BY YEAR(created_datetime), MONTH(created_datetime);

-- ¿Qué pasa con el cliente = 20?

SELECT c.client_id AS id_cliente, CONCAT(c.first_name, ' ', c.last_name) AS cliente, COUNT(s.domain_name) AS sitios_creados, MONTHNAME(s.created_datetime) AS mes, YEAR(s.created_datetime) AS ano
FROM clients AS c
JOIN sites AS s ON s.client_id = c.client_id
WHERE c.client_id = 20
GROUP BY YEAR(created_datetime), MONTH(created_datetime);


-- 5. ¿Qué consulta ejecutaría para obtener el número total de clientes potenciales generados para cada uno de los sitios entre el 1 de enero de 2011 y el 15 de febrero de 2011?

SELECT s.domain_name AS sitio, COUNT(l.leads_id) AS leads,  DATE_FORMAT(l.registered_datetime, '%M %d, %Y') AS fecha
FROM sites AS s
JOIN leads AS l ON l.site_id = s.site_id
WHERE registered_datetime >= '2011/01/01' AND registered_datetime <= '2011/02/15'
GROUP BY fecha;

-- 6. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número total de clientes potenciales que hemos generado para cada uno de nuestros clientes entre el 1 de enero de 2011 y el 31 de diciembre de 2011?

SELECT CONCAT(c.first_name, ' ', c.last_name) AS cliente, COUNT(l.leads_id) AS leads
FROM clients AS c
JOIN sites AS s ON s.client_id = c.client_id
JOIN leads AS l ON l.site_id = s.site_id 
WHERE registered_datetime >= '2011/01/01' AND registered_datetime <= '2011/12/31'
GROUP BY cliente;

-- 7. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número total de clientes potenciales que hemos generado para cada cliente cada mes entre los meses 1 y 6 del año 2011?

SELECT CONCAT(c.first_name, ' ', c.last_name) AS cliente, COUNT(l.leads_id) AS leads, MONTHNAME(l.registered_datetime) AS mes
FROM clients AS c
JOIN sites AS s ON s.client_id = c.client_id
JOIN leads AS l ON l.site_id = s.site_id 
WHERE registered_datetime >= '2011/01/01' AND registered_datetime <= '2011/06/30'
GROUP BY registered_datetime;

-- 8. ¿Qué consulta ejecutaría para obtener una lista de nombres de clientes y el número total de clientes potenciales que hemos generado para cada uno de los sitios de nuestros clientes entre el 1 de enero de 2011 y el 31 de diciembre de 2011?
-- Solicite esta consulta por ID de cliente. 

SELECT CONCAT(c.first_name, ' ', c.last_name) AS cliente, s.domain_name AS sitio, COUNT(l.leads_id) AS leads, DATE_FORMAT(l.registered_datetime, '%M %d, %Y') AS fecha
FROM clients AS c
JOIN sites AS s ON s.client_id = c.client_id
JOIN leads AS l ON l.site_id = s.site_id 
WHERE registered_datetime >= '2011/01/01' AND registered_datetime <= '2011/12/31'
GROUP BY sitio
ORDER BY cliente;

-- Presente una segunda consulta que muestre todos los clientes, los nombres del sitio y el número total de clientes potenciales generados en cada sitio en todo momento.

SELECT CONCAT(c.first_name, ' ', c.last_name) AS cliente, s.domain_name AS sitio, COUNT(l.leads_id) AS leads
FROM clients AS c
JOIN sites AS s ON s.client_id = c.client_id
JOIN leads AS l ON l.site_id = s.site_id 
GROUP BY c.client_id, sitio
ORDER BY cliente;

-- 9. Escriba una sola consulta que recupere los ingresos totales recaudados de cada cliente para cada mes del año. Pídalo por ID de cliente.

SELECT CONCAT(c.first_name, ' ', c.last_name) AS cliente, SUM(b.amount) AS ingresos_totales, MONTHNAME(b.charged_datetime) AS mes, YEAR(b.charged_datetime) AS ano
FROM clients AS c
JOIN billing AS b ON b.client_id = c.client_id
GROUP BY c.client_id, mes, ano
ORDER BY cliente;

-- 10. Escriba una sola consulta que recupere todos los sitios que posee cada cliente.
-- Agrupe los resultados para que cada fila muestre un nuevo cliente.
-- Se volverá más claro cuando agregue un nuevo campo llamado 'sitios' que tiene todos los sitios que posee el cliente.
-- (SUGERENCIA: use GROUP_CONCAT)

SELECT CONCAT(c.first_name, ' ', c.last_name) AS cliente, GROUP_CONCAT(s.domain_name SEPARATOR ' / ') AS sitios
FROM clients AS c
JOIN sites AS s ON s.client_id = c.client_id
GROUP BY c.client_id, cliente;


