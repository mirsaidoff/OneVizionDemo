# Book Management API

This project is a Book Management API built using the Java Spring Boot framework. It interacts with an in-memory H2 database and utilizes the JDBC Template API for database operations as per the given task requirements.

## Task Overview

The task involves creating a RESTful API with the following functionalities:

1. **List All Books**: Returns a list of all books sorted in reverse alphabetical order by the book title.
2. **Add a New Book**: Adds a new book to the database.
3. **List Books Grouped by Author**: Returns a list of all books grouped by author.
4. **Find Top Authors by Character Occurrence**: Returns a list of authors with the highest occurrences of a given character in their book titles.

## Project Structure

The project follows a standard Spring Boot structure:

## Endpoints

1. **List All Books by Title in Descending Order**: `GET /list-ordered/title/desc`
2. **Add a New Book**: `POST /add`
3. **List Books Grouped by Author**: `GET /list/author`
4. **Find Top Authors by Character Occurrence**: `GET /list/author-book-symbol-count`

## Database

The project uses an in-memory H2 database. The schema and initial data are defined as follows:

```sql
CREATE TABLE book (
    id NUMBER NOT NULL,
    title VARCHAR(150) NOT NULL,
    author VARCHAR(150) NOT NULL,
    description VARCHAR(150),
    CONSTRAINT book_pk PRIMARY KEY (id)
);

INSERT INTO book (id, title, author, description) VALUES (1, 'Crime and Punishment', 'F. Dostoevsky', NULL);
INSERT INTO book (id, title, author, description) VALUES (2, 'Anna Karenina', 'L. Tolstoy', NULL);
INSERT INTO book (id, title, author, description) VALUES (3, 'The Brothers Karamazov', 'F. Dostoevsky', NULL);
INSERT INTO book (id, title, author, description) VALUES (4, 'War and Peace', 'L. Tolstoy', NULL);
INSERT INTO book (id, title, author, description) VALUES (5, 'Dead Souls', 'N. Gogol', NULL);
```

## Build and Run

To build and run the project, use the following commands:

```bash
./gradlew build
./gradlew bootRun
```

## Technologies Used

- Java Spring Boot
- Spring JDBC Template
- H2 Database
- Gradle

## License

This project is licensed under the MIT License.

## Repository

For more details, please visit the [GitHub repository](https://github.com/mirsaidoff/OneVizionDemo).
