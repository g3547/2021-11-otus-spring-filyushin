DROP TABLE IF EXISTS BOOK,AUTHOR,GENRE;
CREATE TABLE AUTHOR
(
    AUTHOR_ID BIGINT PRIMARY KEY  AUTO_INCREMENT,
    FULL_NAME VARCHAR(255) NOT NULL
);
CREATE TABLE GENRE
(
    GENRE_ID BIGINT PRIMARY KEY  AUTO_INCREMENT,
    NAME     VARCHAR(255) NOT NULL
);
CREATE TABLE BOOK
(
    BOOK_ID   BIGINT PRIMARY KEY AUTO_INCREMENT,
    TITLE     VARCHAR(255) NOT NULL,
    AUTHOR_ID BIGINT,
    GENRE_ID  BIGINT,
    CONSTRAINT FK_AUTHOR_ID
        FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHOR (AUTHOR_ID),
    CONSTRAINT FK_GENRE_ID
        FOREIGN KEY (GENRE_ID) REFERENCES GENRE (GENRE_ID)
);
CREATE TABLE COMMENT
(
    COMMENT_ID   BIGINT PRIMARY KEY AUTO_INCREMENT,
    BOOK_ID BIGINT,
    COMMENT  VARCHAR(255) NOT NULL,
    CONSTRAINT FK_BOOK_ID
        FOREIGN KEY (BOOK_ID) REFERENCES BOOK  (BOOK_ID)
);