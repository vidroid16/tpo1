package task3;

public abstract class SpaceObject {
   String name;
   Location location;

    public SpaceObject(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Космический объект типа " + this.getClass().getName() + "С названием "+this.name + "И координатами x = "+location.getX()+"y = "+location.getY()+"z = "+location.getZ();
    }

}
