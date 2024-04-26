-- ______________________________________________________________________________________________Задание 8 и 9

DROP DATABASE IF EXISTS mans_friends;
CREATE DATABASE mans_friends;
show databases;
use mans_friends;

CREATE TABLE animals
(
animal_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
animal_type VARCHAR(45) NOT NULL,
animal_name VARCHAR(45) NOT NULL,
commands VARCHAR(45) NOT NULL,
day_of_birth DATE NOT NULL
)
;

CREATE TABLE horses
(
horse_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
animal_type VARCHAR(45) NOT NULL,
animal_name VARCHAR(45) NOT NULL,
commands VARCHAR(45) NOT NULL,
day_of_birth DATE NOT NULL
)
;

CREATE TABLE camels
(
camel_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
animal_type VARCHAR(45) NOT NULL,
animal_name VARCHAR(45) NOT NULL,
commands VARCHAR(45) NOT NULL,
day_of_birth DATE NOT NULL
)
;

CREATE TABLE donkeys
(
donkey_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
animal_type VARCHAR(45) NOT NULL,
animal_name VARCHAR(45) NOT NULL,
commands VARCHAR(45) NOT NULL,
day_of_birth DATE NOT NULL
)
;

CREATE TABLE dogs
(
dog_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
animal_type VARCHAR(45) NOT NULL,
animal_name VARCHAR(45) NOT NULL,
commands VARCHAR(45) NOT NULL,
day_of_birth DATE NOT NULL
)
;

CREATE TABLE cats
(
cat_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
animal_type VARCHAR(45) NOT NULL,
animal_name VARCHAR(45) NOT NULL,
commands VARCHAR(45) NOT NULL,
day_of_birth DATE NOT NULL
)
;

CREATE TABLE hamsters
(
hamster_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
animal_type VARCHAR(45) NOT NULL,
animal_name VARCHAR(45) NOT NULL,
commands VARCHAR(45) NOT NULL,
day_of_birth DATE NOT NULL
)
;

INSERT INTO camels (animal_type, animal_name, commands, day_of_birth)
VALUES
('верблюд','Юкас', 'лежать,идти', '2018-02-02'),
('верблюд','Мин', 'идти, стоп', '2017-08-03'),
('верблюд','Сон', 'быстрее, идти, стоп', '2019-09-04'),
('верблюд','Валенок', 'стоп', '2020-12-05'),
('верблюд','Лия', 'идти', '2022-03-06')
;

INSERT INTO horses (animal_type, animal_name, commands, day_of_birth)
VALUES
('конь','Зина', 'рысь', '2020-11-11'),
('конь','Добрыня', 'рысь, галоп', '2014-5-11'),
('конь','Кит', 'галоп, шагом, тише', '2021-12-17'),
('конь','Гиза', 'галоп, тише, хоп', '2022-01-01'),
('конь','Юля', 'тише, хоп', '2022-12-28')
;

INSERT INTO donkeys (animal_type, animal_name, commands, day_of_birth)
VALUES
('осел','Юрец', 'рысь', '2020-04-11'),
('осел','Индиго', 'рысь, шагом', '2014-05-21'),
('осел','Брыська', 'стоп, шагом', '2021-06-03'),
('осел','Вито', 'стоп, шагом', '2020-06-04'),
('осел','Альпака', 'стоп, хоп', '2023-02-08')
;

INSERT INTO dogs (animal_type, animal_name, commands, day_of_birth)
VALUES
('собака','Бобик', 'сидеть, лежать, кувырок, голос, лапу', '2015-12-05'),
('собака','Шарик', 'сидеть, лежать', '2013-02-08'),
('собака','Пузырик', 'сидеть, лежать, голос', '2018-04-11'),
('собака','Раф', 'голос', '2023-06-17'),
('собака','Мухтар', 'сидеть, лежать, голос, кувырок', '2017-08-16')
;

INSERT INTO cats (animal_type, animal_name, commands, day_of_birth)
VALUES
('кошка','Мурка', 'сидеть, лежать, проси', '2017-11-07'),
('кошка','Шура', 'сидеть, мяу', '2017-01-10'),
('кошка','Кыся', 'проси, нельзя', '2022-03-13'),
('кошка','Кеша', 'сидеть, нельзя', '2019-05-19'),
('кошка','Диза', 'сидеть, лежать, нельзя', '2016-07-18')
;

INSERT INTO hamsters (animal_type, animal_name, commands, day_of_birth)
VALUES
('хомяк','Миша', 'нельзя', '2021-08-09'),
('хомяк','Пухля', 'нельзя', '2022-10-12'),
('хомяк','Юсуф', 'нельзя', '2023-12-15'),
('хомяк','Деря', 'нельзя', '2014-02-21'),
('хомяк','Босс', 'нельзя, ко мне', '2024-04-20')
;
INSERT INTO animals (animal_type, animal_name, commands, day_of_birth)
SELECT animal_type, animal_name, commands, day_of_birth
FROM horses
UNION SELECT animal_type, animal_name, commands, day_of_birth FROM donkeys
UNION SELECT animal_type, animal_name, commands, day_of_birth FROM camels
UNION SELECT animal_type, animal_name, commands, day_of_birth FROM dogs
UNION SELECT animal_type, animal_name, commands, day_of_birth FROM cats
UNION SELECT animal_type, animal_name, commands, day_of_birth FROM hamsters;

-- ______________________________________________________________________________________________Конец задания 8 и 9

/* ______________________________________________________________________________________________ Задание 10
DELETE FROM animals
WHERE animal_type = 'верблюд';

CREATE TABLE baggage_animals
AS 
(
SELECT animal_type, animal_name, commands, day_of_birth 
FROM horses
UNION SELECT animal_type, animal_name, commands, day_of_birth
FROM donkeys
);
SELECT * FROM baggage_animals;
 ______________________________________________________________________________________________ Конец задания 10 */

/* ______________________________________________________________________________________________ Задание 11
DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals 
(
animal_id INT,
animal_type VARCHAR(45) NOT NULL,
animal_name VARCHAR(45) NOT NULL,
day_of_birth DATE NOT NULL,
age INT,
foreign key (animal_id) REFERENCES animals(animal_id) ON DELETE CASCADE
)
;

INSERT INTO young_animals (animal_id, animal_type, animal_name, day_of_birth)
SELECT animal_id, animal_type, animal_name, day_of_birth
FROM animals
WHERE day_of_birth < "2023-04-21" AND day_of_birth > "2021-04-21";

UPDATE young_animals 
SET age = (2024 - YEAR(day_of_birth));
______________________________________________________________________________________________ Конец задания 11 */



/* ______________________________________________________________________________________________ Задание 12
SELECT *
FROM animals a
LEFT JOIN young_animals y ON a.animal_id = y.animal_id; 
______________________________________________________________________________________________ Конец задания 12 */




