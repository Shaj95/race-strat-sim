package race.strat;

/*
 * File Name: Logic.java
 * Description: This class contains all logic and algorithms that are used around the program
 *
 * The reason i made this file was so that other files became cleaner and more readable and there's less code duplication
 *
 * It is also easier to refer to the algorithms and solve issues when you know they're grouped in one place
 *
 * This file plays a critical role in the program, in that it converts the string laptimes of the csv file
 * from the format "1:38.576" to seconds 98.576s, then this is used in GenerateLaps to apply degradation on the list of seconds
 *
 * Then the Logic class re-converts this list of seconds back into the form "1:38.576" and the GenerateLaps class updates
 * the lapTimesList with the new lap times after degradation.
 *
 * It also calculates the intervals between drivers by subtracting an index of the laptime seconds list from each prior index
 *
 */

import java.util.ArrayList;

public class Logic {

    public double convertLapsToSeconds(String lapTime) {
        String[] parts = lapTime.split(":");
        int minutes = Integer.parseInt(parts[0]);

        String[] secondsAndMillis = parts[1].split("\\.");
        int seconds = Integer.parseInt(secondsAndMillis[0]);
        int milliseconds = Integer.parseInt(secondsAndMillis[1]);

        return minutes * 60 + seconds + milliseconds / 1000.0;
    }

    public String convertSecondsToLaps(double lapTimeSeconds) {
        int minutes = (int) (lapTimeSeconds / 60);
        int seconds = (int) (lapTimeSeconds % 60);
        int milliseconds = (int) ((lapTimeSeconds - Math.floor(lapTimeSeconds)) * 1000);

        return String.format("%d:%02d.%03d", minutes, seconds, milliseconds);
    }

    public ArrayList<Double> calculateIntervals(ArrayList<Double> lapTimesSeconds) {
        ArrayList<Double> intervals = new ArrayList<>();
        for (int i = 1; i < lapTimesSeconds.size(); i++) {
            double interval = lapTimesSeconds.get(i) - lapTimesSeconds.get(i - 1);
            // rounding the decimal to 3 places
            interval = roundDecimal(interval, 3);
            intervals.add(interval);
        }
        return intervals;
    }

    private double roundDecimal(double number, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(number * scale) / scale;
    }
}
