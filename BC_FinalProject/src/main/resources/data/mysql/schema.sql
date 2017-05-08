DROP TABLE IF EXISTS `order_product`;
DROP TABLE IF EXISTS `order_invoice`;
DROP TABLE IF EXISTS `cart_product`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(100) NOT NULL,
	`password` VARCHAR(200) NOT NULL,
	`name` VARCHAR(100) NOT NULL,
	`email` VARCHAR(100) NOT NULL,
	`locked` BIT(1) NOT NULL DEFAULT 0,
	PRIMARY KEY (`id`),
	CONSTRAINT `uq_account_username` UNIQUE (`username`)
);

CREATE TABLE `category` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`code` VARCHAR(100) NOT NULL,
	`label` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `uq_code_category` UNIQUE (`code`)
);

CREATE TABLE `product` (
	`id` BIGINT(20) UNSIGNED NOT NULL  AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	`description` VARCHAR(100) NOT NULL,
	`price` FLOAT NOT NULL DEFAULT 0,
	`quantity` INT UNSIGNED NOT NULL DEFAULT 0,
	`category_id` BIGINT(20) UNSIGNED NOT NULL DEFAULT 1,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE
);

CREATE TABLE `cart_product`(
	`id` BIGINT(20) UNSIGNED NOT NULL  AUTO_INCREMENT,
	`account_id` BIGINT(20) UNSIGNED NOT NULL,
	`product_id` BIGINT(20) UNSIGNED NOT NULL,
	`quantity` INT UNSIGNED NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
	CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE,
	CHECK (`quantity` > 0)
);



CREATE TABLE `order_invoice`(
	`id` BIGINT(20) UNSIGNED NOT NULL  AUTO_INCREMENT,
	`account_id` BIGINT(20) UNSIGNED NOT NULL,
	`total` FLOAT UNSIGNED NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_order_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
);


CREATE TABLE `order_product`(
	`id` BIGINT(20) UNSIGNED NOT NULL  AUTO_INCREMENT,
	`product_id` BIGINT(20) UNSIGNED NOT NULL,
	`quantity` INT UNSIGNED NOT NULL,
	`order_invoice_id` BIGINT(20) UNSIGNED NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_order_invoice_id` FOREIGN KEY (`order_invoice_id`) REFERENCES `order_invoice` (`id`) ON DELETE CASCADE,
	CHECK (`quantity` > 0)
);

