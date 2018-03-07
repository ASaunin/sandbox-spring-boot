package com.asaunin.repository;

import com.asaunin.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Repository
public class PersonRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public PersonRepository(@SuppressWarnings("SpringJavaAutowiringInspection") JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Person findById(Long id) {
        String sql = "SELECT * FROM persons WHERE id = ?";
        return jdbc.queryForObject(
                sql,
                new Object[]{id},
                new PersonRowMapper()
        );
    }

    public Person findByNickName(String nickname) {
        String sql = "SELECT * FROM persons WHERE nick_name = ?";
        return jdbc.queryForObject(
                sql,
                new Object[]{nickname},
                new PersonRowMapper()
        );
    }

    public Collection<Person> findAll() {
        String sql = "select * from persons";
        return jdbc.query(sql, new PersonRowMapper());
    }

    private class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setEmail(rs.getString("email"));
            person.setNickName(rs.getString("nick_name"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setSex(rs.getString("sex"));
            return person;
        }

    }

}
