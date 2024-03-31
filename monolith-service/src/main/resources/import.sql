-- IDs for dummy data
ALTER SEQUENCE store_seq RESTART WITH 10000 INCREMENT BY 1;
ALTER SEQUENCE catalog_seq RESTART WITH 10000 INCREMENT BY 1;
ALTER SEQUENCE product_seq RESTART WITH 10000 INCREMENT BY 1;
ALTER SEQUENCE inventory_seq RESTART WITH 10000 INCREMENT BY 1;
ALTER SEQUENCE shipping_seq RESTART WITH 10000 INCREMENT BY 1;

-- REAL DATA

-- stores and inventories
INSERT INTO store(id, name, rating, catalogIDs, inventoryIDs, shippingIDs)
VALUES ('1', 'Teknik Kırtasiye', '5', '{1}', '{1,2}', '{1}');
INSERT INTO inventory(id, productID, price, numberOfProduct)
VALUES ('1', '1', '15', '55');
INSERT INTO inventory(id, productID, price, numberOfProduct)
VALUES ('2', '2', '7', '35');

INSERT INTO store(id, name, rating, catalogIDs, inventoryIDs, shippingIDs)
VALUES ('2', 'Gebze Kırtasiye', '4', '{1}', '{3,4}', '{1}');
INSERT INTO inventory(id, productID, price, numberOfProduct)
VALUES ('3', '1', '13', '20');
INSERT INTO inventory(id, productID, price, numberOfProduct)
VALUES ('4', '2', '8', '38');

-- catalogs
INSERT INTO catalog(id, name, productIDs)
VALUES ('1', 'Okul', '{1,2}');

-- products
INSERT INTO product(id, name, rating, catalogID)
VALUES ('1', 'Kalem', '4', '1');

INSERT INTO product(id, name, rating, catalogID)
VALUES ('2', 'Silgi', '5', '1');


-- shipping
INSERT INTO shipping(id, companyName, price)
VALUES ('1', 'Aras Kargo', '25');