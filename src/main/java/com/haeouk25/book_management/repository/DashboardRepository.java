package com.haeouk25.book_management.repository;

import com.haeouk25.book_management.model.Dashboard;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DashboardRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Dashboard> mapper = new RowMapper<>() {
        @Override
        public Dashboard mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dashboard dashboard = new Dashboard();
            dashboard.setAuthorId(rs.getLong("author_id"));
            dashboard.setAuthorName(rs.getString("author_name"));
            dashboard.setBookCount(rs.getLong("book_count"));
            return dashboard;
        }
    };

    public List<Dashboard> count() {
        return jdbcTemplate.query("SELECT * FROM author_book_count", mapper);
    }
}