CREATE TABLE IF NOT EXISTS BOOK
(
    id          NUMBER       NOT NULL,
    title       VARCHAR(150) NOT NULL,
    author      VARCHAR(150) NOT NULL,
    description VARCHAR(150),
    CONSTRAINT book_pk PRIMARY KEY (id)
);

INSERT INTO BOOK (id, title, author, description)
VALUES (1, 'Crime and Punishment', 'F. Dostoevsky', null);
INSERT INTO BOOK (id, title, author, description)
VALUES (2, 'Anna Karenina', 'L. Tolstoy', null);
INSERT INTO BOOK (id, title, author, description)
VALUES (3, 'The Brothers Karamazov', 'F. Dostoevsky', null);
INSERT INTO BOOK (id, title, author, description)
VALUES (4, 'War and Peace', 'L. Tolstoy', null);
INSERT INTO BOOK (id, title, author, description)
VALUES (5, 'Dead Souls', 'N. Gogol', null);
COMMIT;