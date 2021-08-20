//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DayOne {
    int totalFuel;

    public static void main(String[] args) {
        new DayOne().run();
    }

    private void run() {
        File weightFile = setWeightFile();
        String[] strings = getStrings(weightFile);
        int[] weights = getWeights(strings);
        calculateFuel(weights);
        System.out.println(this.totalFuel);
    }

    private File setWeightFile() {
        return new File("input_files/weights.txt");
    }

    private String[] getStrings(File weightFile) {
        ArrayList<String> stringList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(weightFile));

            String line;
            try {
                while((line = reader.readLine()) != null) {
                    stringList.add(line);
                }
            } catch (Throwable var8) {
                try {
                    reader.close();
                } catch (Throwable var7) {
                    var8.addSuppressed(var7);
                }

                throw var8;
            }

            reader.close();
        } catch (Exception var9) {
            System.out.println("File not found.");
        }

        String[] rawStrings = new String[stringList.size()];
        stringList.toArray(rawStrings);
        return rawStrings;
    }

    private int[] getWeights(String[] strings) {
        int[] weights = new int[strings.length];

        for(int i = 0; i < strings.length; ++i) {
            weights[i] = Integer.parseInt(strings[i]);
        }

        return weights;
    }

    private void calculateFuel(int[] weights) {
        int[] var2 = weights;
        int var3 = weights.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int module = var2[var4];
            int fuel = module / 3 - 2;
            int extraFuel = this.calculateExtraFuel(fuel);
            this.totalFuel += fuel + extraFuel;
        }

    }

    private int calculateExtraFuel(int fuel) {
        int extraFuel = 0;
        int currentFuel = fuel;

        int i;
        for(boolean var4 = false; (i = currentFuel / 3 - 2) > 0; extraFuel += i) {
            currentFuel = i;
        }

        return extraFuel;
    }
}
