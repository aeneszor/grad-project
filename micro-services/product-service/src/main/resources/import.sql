-- IDs for dummy data
ALTER SEQUENCE product_seq RESTART WITH 10000 INCREMENT BY 1;

-- REAL DATA

INSERT INTO product(id, name, rating, catalogID)
VALUES ('1', 'Kalem', '4', '1');

INSERT INTO product(id, name, rating, catalogID)
VALUES ('2', 'Silgi', '5', '1');