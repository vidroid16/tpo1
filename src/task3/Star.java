package task3;

public class Star extends SpaceObject {
    private boolean isSupernova;

    public Star(String name, Location location) {
        super(name, location);
        isSupernova = false;
    }
}
