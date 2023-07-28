USE `sakila`;

SELECT * FROM actor;
INSERT INTO actor values(201,'DIEGO','RODRÍGUEZ','2023-07-14 16:18:00');
UPDATE actor SET first_name = 'DIEGO ISAAC', last_name='RODRÍGUEZ MONTENEGRO', last_update='2023-07-14 16:19:00' WHERE actor_id=201;
DELETE FROM actor WHERE actor_id=201;