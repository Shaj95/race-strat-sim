package race.strat;

/*
 * File Name: GenerateLaps.java
 * Description: This class makes use of the lapTimesList, driverNamesList and currentTyresList from DataProcessor
 *
 * The degradation instance is used here (Singleton Pattern)
 *
 * It then applies degradation on that data from lap 1 and updates the lapTimesList with the new lap time
 * and then prints the data of all laps from lap 2 onwards.
 *
 * It relies on algorithms being pulled from the Logic class (these will be explained in that class)
 *
 */

import java.util.ArrayList;

public class GenerateLaps {

    private ArrayList<String> lapTimesList;
    private ArrayList<String> driverNamesList;
    private ArrayList<String> currentTyreList;
    private Degradation degradation;

    GenerateLaps() {
        lapTimesList = new ArrayList<>();
        driverNamesList = new ArrayList<>();
        currentTyreList = new ArrayList<>();
        degradation = Degradation.getInstance(); // using the instance of the singleton pattern here
    }

    public void generateAndProcessLapTimes(ArrayList<String> lapTimes,ArrayList<String> drivers, ArrayList<String> tyres) {
        this.lapTimesList = lapTimes;
        this.driverNamesList = drivers;
        this.currentTyreList = tyres;
        Logic logic = new Logic();
        ArrayList<Double> lapTimesSeconds = new ArrayList<>();

        for (String lapTime : lapTimesList) {
            double lapTimeSeconds = logic.convertLapsToSeconds(lapTime);
            lapTimesSeconds.add(lapTimeSeconds);
        }

        degradation.applyDegradationToLapTimes(lapTimesSeconds);
        lapTimesList.clear();

        for (Double lapTimeSeconds : lapTimesSeconds) {
            lapTimesList.add(logic.convertSecondsToLaps(lapTimeSeconds));
        }

        // calling the interval method from Logic
        ArrayList<Double> intervals = logic.calculateIntervals(lapTimesSeconds);

        // updated laptimes are displayed here
        System.out.printf("%-20s %-20s %-20s %-20s%n", "Driver Name", "Lap Time", "Current Tyre", "Interval");

        // the race leader is separate from the loop because there is one less interval than drivers
        System.out.printf("%-20s %-20s %-20s %-20s%n", driverNamesList.get(0), lapTimesList.get(0), currentTyreList.get(0), "Leader");

        for (int i = 0; i < lapTimesList.size() - 1; i++) { // adjusted loop to account for one less interval
            // starting the driver index from the second driver onwards
            System.out.printf("%-20s %-20s %-20s %-20s%n", driverNamesList.get(i+1), lapTimesList.get(i+1), currentTyreList.get(i+1), intervals.get(i));

        }
    }
}
