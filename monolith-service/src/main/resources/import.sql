ALTER SEQUENCE store_seq RESTART WITH 10;

INSERT INTO store(id, name, rating, catalogIDs, inventoryIDs, shippingIDs)
VALUES (nextval('store_seq'), 'Walmart', '4', '{123132, 10}', '{154543}', '{4112}');

INSERT INTO store(id, name, rating, catalogIDs, inventoryIDs, shippingIDs)
VALUES (nextval('store_seq'), 'Walmart', '4', '{123132}', '{154543}', '{4112}');

INSERT INTO store(id, name, rating, catalogIDs, inventoryIDs, shippingIDs)
VALUES ('20', 'Walmart', '4', '{123132, 123133}', '{154543}', '{4112}');

INSERT INTO catalog(id, name, productIDs)
VALUES ('123132', 'deneme', '{55, 25, 35}');

INSERT INTO catalog(id, name, productIDs)
VALUES ('123133', 'deneme2', '{551, 125, 135}');

