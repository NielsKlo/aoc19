//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DaySix {
    HashMap<String, Planet> planetMap = new HashMap();

    public DaySix() {
    }

    public static void main(String[] args) {
        DaySix mapData = new DaySix();
        mapData.countOrbits();
        int distanceToSanta = mapData.findSanta();
        System.out.println(distanceToSanta);
    }

    int countOrbits() {
        String[] orbitStrings = this.getOrbitStrings();
        List<Orbit> directOrbits = this.getDirectOrbits(orbitStrings);
        return this.getTotalOrbits(directOrbits);
    }

    String[] getOrbitStrings() {
        Path path = Paths.get("input_files/orbitMap.txt");

        try {
            String[] orbitStrings = (String[])Files.readAllLines(path).toArray(new String[0]);
            return orbitStrings;
        } catch (Exception var4) {
            throw new RuntimeException("Couldn't find the file with orbits");
        }
    }

    List<Orbit> getDirectOrbits(String[] orbitStrings) {
        List<Orbit> directOrbits = new ArrayList();
        String[] var3 = orbitStrings;
        int var4 = orbitStrings.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String orbit = var3[var5];
            directOrbits.add(new Orbit(orbit));
        }

        return directOrbits;
    }

    int getTotalOrbits(List<Orbit> directOrbits) {
        int totalOrbits = 0;
        this.makePlanets(directOrbits);
        this.connectPlanets();

        int orbits;
        for(Iterator var3 = this.planetMap.values().iterator(); var3.hasNext(); totalOrbits += orbits) {
            Planet planet = (Planet)var3.next();
            orbits = planet.countOrbits();
        }

        return totalOrbits;
    }

    void makePlanets(List<Orbit> orbits) {
        Iterator var2 = orbits.iterator();

        while(var2.hasNext()) {
            Orbit orbit = (Orbit)var2.next();
            String planetName = orbit.orbitingPlanet;
            String orbitedPlanetName = orbit.orbitedPlanet;
            this.planetMap.put(planetName, new Planet(planetName, orbitedPlanetName));
        }

    }

    void connectPlanets() {
        Iterator var1 = this.planetMap.values().iterator();

        while(var1.hasNext()) {
            Planet planet = (Planet)var1.next();
            Planet orbitedPlanet = (Planet)this.planetMap.get(planet.orbitedPlanetName);
            planet.setOrbitedPlanet(orbitedPlanet);
        }

    }

    int findSanta() {
        List<Planet> santaRoute = new ArrayList();
        List<Planet> yourRoute = new ArrayList();
        Planet santaPlanet = (Planet)this.planetMap.get("SAN");
        Planet yourPlanet = (Planet)this.planetMap.get("YOU");
        santaPlanet.getRouteToCOM(santaRoute);
        yourPlanet.getRouteToCOM(yourRoute);
        Planet firstCommonPlanet = this.findFirstCommonPlanet(santaRoute, yourRoute);
        int santaDistance = santaRoute.indexOf(firstCommonPlanet);
        int yourDistance = yourRoute.indexOf(firstCommonPlanet);
        return santaDistance + yourDistance;
    }

    Planet findFirstCommonPlanet(List<Planet> santaRoute, List<Planet> yourRoute) {
        Planet firstCommonPlanet = null;
        Iterator var4 = yourRoute.iterator();

        while(var4.hasNext()) {
            Planet planet = (Planet)var4.next();
            if (santaRoute.contains(planet)) {
                firstCommonPlanet = planet;
                break;
            }
        }

        return firstCommonPlanet;
    }
}
class Orbit {
    String orbitedPlanet;
    String orbitingPlanet;

    public Orbit(String orbit) {
        this.orbitedPlanet = orbit.substring(0, 3);
        this.orbitingPlanet = orbit.substring(4);
    }
}

class Planet {
    String planet;
    String orbitedPlanetName;
    Planet orbitedPlanet;

    public Planet(String planet, String orbitedPlanetName) {
        this.planet = planet;
        this.orbitedPlanetName = orbitedPlanetName;
    }

    public void setOrbitedPlanet(Planet orbitedPlanet) {
        this.orbitedPlanet = orbitedPlanet;
    }

    public int countOrbits() {
        return this.orbitedPlanet == null ? 1 : this.orbitedPlanet.countOrbits() + 1;
    }

    public void getRouteToCOM(List<Planet> planetsOnRoute) {
        if (this.orbitedPlanet != null) {
            planetsOnRoute.add(this.orbitedPlanet);
            this.orbitedPlanet.getRouteToCOM(planetsOnRoute);
        }

    }
}
