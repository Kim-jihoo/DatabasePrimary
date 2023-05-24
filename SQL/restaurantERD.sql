CREATE DATABASE resdb;

USE resdb;

CREATE TABLE `users` (
  `id` varchar(255) PRIMARY KEY,
  `password` varchar(255)
);

CREATE TABLE `restaurant` (
  `name` varchar(255) PRIMARY KEY,
  `menu` varchar(255),
  `area` varchar(255),
  `category` varchar(255)
);

CREATE TABLE `menu` (
  `name` varchar(255) PRIMARY KEY,
  `description` varchar(255),
  `price` integer,
  `review` integer
);

CREATE TABLE `review` (
  `userid` varchar(255),
  `restaurant` varchar(255),
  `menu` varchar(255),
  `rate` integer,
  `comment` varchar(255),

   PRIMARY KEY(`userid`, `restaurant`, `menu`)
);

ALTER TABLE `review` ADD FOREIGN KEY (`userid`) REFERENCES `users` (`id`);

ALTER TABLE `review` ADD FOREIGN KEY (`menu`) REFERENCES `menu` (`name`);

ALTER TABLE `review` ADD FOREIGN KEY (`restaurant`) REFERENCES `restaurant` (`name`);

ALTER TABLE `menu` ADD FOREIGN KEY (`review`) REFERENCES `review` (`id`);

ALTER TABLE `restaurant` ADD FOREIGN KEY (`menu`) REFERENCES `menu` (`name`);
