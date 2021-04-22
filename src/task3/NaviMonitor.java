package task3;

import java.util.ArrayList;

public class NaviMonitor {
    Location myLocation;
    StarSystem myStarSystem;

    public Location getMyLocation() {
        return myLocation;
    }

    public StarSystem getMyStarSystem() {
        return myStarSystem;
    }
    private boolean checkStar(StarSystem starSystem, Location location){
        ArrayList<Star> stars = starSystem.getStars();
        for (Star s:stars) {
            if(s.getLocation().equals(location)){
                return true;
            }
        }
        return false;
    }
    public void goTo(Location location, StarSystem starSystem){

        Planet tPlanet = new Planet("teorical",location,"red",starSystem);
        ArrayList<Planet> planets = starSystem.getPlanets();
        for (Planet p:planets) {
            if(p.equals(tPlanet)){
                System.out.println("Корабль прибыл в " + starSystem.getName() + " на планету "+p.name);
                this.myLocation = location;
                this.myStarSystem = starSystem;
                return;
            }
        }
        if(checkStar(starSystem,location)){
            System.out.println("Предупреждение: Вы не можете летать на звезды");
            return;
        }
        if(myStarSystem == null){
            System.out.println("Корабль прибыл в " + starSystem.getName());
            this.myLocation = location;
            this.myStarSystem = starSystem;
            return;
        }
        if(myStarSystem.equals(starSystem)){
            System.out.println("Корабль продолжил свое путешествие по " + starSystem.getName());
        }
        if(!myStarSystem.equals(starSystem)){
            System.out.println("Корабль прибыл в " + starSystem.getName());
        }
        this.myLocation = location;
        this.myStarSystem = starSystem;
    }

}
