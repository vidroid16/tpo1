package com.company;

import task1.TaylorAcos;
import task2.MyHashTable;
import task3.Location;
import task3.NaviMonitor;
import task3.Star;
import task3.StarSystem;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //System.out.println(TaylorAcos.getAcos(0.232145));
//        MyHashTable table = new MyHashTable();
//        table.add("hello");
//        table.add("hell");
//        table.add("hell");
//        table.add("holle");
//        table.find("hell");
//        table.find("qwerty");
//        table.delete("qwerty");
//        table.delete("hello");
        ArrayList<Star> stars = new ArrayList();
        Location loc1 = new Location(1,4,5);
        Star sun = new Star("Sun", loc1);
        stars.add(sun);
        StarSystem solaris = new StarSystem("Sun System",stars,10000);
        solaris.generateObjects();
        NaviMonitor naviMonitor = new NaviMonitor();
        naviMonitor.goTo(solaris.getPlanets().get(4).getLocation(),solaris);
        naviMonitor.goTo(solaris.getPlanets().get(3).getLocation(),solaris);
        naviMonitor.goTo(loc1,solaris);
    }
}
