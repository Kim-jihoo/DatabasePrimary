CREATE TABLE users (
  id VARCHAR(255) PRIMARY KEY,
  pw VARCHAR(255)
);

CREATE TABLE restaurant (
  name VARCHAR(255) PRIMARY KEY,
  menu VARCHAR(255),
  area VARCHAR(255),
  category VARCHAR(255)
);

CREATE TABLE menu (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  restaurant VARCHAR(255),
  price INT
);

CREATE TABLE review (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id VARCHAR(255),
  restaurant VARCHAR(255),
  menu VARCHAR(255),
  comment VARCHAR(255),
  rate DECIMAL(3,1) CHECK (rate >= 0 AND rate <= 5),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (restaurant) REFERENCES restaurant(name)
);
