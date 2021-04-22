package task3;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class StarSystem {
    private String name;
    private ArrayList<Star> stars;
    private ArrayList<Planet> planets;
    private int size;

    public StarSystem(String name, ArrayList<Star> stars, int size) {
        this.name = name;
        this.stars = stars;
        this.size = size;
        planets = new ArrayList<>();
    }

    public void generateObjects(){
        String planetNameStart;
        String[] colors = {"красный", "синий","желтый"};
        try {
            planetNameStart = this.name.substring(0,2).toUpperCase(Locale.ROOT)+"-";
        }catch (StringIndexOutOfBoundsException e){
            planetNameStart = this.name.toUpperCase(Locale.ROOT)+"-";
        }catch (NullPointerException e){
            planetNameStart = "NNP-";
        }
        for (int i = 0; i < 1000; i++) {
            planets.add(new Planet(planetNameStart+i, new Location(ThreadLocalRandom.current().nextDouble(0, size + 1),ThreadLocalRandom.current().nextDouble(0, size + 1),
                    ThreadLocalRandom.current().nextDouble(0, size + 1)), colors[ThreadLocalRandom.current().nextInt(0, 3)],this));
        }
    }
    public ArrayList<Planet> getPlanets(){
        return planets;
    }

    public ArrayList<Star> getStars() {
        return stars;
    }

    public String getName() {
        return name;
    }

    public String makeCataclysm(){
        int pId = (int)((Math.random()*planets.size())%planets.size());
        Planet planet = planets.get(pId);
        String[] reasons = {"радиацией", "врывом атомной бомбы","метеоритным дождем"};
        return "Планета "+planet.name+reasons[ThreadLocalRandom.current().nextInt(0, 3)];
    };
}
