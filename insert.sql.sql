INSERT INTO restaurant (name, menu, area, category) VALUES
('donummami', 'rice with salmon', 'sinchon', 'japanese food'),
('yuyakedokyo', 'cheese pork cutlet', 'main gate', 'japanese food'),
('ramen 81beonok', 'sindonkocheuramen', 'sinchon', 'japanese food'),
('yusoba', 'beef pork soba set', 'main gate', 'japanese food'),
('jonjaeui iyu', 'a home-style meal', 'back gate', 'korean food'),
('studio Wup', 'einspanner', 'back gate', 'dessert'),
('boss donkaz', 'samonim pork cutlet', 'main gate', 'italian food'),
('ttalgigol', 'cheese kimchi soft tofu stew', 'back gate','korean food'),
('cafe PERA', 'strawberry tart', 'main gate', 'dessert'),
('T-ara pasta', 'aglio e olio', 'main gate', 'italian food'),
('donburimono', 'beef tartare with rice', 'sinchon', 'japanese food'),
('acornstor', 'pork lunch box', 'main gate', 'korean food'),
('jinseonmigwan', 'school meal', 'school', 'korean food'),
('hollywood', 'dimare', 'back gate', 'italian food'),
('gabaedang', 'milk tea', 'school', 'dessert'),
('ihouse', 'a breakfast of 1,000 won', 'school', 'korean food'),
('bella phaha', 'malenka', 'main gate', 'dessert'),
('my del place', 'kimchi stew with pork', 'school', 'korean food'),
('TAO', 'maratang', 'shinchon', 'chinese food'),
('ewhaseong', 'black-bean-sauce noodles', 'main gate', 'chinese food');

INSERT INTO users (id, pw) VALUES
('a123', 'aaa'),
('b123', 'bbb'),
('c123', 'ccc'),
('d123', 'ddd'),
('e123', 'eee'),
('f123', 'fff'),
('g123', 'ggg'),
('h123', 'hhh'),
('i123', 'iii'),
('j123', 'jjj');

INSERT INTO menu (name, restaurant, price) VALUES
('rice with salmon','donummami','13000')
('cheese pork cutlet','yuyakedokyo','11000')
('sindonkocheuramen','ramen 81beonok', '8000')
('beef pork soba set','yusoba', '15000')
('a home-style meal','jonjaeui iyu', '7000')
('einspanner','studio Wup', '5000')
('samonim pork cutlet', '9500')
('cheese kimchi soft tofu stew','5500')
('strawberry tart','35000')
('aglio e olio','8500')
('beef tartare with rice' ,'10000')
('pork lunch box', '6900')
('school meal', '6500')
('dimare', '10000')
('milk tea', '2500')
('a breakfast of 1,000 won','1000')
('malenka', '5000')
('kimchi stew with pork', '7500')
('maratang', '2000')
('black-bean-sauce noodles','6000')
 
INSERT INTO review (user_id, restaurant, menu, rate, comment) VALUES 
('f123', 'donummami', 'rice with salmon', 4.3, 'I like salmon because it is thick'),
('a123', 'yuyakedokyo', 'cheese pork cutlet', 3.8, 'It tasted very unique'),
('c123', 'ramen 81beonok', 'sindonkocheuramen', 4.9, 'I like the soup because it is hot and spicy'),
('d123', 'yusoba', 'beef pork soba set', 2.7, 'It is kind of expensive but delicious'),
('h123', 'jonjaeui iyu', 'a home-style meal', 4.2, 'It is good for engineering students to eat'),
('f123', 'studio Wup', 'einspanner', 3.9, 'It is perfect proportion to coffee, but it is not that sweet'),
('g123', 'boss donkaz', 'samonim pork cutlet', 4.7, 'The sauce is sweet, so it is delicious'),
('h123', 'ttalgigol', 'cheese kimchi soft tofu stew', 4.1, 'It is cheap and delicious'),
('d123', 'cafe PERA', 'strawberry tart', 2.4, 'It is good, but it is small and expensive'),
('b123', 'T-ara pasta', 'aglio e olio', 3.6, 'It is just a simple taste'),
('i123', 'donburimono', 'beef tartare with rice', 2.9, 'It was good but a bit sweet'),
('j123', 'acornstor', 'pork lunch box', 4.8, 'There is a lot and it is delicious'),
('c123', 'jinseonmigwan', 'school meal', 3.3, 'It is the most delicious food in the school'),
('a123', 'hollywood', 'dimare', 4.6, 'It has a lot of seafood in it'),
('d123', 'gabaedang', 'milk tea', 4.0, 'Milk tea is sweet and delicious'),
('e123', 'ihouse', 'a breakfast of 1,000 won', 4.4, 'It is nice to be able to eat for 1,000 won'),
('h123', 'bella phaha' ,'malenka', 4.2, 'If you eat it with ice cream, it is sweet and delicious'),
('j123', 'my del place', 'kimchi stew with pork', 4.9, 'It is good to serve quite a lot of meat and to give you unlimited refills of rice'),
('i123', 'TAO', 'maratang', 3.7, 'The hygiene of the store is good and delicious'),
('b123', 'Ewhaseong', 'black-bean-sauce noodles', 4.5, 'It is cheap and delicious');

