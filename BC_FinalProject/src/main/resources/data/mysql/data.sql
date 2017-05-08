INSERT INTO account (username, password, name, email, locked) VALUES ('user0', 'user0Password', 'user0Name', 'user0Email', false);
INSERT INTO account (username, password, name, email, locked) VALUES ('user1', 'user1Password', 'user1Name', 'user1Email', false);
INSERT INTO account (username, password, name, email, locked) VALUES ('user2', 'user2Password', 'user2Name', 'user2Email', false);
INSERT INTO account (username, password, name, email, locked) VALUES ('user3', 'user3Password', 'user3Name', 'user3Email', false);

INSERT INTO category(code, label) VALUES ('DEFAULT','Default category');
INSERT INTO category(code, label) VALUES ('PERFUM','perfum s category');
INSERT INTO category(code, label) VALUES ('DEODORANT','deodorant s category');

INSERT INTO product(name,description,price,quantity,category_id) VALUES('DefaultProduct0','DefaultProductDescription',12,16,1);
INSERT INTO product(name,description,price,quantity,category_id) VALUES('PerfumProduct0','PerfumProductDescription',12.5,14,2);
INSERT INTO product(name,description,price,quantity,category_id) VALUES('DeodorantProduct0','DeodorantProductDescription',15,15,3);
INSERT INTO product(name,description,price,quantity,category_id) VALUES('PerfumProduct1','PerfumProductDescription',17,10,2);
INSERT INTO product(name,description,price,quantity,category_id) VALUES('DeodorantProduct1','DeodorantProductDescription',8,12,3);
INSERT INTO product(name,description,price,quantity,category_id) VALUES('PerfumProduct2','PerfumProductDescription',4,18,2);
INSERT INTO product(name,description,price,quantity,category_id) VALUES('DeodorantProduct2','DeodorantProductDescription',11.2,10,3);

INSERT INTO cart_product(account_id,product_id,quantity) VALUES(1,1,2);
INSERT INTO cart_product(account_id,product_id,quantity) VALUES(1,3,3);
INSERT INTO cart_product(account_id,product_id,quantity) VALUES(2,1,2);
INSERT INTO cart_product(account_id,product_id,quantity) VALUES(2,2,2);
INSERT INTO cart_product(account_id,product_id,quantity) VALUES(2,3,2);
