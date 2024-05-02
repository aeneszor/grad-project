-- IDs for dummy data
ALTER SEQUENCE shipping_seq RESTART WITH 10000 INCREMENT BY 1;

-- REAL DATA

INSERT INTO shipping(id, companyName, price)
VALUES ('1', 'Aras Kargo', '25');