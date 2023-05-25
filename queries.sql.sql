-- Active: 1684454049634@@127.0.0.1@3306@TEAMPRIMARY

--1.1 회원가입
INSERT INTO users (id, pw) VALUES 
--1.2 리뷰 작성
INSERT INTO review (user_id,restaurant,menu,comment,rate)
SELECT *
FROM users
WHERE id = user_id;

--2.1 
CREATE VIEW restaurant_ratings AS
SELECT r.name, r.area, r.category, AVG(m.rate) AS average_rate
FROM restaurant r
JOIN menu m ON r.name = m.restaurant
GROUP BY r.name, r.area, r.category
HAVING AVG(m.rate) > 4.00;

SELECT * FROM restaurant_ratings;

--2.2
CREATE VIEW affordable_menu AS
SELECT m.restaurant, m.name AS menu, m.price, r.rate
FROM menu m 
JOIN review r on m.restaurant = r.restaurant AND m.name = r.menu
WHERE m.price < 20000;

SELECT * FROM affordable_menu

--2.3
SELECT *
FROM restaurant 
WHERE area = ''
GROUP BY area;


--3. update
