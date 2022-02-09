DROP TABLE CUSTOMERS, ORDERS, BOARDS, SHOES;

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

CREATE TABLE BOARDS(
    id BIGSERIAL PRIMARY KEY,
    boardBrand TEXT NOT NULL,
    boardSize float NOT NULL,
    wheelSize int NOT NULL,
    wheelColor TEXT NOT NULL
);

CREATE TABLE SHOES(
    id BIGSERIAL PRIMARY KEY,
    shoeBrand TEXT NOT NULL,
    shoeType TEXT NOT NULL,
    shoeSize float NOT NULL,
    shoeColor TEXT NOT NULL
);


INSERT INTO BOARDS (boardBrand, boardSize, wheelSize, wheelColor)
VALUES ('Alien Workshop', 8.5, 56, 'Green'),
       ('Santa Cruz', 8.38, 55, 'Blue'),
       ('Almost', 8.125, 54, 'Red'),
       ('Antihero', 8.0, 56, 'Brown'),
       ('Baker', 8.5, 55, 'Black'),
       ('Element', 8.38, 54, 'Green'),
       ('Toy Machine', 8.125, 56, 'Blue'),
       ('Zero', 8.0, 55, 'Red'),
       ('Flip', 8.5, 54, 'Brown'),
       ('Birdhouse', 8.38, 53, 'Black');

INSERT INTO SHOES (shoeBrand, shoeType, shoeSize, shoeColor)
VALUES ('Vans', 'Athletic', 11.5, 'Red'),
       ('Nike', 'Athletic', 7.5, 'Blue'),
       ('Cariuma', 'Athletic', 8.5, 'Grey'),
       ('DC', 'Athletic', 10, 'Orange'),
       ('Converse', 'Athletic', 12, 'Brown');

INSERT INTO BACKPACKS (bagBrand, bagSize, bagColor)
VALUES ('Element', 'Large', 'Brown')


<--!--> Make sure to create the Backpacks table <--!-->
