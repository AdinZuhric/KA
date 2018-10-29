package com.example.adin.ka;

import android.graphics.Point;

/**
 * Created by adin on 6/11/2016.
 */
public class Stanje {

    private String naziv;
    private Point pozicija;

    public Stanje(String s, Point p)
    {
        naziv=s;
        pozicija=p;
    }
    public String getNaziv()
    {return  naziv;}

    public int getX()
    {return pozicija.x;}

    public int getY()
    {return pozicija.y;}
}
