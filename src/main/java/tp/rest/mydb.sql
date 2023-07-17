DROP TABLE IF EXISTS `clients`;

CREATE TABLE
	`clients` (
		`id` INT NOT NULL AUTO_INCREMENT,
		`company_name` VARCHAR(40) NOT NULL,
		`first_name` VARCHAR(40) NOT NULL,
		`last_name` VARCHAR(40) NOT NULL,
		`email` VARCHAR(90) NOT NULL,
		`phone` VARCHAR(10) NOT NULL,
		`address` VARCHAR(255) NOT NULL,
		`zip_code` VARCHAR(10) NOT NULL,
		`city` VARCHAR(40) NOT NULL,
		`country` VARCHAR(60) NOT NULL,
		`state` INT NOT NULL DEFAULT 0,
		PRIMARY KEY (`id`)
	) ENGINE = InnoDB AUTO_INCREMENT = 5 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `orders`;

CREATE TABLE
	`orders` (
		`id` INT NOT NULL AUTO_INCREMENT,
		`type_presta` VARCHAR(40) NOT NULL,
		`designation` VARCHAR(90) NOT NULL,
		`client_id` INT NOT NULL,
		`nb_days` INT DEFAULT NULL,
		`unit_price` INT DEFAULT NULL,
		`state` INT DEFAULT NULL,
		PRIMARY KEY (`id`),
		KEY `fk_orders_clients` (`client_id`),
		CONSTRAINT `fk_orders_clients` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
	) ENGINE = InnoDB AUTO_INCREMENT = 8 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO
	`clients` (`id`, `company_name`, `first_name`, `last_name`, `email`, `phone`, `address`, `zip_code`, `city`, `country`, `state`)
VALUES
	(1, 'Capgemini',     'Fabrice', 'Martin', 'martin@mail.com',  '0656858433', 'ABC', 'XYZ', 'Nantes', 'France', 0),
	(2, 'M2I Formation', 'Julien',  'Lamard', 'lamard@mail.com',  '0611223344', 'ABC', 'XYZ', 'Paris',  'France', 1),
	(3, 'Sogeti',        'Martin',  'Matin',  'matin2@mail.com',  '0656858433', 'ABC', 'XYZ', 'Nantes', 'France', 0),
	(4, 'Atos',          'Floran',  'Martin', 'martin3@mail.com', '0656858433', 'ABC', 'XYZ', 'Nantes', 'France', 0);

INSERT INTO
	`orders` (`id`, `type_presta`, `designation`, `client_id`, `nb_days`, `unit_price`, `state`)
VALUES
	(1, 'Formation', 'Angular init',      2,    3, 1200,    0),
	(2, 'Formation', 'React avancé',      2,    3, 1000,    1),
	(3, 'Coaching',  'React Techlead',    1,   20,  900,    1),
	(4, 'Coaching',  'Nest.js Techlead',  1,   50,  800,    0),
	(5, 'Coaching',  'React Teachead',    3, NULL, NULL, NULL),
	(6, 'Coaching',  'Jakarta EE',        3, NULL, NULL, NULL),
	(7, 'Coaching',  'Angular Techlead',  4, NULL, NULL, NULL);