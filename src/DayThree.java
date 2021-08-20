//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DayThree {
    Movement[] directionsOne;
    Movement[] directionsTwo;
    HashMap<Location, Integer> mapOne = new HashMap();
    HashMap<Location, Integer> mapTwo = new HashMap();

    public static void main(String[] args) {
        DayThree wires = new DayThree();
        wires.layWires();
        ArrayList<Location> intersections = wires.findIntersections();
        Location nearestIntersection = wires.findNearestIntersection(intersections);
        System.out.println(nearestIntersection.distance);
    }

    DayThree() {
        String[] firstString = this.getStrings("input_files/wireOne.txt");
        String[] secondString = this.getStrings("input_files/wireTwo.txt");
        this.makeDirections(firstString, secondString);
    }

    String[] getStrings(String pathString) {
        Path path = Paths.get(pathString);
        String[] wire = null;

        try {
            wire = ((String[])Files.readAllLines(path).toArray(new String[0]))[0].split(",");
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        return wire;
    }

    void makeDirections(String[] wireOneStrings, String[] wireTwoStrings) {
        this.directionsOne = new Movement[wireOneStrings.length];
        this.directionsTwo = new Movement[wireTwoStrings.length];
        this.convertStrings(this.directionsOne, wireOneStrings);
        this.convertStrings(this.directionsTwo, wireTwoStrings);
    }

    void convertStrings(Movement[] directions, String[] strings) {
        for(int i = 0; i < strings.length; ++i) {
            directions[i] = new Movement(strings[i]);
        }

    }

    void layWires() {
        this.layWire(this.directionsOne, this.mapOne);
        this.layWire(this.directionsTwo, this.mapTwo);
    }

    void layWire(Movement[] movements, HashMap<Location, Integer> map) {
        int y = 0;
        int x = 0;
        int distance = 0;
        Movement[] var6 = movements;
        int var7 = movements.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            Movement move = var6[var8];
            int yDisplacement = move.direction[0];
            int xDisplacement = move.direction[1];

            for(int i = 0; i < move.distance; ++i) {
                ++distance;
                y += yDisplacement;
                x += xDisplacement;
                map.put(new Location(y, x, distance), distance);
            }
        }

    }

    ArrayList<Location> findIntersections() {
        HashMap<Location, Integer> smallestSet = this.mapOne.size() < this.mapTwo.size() ? this.mapOne : this.mapTwo;
        HashMap<Location, Integer> otherSet = this.mapOne.size() >= this.mapTwo.size() ? this.mapOne : this.mapTwo;
        ArrayList<Location> intersections = new ArrayList();
        Iterator var4 = smallestSet.keySet().iterator();

        while(var4.hasNext()) {
            Location location = (Location)var4.next();
            if (otherSet.containsKey(location)) {
                int otherDistance = (Integer)otherSet.get(location);
                intersections.add(new Location(location.y, location.x, location.distance + otherDistance));
            }
        }

        return intersections;
    }

    Location findNearestIntersection(ArrayList<Location> list) {
        Location nearestIntersection = null;
        int shortestDistance = 2147483647;
        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            Location location = (Location)var4.next();
            int distance = location.distance;
            if (distance < shortestDistance) {
                shortestDistance = distance;
                nearestIntersection = location;
            }
        }

        return nearestIntersection;
    }
}
class Location {
    int y;
    int x;
    int distance;

    Location(int y, int x, int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Location)) {
            return false;
        } else {
            Location other = (Location)obj;
            return this.x == other.x && this.y == other.y;
        }
    }

    public int hashCode() {
        return this.x + this.y;
    }
}
class Movement {
    int[] direction;
    int distance;

    Movement(String str) {
        this.setDirection(str);
        this.setDistance(str);
    }

    void setDirection(String str) {
        char c = str.charAt(0);
        switch(c) {
            case 'D':
                this.direction = new int[]{-1, 0};
                break;
            case 'L':
                this.direction = new int[]{0, -1};
                break;
            case 'R':
                this.direction = new int[]{0, 1};
                break;
            case 'U':
                this.direction = new int[]{1, 0};
                break;
            default:
                throw new RuntimeException("Unknown direction identifier");
        }

    }

    void setDistance(String str) {
        String distanceString = str.substring(1);
        this.distance = Integer.parseInt(distanceString);
    }

    public String toString() {
        int var10000 = this.direction[0];
        return "Direction: " + var10000 + ", " + this.direction[1] + " Distance: " + this.distance;
    }
}