-- 1. ¿Qué consulta ejecutarías para obtener todos los clientes dentro de city_id = 312?
-- Su consulta debe devolver el nombre, apellido, correo electrónico y dirección del cliente.

SELECT c.first_name AS nombre, c.last_name AS apellido, c.email, a.address AS direccion, ct.city as ciudad, a.city_id as id_ciudad
FROM customer AS c
JOIN address AS a ON c.address_id = a.address_id
JOIN city AS ct ON a.city_id = ct.city_id
WHERE a.city_id = 312;

-- 2. ¿Qué consulta harías para obtener todas las películas de comedia?
-- Su consulta debe devolver el título de la película, la descripción, el año de estreno, la calificación, las características especiales y el género (categoría).

SELECT f.title AS titulo, f.description AS descripcion, f.release_year AS lanzamiento, f.rating AS calificacion, f.special_features AS caracteristicas_esp, c.name AS genero
FROM film AS f
JOIN film_category AS fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
WHERE c.name = "Comedy"; 

-- 3. ¿Qué consulta harías para obtener todas las películas unidas por actor_id = 5? 
-- Su consulta debe devolver la identificación del actor, el nombre del actor, el título de la película, la descripción y el año de lanzamiento.

SELECT a.actor_id AS id_actor, a.first_name AS nombre_actor, a.last_name AS apellido_actor, f.title AS titulo, f.description AS descripcion, f.release_year AS lanzamiento
FROM actor AS a
JOIN film_actor AS fa ON a.actor_id = fa.actor_id
JOIN film AS f ON f.film_id = fa.film_id
WHERE a.actor_id = 5; 

-- 4. ¿Qué consulta ejecutaría para obtener todos los clientes en store_id = 1 y dentro de estas ciudades (1, 42, 312 y 459)?
-- Su consulta debe devolver el nombre, apellido, correo electrónico y dirección del cliente.

SELECT c.customer_id AS id_cliente, c.first_name AS nombre, c.last_name AS apellido, c.email AS correo, a.address AS direccion
FROM customer AS c
JOIN address AS a ON a.address_id = c.address_id
WHERE c.store_id = 1 && a.city_id IN (1, 42, 312, 459); 


-- 5. ¿Qué consulta realizarías para obtener todas las películas con una "calificación = G" y "característica especial = detrás de escena", unidas por actor_id = 15?
-- Su consulta debe devolver el título de la película, la descripción, el año de lanzamiento, la calificación y la función especial. Sugerencia: puede usar la función LIKE para obtener la parte 'detrás de escena'.

SELECT f.title AS titulo, f.description AS descripcion, f.release_year AS lanzamiento, f.rating AS calificacion, f.special_features AS caracteristica_esp
FROM film AS f
JOIN film_actor AS fa ON fa.film_id = f.film_id
WHERE f.rating LIKE "G" && fa.actor_id = 15 && f.special_features LIKE "%Behind the Scenes%";

-- 6. ¿Qué consulta harías para obtener todos los actores que se unieron en el film_id = 369?
-- Su consulta debe devolver film_id, title, actor_id y actor_name.

SELECT f.film_id AS id_pelicula, f.title AS titulo, fa.actor_id AS id_actor, CONCAT (a.first_name, ' ', a.last_name) AS nombre
FROM film AS f
JOIN film_actor AS fa ON fa.film_id = f.film_id
JOIN actor AS a ON a.actor_id = fa.actor_id
WHERE f.film_id = 369;

-- 7. ¿Qué consulta harías para obtener todas las películas dramáticas con una tarifa de alquiler de 2.99? 
-- Su consulta debe devolver el título de la película, la descripción, el año de estreno, la calificación, las características especiales y el género (categoría).

SELECT f.title AS titulo, f.description AS descripcion, f.release_year AS estreno, f.rating AS calificacion, f.special_features as caracteristicas_esp, c.name as categoria, f.rental_rate as tarifa_alquiler
FROM film AS f
JOIN film_category AS fc ON fc.film_id = f.film_id
JOIN category AS c ON c.category_id = fc.category_id
WHERE f.rental_rate = 2.99 && c.name = "Drama";

-- 8. ¿Qué consulta harías para obtener todas las películas de acción a las que se une SANDRA KILMER?
-- Su consulta debe devolver el título de la película, la descripción, el año de estreno, la calificación, las características especiales, el género (categoría) y el nombre y apellido del actor.

SELECT CONCAT(a.first_name, ' ', a.last_name) AS nombre_actor, f.title AS titulo, f.description AS descripcion, f.release_year AS estreno, f.rating AS calificacion, f.special_features AS caracteristicas_esp, c.name AS categoria
FROM film AS f
JOIN film_category AS fc ON fc.film_id = f.film_id
JOIN category AS c ON c.category_id = fc.category_id
JOIN film_actor AS fa ON fa.film_id = f.film_id
JOIN actor AS a ON a.actor_id = fa.actor_id
WHERE c.name = "Action" && a.first_name = "SANDRA" && a.last_name = "KILMER";



