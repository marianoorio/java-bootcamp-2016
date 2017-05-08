
##Previous requirements

##Database
CREATE DATABASE shop;

CREATE USER 'shopusr'@'localhost' identified by 'p4$$woRd';

GRANT ALL ON shop.* to 'shopusr'@'localhost';

FLUSH PRIVILEGES;

##RUN
mvn spring-boot:run from project folder
