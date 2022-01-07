insert into AUTHOR (AUTHOR_ID, FULL_NAME)
values (1, 'Ivanov Petr Olegovich'),
       (2, 'Petrov Kirill Fedorovich'),
       (3, 'Quine')
;

insert into GENRE (GENRE_ID, NAME)
values (1, 'Non fiction'),
       (2, 'Roman'),
       (3, 'biographic')
;

INSERT INTO BOOK(BOOK_ID, TITLE, AUTHOR_ID, GENRE_ID)
VALUES (1, 'title1', 3, 1),
       (2, 'title2', 2, 2);