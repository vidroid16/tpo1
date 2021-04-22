package task3.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import task2.MyHashTable;
import task3.Location;
import task3.NaviMonitor;
import task3.Star;
import task3.StarSystem;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Tests for task3")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Task3Tests extends Assertions {
    ArrayList<StarSystem> allStarSystems;
    ArrayList<Star> allStars;
    ArrayList<Location> allLocations;
    NaviMonitor naviMonitor;
    int test;
    int test2;
    @BeforeAll
    public void init(){
        allStarSystems = new ArrayList<>();
        allLocations = new ArrayList<>();
        allStars = new ArrayList<>();
        Location loc1 = new Location(114,44,143);
        Location loc2 = new Location(434,151,854);
        Location loc3 = new Location(335,153,99);
        Location loc4 = new Location(332,454,511);
        allLocations.add(loc1);
        allLocations.add(loc2);
        allLocations.add(loc3);
        allStars.add(new Star("Sun", loc1));
        allStars.add(new Star("Sirius", loc2));
        allStars.add(new Star("AlphaCentaura", loc3));
        ArrayList<Star> stars1 = new ArrayList<>();
        ArrayList<Star> stars2 = new ArrayList<>();
        stars1.add(allStars.get(0));
        allStarSystems.add(new StarSystem("Sun System",stars1,10000));
        stars2.add(allStars.get(1));
        stars2.add(allStars.get(2));
        allStarSystems.add(new StarSystem("Bipolar System",stars2,10000));
        for (StarSystem s:allStarSystems) {
            s.generateObjects();
        }
        naviMonitor = new NaviMonitor();
        test = 0;
        test2 = 0;
    }


    @RepeatedTest(2000)
    @DisplayName("Test goTo Planets")
    void goToPlanetTest() {
        test++;
        naviMonitor.goTo(allStarSystems.get(test/1001).getPlanets().get(test%1000).getLocation(),allStarSystems.get(test/1001));
        assertEquals(naviMonitor.getMyLocation(), allStarSystems.get(test/1001).getPlanets().get(test%1000).getLocation());
    }
    @Test
    @DisplayName("Test goTo Star")
    void goToStars(){
        Location location = naviMonitor.getMyLocation();
        naviMonitor.goTo(allLocations.get(1),allStarSystems.get(1));
        assertEquals(naviMonitor.getMyLocation(),location);
    }
}