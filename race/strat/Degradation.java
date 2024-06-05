package race.strat;

/*
 * File Name: Degradation.java
 * Description: This class utilizes the Sigleton Pattern to create a single instance of the tyre degradation that will be
 * applied to the laptimes after lap 1
 *
 * The purpose of using the singleton pattern was to avoid a new creation of the degradation value (an issue that existed
 * before i applied the singleton pattern)
 *
 * The degradation value is randomly generated once when the program is run
 *
 */

import java.util.ArrayList;
import java.util.Random;

public class Degradation {

    private static Degradation instance;
    private double tyreDeg;

    private Degradation() {

        Random random = new Random();
        this.tyreDeg = random.nextDouble() * (0.35 - 0.1) + 0.1; // this is the typical range of tyre deg
        this.tyreDeg = roundDecimal(this.tyreDeg, 3);
        System.out.println("The expected laptime degradation is: " + this.tyreDeg + "s per lap");
    }

    public static Degradation getInstance() {
        if (instance == null) {
            instance = new Degradation();
        }
        return instance;
    }

    public double getTyreDeg() {
        return tyreDeg;
    }

    public void applyDegradationToLapTimes(ArrayList<Double> lapTimesSeconds) {

        double tyreDeg = getTyreDeg();
        for (int i = 0; i < lapTimesSeconds.size(); i++) {
            double degradedTime = lapTimesSeconds.get(i) + tyreDeg;
            lapTimesSeconds.set(i, degradedTime);
        }
    }

    private double roundDecimal(double number, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(number * scale) / scale;
    }
}
