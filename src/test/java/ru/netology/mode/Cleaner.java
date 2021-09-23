package ru.netology.mode;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.DriverManager;

public class Cleaner {
    private Cleaner() {
    }

    @SneakyThrows
    public static void cleanTable() {
        var clean1SQL = "DELETE FROM card_transactions";
        var clean2SQL = "DELETE FROM cards";
        var clean3SQL = "DELETE FROM auth_codes";
        var clean4SQL = "DELETE FROM users";
        var runner = new QueryRunner();
        try (
                var conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                )
        ) {
            runner.update(conn, clean1SQL);
            runner.update(conn, clean2SQL);
            runner.update(conn, clean3SQL);
            runner.update(conn, clean4SQL);

        }
    }
}
