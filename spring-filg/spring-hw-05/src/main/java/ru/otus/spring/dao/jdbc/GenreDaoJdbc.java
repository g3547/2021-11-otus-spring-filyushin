package ru.otus.spring.dao.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.dao.GenreDao;
import ru.otus.spring.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class GenreDaoJdbc implements GenreDao {

    private final NamedParameterJdbcOperations jdbc;

    @Override
    public List<Genre> getGenres() {
        return jdbc.getJdbcOperations().query("SELECT GENRE_ID,NAME FROM GENRE", new GenreMapper());
    }

    @Override
    public Genre getGenreById(long id) {
        return jdbc.queryForObject("SELECT GENRE_ID,NAME FROM GENRE WHERE GENRE_ID=:id",
                Map.of("id", id), new GenreMapper());
    }


    public static class GenreMapper implements RowMapper<Genre> {
        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("GENRE_ID");
            String name = rs.getString("NAME");

            return new Genre(id, name);
        }
    }
}
