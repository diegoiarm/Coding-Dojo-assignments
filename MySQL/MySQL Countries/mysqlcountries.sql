-- 1. ¿Qué consulta harías para obtener todos los países que hablan esloveno? 
-- Tu consulta debe devolver el nombre del país, el idioma y el porcentaje de idioma.
-- Tu consulta debe organizar el resultado por porcentaje de idioma en orden descendente. (1)

SELECT world.countries.name AS pais, world.languages.language AS idioma, world.languages.percentage AS porcentaje
FROM world.languages
JOIN world.countries ON world.languages.country_id = world.countries.id
WHERE world.languages.language = "Slovene"
ORDER BY world.languages.percentage DESC;

-- 2. ¿Qué consulta ejecutarías para mostrar el número total de ciudades para cada país?
-- Su consulta debe devolver el nombre del país y el número total de ciudades.
-- Tu consulta debe organizar el resultado por el número de ciudades en orden descendente. (3)

SELECT world.countries.name AS pais, COUNT(cities.name) AS cantidad_ciudades
FROM cities
JOIN countries ON cities.country_id = countries.id
GROUP BY countries.name
ORDER BY cantidad_ciudades DESC;


-- 3. ¿Qué consulta harías para obtener todas las ciudades de México con una población de más de 500,000?
-- Tu consulta debe organizar el resultado por población en orden descendente. (1)

SELECT countries.name AS pais, cities.name AS ciudad, cities.population AS poblacion FROM countries
countries INNER JOIN cities
ON countries.id = cities.country_id
AND countries.name = 'Mexico'
AND cities.population > 500000
ORDER BY cities.population DESC;

-- 4. ¿Qué consulta ejecutarías para obtener todos los idiomas en cada país con un porcentaje superior al 89%?
-- Tu consulta debe organizar el resultado por porcentaje en orden descendente. (1)

SELECT c.name AS pais, l.language AS idioma, l.percentage AS porcentaje
FROM countries c
JOIN languages l ON c.id = l.country_id
WHERE l.percentage > 89
GROUP BY c.name, l.language, l.percentage
ORDER BY l.percentage DESC;

-- 5. ¿Qué consulta haría para obtener todos los países con un área de superficie inferior a 501 y una población superior a 100,000? (2)

SELECT name AS pais, surface_area AS superficie, population AS poblacion 
FROM countries
WHERE surface_area < 501
AND population > 100000;

-- 6. ¿Qué consulta harías para obtener países con solo Monarquía Constitucional con un capital superior a 200 y una esperanza de vida superior a 75 años? (1)

SELECT name AS pais, government_form AS tipo_de_gobierno, capital, life_expectancy AS esperanza_de_vida 
FROM countries
WHERE government_form = 'Constitutional Monarchy'
AND capital > 200
AND life_expectancy < 75;

-- 7. ¿Qué consulta harías para obtener todas las ciudades de Argentina dentro del distrito de Buenos Aires y tener una población superior a 500,000?
-- La consulta debe devolver el nombre del país, el nombre de la ciudad, el distrito y la poblacion.

SELECT countries.name AS pais, cities.name AS ciudad, cities.district AS distrito, cities.population AS poblacion FROM countries
countries INNER JOIN cities
ON countries.id = cities.country_id
AND countries.name = 'Argentina'
AND cities.district = 'Buenos Aires'
AND cities.population > 500000;

-- 8. ¿Qué consulta harías para resumir el número de países en cada región? La consulta debe mostrar el nombre de la región y el número de países.
-- Además, la consulta debe organizar el resultado por el número de países en orden descendente. (2)

SELECT countries.region AS region, COUNT(countries.name) AS cantidad_paises FROM countries
GROUP BY countries.region
ORDER BY cantidad_paises DESC;
