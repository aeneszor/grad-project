-- IDs for dummy data
ALTER SEQUENCE inventory_seq RESTART WITH 10000 INCREMENT BY 1;

-- REAL DATA

INSERT INTO inventory(id, productID, price, numberOfProduct)
VALUES ('1', '1', '15', '55');

INSERT INTO inventory(id, productID, price, numberOfProduct)
VALUES ('2', '2', '7', '35');

INSERT INTO inventory(id, productID, price, numberOfProduct)
VALUES ('3', '1', '13', '20');

INSERT INTO inventory(id, productID, price, numberOfProduct)
VALUES ('4', '2', '8', '38');