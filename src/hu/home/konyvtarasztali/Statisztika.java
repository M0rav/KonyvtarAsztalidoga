package hu.home.konyvtarasztali;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Statisztika {
    private List<Konyv> konyvek = new ArrayList<>();
    private Connection conn;
    private String DB_DRIVER = "mysql";
    private String DB_HOST = "localhost";
    private String DB_PORT = "3306";
    private String DB_DBNAME = "books";
    private String DB_USER = "root";
    private String DB_PASS = "";
//beolvasás
    public Statisztika() throws SQLException {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String url = String.format("jdbc:%s://%s:%s/%s", DB_DRIVER, DB_HOST, DB_PORT, DB_DBNAME);
            conn = DriverManager.getConnection(url, DB_USER, DB_PASS);
            String sql = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String author = result.getString("author");
                int publish_year = result.getInt("publish_year");
                int page_count = result.getInt("page_count");
                Konyv konyv = new Konyv(id, title, author, publish_year, page_count);
                konyvek.add(konyv);
            }
            System.out.println("Ez a result:" + result);
        } catch (ClassNotFoundException e) {
        }
    }
//1. feladat
    public int otszaznalTobb() {
        int db = 0;
        for (int i = 0; i < konyvek.size(); i++) {
            if (konyvek.get(i).getPage_count() > 500) {
                db++;
            }

        }
        return db;
    }
    //2. feladat
    public boolean idosebbeotvennel(){
        for (int i = 0; i < konyvek.size(); i++) {
        if (konyvek.get(i).getPublish_year()<1950){
            return true;
        }
        }
        return false;
    }
    //3. feladat
    public Konyv leghoszabb(){
        int oldalak = 0;
        int hely = 0;
        Konyv legnagyobb = konyvek.get(0);
        for (int i = 0; i < konyvek.size(); i++) {
            if (konyvek.get(i).getPage_count()> oldalak){
                oldalak = konyvek.get(i).getPage_count();
                hely = konyvek.get(i).getId();
            }

        }

        return konyvek.get(hely);
    }
    //4. feladat


    //5. feladat
    public void vanszerzo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Adja meg a könyvnek a címét: ");
        String cim = sc.nextLine();
        String szerzo = null;
        for (int i = 0; i < konyvek.size(); i++) {
            if (konyvek.get(i).getAuthor().equals(cim)){
                szerzo=konyvek.get(i).getAuthor();
            }
            else {
                System.out.println("Sajnos nics ilyen könyv");
                return;
            }
        }
        System.out.println("A szerző:" + szerzo);
    }

}
