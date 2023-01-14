package hu.home.konyvtarasztali;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Statisztika s = new Statisztika();
            System.out.println("Az ötszáz oldalnál hoszabb könyvek:"+ s.otszaznalTobb());
            System.out.println("Van ötven évnél idősebb könyv?:" + s.idosebbeotvennel());
            System.out.println("A leghoszabb könyv:" + s.leghoszabb());
            System.out.println();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}