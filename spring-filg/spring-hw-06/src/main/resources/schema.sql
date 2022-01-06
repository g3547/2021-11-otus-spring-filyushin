DROP TABLE IF EXISTS BOOK,AUTHOR,GENRE;
CREATE TABLE AUTHOR
(
    AUTHOR_ID BIGINT PRIMARY KEY,
    FULL_NAME VARCHAR(255) NOT NULL
);
CREATE SEQUENCE SEQ_AUTHOR START WITH 3 INCREMENT BY 1 MINVALUE 1;

CREATE TABLE GENRE
(
    GENRE_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME     VARCHAR(255) NOT NULL
);
CREATE SEQUENCE SEQ_GENRE START WITH 3 INCREMENT BY 1 MINVALUE 1;

CREATE TABLE BOOK
(
    BOOK_ID   BIGINT PRIMARY KEY,
    TITLE     VARCHAR(255) NOT NULL,
    AUTHOR_ID BIGINT,
    GENRE_ID  BIGINT,
    CONSTRAINT FK_AUTHOR_ID
        FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHOR (AUTHOR_ID),
    CONSTRAINT FK_GENRE_ID
        FOREIGN KEY (GENRE_ID) REFERENCES GENRE (GENRE_ID)
);
CREATE SEQUENCE SEQ_BOOK START WITH 3 INCREMENT BY 1 MINVALUE 1;

CREATE TABLE COMMENT
(
    COMMENT_ID BIGINT PRIMARY KEY,
    BOOK_ID    BIGINT       NOT NULL,
    COMMENT    VARCHAR(255) NOT NULL,
    CONSTRAINT FK_BOOK_ID
        FOREIGN KEY (BOOK_ID) REFERENCES BOOK (BOOK_ID)
);
CREATE SEQUENCE SEQ_COMMENT START WITH 4 INCREMENT BY 1 MINVALUE 1;

