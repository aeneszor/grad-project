-- IDs for dummy data
ALTER SEQUENCE catalog_seq RESTART WITH 10000 INCREMENT BY 1;

-- REAL DATA

INSERT INTO catalog(id, name, productIDs)
VALUES ('1', 'Okul', '{1,2}');