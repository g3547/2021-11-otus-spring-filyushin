package ru.otus.spring.dao.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.domain.Author;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Book getBookById(long id) {
        return jdbc
                .queryForObject("SELECT BOOK_ID,TITLE,AUTHOR_ID,GENRE_ID,g.NAME,a.FULL_NAME " +
                                "FROM BOOK b " +
                                "JOIN AUTHOR a ON b.author_id=a.author_id" +
                                "JOIN GENRE g ON b.genre_id=g.genre_id" +
                                "WHERE b.BOOK_ID=:id", Map.of("id", id),
                        new BookMapper());
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return jdbc
                .query("SELECT BOOK_ID,TITLE,AUTHOR_ID,GENRE_ID,g.NAME,a.FULL_NAME " +
                                "FROM BOOK b " +
                                "JOIN AUTHOR a ON b.author_id=a.author_id" +
                                "JOIN GENRE g ON b.genre_id=g.genre_id" +
                                "WHERE a.author_id=:author_id", Map.of("author_id", author.getId()),
                        new BookMapper());
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return jdbc
                .query("SELECT BOOK_ID,TITLE,AUTHOR_ID,GENRE_ID,g.NAME,a.FULL_NAME " +
                                "FROM BOOK b " +
                                "JOIN AUTHOR a ON b.author_id=a.author_id" +
                                "JOIN GENRE g ON b.genre_id=g.genre_id" +
                                "WHERE g.genre_id=:genre_id", Map.of("genre_id", genre.getId()),
                        new BookMapper());
    }

    @Override
    public List<Book> getBooks() {
        return jdbc.getJdbcOperations()
                .query("SELECT BOOK_ID,TITLE,AUTHOR_ID,GENRE_ID,g.NAME,a.FULL_NAME " +
                                "FROM BOOK b " +
                                "JOIN AUTHOR a ON b.author_id=a.author_id" +
                                "JOIN GENRE g ON b.genre_id=g.genre_id",
                        new BookMapper());

    }

    @Override
    public void addBook(Book newBook) {
        Map<String, Object> params = Map.of("book_id", newBook.getId(),
                "title", newBook.getTitle(),
                "author_id", newBook.getAuthor().getId(),
                "genre_id", newBook.getId());
        jdbc.getJdbcOperations().
                update("INSERT into BOOK(BOOK_ID,TITLE,AUTHOR_ID,GENRE_ID) " +
                        "values (:book_id,:title,:author_id,:genre_id)", params);
    }

    @Override
    public void updateBook(Book book) {
        Map<String, Object> params = Map.of("book_id", book.getId(),
                "title", book.getTitle(),
                "author_id", book.getAuthor().getId(),
                "genre_id", book.getId());

        jdbc.update("UPDATE BOOK" +
                                "SET (TITLE,AUTHOR_ID,GENRE_ID) = (:title,:author_id,:genre_id) " +
                                "WHERE BOOK_ID=:book_id",
                        params);
    }

    @Override
    public void deleteBook(Book book) {
        jdbc.update("DELETE FROM BOOK WHERE BOOK_ID=:book_id",
                Map.of("book_id", book.getId()))
        ;
    }

    public static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("BOOK_ID");
            String title = rs.getString("TITLE");
            long author_id = rs.getLong("AUTHOR_ID");
            String authorName = rs.getString("FULL_NAME");
            long genreId = rs.getLong("GENRE_ID");
            String genreName = rs.getString("NAME");

            Author author = new Author(author_id, authorName);
            Genre genre = new Genre(genreId, genreName);
            return new Book(id, title, author, genre);
        }
    }
}
