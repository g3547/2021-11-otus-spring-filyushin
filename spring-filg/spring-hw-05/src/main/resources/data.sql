insert into AUTHOR (AUTHOR_ID, FULL_NAME)
values (1, 'Ivanov Petr Olegovich'),
       (2, 'Petrov Kirill Fedorovich');

insert into GENRE (GENRE_ID, NAME)
values (1, 'Non fiction'),
       (2, 'Roman');

INSERT INTO BOOK(BOOK_ID, TITLE, AUTHOR_ID, GENRE_ID)
VALUES (1, 'title - t1', 1, 1),
       (2, 'title - 2', 2, 2);