-- IDs for dummy data
ALTER SEQUENCE store_seq RESTART WITH 10000 INCREMENT BY 1;

-- REAL DATA

INSERT INTO store(id, name, rating, catalogIDs, inventoryIDs, shippingIDs)
VALUES ('1', 'Teknik Kırtasiye', '5', '{1}', '{1,2}', '{1}');

INSERT INTO store(id, name, rating, catalogIDs, inventoryIDs, shippingIDs)
VALUES ('2', 'Gebze Kırtasiye', '4', '{1}', '{3,4}', '{1}');