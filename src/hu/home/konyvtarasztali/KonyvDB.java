package hu.home.konyvtarasztali;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KonyvDB {
    private Connection conn;
    private String DB_DRIVER = "mysql";
    private String DB_HOST = "localhost";
    private String DB_PORT = "3306";
    private String DB_DBNAME = "books";
    private String DB_USER = "root";
    private String DB_PASS = "";


    public KonyvDB() throws SQLException {
        String url = String.format("jdbc:%s://%s:%s/%s", DB_DRIVER, DB_HOST, DB_PORT, DB_DBNAME);
        conn = DriverManager.getConnection(url, DB_USER, DB_PASS);

    }

    public List<Konyv> getKonyvek() throws SQLException {
        String sql = "SELECT * FROM books";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        List<Konyv>konyvek = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt("id");
            String title = result.getString("title");
            String author = result.getString("author");
            int publish_year = result.getInt("publish_year");
            int page_count = result.getInt("page_count");
            Konyv konyv = new Konyv(id, title, author, publish_year, page_count);
            konyvek.add(konyv);
        }
        return konyvek;

    }
}
