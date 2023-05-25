INSERT INTO restaurant (name, area, category) VALUES
('donummami', 'sinchon', 'japanese food'),
('yuyakedokyo', 'main gate', 'japanese food'),
('ramen 81beonok', 'sinchon', 'japanese food'),
('yusoba', 'main gate', 'japanese food'),
('jonjaeui iyu', 'back gate', 'korean food'),
('studio Wup', 'back gate', 'dessert'),
('boss donkaz', 'main gate', 'italian food'),
('ttalgigol', 'back gate','korean food'),
('cafe PERA', 'main gate', 'dessert'),
('T-ara pasta', 'main gate', 'italian food'),
('donburimono', 'sinchon', 'japanese food'),
('acornstor', 'main gate', 'korean food'),
('jinseonmigwan', 'main gate', 'korean food'),
('hollywood', 'back gate', 'italian food'),
('gabaedang', 'school', 'dessert'),
('ihouse', 'school', 'korean food'),
('bella phaha', 'main gate', 'dessert'),
('my del place', 'school', 'korean food'),
('TAO', 'maratang', 'chinese food'),
('ewhaseong', 'main gate', 'chinese food');


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

INSERT INTO menu (name, restaurant, price)
VALUES
('rice with salmon', 'donummami', 13000),
('kyudon', 'donummami', 8000),
('ebi-dong', 'donummami', 10000),
('cheese pork cutlet', 'yuyakedokyo', 11000),
('pork sirloin cutlet', 'yuyakedokyo', 9500),
('pork tenderloin cutlet', 'yuyakedokyo', 11000),
('einspanner', 'studio Wup', 5000),
('cheesecake', 'studio Wup', 6500),
('brownie', 'studio Wup', 4000),
('cheese kimchi soft tofu stew', 'ttalgigol', 5500),
('rice with kimchi and fish roe', 'ttalgigol', 5500),
('banquet noodles', 'ttalgigol', 4500),
('aglio e olio', 'T-ara pasta', 8500),
('fish roe cream pasta', 'T-ara pasta', 9900),
('shrimp rose', 'T-ara pasta', 10900),
('dimare', 'hollywood', 10000),
('spaghetti alla carbonara', 'hollywood', 9000),
('black-bean-sauce noodles', 'ewhaseong', 6000),
('tangjjamyeon', 'ewhaseong', 9000),
('japchae bap', 'ewhaseong', 9000);


INSERT INTO review (user_id, restaurant, menu, comment, rate)
VALUES
('a123', 'donummami', 'rice with salmon', 'I like salmon because it is thick', 4.5),
('c123', 'donummami', 'kyudon', 'It was good but a bit sweet', 4.2),
('e123', 'donummami', 'ebi-dong', 'There is a big shrimp in it', 3.2),
('i123', 'yuyakedokyo', 'cheese pork cutlet', 'It tasted very unique', 5),
('c123', 'yuyakedokyo', 'pork sirloin cutlet', 'The sauce is sweet, so it is delicious', 3.8),
('a123', 'yuyakedokyo', 'pork tenderloin cutlet', 'The meat is very soft', 4),
('i123', 'studio Wup', 'einspanner', 'It is perfect proportion to coffee, but it is not that sweet', 3),
('b123', 'studio Wup', 'cheesecake', 'It is the best cheese cake I have ever had', 5),
('d123', 'studio Wup', 'brownie', 'It is sweet and delicious', 4.5),
('g123', 'ttalgigol', 'cheese kimchi soft tofu stew', 'It is good, but it is small and expensive', 4),
('h123', 'ttalgigol', 'rice with kimchi and fish roe', 'It is cost-effective', 4.2),
('i123', 'ttalgigol', 'banquet noodles', 'The hygiene is poor', 2),
('f123', 'T-ara pasta', 'aglio e olio', 'It is just a simple taste', 3.2),
('j123', 'T-ara pasta', 'fish roe cream pasta', 'It is kind of expensive but delicious', 3.5),
('a123', 'T-ara pasta', 'shrimp rose', 'I like it because there are a lot of shrimp', 4.5),
('b123', 'hollywood', 'dimare', 'It has a lot of seafood in it', 4),
('g123', 'hollywood', 'spaghetti alla carbonara', 'It was too salty for me', 2.5),
('d123', 'ewhaseong', 'black-bean-sauce noodles', 'It is cheap and delicious', 3.5),
('h123', 'ewhaseong', 'tangjjamyeon', 'Sweet and sour pork is delicious', 4.3),
('j123', 'ewhaseong', 'japchae bap', 'The soy sauce is good and the noodles are chewy', 5);

