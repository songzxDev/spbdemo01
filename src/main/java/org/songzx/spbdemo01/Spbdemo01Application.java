package org.songzx.spbdemo01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class Spbdemo01Application implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Spbdemo01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        showConnection();
//        showData();
    }

//    private void showConnection() throws SQLException {
//        log.info(dataSource.toString());
//        Connection conn = dataSource.getConnection();
//        log.info(conn.toString());
//        conn.close();
//    }
//
//    private void showData() {
//        jdbcTemplate.queryForList("SELECT * FROM `mycat`")
//                .forEach(row -> log.info(row.toString()));
//    }
}
