DROP TABLE CUSTOMERS, ORDERS, BOARDS, SHOES, BACKPACKS, SHIRTS, PANTS, HOODIES, SOCKS, HATS, HELMETS;

CREATE TABLE CUSTOMERS(
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    phone bigint NOT NULL,
    address TEXT NOT NULL
);

CREATE TABLE ORDERS(
    id BIGSERIAL PRIMARY KEY
);
-------------------------------------------------------------------------
CREATE TABLE BOARDS(
    id BIGSERIAL PRIMARY KEY,
    boardBrand TEXT NOT NULL,
    boardSize float NOT NULL,
    wheelSize int NOT NULL,
    wheelColor TEXT NOT NULL,
    price FLOAT NOT NULL
);

INSERT INTO BOARDS (boardBrand, boardSize, wheelSize, wheelColor, price)
VALUES ('Baker', 8.5, 56, 'Green', 79.95),
       ('Santa Cruz', 8.38, 55, 'Blue', 84.95),
       ('Element', 8.125, 54, 'Red', 89.95),
       ('Birdhouse', 8.0, 56, 'Brown', 81.95),
       ('Zero', 8.5, 55, 'Black', 74.95);

-------------------------------------------------------------------------
CREATE TABLE SHOES(
    id BIGSERIAL PRIMARY KEY,
    shoeBrand TEXT NOT NULL,
    shoeType TEXT NOT NULL,
    shoeSize float NOT NULL,
    shoeColor TEXT NOT NULL,
    price FLOAT NOT NULL
);

INSERT INTO SHOES (shoeBrand, shoeType, shoeSize, shoeColor, price)
VALUES ('Vans', 'Athletic', 11.5, 'Red', 64.95),
       ('Nike', 'Athletic', 7.5, 'Blue', 74.95),
       ('Cariuma', 'Athletic', 8.5, 'Grey', 69.95),
       ('DC', 'Athletic', 10, 'Orange', 54.95),
       ('Emerica', 'Athletic', 12, 'Brown', 59.95);

-------------------------------------------------------------------------
CREATE TABLE BACKPACKS(
    id BIGSERIAL PRIMARY KEY,
    bagBrand TEXT NOT NULL,
    bagSize TEXT NOT NULL,
    bagColor TEXT NOT NULL,
    isWaterproof TEXT NOT NULL,
    price FLOAT NOT NULL
);

INSERT INTO BACKPACKS (bagBrand, bagSize, bagColor, isWaterproof, price)
VALUES ('Vans', 'Large', 'Brown', 'Yes', 64.95),
       ('Nike', 'Medium', 'Red', 'No', 54.95),
       ('Under Armour', 'Large', 'Blue', 'Yes', 44.95),
       ('Hurley', 'Small', 'Green', 'No', 26.95),
       ('Element', 'Large', 'Orange', 'Yes', 18.95);

-------------------------------------------------------------------------
CREATE TABLE SHIRTS(
    id BIGSERIAL PRIMARY KEY,
    shirtBrand TEXT NOT NULL,
    shirtType TEXT NOT NULL,
    shirtSize TEXT NOT NULL,
    shirtColor TEXT NOT NULL,
    price FLOAT NOT NULL
);
INSERT INTO SHIRTS (shirtBrand, shirtType, shirtSize, shirtColor, price)
VALUES ('Nike SB', 'Short Sleeve', 'Medium', 'Blue', 19.95),
       ('Polar Skate', 'Long Sleeve', 'Large', 'Green', 14.95),
       ('Santa Cruz', 'Flannel', 'Medium', 'Red', 17.95),
       ('Thrasher', 'Long Sleeve', 'Small', 'Purple', 21.95),
       ('Powell Peralta', 'Short Sleeve', 'XL', 'Brown', 16.95);

-------------------------------------------------------------------------
CREATE TABLE PANTS(
    id BIGSERIAL PRIMARY KEY,
    pantsBrand TEXT NOT NULL,
    pantsType TEXT NOT NULL,
    pantsSize TEXT NOT NULL,
    pantsColor TEXT NOT NULL,
    price FLOAT NOT NULL
);

INSERT INTO PANTS (pantsBrand, pantsType, pantsSize, pantsColor, price)
VALUES ('Nike SB', 'Flexible', '28-30', 'Blue', 39.95),
       ('Volcom', 'Cargo', '32-32', 'Blue', 34.95),
       ('Dickies', 'Slim Straight', '36-32', 'Blue', 37.95),
       ('Vans', 'Lounge', '32-34', 'Blue', 31.95),
       ('Adidas', 'Khakis', '30-36', 'Blue', 36.95);

-------------------------------------------------------------------------
CREATE TABLE HOODIES(
    id BIGSERIAL PRIMARY KEY,
    hoodieBrand TEXT NOT NULL,
    hoodieSize TEXT NOT NULL,
    hoodieColor TEXT NOT NULL,
    price FLOAT NOT NULL
);

INSERT INTO HOODIES (hoodieBrand, hoodieSize, hoodieColor, price)
VALUES ('Nike SB', 'Large', 'Blue', 99.95),
       ('Volcom', 'Small', 'Red', 94.95),
       ('Dickies', 'Medium', 'Orange', 97.95),
       ('Vans', 'XL', 'Yellow', 91.95),
       ('Polar Skate', 'Medium', 'Green', 106.95);

-------------------------------------------------------------------------
CREATE TABLE SOCKS(
    id BIGSERIAL PRIMARY KEY,
    socksBrand TEXT NOT NULL,
    socksSize TEXT NOT NULL,
    socksColor TEXT NOT NULL,
    price FLOAT NOT NULL
);

INSERT INTO SOCKS (socksBrand, socksSize, socksColor, price)
VALUES ('Pizza', 'Short', 'Blue', 12.95),
       ('Vans', 'Long', 'Red', 11.95),
       ('Lakai', 'Medium', 'Orange', 9.95),
       ('Nike', 'Short', 'Yellow', 14.95),
       ('Polar Skate', 'Long', 'Green', 10.95);

-------------------------------------------------------------------------
CREATE TABLE HATS(
    id BIGSERIAL PRIMARY KEY,
    hatsBrand TEXT NOT NULL,
    hatsType TEXT NOT NULL,
    hatsColor TEXT NOT NULL,
    price FLOAT NOT NULL
);

INSERT INTO HATS (hatsBrand, hatsType, hatsColor, price)
VALUES ('Pizza', 'Snapback', 'Blue', 12.95),
       ('Vans', 'Strapback', 'Green', 11.95),
       ('Lakai', 'Curved Bill', 'Orange', 9.95),
       ('Thrasher', 'Snapback', 'Yellow', 14.95),
       ('Nike', 'Beanie', 'Red', 10.95);

-------------------------------------------------------------------------
CREATE TABLE HELMETS(
    id BIGSERIAL PRIMARY KEY,
    helmetBrand TEXT NOT NULL,
    helmetSize TEXT NOT NULL,
    helmetColor TEXT NOT NULL,
    price FLOAT NOT NULL
);

INSERT INTO HELMETS (helmetBrand, helmetSize, helmetColor, price)
VALUES ('Triple 8', 'Large', 'Orange', 12.95),
       ('Triple 8', 'Small', 'Blue', 11.95),
       ('The one Jacen needed', 'Medium', 'Red/Black', 9.95);

-------------------------------------------------------------------------



