package task3;

import java.util.Objects;

public class Planet extends SpaceObject {
    String color;
    StarSystem starSystem;

    public Planet(String name, Location location, String color, StarSystem starSystem) {
        super(name,location);
        this.starSystem = starSystem;
        this.color = color;
    }

    public StarSystem getStarSystem() {
        return starSystem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(location.getX(), planet.getLocation().getX()) &&
                Objects.equals(location.getY(), planet.getLocation().getY()) &&
                Objects.equals(location.getZ(), planet.getLocation().getZ()) &&
                Objects.equals(this.starSystem, planet.getStarSystem());
    }
}
