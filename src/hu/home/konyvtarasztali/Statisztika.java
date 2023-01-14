package hu.home.konyvtarasztali;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Statisztika {
    private List<Konyv> konyvek = new ArrayList<>();
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
