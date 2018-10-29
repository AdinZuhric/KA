package com.example.adin.ka;

import android.graphics.Point;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adin on 6/11/2016.
 */
public class KonacniAutomat {

    private List<Stanje> stanja = new ArrayList<Stanje>();
    private Stanje pocetnoStanje;
    private List<Stanje> finalnaStanja = new ArrayList<Stanje>();
    private String alfabet;
    public ArrayList<ArrayList<String>> prelazi = new ArrayList<ArrayList<String>>();

    public KonacniAutomat() {
    }

    public Stanje getStanje(int i)
    {return stanja.get(i);}
    public void dodajStanje(Stanje s) {
        if(stanja.size()==0)
            pocetnoStanje=s;
        stanja.add(s);
        ArrayList<String> l=new ArrayList<String>();
        for (int i=0;i<alfabet.length();i++)
            l.add("");

        prelazi.add(l);
    }
    public int velicina() {
        return stanja.size();
    }

    public int velicinaPrelaza() {
        return prelazi.size();

    }

    public void setAlfabet(String a) {
        alfabet = a;
    }
    public char getAlfabet(int i)
    {
        return alfabet.charAt(i);
    }
    public int duzinaAlfabeta()
    {
        return alfabet.length();
    }

    public void dodajFinalnoStanje(Stanje s) {
        finalnaStanja.add(s);
    }

    public void setPocetnoStanje(Stanje s) {
        pocetnoStanje = s;
    }

    public Stanje getPocetnoStanje() {
        return pocetnoStanje;
    }

    public int finalnaStanjaSize() {return  finalnaStanja.size();}

    public Stanje getFinalnoStanje(int i)
    {
        return  finalnaStanja.get(i);
    }

    public boolean provjeriString(String s)
    {
        Stanje trenutnoStanje = getPocetnoStanje();
        String prelaziStanja="";
        for (int j = 0; j < s.length(); j++) {
            int a = 0;
            while (s.charAt(j) != alfabet.charAt(a))
                a++;
            int b = 0;
            while (!trenutnoStanje.getNaziv().equals(stanja.get(b).getNaziv()))
                b++;
            String n = prelazi.get(b).get(a);
            b = 0;
            while (!n.equals( stanja.get(b).getNaziv()))
                b++;
            prelaziStanja+=trenutnoStanje.getNaziv()+"->"+s.charAt(j)+"=";
            trenutnoStanje = stanja.get(b);
            prelaziStanja+=trenutnoStanje.getNaziv()+"\n";

        }



        for (int i = 0; i < finalnaStanja.size(); i++) {
            if (trenutnoStanje == finalnaStanja.get(i))
                return true;
        }

        return false;
    }
    public String prelaziStanja(String s) {
        Stanje trenutnoStanje = getPocetnoStanje();
        String prelaziStanja="";
        for (int j = 0; j < s.length(); j++) {
            int a = 0;
            while (s.charAt(j) != alfabet.charAt(a))
                a++;
            int b = 0;
            while (!trenutnoStanje.getNaziv().equals(stanja.get(b).getNaziv()))
                b++;
            String n = prelazi.get(b).get(a);
            b = 0;
            while (!n.equals( stanja.get(b).getNaziv()))
                b++;
            prelaziStanja+=trenutnoStanje.getNaziv()+"->"+s.charAt(j)+"=";
            trenutnoStanje = stanja.get(b);
            prelaziStanja+=trenutnoStanje.getNaziv()+"\n";

        }
    return prelaziStanja;}




}
