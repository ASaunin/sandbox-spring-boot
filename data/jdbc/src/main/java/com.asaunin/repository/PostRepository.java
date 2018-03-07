package com.asaunin.repository;

import com.asaunin.domain.Person;
import com.asaunin.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Repository
public class PostRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public PostRepository(@SuppressWarnings("SpringJavaAutowiringInspection") JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Post findById(Long id) {
        String sql = "SELECT * FROM posts ORDER BY posted_on LIMIT 1";
        return jdbc.queryForObject(
                sql,
                new PostRowMapper()
        );
    }

    public Collection<Post> findByAuthorOrderByPostedOnDesc(Person author) {
        String sql = "SELECT * FROM posts where author_id = ? ORDER BY posted_on";
        return jdbc.query(
                sql,
                new Object[]{author.getId()},
                new PostRowMapper()
        );
    }

    public Collection<Post> findAllByOrderByPostedOnDesc() {
        String sql = "SELECT * FROM posts ORDER BY posted_on";
        return jdbc.query(
                sql,
                new PostRowMapper()
        );
    }

    private class PostRowMapper implements RowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();
            post.setId(rs.getInt("id"));
            post.setTitle(rs.getString("title"));
            post.setDescription(rs.getString("body").substring(1, 500));
            post.setBody(rs.getString("body"));
            post.setPostedOn(rs.getDate("posted_on"));
            post.setAuthor(rs.getInt("author_id"));
            return post;
        }

    }

}
