package ru.netology.mode;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.DriverManager;

public class Cleaner {
    private Cleaner() {
    }

    @SneakyThrows
    public static void cleanTable() {
        var clean1SQL = "DELETE cards,users FROM cards join users on users.id=cards.user_id";
        var clean2SQL = "DELETE auth_codes,users FROM auth_codes join users on users.id=auth_codes.user_id";
        var runner = new QueryRunner();
        try (
                var conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app", "app", "pass"
                )
        ) {
            runner.update(conn, clean1SQL);
            runner.update(conn, clean2SQL);
        }
    }
}
